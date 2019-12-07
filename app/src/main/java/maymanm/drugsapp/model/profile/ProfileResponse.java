package maymanm.drugsapp.model.profile;

import com.google.gson.annotations.SerializedName;

import maymanm.drugsapp.model.login.response.AccountData;

public class ProfileResponse{

	@SerializedName("message")
	private String msg;

	@SerializedName("data")
	private AccountData data;

	@SerializedName("status")
	private int status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setData(AccountData data){
		this.data = data;
	}

	public AccountData getData(){
		return data;
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
			"ProfileResponse{" + 
			"msg = '" + msg + '\'' + 
			",data = '" + data + '\'' +
			",status = '" + status + '\'' + 
			"}";
		}
}