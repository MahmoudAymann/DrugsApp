package maymanm.drugsapp.model.updateaddress;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MahmoudAyman on 11/12/2019.
 **/
public class UpdateAddressRequest {

    @SerializedName("lat")
    private double lat;

    @SerializedName("lng")
    private double lng;


    @SerializedName("location")
    private String location;

    @SerializedName("address_id")
    private String addressId;


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Data{" +
                "lat=" + lat + "\n" +
                "lng=" + lng + "\n" +
                "location=" + location + "\n" +
                "address_id=" + addressId + "\n" +
                "}";
    }
}
