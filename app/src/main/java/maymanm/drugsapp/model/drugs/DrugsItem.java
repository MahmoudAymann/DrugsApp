package maymanm.drugsapp.model.drugs;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DrugsItem{

	@SerializedName("image")
	private String image;

	@SerializedName("overdose")
	private String overdose;

	@SerializedName("contraindications")
	private String contraindications;

	@SerializedName("precautions")
	private String precautions;

	@SerializedName("pregnancy")
	private String pregnancy;

	@SerializedName("packaging")
	private String packaging;

	@SerializedName("interactions")
	private String interactions;

	@SerializedName("side_effects")
	private String sideEffects;

	@SerializedName("rate")
	private String rate;

	@SerializedName("composition")
	private String composition;

	@SerializedName("pharmacology")
	private String pharmacology;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("indication")
	private String indication;

	@SerializedName("tablets")
	private List<TabletsItem> tablets;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setOverdose(String overdose){
		this.overdose = overdose;
	}

	public String getOverdose(){
		return overdose;
	}

	public void setContraindications(String contraindications){
		this.contraindications = contraindications;
	}

	public String getContraindications(){
		return contraindications;
	}

	public void setPrecautions(String precautions){
		this.precautions = precautions;
	}

	public String getPrecautions(){
		return precautions;
	}

	public void setPregnancy(String pregnancy){
		this.pregnancy = pregnancy;
	}

	public String getPregnancy(){
		return pregnancy;
	}

	public void setPackaging(String packaging){
		this.packaging = packaging;
	}

	public String getPackaging(){
		return packaging;
	}

	public void setInteractions(String interactions){
		this.interactions = interactions;
	}

	public String getInteractions(){
		return interactions;
	}

	public void setSideEffects(String sideEffects){
		this.sideEffects = sideEffects;
	}

	public String getSideEffects(){
		return sideEffects;
	}

	public void setRate(String rate){
		this.rate = rate;
	}

	public String getRate(){
		return rate;
	}

	public void setComposition(String composition){
		this.composition = composition;
	}

	public String getComposition(){
		return composition;
	}

	public void setPharmacology(String pharmacology){
		this.pharmacology = pharmacology;
	}

	public String getPharmacology(){
		return pharmacology;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIndication(String indication){
		this.indication = indication;
	}

	public String getIndication(){
		return indication;
	}

	public void setTablets(List<TabletsItem> tablets){
		this.tablets = tablets;
	}

	public List<TabletsItem> getTablets(){
		return tablets;
	}

	@Override
 	public String toString(){
		return 
			"DrugsItem{" + 
			"image = '" + image + '\'' + 
			",overdose = '" + overdose + '\'' + 
			",contraindications = '" + contraindications + '\'' + 
			",precautions = '" + precautions + '\'' + 
			",pregnancy = '" + pregnancy + '\'' + 
			",packaging = '" + packaging + '\'' + 
			",interactions = '" + interactions + '\'' + 
			",side_effects = '" + sideEffects + '\'' + 
			",rate = '" + rate + '\'' + 
			",composition = '" + composition + '\'' + 
			",pharmacology = '" + pharmacology + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",indication = '" + indication + '\'' + 
			",tablets = '" + tablets + '\'' + 
			"}";
		}
}