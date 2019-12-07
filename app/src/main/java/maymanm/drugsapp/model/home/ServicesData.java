package maymanm.drugsapp.model.home;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ServicesData implements Parcelable {

	@SerializedName("services")
	private ArrayList<ServicesItem> services;

	@SerializedName("sliders")
	private List<SlidersItem> sliders;

	private ServicesData(Parcel in) {
		services = in.createTypedArrayList(ServicesItem.CREATOR);
	}

	public static final Creator<ServicesData> CREATOR = new Creator<ServicesData>() {
		@Override
		public ServicesData createFromParcel(Parcel in) {
			return new ServicesData(in);
		}

		@Override
		public ServicesData[] newArray(int size) {
			return new ServicesData[size];
		}
	};

	public void setServices(ArrayList<ServicesItem> services){
		this.services = services;
	}

	public ArrayList<ServicesItem> getServices(){
		return services;
	}

	public void setSliders(List<SlidersItem> sliders){
		this.sliders = sliders;
	}

	public List<SlidersItem> getSliders(){
		return sliders;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"services = '" + services + '\'' + 
			",sliders = '" + sliders + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeTypedList(services);
	}
}