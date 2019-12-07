package maymanm.drugsapp.view.adapter.itemviewmodel;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.drugs.TabletsItem;
import maymanm.drugsapp.model.favourite.FavouriteItem;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class ItemTabletViewModel extends BaseViewModel {
    public TabletsItem item;

    public ItemTabletViewModel(TabletsItem item) {
        this.item = item;
    }


    public void onItemClick() {
        setValue(null);
    }
}
