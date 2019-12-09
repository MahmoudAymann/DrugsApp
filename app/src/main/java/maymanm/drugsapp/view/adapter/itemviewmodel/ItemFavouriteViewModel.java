package maymanm.drugsapp.view.adapter.itemviewmodel;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.drugs.DrugsItem;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class ItemFavouriteViewModel extends BaseViewModel {
    public DrugsItem item;

    public ItemFavouriteViewModel(DrugsItem item) {
        this.item = item;
    }


    public void onItemClick() {
        setValue(null);
    }
}
