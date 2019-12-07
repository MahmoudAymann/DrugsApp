package maymanm.drugsapp.view.adapter.itemviewmodel;

import androidx.databinding.Bindable;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.home.SlidersItem;

public class ItemSliderViewModel extends BaseViewModel {

    private SlidersItem slidersItem;
    public ItemSliderViewModel(SlidersItem currentItem) {
        this.slidersItem = currentItem;
    }

    @Bindable
    public SlidersItem getSliderItem() {
        return slidersItem;
    }

    public void onItemClick(){
        setValue(null);
    }



}
