package maymanm.drugsapp.model.notification;

import com.google.gson.annotations.SerializedName;

public class NotificationItem{

	@SerializedName("id")
	private int id;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("title")
	private String title;

	@SerializedName("message")
	private String message;

	@SerializedName("type")
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"created_at = '" + createdAt + '\'' + 
			",title = '" + title + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}