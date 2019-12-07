package maymanm.drugsapp.view.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.airbnb.lottie.LottieAnimationView;
import com.tbuonomo.morphbottomnavigation.MorphBottomNavigationView;

import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.ParentActivity;
import maymanm.drugsapp.databinding.ActivityMainBinding;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.LocalHelper;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.util.RxUtils;
import maymanm.drugsapp.view.ui.clickhandler.BottomNavigationBarClick;
import maymanm.drugsapp.view.ui.clickhandler.SideMenuClickHandler;
import maymanm.drugsapp.view.ui.fragment.main.HomeFragment;
import maymanm.drugsapp.viewmodel.activity.MainActivityViewModel;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MainActivity extends ParentActivity implements Observer<Object> {

    private ActionBarDrawerToggle mToggle;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private Disposable disposable;

    public MainActivityViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LocalHelper.changeLanguage(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        settingViewModel();
        settingNavDrawer();
        settingBottomNavigationBar();
        if (getIntent().hasExtra(Params.INTENT_PAGE)) {
            addFragment(getIntent().getIntExtra(Params.INTENT_PAGE, 0));
        } else
            Timber.e("no fragment registered");
    }

    private void settingBottomNavigationBar() {
        getMorphBottomNavigationView().setOnNavigationItemSelectedListener(new BottomNavigationBarClick(this));
    }

    private void addFragment(int page) {
        Fragment fragment = new HomeFragment();
        String backStackText = "";
//        if (page == Codes.NOTIFICATION_SCREEN) {
//            fragment = new NotificationsFragment();
//            backStackText = "NotificationsFragment";
//        }
        fragment.setArguments(getIntent().getBundleExtra(Params.BUNDLE_PAGE));
        MovementManager.replaceFragment(this, fragment, backStackText);
    }

    public MorphBottomNavigationView getMorphBottomNavigationView() {
        return binding.appBarMain.contentMain.bottomNavigationView;
    }

    private void settingViewModel() {
        viewModel = new MainActivityViewModel();
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(this, this);
        viewModel.navDrawerAdapter.getMutableLiveData().observe(this, new SideMenuClickHandler(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.refreshUserData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Codes.CHANGE_LANGUAGE_REQUEST_CODE) {
            if (data != null) {
                if (data.hasExtra(Params.LANGUAGE_CHANGE)) {
                    if (data.getBooleanExtra(Params.LANGUAGE_CHANGE, false)) {
                        disposable = RxUtils.delay(0, this::recreate);
                    }
                }
            }
        }
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_home_container);
            Objects.requireNonNull(fragment).onActivityResult(requestCode, resultCode, data);
        } catch (Exception e) {
            e.getStackTrace();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        if (disposable != null)
            disposable.dispose();
        super.onPause();
    }

    private void settingNavDrawer() {
        mToggle = new ActionBarDrawerToggle(this,
                getDrawerLayout(), getToolbar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        mToggle.setDrawerIndicatorEnabled(false);
//        mToggle.setHomeAsUpIndicator(R.drawable.ic_burger_menu);
//        mToggle.setToolbarNavigationClickListener(view -> getDrawerLayout().openDrawer(GravityCompat.START));
//        getDrawerLayout().addDrawerListener(mToggle);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (getDrawerLayout().isDrawerOpen(GravityCompat.START)) {
            getDrawerLayout().closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().findFragmentById(R.id.fl_home_container) instanceof HomeFragment) {
                MyAnimation.starDialogWithAnim(this, Codes.EXIT_DIALOG, binding.drawerLayout);
            } else {
                super.onBackPressed();
            }
        }
    }

    public Toolbar getToolbar() {
        return binding.appBarMain.toolbar;
    }

    public TextView getToolbarTitle() {
        return binding.appBarMain.toolbarTitle;
    }

    public LottieAnimationView getAnimationView() {
        return binding.appBarMain.contentMain.animView;
    }

    public DrawerLayout getDrawerLayout() {
        return binding.drawerLayout;
    }


    @Override
    public void onChanged(Object obj) {
        int result = (Integer) obj;
        switch (result) {
            case Codes.ON_GRAND_CLICK:
                MyAnimation.starDialogWithAnim(this, Codes.GRAND_DIALOG, binding.drawerLayout);
                break;
            case Codes.PROFILE_SCREEN:
                if (PreferenceHelperManager.isLogged())
                    MovementManager.startActivityFragment(this, DetailsActivity.class, Codes.PROFILE_SCREEN);
                else
                    MovementManager.startActivityFragment(this, AuthActivity.class, Codes.LOGIN_SCREEN);
                break;
        }
    }
}
