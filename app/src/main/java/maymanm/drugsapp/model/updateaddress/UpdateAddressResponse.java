package maymanm.drugsapp.model.updateaddress;

import com.google.gson.annotations.SerializedName;

public class UpdateAddressResponse{

	@SerializedName("address_id")
	private String addressId;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;


	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
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
			"UpdateAddressResponse{" + 
			"address_id = '" + addressId + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}