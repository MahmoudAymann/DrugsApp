package maymanm.drugsapp.model.notification.setting;

import com.google.gson.annotations.SerializedName;

public class ChangeStatusResponse{

	@SerializedName("isNotify")
	private int isNotify;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setIsNotify(int isNotify){
		this.isNotify = isNotify;
	}

	public int getIsNotify(){
		return isNotify;
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
			"ChangeStatusResponse{" + 
			"isNotify = '" + isNotify + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}