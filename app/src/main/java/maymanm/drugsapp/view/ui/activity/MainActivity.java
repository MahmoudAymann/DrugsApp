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

import com.forms.sti.progresslitieigb.Model.Setting;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.Objects;
import maymanm.drugsapp.R;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.ParentActivity;
import maymanm.drugsapp.databinding.ActivityMainBinding;
import maymanm.drugsapp.util.LocalHelper;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.util.RxUtils;
import maymanm.drugsapp.util.SettingsManager;
import maymanm.drugsapp.view.adapter.parent.MainFragmentPagerAdapter;
import maymanm.drugsapp.view.ui.clickhandler.SideMenuClickHandler;
import maymanm.drugsapp.view.ui.fragment.main.DisabledFragment;
import maymanm.drugsapp.view.ui.fragment.main.DiscoverFragment;
import maymanm.drugsapp.view.ui.fragment.main.DrugsFragment;
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
        if (getIntent().hasExtra(Params.INTENT_PAGE)) {
            addFragment(getIntent().getIntExtra(Params.INTENT_PAGE, 0));
        } else
            Timber.e("no fragment registered");
    }


    private void addFragment(int page) {
        MainFragmentPagerAdapter hostedAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), getLifecycle());
        hostedAdapter.addFragment(new DrugsFragment(), getIntent().getBundleExtra(Params.BUNDLE_PAGE));
        hostedAdapter.addFragment(new DiscoverFragment(), getIntent().getBundleExtra(Params.BUNDLE_PAGE));
        hostedAdapter.addFragment(new DisabledFragment(), getIntent().getBundleExtra(Params.BUNDLE_PAGE));
        binding.appBarMain.contentMain.viewPager2.setAdapter(hostedAdapter);
        TabLayoutMediator mediator = new TabLayoutMediator(binding.appBarMain.contentMain.tabLayout, binding.appBarMain.contentMain.viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(getString(R.string.drugs));
                    break;
                case 1:
                    tab.setText(getString(R.string.discover));
                    break;
                case 2:
                    tab.setText(getString(R.string.disableds));
                    break;
            }
        });
        mediator.attach();
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
        mToggle.setDrawerIndicatorEnabled(false);
        mToggle.setHomeAsUpIndicator(R.drawable.ic_burger_menu);
        mToggle.setToolbarNavigationClickListener(view -> getDrawerLayout().openDrawer(GravityCompat.START));
        getDrawerLayout().addDrawerListener(mToggle);
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
            if (getSupportFragmentManager().findFragmentById(R.id.fl_home_container) instanceof DrugsFragment) {
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

    public DrawerLayout getDrawerLayout() {
        return binding.drawerLayout;
    }


    @Override
    public void onChanged(Object obj) {
        int result = (Integer) obj;
        switch (result) {
            case Codes.ON_GRAND_CLICK:
                SettingsManager.openFacebook(this, "https://www.facebook.com/Drugs-Home-109294930559087");
                break;
        }
    }
}
