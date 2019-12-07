package maymanm.drugsapp.fcmanager;

import com.google.gson.annotations.SerializedName;

public class FirebaseResponse{

	@SerializedName("sound")
	private String sound;

	@SerializedName("icon")
	private String icon;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSound(String sound){
		this.sound = sound;
	}

	public String getSound(){
		return sound;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	@Override
 	public String toString(){
		return 
			"FirebaseResponse{" + 
			"sound = '" + sound + '\'' + 
			",icon = '" + icon + '\'' + 
			",title = '" + title + '\'' + 
			",body = '" + body + '\'' +
			",type = '" + type + '\'' +
			"}";
		}
}