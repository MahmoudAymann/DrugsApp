package maymanm.drugsapp.viewmodel.fragment.auth;

import android.view.View;

import androidx.databinding.ObservableBoolean;

import com.android.volley.Request;

import java.util.List;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.register.RegisterRequest;
import maymanm.drugsapp.model.register.RegisterResponse;
import maymanm.drugsapp.util.ErrorsUtil;
import maymanm.drugsapp.util.PreferenceHelperManager;

public class RegisterViewModel extends BaseViewModel {

    public RegisterRequest registerRequest;
    public ObservableBoolean obsTermsCheck = new ObservableBoolean();

    public RegisterViewModel() {
        registerRequest = new RegisterRequest();
    }

    private void goRegister() {
        if (ErrorsUtil.checkRegisterErrors(this, registerRequest)) {
            setValue(Codes.SHOW_MESSAGE);
            return;
        }
        accessLoadingBar(View.VISIBLE);
        new ConnectionHelper(new ConnectionListener() {
            @Override
            public void onRequestSuccess(Object response) {
                RegisterResponse registerResponse = (RegisterResponse) response;
                switch (registerResponse.getStatus()) {
                    case WebServices.SUCCESS:
                        setMessage(registerResponse.getMessage());
                        PreferenceHelperManager.saveUserDetails(registerResponse.getData());
                        setValue(Codes.HOME_SCREEN);
                        break;
                    case WebServices.FAILED:
                        setMessage(registerResponse.getMessage());
                        setValue(Codes.SHOW_MESSAGE);
                        break;
                }
                accessLoadingBar(View.GONE);
            }
        }).requestJsonObject(Request.Method.POST, WebServices.REGISTER, registerRequest, RegisterResponse.class);
    }

    public void onSignUpClick() {
        registerRequest.setLocation(obsLocation.get());
        if (ErrorsUtil.checkRegisterErrors(this, registerRequest)) {
            setValue(Codes.SHOW_MESSAGE);
            return;
        }
        goRegister();
    }

    public void onSpinnerClick(int type) {
        if (type == 1) { //country
            if (obsShowCityMenu.get()) {
                obsShowCityMenu.set(false);
                obsImageArrowCityUp.set(false);
                return;
            }
            if (obsShowCountryMenu.get()) {
                obsShowCountryMenu.set(false);
                obsImageArrowCountryUp.set(false);
            } else {
                obsShowCountryMenu.set(true);
                obsImageArrowCountryUp.set(true);
            }
        }
        //city
        else {
            if (obsShowCountryMenu.get()) {
                obsShowCountryMenu.set(false);
                obsImageArrowCountryUp.set(false);
                return;
            }
            if (obsShowCityMenu.get()) {
                obsShowCityMenu.set(false);
                obsImageArrowCityUp.set(false);
            } else {
                obsShowCityMenu.set(true);
                obsImageArrowCityUp.set(true);
            }
        }
    }

    public void onBackClick() {
        setValue(Codes.PRESS_BACK);
    }

    public void onLocationClick() {
        setValue(Codes.LOCATION_SCREEN);
    }


    @OnClick
    public void onTermsClick() {
        setValue(Codes.TERMS_SCREEN);
    }

}
