package maymanm.drugsapp.base.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.RevealAnimation;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.databinding.ActivityDialogBinding;
import maymanm.drugsapp.view.ui.fragment.dialogs.ExitDialogFragment;
import maymanm.drugsapp.view.ui.fragment.dialogs.ImageDialogFragment;
import maymanm.drugsapp.view.ui.fragment.dialogs.LogoutDialogFragment;
import maymanm.drugsapp.view.ui.fragment.dialogs.PermissionDialogFragment;
import timber.log.Timber;

public class DialogActivity extends ParentActivity {
    ActivityDialogBinding binding;
    RevealAnimation mRevealAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dialog);
        mRevealAnimation = new RevealAnimation(binding.getRoot(), getIntent().getBundleExtra(Params.BUNDLE_PAGE), this);

        if (getIntent().hasExtra(Params.INTENT_PAGE)) {
            addFragment(getIntent().getIntExtra(Params.INTENT_PAGE, 0));
        } else
            Timber.e("no fragment registered");
    }

    private void addFragment(int page) {
        Fragment fragment;
         if (page == Codes.PERMISSION_DIALOG) {
            fragment = new PermissionDialogFragment();
        }  else if (page == Codes.EXIT_DIALOG) {
            fragment = new ExitDialogFragment();
        } else if (page == Codes.LOGOUT_SCREEN) {
            fragment = new LogoutDialogFragment();
        }else{
            fragment = new ImageDialogFragment();
        }

        fragment.setArguments(getIntent().getBundleExtra(Params.BUNDLE_PAGE));
        MovementManager.replaceFragment(this, fragment, "");
    }

    @Override
    public void onBackPressed() {
        mRevealAnimation.unRevealActivity();
    }

    public LottieAnimationView getAnimationView() {
        return binding.animView;
    }

}
