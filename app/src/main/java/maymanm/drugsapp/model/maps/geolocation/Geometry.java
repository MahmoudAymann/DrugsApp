package maymanm.drugsapp.model.maps.geolocation;

import com.google.gson.annotations.SerializedName;

public class Geometry{

	@SerializedName("viewport")
	private Viewport viewport;

	@SerializedName("bounds")
	private Bounds bounds;

	@SerializedName("location")
	private Location location;

	@SerializedName("location_type")
	private String locationType;

	public void setViewport(Viewport viewport){
		this.viewport = viewport;
	}

	public Viewport getViewport(){
		return viewport;
	}

	public void setBounds(Bounds bounds){
		this.bounds = bounds;
	}

	public Bounds getBounds(){
		return bounds;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setLocationType(String locationType){
		this.locationType = locationType;
	}

	public String getLocationType(){
		return locationType;
	}

	@Override
 	public String toString(){
		return 
			"Geometry{" + 
			"viewport = '" + viewport + '\'' + 
			",bounds = '" + bounds + '\'' + 
			",location = '" + location + '\'' + 
			",location_type = '" + locationType + '\'' + 
			"}";
		}
}