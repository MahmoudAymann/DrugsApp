package maymanm.drugsapp.model.home;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ServicesResponse implements Serializable {

	@SerializedName("data")
	private ServicesData data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setServicesData(ServicesData data){
		this.data = data;
	}

	public ServicesData getServicesData(){
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
			"ServicesResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}