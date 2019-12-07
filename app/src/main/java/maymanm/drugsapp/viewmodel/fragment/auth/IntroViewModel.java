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

public class IntroViewModel extends BaseViewModel {

    public IntroViewModel() {

    }

    @OnClick
    public void onLoginClick() {
        setValue(Codes.LOGIN_SCREEN);
    }


    public void onSignupClick() {
        setValue(Codes.REGISTER_SCREEN);
    }

}
