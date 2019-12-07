package maymanm.drugsapp.model.maps.geolocation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeoLocAddressResponse {

	@SerializedName("plus_code")
	private PlusCode plusCode;

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("status")
	private String status;

	public void setPlusCode(PlusCode plusCode){
		this.plusCode = plusCode;
	}

	public PlusCode getPlusCode(){
		return plusCode;
	}

	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"GeoAddressResponse{" + 
			"plus_code = '" + plusCode + '\'' + 
			",results = '" + results + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}