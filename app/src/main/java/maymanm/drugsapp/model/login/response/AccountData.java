
package maymanm.drugsapp.model.login.response;

import com.google.gson.annotations.SerializedName;

public class AccountData {

    @SerializedName("country")
    private String country;

    @SerializedName("lng")
    private String lng;

    @SerializedName("user_image")
    private String userImage;

    @SerializedName("jwt_token")
    private String jwtToken;

    @SerializedName("address_id")
    private String addressId;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("user_number")
    private String userNumber;

    @SerializedName("points")
    private String points;

    @SerializedName("city_name")
    private String cityName;

    @SerializedName("qr_code")
    private String qrCode;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("location")
    private String location;

    @SerializedName("id")
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("lat")
    private String lat;

    @SerializedName("country_id")
    private String countryId;

    @SerializedName("city_id")
    private String cityId;

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setLng(String lng){
        this.lng = lng;
    }

    public String getLng(){
        return lng;
    }

    public void setUserImage(String userImage){
        this.userImage = userImage;
    }

    public String getUserImage(){
        return userImage;
    }

    public void setJwtToken(String jwtToken){
        this.jwtToken = jwtToken;
    }

    public String getJwtToken(){
        return jwtToken;
    }

    public void setAddressId(String addressId){
        this.addressId = addressId;
    }

    public String getAddressId(){
        return addressId;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setUserNumber(String userNumber){
        this.userNumber = userNumber;
    }

    public String getUserNumber(){
        return userNumber;
    }

    public void setPoints(String points){
        this.points = points;
    }

    public String getPoints(){
        return points;
    }

    public void setCityName(String cityName){
        this.cityName = cityName;
    }

    public String getCityName(){
        return cityName;
    }

    public void setQrCode(String qrCode){
        this.qrCode = qrCode;
    }

    public String getQrCode(){
        return qrCode;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLat(String lat){
        this.lat = lat;
    }

    public String getLat(){
        return lat;
    }

    public void setCountryId(String countryId){
        this.countryId = countryId;
    }

    public String getCountryId(){
        return countryId;
    }

    public void setCityId(String cityId){
        this.cityId = cityId;
    }

    public String getCityId(){
        return cityId;
    }

    @Override
    public String toString(){
        return
                "Data{" +
                        "country = '" + country + '\'' +
                        ",lng = '" + lng + '\'' +
                        ",user_image = '" + userImage + '\'' +
                        ",jwt_token = '" + jwtToken + '\'' +
                        ",address_id = '" + addressId + '\'' +
                        ",last_name = '" + lastName + '\'' +
                        ",user_number = '" + userNumber + '\'' +
                        ",points = '" + points + '\'' +
                        ",city_name = '" + cityName + '\'' +
                        ",qr_code = '" + qrCode + '\'' +
                        ",phone_number = '" + phoneNumber + '\'' +
                        ",location = '" + location + '\'' +
                        ",id = '" + id + '\'' +
                        ",first_name = '" + firstName + '\'' +
                        ",lat = '" + lat + '\'' +
                        ",country_id = '" + countryId + '\'' +
                        ",city_id = '" + cityId + '\'' +
                        "}";
    }
}
