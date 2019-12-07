package maymanm.drugsapp.viewmodel.activity;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.util.RxUtils;
import io.reactivex.disposables.Disposable;

public class SplashScreenViewModel extends BaseViewModel {

    private Disposable disposable;

    public SplashScreenViewModel() {
        startApp();
    }

    private void startApp() {
        disposable = RxUtils.delay(2, this::doAfterDelay);
    }

    private void doAfterDelay() {
        if (PreferenceHelperManager.isLogged()) {
            setValue(Codes.HOME_SCREEN);
        } else {
            setValue(Codes.LOGIN_SCREEN);
        }
        disposable.dispose();
    }

}
