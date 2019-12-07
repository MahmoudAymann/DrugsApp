package maymanm.drugsapp.model.enterphone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import maymanm.drugsapp.base.constantsutils.Codes;

/**
 * Created by MahmoudAyman on 11/16/2019.
 **/
public class EnterPhoneRequest {

    @SerializedName("phone_number")
    private String phone;

    @SerializedName("type")
    private int type = Codes.APP_TYPE;

    @Expose
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
