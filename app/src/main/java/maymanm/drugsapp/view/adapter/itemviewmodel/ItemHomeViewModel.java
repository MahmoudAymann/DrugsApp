package maymanm.drugsapp.view.adapter.itemviewmodel;

import androidx.databinding.Bindable;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.home.HomeItem;

public class ItemHomeViewModel extends BaseViewModel {

    private HomeItem HomeItem;
    public ItemHomeViewModel(HomeItem homeItem) {
        this.HomeItem = homeItem;
    }

    @Bindable
    public HomeItem getHomeItem() {
        return HomeItem;
    }

    public void onItemClick(){
        setValue(null);
    }



}
