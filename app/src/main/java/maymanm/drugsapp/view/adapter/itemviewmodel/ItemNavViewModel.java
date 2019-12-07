package maymanm.drugsapp.view.adapter.itemviewmodel;

import androidx.databinding.Bindable;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.navdrawer.NavDrawerItem;

public class ItemNavViewModel extends BaseViewModel {

    private NavDrawerItem navDrawerItem;

    public ItemNavViewModel(NavDrawerItem currentItem) {
        this.navDrawerItem = currentItem;
    }

    @Bindable
    public NavDrawerItem getNavDrawerItem() {
        return navDrawerItem;
    }

    public void onItemClick(){
        setValue(null);
    }



}
