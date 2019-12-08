package maymanm.drugsapp.viewmodel.activity;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.JsonStrings;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.model.drugs.DrugsResponse;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.util.RxUtils;
import io.reactivex.disposables.Disposable;

public class SplashScreenViewModel extends BaseViewModel {

    private Disposable disposable;
    private JsonStrings jsonStrings = new JsonStrings();

    public SplashScreenViewModel() {
        startApp();
        PreferenceHelperManager.saveDrugs(ApplicationUtil.ObjectFromStringJson(jsonStrings.getNormalDrugs(), DrugsResponse.class));
    }

    private void startApp() {
        disposable = RxUtils.delay(2, this::doAfterDelay);
    }

    private void doAfterDelay() {
        if (PreferenceHelperManager.isLogged()) {
            setValue(Codes.HOME_SCREEN);
        } else {
            setValue(Codes.INTRO_SCREEN);
        }
        disposable.dispose();
    }

}
