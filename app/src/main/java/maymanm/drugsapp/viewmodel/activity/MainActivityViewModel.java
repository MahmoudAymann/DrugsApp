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
        if(PreferenceHelperManager.getUserLoginDetails().getFirstName() != null){
            navDrawerContainer.getNavHeaderItem().setName(PreferenceHelperManager.getUserLoginDetails().getFirstName() + " " +PreferenceHelperManager.getUserLoginDetails().getLastName());
        }else
            navDrawerContainer.getNavHeaderItem().setName(getString(R.string.new_user));
        navDrawerContainer.getNavHeaderItem().setPhone(PreferenceHelperManager.getUserLoginDetails().getPhoneNumber());
        navDrawerContainer.getNavHeaderItem().setImage(PreferenceHelperManager.getUserLoginDetails().getUserImage());
        navDrawerContainer.getNavHeaderItem().setPoints(PreferenceHelperManager.getUserLoginDetails().getPoints());
        notifyChange();
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

    @OnClick
    public void onSearchClick(){
        setValue(Codes.TOOLBAR_SEARCH_CLICK);
    }

}