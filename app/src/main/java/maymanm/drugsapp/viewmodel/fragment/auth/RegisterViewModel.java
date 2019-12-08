package maymanm.drugsapp.viewmodel.fragment.auth;

import android.view.View;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;

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
    public ObservableInt obsIsMedical = new ObservableInt(-1);
    public RegisterViewModel() {

    }

    public void onCheckClick(int isMedical){
        obsIsMedical.set(isMedical);
    }

    @OnClick
    public void onSignUpClick() {
        setValue(Codes.HOME_SCREEN);
    }

    public void onBackClick() {
        setValue(Codes.PRESS_BACK);
    }
}
