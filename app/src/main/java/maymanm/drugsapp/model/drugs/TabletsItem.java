package maymanm.drugsapp.model.drugs;

import com.google.gson.annotations.SerializedName;

public class TabletsItem{

	@SerializedName("cost")
	private String cost;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	public void setCost(String cost){
		this.cost = cost;
	}

	public String getCost(){
		return cost;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
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
			"TabletsItem{" + 
			"cost = '" + cost + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}