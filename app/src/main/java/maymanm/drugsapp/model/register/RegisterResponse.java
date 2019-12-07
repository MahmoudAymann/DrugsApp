package maymanm.drugsapp.model.register;

import com.google.gson.annotations.SerializedName;

import maymanm.drugsapp.model.login.response.AccountData;

public class RegisterResponse{

	@SerializedName("data")
	private AccountData data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(AccountData data){
		this.data = data;
	}

	public AccountData getData(){
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
			"RegisterResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}