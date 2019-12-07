package maymanm.drugsapp.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Location;
import android.net.Uri;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.application.BaseApplication;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;
import timber.log.Timber;

public abstract class MyMapUtility {

    public static void showCurrentLocationBtn(GoogleMap mMap, boolean show) {
        try {
            if (show)
                mMap.setMyLocationEnabled(true);
            else
                mMap.setMyLocationEnabled(false);
        } catch (SecurityException e) {
            Timber.e(e);
        }
    }

    public static void showZoomBtn(GoogleMap mMap, boolean show) {
        if (show)
            mMap.getUiSettings().setZoomControlsEnabled(true);
        else
            mMap.getUiSettings().setZoomControlsEnabled(false);
    }

    public static void showCompassBtn(GoogleMap mMap, boolean show) {
        if (show)
            mMap.getUiSettings().setCompassEnabled(true);
        else
            mMap.getUiSettings().setCompassEnabled(false);
    }

    public static Bitmap setMarkerIcon(int drawableRes) {
        Drawable drawable = BaseApplication.getInstance().getApplicationContext().getResources()
                .getDrawable(drawableRes);
        return ApplicationUtil.drawableToBitmap(drawable);
    }

    public static void openGoogleMapsForDirection(String lat, String lng, Activity activity) {
        //ex: https://www.google.com/maps/search/?api=1&query=47.5951518,-122.3316393
        StringBuilder builder = new StringBuilder("https://www.google.com/maps/search/?");
        builder.append("api=1&")
                .append("query=")
                .append(lat)
                .append(",")
                .append(lng);
        Timber.e(builder.toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(builder.toString()));
        intent.setPackage("com.google.android.apps.maps");
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            try {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(builder.toString()));
                activity.startActivity(unrestrictedIntent);
            } catch (ActivityNotFoundException innerEx) {
                Timber.e("Please install a maps application");
            }
        }
    }

    @SuppressLint("MissingPermission")
    public static Observable<Location> getCurrentLocation(ReactiveLocationProvider reactiveLocationProvider) {
        if (reactiveLocationProvider == null) {
            reactiveLocationProvider = new ReactiveLocationProvider(BaseApplication.getInstance());
        }
        return reactiveLocationProvider.getLastKnownLocation();
    }


    public static Observable<List<Address>> getAddress(ReactiveLocationProvider reactiveLocationProvider, LatLng latLng) {
        if (reactiveLocationProvider == null) {
            reactiveLocationProvider = new ReactiveLocationProvider(BaseApplication.getInstance());
        }
        Observable<List<Address>> reverseGeocodeObservable = reactiveLocationProvider
                .getReverseGeocodeObservable(latLng.latitude, latLng.longitude, 1);
        return reverseGeocodeObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<Location> getLocationUpdates(ReactiveLocationProvider locationProvider) {
        if (locationProvider == null) {
            locationProvider = new ReactiveLocationProvider(BaseApplication.getInstance());
        }
        LocationRequest request = LocationRequest.create() //standard GMS LocationRequest
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setNumUpdates(1)
                .setInterval(1000 * 10)
                .setFastestInterval(1000 * 5);
        return locationProvider.getUpdatedLocation(request);
    }

    public static MarkerOptions getMarkerOptions(String title, LatLng latLng, BitmapDescriptor icon) {
        MarkerOptions options = new MarkerOptions();
        options.title(title)
                .position(latLng)
                .icon(icon);
        return options;
    }

    public static MarkerOptions getMarkerOptions(String title, LatLng latLng, float icon) {
        MarkerOptions options = new MarkerOptions();
        options.title(title)
                .position(latLng)
                .icon(BitmapDescriptorFactory.defaultMarker(icon));
        return options;
    }

    public static Observable<List<Address>> searchAddress(ReactiveLocationProvider locationProvider, String text) {
        Observable<List<Address>> geocodeObservable = locationProvider
                .getGeocodeObservable(text, 3);
        return geocodeObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static ArrayList<Float> getCursorsList() {
        ArrayList<Float> list = new ArrayList<>();
        list.add(BitmapDescriptorFactory.HUE_RED);
        list.add(BitmapDescriptorFactory.HUE_BLUE);
        list.add(BitmapDescriptorFactory.HUE_ORANGE);
        list.add(BitmapDescriptorFactory.HUE_ROSE);
        list.add(BitmapDescriptorFactory.HUE_CYAN);
        list.add(BitmapDescriptorFactory.HUE_GREEN);
        list.add(BitmapDescriptorFactory.HUE_MAGENTA);
        list.add(BitmapDescriptorFactory.HUE_AZURE);
        list.add(BitmapDescriptorFactory.HUE_VIOLET);
        list.add(BitmapDescriptorFactory.HUE_YELLOW);
        return list;
    }

    private static int getRandomIntBetweenRange(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }

    public static float getRandomDefaultCursors(ArrayList<Float> list) {
        if (list != null && list.size() >= 9)
            return list.get(getRandomIntBetweenRange(0, 9));
        else
            return 0;
    }
}
