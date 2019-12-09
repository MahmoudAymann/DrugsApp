package maymanm.drugsapp.viewmodel.activity;

import android.preference.Preference;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.databinding.ObservableBoolean;

import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.util.PreferenceHelperManager;
import timber.log.Timber;

public class DetailsActivityViewModel extends BaseViewModel {

    public ObservableBoolean obsIsProduct = new ObservableBoolean();
    public ObservableBoolean obsIsFav = new ObservableBoolean();


    public DetailsActivityViewModel() {

    }

    public void onButtonBackClick() {
        setValue(Codes.PRESS_BACK);
    }

    public void onFavClick() {
        if (obsIsFav.get()) {
            //remove
            for (int id : PreferenceHelperManager.getIds()) {
                if (PreferenceHelperManager.getDrugId() == id) {
                    PreferenceHelperManager.getIds().remove(Integer.valueOf(id));
                    PreferenceHelperManager.saveIds(PreferenceHelperManager.getIds());
                    break;
                }
            }
            Timber.e("" + PreferenceHelperManager.getIds());
            obsIsFav.set(false);
        } else {
            //add
            List<Integer> stringList = PreferenceHelperManager.getIds();
            stringList.add(PreferenceHelperManager.getDrugId());
            PreferenceHelperManager.saveIds(stringList);
            Timber.e(PreferenceHelperManager.getIds() + "");
            obsIsFav.set(true);
        }
    }
}
