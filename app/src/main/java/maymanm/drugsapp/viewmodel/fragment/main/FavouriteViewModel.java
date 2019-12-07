package maymanm.drugsapp.viewmodel.fragment.main;

import java.util.ArrayList;
import java.util.List;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.drugs.DrugsItem;
import maymanm.drugsapp.model.favourite.FavouriteItem;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.parent.FavouriteAdapter;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class FavouriteViewModel extends BaseViewModel {

    public FavouriteAdapter favouriteAdapter = new FavouriteAdapter();

    private List<FavouriteItem> mDataList = new ArrayList<>();
    private List<DrugsItem> prefList;
    private int counter = 1;

    public FavouriteViewModel() {
        prefList = PreferenceHelperManager.getDrugsResponse().getData().getDrugs();
        for (int i = 0; i < prefList.size(); i++) {
            for (int k = 0; k < PreferenceHelperManager.getIds().size(); k++) {
                if (PreferenceHelperManager.getIds().get(k).equals(String.valueOf(prefList.get(i).getId()))) {
                    FavouriteItem favouriteItem = new FavouriteItem();
                    favouriteItem.setId(counter);
                    counter ++;
                    favouriteItem.setName(prefList.get(i).getName());
                    favouriteItem.setDrugId(prefList.get(i).getId());
                    mDataList.add(favouriteItem);
                }
            }
        }//end for

        favouriteAdapter.updateDataList(mDataList);
    }

    public void onRefresh() {
        isLoading.set(true);
        isLoading.set(false);
    }
}
