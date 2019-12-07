package maymanm.drugsapp.view.ui.activity;


import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.ParentActivity;
import maymanm.drugsapp.databinding.ActivityAuthBinding;
import maymanm.drugsapp.util.LocalHelper;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.view.ui.fragment.auth.ForgotPasswordFragment;
import maymanm.drugsapp.view.ui.fragment.auth.IntroFragment;
import maymanm.drugsapp.view.ui.fragment.auth.LoginFragment;
import maymanm.drugsapp.view.ui.fragment.auth.RegisterFragment;
import timber.log.Timber;

public class AuthActivity extends ParentActivity {
    public ActivityAuthBinding binding;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LocalHelper.changeLanguage(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        if (getIntent().hasExtra(Params.INTENT_PAGE)) {
            addFragment(getIntent().getIntExtra(Params.INTENT_PAGE, 0));
        } else
            Timber.e("no fragment registered");
    }

    private void addFragment(int page) {
        Fragment fragment;
        if (page == Codes.REGISTER_SCREEN) {
            fragment = new RegisterFragment();
        }else if (page == Codes.FORGOT_PASSWORD_SCREEN) {
            fragment = new ForgotPasswordFragment();
        } else if (page == Codes.INTRO_SCREEN) {
            fragment = new IntroFragment();
        } else {
            fragment = new LoginFragment();
        }

        fragment.setArguments(getIntent().getBundleExtra(Params.BUNDLE_PAGE));
        MovementManager.replaceFragment(this, fragment, "");
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public LottieAnimationView getAnimationView() {
        return binding.animView;
    }

    @Override
    public void onBackPressed() {
        if (isTaskRoot()) {
            MyAnimation.starDialogWithAnim(this, Codes.EXIT_DIALOG, binding.getRoot());
        }
        else {
            super.onBackPressed();
        }
    }
}
