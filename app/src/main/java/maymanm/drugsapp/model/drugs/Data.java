package maymanm.drugsapp.model.drugs;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("drugs")
	private List<DrugsItem> drugs;

	public void setDrugs(List<DrugsItem> drugs){
		this.drugs = drugs;
	}

	public List<DrugsItem> getDrugs(){
		return drugs;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"drugs = '" + drugs + '\'' + 
			"}";
		}
}