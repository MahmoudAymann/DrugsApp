package maymanm.drugsapp.viewmodel.fragment.auth;

import android.annotation.SuppressLint;
import android.location.Address;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;

import com.android.volley.Request;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.maps.MapRequest;
import maymanm.drugsapp.model.maps.geolocation.GeoLocAddressResponse;
import maymanm.drugsapp.model.maps.geolocation.GeoLocationRequest;
import maymanm.drugsapp.model.updateaddress.UpdateAddressRequest;
import maymanm.drugsapp.model.updateaddress.UpdateAddressResponse;
import maymanm.drugsapp.util.MyMapUtility;
import maymanm.drugsapp.util.PreferenceHelperManager;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;
import timber.log.Timber;

/**
 * Created by MahmoudAyman on 30/07/19.
 */

public class MapFragmentViewModel extends BaseViewModel {

    private MapRequest mapRequest;
    private ReactiveLocationProvider locationProvider;
    private Disposable lastLocationDis, addressDis, locationUpdateDisposable, searchDis;
    private GoogleMap mMap;
    public ObservableBoolean isSearching = new ObservableBoolean();
    public ObservableBoolean isDone = new ObservableBoolean();
    public ObservableBoolean enableBtn = new ObservableBoolean();
    private LatLng lastLatLng;
    private int fragment;
    private Marker currentMarker;
//    private AddressesAdapter addressesAdapter = new AddressesAdapter();

    public MapFragmentViewModel(ReactiveLocationProvider locationProvider, int fragment) {
        this.locationProvider = locationProvider;
        this.fragment = fragment;
        mapRequest = new MapRequest();
        isDone.set(true);
    }


    @Bindable
    public MapRequest getMapRequest() {
        return mapRequest;
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        lastLocationDis = MyMapUtility.getCurrentLocation(locationProvider)
                .subscribe(location -> {
                    Timber.e("location get: %s", location);
                    lastLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                    getAddress(lastLatLng);
                    lastLocationDis.dispose();
                });

    }

    private void getAddress(LatLng latLng) {
        accessLoadingBar(View.VISIBLE);
        MyMapUtility.getAddress(locationProvider, latLng)
                .subscribe(new Observer<List<Address>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addressDis = d;
                    }

                    @Override
                    public void onNext(List<Address> addressList) {
                        Timber.e(addressList.toString());
                        if (!addressList.isEmpty()) {
                            setCurrentMarkerNow(addressList.get(0).getAddressLine(0), latLng);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                        activateGeoCurrentLocation();
                    }

                    @Override
                    public void onComplete() {
                        accessLoadingBar(View.GONE);
                    }
                });
        animateCamera(lastLatLng);
    }

    public void animateCamera(LatLng lastLatLng) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                lastLatLng, // coordinates
                10); // zoom
        mMap.animateCamera(cameraUpdate);
    }


    private void activateGeoCurrentLocation() {
        accessLoadingBar(View.VISIBLE);
        GeoLocationRequest request = new GeoLocationRequest();
        if (lastLatLng != null)
            request.setLatlng(lastLatLng.latitude + "," + lastLatLng.longitude);
        request.setSensor(true);
        new ConnectionHelper(new ConnectionListener() {
            @Override
            public void onRequestSuccess(Object response) {
                GeoLocAddressResponse updateLocationResponse = ((GeoLocAddressResponse) response);
                if ("OK".equals(updateLocationResponse.getStatus())) {
                    setCurrentMarkerNow(updateLocationResponse.getResults().get(0).getFormattedAddress(), lastLatLng);
                    animateCamera(lastLatLng);
                } else {
                    setValue(Codes.SHOW_LOCATION_ERROR);
                }
                accessLoadingBar(View.GONE);
            }
        }).requestJsonObject(Request.Method.GET, WebServices.GEO_LOCATION_ADDRESS
                , request, GeoLocAddressResponse.class);
    }

    private void getLocationUpdates() {
        locationUpdateDisposable = MyMapUtility.getLocationUpdates(locationProvider)
                .subscribe(location -> {
                    Timber.e(location.toString());
                });
    }

    public void setCurrentMarkerNow(String title, LatLng latLng) {
        if (currentMarker != null) {
            currentMarker.remove();
        }

        currentMarker = mMap.addMarker(MyMapUtility.getMarkerOptions(title, latLng,
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
        );

        //set data
        mapRequest.setCurrentAddress(title);
        mapRequest.setLat(latLng.latitude);
        mapRequest.setLng(latLng.longitude);
        notifyChange();
    }

    public void onSaveClick() {
        setValue(Codes.ON_SAVE_CLICK);
    }

    public void stopAllLocationListeners() {
        if (lastLocationDis != null) {
            lastLocationDis.dispose();
        }
        if (addressDis != null) {
            addressDis.dispose();
        }
        if (locationUpdateDisposable != null) {
            locationUpdateDisposable.dispose();
        }
        if (searchDis != null) {
            searchDis.dispose();
        }
    }

    public void onMapClickListener(LatLng latLng) {
        getAddress(latLng);
    }

    public void onMapReady(GoogleMap mMap) {
        this.mMap = mMap;
        getLastLocation();
        MyMapUtility.showZoomBtn(mMap, true);
        setValue(Codes.ON_MAP_READY);
    }

    public void searchAddress(String s) {
        MyMapUtility.searchAddress(locationProvider, s)
                .subscribe(new Observer<List<Address>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        searchDis = d;
                    }

                    @Override
                    public void onNext(List<Address> addresses) {
                        Timber.e(addresses.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                        searchGoogleMapApi(); // need places api key
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    private void searchGoogleMapApi() {

    }

    @Bindable
    public TextWatcher getSearchTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isSearching.set(true);
                isDone.set(false);
                if (i2 == 0) {
                    Timber.e("0");
                    isSearching.set(false);
                    isDone.set(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchAddress(editable.toString());
            }
        };
    }

    public void updateAddress() {
        UpdateAddressRequest request = new UpdateAddressRequest();
        if (PreferenceHelperManager.getAddressId() != null) {
            request.setAddressId(PreferenceHelperManager.getAddressId());
        }
        request.setLat(mapRequest.getLat());
        request.setLng(mapRequest.getLng());
        request.setLocation(mapRequest.getCurrentAddress());
        accessLoadingBar(View.VISIBLE);
        new ConnectionHelper(new ConnectionListener() {
            @Override
            public void onRequestSuccess(Object response) {
                UpdateAddressResponse addressResponse = ((UpdateAddressResponse) response);
                switch (addressResponse.getStatus()) {
                    case WebServices.SUCCESS:
                        if (addressResponse.getAddressId() != null)
                            PreferenceHelperManager.setAddressId(addressResponse.getAddressId());
                        setValue(Codes.CHECKOUT_SCREEN);
                        break;
                    case WebServices.FAILED:
                        setMessage(addressResponse.getMessage());
                        setValue(Codes.SHOW_MESSAGE);
                        break;
                }
                accessLoadingBar(View.GONE);
            }
        }).requestJsonObject(Request.Method.POST, WebServices.UPDATE_ADDRESS, request, UpdateAddressResponse.class);
    }
}
