package maymanm.drugsapp.viewmodel.fragment.main.profile;

import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.android.volley.Request;

import java.util.ArrayList;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.filesutils.VolleyFileObject;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.login.response.AccountData;
import maymanm.drugsapp.model.profile.ProfileRequest;
import maymanm.drugsapp.model.profile.ProfileResponse;
import maymanm.drugsapp.util.PreferenceHelperManager;
import timber.log.Timber;

public class ProfileViewModel extends BaseViewModel {

    public ProfileRequest profileRequest;
    private ArrayList<VolleyFileObject> volleyFileObjects;
    private ProfileResponse profileResponse;
    public ObservableField<String> obsLocation = new ObservableField<>();
    public AccountData accountData;
    public ObservableBoolean obsShowRemoveBtn = new ObservableBoolean();
    private int fragmentNameInt;

    public ProfileViewModel(int fragmentNameInt) {
        this.fragmentNameInt = fragmentNameInt;
        profileRequest = new ProfileRequest();
        volleyFileObjects = new ArrayList<>();
        getProfileData();
    }

    public ArrayList<VolleyFileObject> getVolleyFileObjects() {
        return volleyFileObjects;
    }

    private void updateNoImage() {
        Timber.e("no image");
        profileRequest.setImage(null);
        new ConnectionHelper(new ConnectionListener() {
            @Override
            public void onRequestSuccess(Object response) {
                profileResponse = (ProfileResponse) response;
                if (profileResponse.getStatus() == WebServices.SUCCESS) {
                    setMessage(profileResponse.getMsg());
                    setValue(Codes.SHOW_MESSAGE);
                    saveUserData();
                    setValue(Codes.HOME_SCREEN);
                } else if (profileResponse.getStatus() == WebServices.FAILED) {
                    setMessage(profileResponse.getMsg());
                    setValue(Codes.SHOW_MESSAGE);
                }
                accessLoadingBar(View.GONE);
            }

            @Override
            public void onRequestError(String error) {
                setMessage(error);
                setValue(Codes.SHOW_MESSAGE);
                accessLoadingBar(View.GONE);
            }
        }).requestJsonObject(Request.Method.POST, WebServices.EDIT_PROFILE, profileRequest, ProfileResponse.class);

    }

    private void updateWithImage() {
        Timber.e("image");
        new ConnectionHelper(new ConnectionListener() {
            @Override
            public void onRequestSuccess(Object response) {
                profileResponse = (ProfileResponse) response;
                if (profileResponse.getStatus() == WebServices.SUCCESS) {
                    setMessage(profileResponse.getMsg());
                    setValue(Codes.SHOW_MESSAGE);
                    saveUserData();
                    setValue(Codes.HOME_SCREEN);
                } else if (profileResponse.getStatus() == WebServices.FAILED) {
                    setMessage(profileResponse.getMsg());
                    setValue(Codes.SHOW_MESSAGE);
                }
                accessLoadingBar(View.GONE);
            }

            @Override
            public void onRequestError(String error) {
                setMessage(error);
                setValue(Codes.SHOW_MESSAGE);
                accessLoadingBar(View.GONE);
            }

        }).multiPartConnect(WebServices.EDIT_PROFILE, profileRequest, volleyFileObjects, ProfileResponse.class);
    }

    private void saveUserData() {
        if (profileResponse.getData() != null) {
            PreferenceHelperManager.saveUserDetails(profileResponse.getData());
            profileRequest.setImage(PreferenceHelperManager.getUserLoginDetails().getUserImage());
            notifyChange();
        }
    }

    private void getProfileData() {
        accountData = PreferenceHelperManager.getUserLoginDetails();
        notifyChange();
        obsCityName.set(accountData.getCityName());
        obsLocation.set(accountData.getLocation());
        profileRequest.setCityId(accountData.getCityId());
        profileRequest.setLocation(accountData.getLocation());
        profileRequest.setLatitude(Double.parseDouble(accountData.getLat()));
        profileRequest.setLongitude(Double.parseDouble(accountData.getLng()));
    }

    @OnClick
    public void updateBtnClick() {
        accessLoadingBar(View.VISIBLE);
        profileRequest.setLocation(obsLocation.get());
        if (volleyFileObjects.size() != 0) {
            updateWithImage();
            return;
        }
        updateNoImage();
    }

    @OnClick
    public void onChangePassword() {
        setValue(Codes.CHANGE_PASSWORD_SCREEN);
    }

    @OnClick
    public void onQrClick() {
        setValue(Codes.QR_CODE);
    }

    @OnClick
    public void onEditClick() {
        setValue(Codes.ON_EDIT_CLICK);
    }

    @OnClick
    public void onSettingClick() {
        setValue(Codes.ON_SETTING_CLICK);
    }

    @OnClick
    public void onLocationClick() {
        if (obsShowCityMenu.get()) {
            obsShowCityMenu.set(false);
            obsImageArrowCityUp.set(false);
            return;
        }
        setValue(Codes.ON_LOCATION_CLICK);
    }

    @OnClick
    public void onSpinnerClick() {
        if (obsShowCityMenu.get()) {
            obsShowCityMenu.set(false);
            obsImageArrowCityUp.set(false);
        } else {
            obsShowCityMenu.set(true);
            obsImageArrowCityUp.set(true);
        }
    }

    @OnClick
    public void onRemoveImageClick() {
        obsShowRemoveBtn.set(false);
        volleyFileObjects.clear();
        setValue(Codes.ON_REMOVE_IMAGE);
    }

}
