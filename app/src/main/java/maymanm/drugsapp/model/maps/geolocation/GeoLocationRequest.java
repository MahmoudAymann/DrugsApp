package maymanm.drugsapp.model.maps.geolocation;

import com.google.gson.annotations.SerializedName;

import maymanm.drugsapp.R;
import maymanm.drugsapp.application.BaseApplication;

public class GeoLocationRequest {

    @SerializedName("key")
    private String key;

    @SerializedName("latlng")
    private String latlng;

    @SerializedName("sensor")
    private boolean sensor;

//    public String getKey() { return BaseApplication.getInstance().getString(R.string.google_maps_key); }

    public String getLatlng() {
        return latlng;
    }

    public void setLatlng(String latlng) {
        this.latlng = latlng;
    }

    public boolean isSensor() {
        return sensor;
    }

    public void setSensor(boolean sensor) {
        this.sensor = sensor;
    }
}
