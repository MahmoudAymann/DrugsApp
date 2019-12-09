package maymanm.drugsapp.viewmodel.fragment.main;

import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.drugs.DrugsItem;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.parent.FavouriteAdapter;
import timber.log.Timber;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class FavouriteViewModel extends BaseViewModel {

    public FavouriteAdapter favouriteAdapter = new FavouriteAdapter();

    public FavouriteViewModel() {
        List<DrugsItem> prefList = PreferenceHelperManager.getDrugsResponse().getData().getDrugs();
        List<DrugsItem> mDataList = new ArrayList<>();
        for (DrugsItem item : prefList) {
            for (int id : PreferenceHelperManager.getIds()) {
                if (item.getId() == id) {
                    mDataList.add(item);
                }
            }
        }//end for
        Timber.e(mDataList.size() + "");
        favouriteAdapter.updateDataList(mDataList);
    }

    public void onRefresh() {
        isLoading.set(true);
        isLoading.set(false);
    }
}
