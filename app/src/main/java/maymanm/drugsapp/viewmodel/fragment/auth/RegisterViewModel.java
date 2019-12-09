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
import maymanm.drugsapp.util.RxUtils;

public class RegisterViewModel extends BaseViewModel {
    public ObservableInt obsIsMedical = new ObservableInt(-1);
    public RegisterViewModel() {

    }

    public void onCheckClick(int isMedical){
        obsIsMedical.set(isMedical);
    }

    @OnClick
    public void onSignUpClick() {
        accessLoadingBar(View.VISIBLE);
        RxUtils.delay(2, () -> {
            setMessage("your information has been added");
            setValue(Codes.SHOW_MESSAGE);
            setValue(Codes.HOME_SCREEN);
        });
    }

    public void onBackClick() {
        setValue(Codes.PRESS_BACK);
    }
}
