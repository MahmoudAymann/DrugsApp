package maymanm.drugsapp.model.login.request;

import com.google.gson.annotations.SerializedName;

import maymanm.drugsapp.util.PreferenceHelperManager;

public class LoginRequest {

    @SerializedName("phone_number")
    private String phone;

    @SerializedName("password")
    private String password;

    @SerializedName("type")
    private int type = 1;

    @SerializedName("firebase")
    private String firebase = PreferenceHelperManager.getGoogleToken();

    public String getFirebase() {
        return firebase;
    }

    public void setFirebase(String firebase) {
        this.firebase = firebase;
    }

    public int getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
