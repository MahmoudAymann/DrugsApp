package maymanm.drugsapp.viewmodel.fragment.main;


import android.util.SparseIntArray;
import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.android.volley.Request;

import java.util.List;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.home.HomeItem;
import maymanm.drugsapp.model.home.ServicesResponse;
import maymanm.drugsapp.model.home.SlidersItem;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.util.RxUtils;
import maymanm.drugsapp.view.adapter.parent.HomeAdapter;
import io.reactivex.disposables.Disposable;

public class DrugsViewModel extends BaseViewModel {
    public ObservableBoolean obsIsBrand = new ObservableBoolean(true);
    public ObservableField<String> obsText = new ObservableField<>();
    public DrugsViewModel() {
        startPopulateData();
    }


    private void startPopulateData() {

    }

    @OnClick
    public void onRadioClick(boolean isBrand){
        obsIsBrand.set(isBrand);
    }

    @OnClick
    public void onSearchClick(){
        if (obsIsBrand.get()){
            PreferenceHelperManager.setDrugCategory(1);
        }else
            PreferenceHelperManager.setDrugCategory(2);
        setValue(Codes.SEARCH_SCREEN);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
