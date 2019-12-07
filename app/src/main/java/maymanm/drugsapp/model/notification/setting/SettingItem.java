package maymanm.drugsapp.model.notification.setting;

import com.google.gson.annotations.SerializedName;

public class SettingItem {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("switch")
    private boolean switcH;

    @SerializedName("image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public boolean isSwitcH() {
        return switcH;
    }

    public void setSwitcH(boolean switcH) {
        this.switcH = switcH;
    }

    @Override
    public String toString(){
        return
                "DataItem{" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        ",switch = '" + switcH + '\'' +
                        "}";
    }
}
