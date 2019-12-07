package maymanm.drugsapp.view.adapter.itemviewmodel;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.favourite.FavouriteItem;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class ItemFavouriteViewModel extends BaseViewModel {
    public FavouriteItem item;

    public ItemFavouriteViewModel(FavouriteItem item) {
        this.item = item;
    }


    public void onItemClick() {
        setValue(null);
    }
}
