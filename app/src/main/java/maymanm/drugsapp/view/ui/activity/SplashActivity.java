package maymanm.drugsapp.view.ui.activity;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.view.ParentActivity;
import maymanm.drugsapp.databinding.ActivitySplashBinding;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.viewmodel.activity.SplashScreenViewModel;

public class SplashActivity extends ParentActivity implements Observer<Object> {
    ActivitySplashBinding activitySplashScreenBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ApplicationUtil.setTransparent(this);
        super.onCreate(savedInstanceState);
        activitySplashScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        settingViewModel();
    }

    private void settingViewModel() {
        SplashScreenViewModel splashScreenViewModel = new SplashScreenViewModel();
        splashScreenViewModel.getMutableLiveData().observe(this, this);
    }

    @Override
    public void onChanged(Object value) {
        int result = (Integer) value;
        if (result == Codes.HOME_SCREEN)
            MovementManager.startActivityFragment(this, MainActivity.class, Codes.HOME_SCREEN);
        else
            MovementManager.startAuthActivity(this, result);
        finish();
    }

}
