package maymanm.drugsapp.viewmodel.fragment.main;

import android.preference.Preference;

import androidx.databinding.ObservableField;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.model.drugs.DrugsItem;
import maymanm.drugsapp.model.drugs.DrugsResponse;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.parent.TabletsAdapter;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class ProductInfoViewModel extends BaseViewModel {

    public ObservableField<String> obsText = new ObservableField<>();
    public DrugsItem item;
    public ProductInfoViewModel(String text, int id) {
        obsText.set(text);
        getData(id);
    }

    private void getData(int id) {
        for (int i= 0 ; i< PreferenceHelperManager.getDrugsResponse().getData().getDrugs().size(); i++){
            if (id == PreferenceHelperManager.getDrugsResponse().getData().getDrugs().get(i).getId()){
                item = PreferenceHelperManager.getDrugsResponse().getData().getDrugs().get(i);
                break;
            }
        }
        notifyChange();
    }
}
