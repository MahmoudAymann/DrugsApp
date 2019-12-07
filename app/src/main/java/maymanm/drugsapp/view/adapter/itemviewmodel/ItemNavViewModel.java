package maymanm.drugsapp.view.adapter.itemviewmodel;

import androidx.databinding.Bindable;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.navdrawer.NavDrawerItem;
import timber.log.Timber;

public class ItemNavViewModel extends BaseViewModel {

    public NavDrawerItem navDrawerItem;

    public ItemNavViewModel(NavDrawerItem currentItem) {
        this.navDrawerItem = currentItem;
    }

    public void onItemClick(){
        setValue(null);
    }



}
