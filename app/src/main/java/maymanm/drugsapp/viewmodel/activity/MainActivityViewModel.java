package maymanm.drugsapp.viewmodel.activity;

import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;

import maymanm.drugsapp.R;
import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.model.navdrawer.NavDrawerContainer;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.parent.NavDrawerAdapter;

public class MainActivityViewModel extends BaseViewModel {
    public NavDrawerContainer navDrawerContainer;
    public NavDrawerAdapter navDrawerAdapter;
    public ObservableBoolean showSearchIcon = new ObservableBoolean();

    public MainActivityViewModel() {
        navDrawerAdapter = new NavDrawerAdapter();
        navDrawerContainer = new NavDrawerContainer();
        setItems();
    }



    public void refreshUserData(){
//        if(PreferenceHelperManager.getDrugsResponse().getFirstName() != null){
//            navDrawerContainer.getNavHeaderItem().setName(PreferenceHelperManager.getDrugsResponse().getFirstName() + " " +PreferenceHelperManager.getDrugsResponse().getLastName());
//        }else
//            navDrawerContainer.getNavHeaderItem().setName(getString(R.string.new_user));
//        navDrawerContainer.getNavHeaderItem().setPhone(PreferenceHelperManager.getDrugsResponse().getPhoneNumber());
//        navDrawerContainer.getNavHeaderItem().setImage(PreferenceHelperManager.getDrugsResponse().getUserImage());
//        navDrawerContainer.getNavHeaderItem().setPoints(PreferenceHelperManager.getDrugsResponse().getPoints());
//        notifyChange();
    }

    private void setItems() {
        if (PreferenceHelperManager.isLogged()) {
            refreshUserData();
        }
        navDrawerAdapter.updateDataList(navDrawerContainer.getDrawerItemsData());
        notifyChange();
    }

    @OnClick
    public void onGrandBtnClick(){
        setValue(Codes.ON_GRAND_CLICK);
    }

    @OnClick
    public void onProfileClick(){
        setValue(Codes.PROFILE_SCREEN);
    }


}