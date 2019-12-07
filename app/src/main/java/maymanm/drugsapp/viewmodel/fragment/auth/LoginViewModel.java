package maymanm.drugsapp.viewmodel.fragment.auth;

import android.view.View;

import com.android.volley.Request;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.login.request.LoginRequest;
import maymanm.drugsapp.model.login.response.LoginResponse;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.PreferenceHelperManager;

public class LoginViewModel extends BaseViewModel {

    private LoginRequest loginRequest = new LoginRequest();

    public LoginViewModel() {
        if  (PreferenceHelperManager.getGoogleToken().equals("n/a")){
            ApplicationUtil.requestNewToken();
        }
    }

    @OnClick
    public void onLoginClick() {
        if  (PreferenceHelperManager.getGoogleToken().equals("n/a")){
            ApplicationUtil.requestNewToken();
            return;
        }
        goLogin();
    }

    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    private void goLogin() {
        loginRequest.setFirebase(PreferenceHelperManager.getGoogleToken());
        accessLoadingBar(View.VISIBLE);
        new ConnectionHelper(new ConnectionListener() {
            @Override
            public void onRequestSuccess(Object response) {
                LoginResponse loginResponse = (LoginResponse) response;
                switch (loginResponse.getStatus()) {
                    case WebServices.SUCCESS:
                        PreferenceHelperManager.saveUserDetails(loginResponse.getData());
                        setMessage(loginResponse.getMessage());
                        setValue(Codes.HOME_SCREEN);
                        break;
                    case WebServices.FAILED:
                            setMessage(loginResponse.getMessage());
                        setValue(Codes.SHOW_MESSAGE);
                        break;
                }
                accessLoadingBar(View.GONE);
            }
        }).requestJsonObject(Request.Method.POST, WebServices.LOGIN, loginRequest, LoginResponse.class);
    }

    public void onSkipClick() {
        setValue(Codes.HOME_SCREEN);
    }

    public void onSignupClick() {
        setValue(Codes.REGISTER_SCREEN);
    }

    public void onForgotPassClick(){
        setValue(Codes.ENTER_PHONE_SCREEN);
    }

}
