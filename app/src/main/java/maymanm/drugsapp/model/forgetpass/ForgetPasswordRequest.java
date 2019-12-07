package maymanm.drugsapp.model.forgetpass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MahmoudAyman on 11/16/2019.
 **/
public class ForgetPasswordRequest {

    @SerializedName("new_password")
    private String password;

    @SerializedName("phone_number")
    private String phone;

    @SerializedName("type")
    private int type = 1;

    @Expose
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
