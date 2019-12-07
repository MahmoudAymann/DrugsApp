package maymanm.drugsapp.model.notification.setting;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MahmoudAyman on 11/12/2019.
 **/
public class ChangeStatusRequest {

    @SerializedName("service_id")
    private int serviceId;


    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
