package maymanm.drugsapp.model.notification.setting;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationSettingsResponse{

	@SerializedName("data")
	private List<SettingItem> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(List<SettingItem> data){
		this.data = data;
	}

	public List<SettingItem> getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"NotificationSettingsResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}