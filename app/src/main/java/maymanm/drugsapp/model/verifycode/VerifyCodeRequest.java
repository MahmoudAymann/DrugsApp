package maymanm.drugsapp.model.verifycode;

import com.google.gson.annotations.SerializedName;

import maymanm.drugsapp.util.PreferenceHelperManager;

public class VerifyCodeRequest {

    @SerializedName("phone")
    private String phone = PreferenceHelperManager.getPhone();

    @SerializedName("activate_code")
    private String activateCode;

    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
