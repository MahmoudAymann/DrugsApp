package maymanm.drugsapp.model.home;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SlidersItem implements Serializable {

    @SerializedName("slider_image")
    private String sliderImage;

    @SerializedName("id")
    private int id;

    public void setSliderImage(String sliderImage) {
        this.sliderImage = sliderImage;
    }

    public String getSliderImage() {
        return sliderImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "SlidersItem{" +
                        "slider_image = '" + sliderImage + '\'' +
                        "id = '" + id + '\'' +
                        "}";
    }
}