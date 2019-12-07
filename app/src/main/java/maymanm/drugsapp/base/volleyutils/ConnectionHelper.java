package maymanm.drugsapp.base.volleyutils;

import android.widget.ImageView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.json.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.application.BaseApplication;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.filesutils.VolleyFileObject;
import maymanm.drugsapp.model.maps.geolocation.GeoLocationRequest;
import maymanm.drugsapp.util.PreferenceHelperManager;
import timber.log.Timber;


public class ConnectionHelper {

    private static DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageForEmptyUri(R.drawable.logo)
            .showImageOnLoading(R.drawable.logo)
            .showImageOnFail(R.drawable.logo)
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();

    private static ImageLoader imageLoader = ImageLoader.getInstance();
    private ConnectionListener connectionListener;
    private RequestQueue queue;
    private static final int TIME_OUT = 10000;
    private Gson gson;

    public ConnectionHelper(ConnectionListener connectionListener) {
        this.connectionListener = connectionListener;
        queue = BaseApplication.getInstance().getRequestQueue();
        gson = new Gson();
    }

    public void requestJsonObject(int method, String url, Object requestData, final Class<?> responseType) {
        final Gson gson = new Gson();
        String link;
        if (url.equals(WebServices.GEO_LOCATION_ADDRESS)){
            GeoLocationRequest request = (GeoLocationRequest) requestData;
            link = WebServices.GEO_LOCATION_ADDRESS +
                    "key=" +"not found" +
                    "&latlng=" + request.getLatlng() +
                    "&sensor=" + request.isSensor();
        }else
            link = WebServices.BASE_URL + url;

        link = link.replaceAll(" ", "%20");
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(gson.toJson(requestData));
        } catch (Exception e) {
            e.getStackTrace();
        }

        Timber.e(url);
        if (jsonObject != null) {
            Timber.e(jsonObject.toString());
        } else {
            Timber.e("Make sure that you added request correctly");
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(method, link, jsonObject,
                response -> {
                    Timber.e(response.toString());
                    parseData(response, responseType);
                }
                , volleyError -> {
            showErrorDetails(volleyError);
            connectionListener.onRequestError(volleyError.getMessage());
        }) {
            @Override
            public Map getHeaders() {

                return getCustomHeaders();
            }
        };
        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(jsonObjReq);

    }


    public void multiPartConnect(String url, final Object requestData, final List<VolleyFileObject> volleyFileObjects, final Class<?> responseType) {
        String link = WebServices.BASE_URL + url;
        link = link.replaceAll(" ", "%20");
        Timber.e("the error%s", link);

        final VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, link, networkResponse -> {
            String responseString = new String(networkResponse.data);
            JSONObject response = null;
            try {
                Timber.e(responseString);
                response = new JSONObject(responseString);
            } catch (Exception e) {
                e.getStackTrace();
            }
            parseData(response, responseType);
        }, volleyError -> {
            showErrorDetails(volleyError);
            connectionListener.onRequestError(volleyError.getMessage());
        }) {
            @Override
            protected Map<String, String> getParams() {
                return getParameters(requestData);
            }
            @Override
            public Map<String, String> getHeaders() {
                return getCustomHeaders();
            }
            @Override
            protected Map<String, DataPart> getByteData() {
                return getFileParameters(volleyFileObjects);
            }

        };

        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(multipartRequest);
    }

    public HashMap<String, String> getCustomHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        //header
        String token = PreferenceHelperManager.getUserLoginDetails().getJwtToken();
        Timber.tag("token").e(token);
        headers.put("jwt", token);
        headers.put("lang", PreferenceHelperManager.getLanguage());
        return headers;
    }


    public static void loadImage(final ImageView image, String imageUrl) {
        Timber.d(imageUrl);
        imageLoader.displayImage(imageUrl, image, options);
    }

    public static void loadImage(final ImageView image, String imageUrl, ImageLoadingListener imageLoadingListener) {
        Timber.d(imageUrl);
        imageLoader.displayImage(imageUrl, image, options, imageLoadingListener);
    }


    private void showErrorDetails(VolleyError volleyError) {
        String body;

        Timber.e("theerror");

        try {
            final String statusCode = String.valueOf(volleyError.networkResponse.statusCode);
            body = new String(volleyError.networkResponse.data, StandardCharsets.UTF_8);
            Timber.e("Error Body " + body + " StatusCode " + statusCode);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private void parseData(JSONObject response, final Class<?> responseType) {

        try {
            System.out.println("Response " + response.toString());
            if (response.toString().equals("")) {
                connectionListener.onRequestError(null);
            } else {
                connectionListener.onRequestSuccess(gson.fromJson(response.toString(), responseType));
            }
        } catch (Exception e) {
            connectionListener.onRequestError(e.getMessage());
            Timber.e(e);
        }

    }

    private Map<String, String> getParameters(final Object requestData) {
        Map<String, String> params = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(gson.toJson(requestData));
            for (int i = 0; i < Objects.requireNonNull(jsonObject.names()).length(); i++) {
                params.put(jsonObject.names().getString(i), jsonObject.get(jsonObject.names().getString(i)) + "");
                Timber.e("%s", jsonObject.get(Objects.requireNonNull(jsonObject.names()).getString(i)));
            }
            Timber.e("params size: %s", params.size());
        } catch (Exception e) {
            Timber.e(e);
        }
        return params;
    }

    private Map<String, VolleyMultipartRequest.DataPart> getFileParameters(List<VolleyFileObject> volleyFileObjects) {
        Map<String, VolleyMultipartRequest.DataPart> filesParams = new HashMap<>();
        if (volleyFileObjects == null) {
            return filesParams;
        }

        for (int i = 0; i < volleyFileObjects.size(); i++) {
            final File filePath = new File(volleyFileObjects.get(i).getFilePath());
            filesParams.put(volleyFileObjects.get(i).getParamName(),
                    new VolleyMultipartRequest.DataPart(filePath.getName()
                    , volleyFileObjects.get(i).getCompressObject().getBytes())
            );
        }
        Timber.e("filesParams size: %s", filesParams.size());
        return filesParams;
    }


}