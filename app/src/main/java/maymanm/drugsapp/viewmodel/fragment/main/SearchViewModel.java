package maymanm.drugsapp.viewmodel.fragment.main;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.model.drugs.DrugsItem;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.parent.DrugsAdapter;
import timber.log.Timber;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class SearchViewModel extends BaseViewModel {

    public DrugsAdapter drugsAdapter = new DrugsAdapter();
    public ObservableField<String> obsText = new ObservableField<>();
    List<DrugsItem> drugsItems;

    public SearchViewModel(String text) {
        obsText.set(text);
        drugsItems = getDrugsList();
        drugsAdapter.setOldListData(drugsItems);
        drugsAdapter.updateDataList(drugsItems);
        setMessage(text);
        setValue(Codes.ON_TEXT_CHANGED);
    }

    private List<DrugsItem> getDrugsList() {
        List<DrugsItem> drugs = new ArrayList<>();
        for (DrugsItem item :
                PreferenceHelperManager.getDrugsResponse().getData().getDrugs()) {
            if (item.getCategory() == PreferenceHelperManager.getDrugCategory()) {
                drugs.add(item);
            }
        }
        return drugs;
    }

    public TextWatcher textWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Timber.e(charSequence.toString());
                if (!charSequence.toString().isEmpty()) {
                    setMessage(charSequence.toString());
                    setValue(Codes.ON_TEXT_CHANGED);
                } else {
//                    drugsAdapter.updateDataList(drugsItems);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }

    @OnClick
    public void onSearchClick() {
        setMessage(obsText.get());
        setValue(Codes.ON_TEXT_CHANGED);
        setValue(Codes.PRESS_SKIP);
    }

}
