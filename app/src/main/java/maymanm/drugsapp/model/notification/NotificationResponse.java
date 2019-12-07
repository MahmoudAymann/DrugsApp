package maymanm.drugsapp.model.notification;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationResponse{

	@SerializedName("data")
	private List<NotificationItem> data;

	@SerializedName("msg")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(List<NotificationItem> data){
		this.data = data;
	}

	public List<NotificationItem> getData(){
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
			"NotificationResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}