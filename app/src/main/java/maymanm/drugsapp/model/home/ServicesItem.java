package maymanm.drugsapp.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ServicesItem implements Parcelable {

	@SerializedName("name")
	private String serviceName;

	@SerializedName("service_image")
	private String serviceImage;

	@SerializedName("id")
	private int id;

	protected ServicesItem(Parcel in) {
		serviceName = in.readString();
		serviceImage = in.readString();
		id = in.readInt();
	}

	public static final Creator<ServicesItem> CREATOR = new Creator<ServicesItem>() {
		@Override
		public ServicesItem createFromParcel(Parcel in) {
			return new ServicesItem(in);
		}

		@Override
		public ServicesItem[] newArray(int size) {
			return new ServicesItem[size];
		}
	};

	public void setServiceName(String serviceName){
		this.serviceName = serviceName;
	}

	public String getServiceName(){
		return serviceName;
	}

	public void setServiceImage(String serviceImage){
		this.serviceImage = serviceImage;
	}

	public String getServiceImage(){
		return serviceImage;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"ServicesItem{" + 
			"service_name = '" + serviceName + '\'' + 
			",service_image = '" + serviceImage + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(serviceName);
		parcel.writeString(serviceImage);
		parcel.writeInt(id);
	}
}