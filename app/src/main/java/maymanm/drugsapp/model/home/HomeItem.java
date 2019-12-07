package maymanm.drugsapp.model.home;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.R;

import static maymanm.drugsapp.util.ApplicationUtil.getString;

public class HomeItem{

	@SerializedName("image")
	private int imageRes;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public HomeItem() {
	}

	private HomeItem( int id, String name, int imageRes) {
		this.imageRes = imageRes;
		this.name = name;
		this.id = id;
	}

	public int getImageRes() {
		return imageRes;
	}

	public void setImageRes(int imageRes) {
		this.imageRes = imageRes;
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

	@Override
 	public String toString(){
		return 
			"CategoriesItem{" + 
			"image = '" + imageRes + '\'' +
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}

	public List<HomeItem> getListItems() {
		List<HomeItem> homeItems = new ArrayList<>();

		return homeItems;
	}
}