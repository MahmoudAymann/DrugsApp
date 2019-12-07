package maymanm.drugsapp.view.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.airbnb.lottie.LottieAnimationView;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.ParentActivity;
import maymanm.drugsapp.databinding.ActivityDetailsBinding;
import maymanm.drugsapp.listener.OnSearchViewListener;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.LocalHelper;
import maymanm.drugsapp.viewmodel.activity.DetailsActivityViewModel;
import timber.log.Timber;

public class DetailsActivity extends ParentActivity implements Observer<Object> {
    private ActivityDetailsBinding binding;
    private DetailsActivityViewModel viewModel;
    private OnSearchViewListener searchViewListener;
    private int fragment;

    public void searchViewListener(OnSearchViewListener searchViewListener) {
        this.searchViewListener = searchViewListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LocalHelper.changeLanguage(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        ApplicationUtil.setElevation(binding.appBarDetails.toolbar, 4);
        setViewModel();
        if (getIntent().hasExtra(Params.INTENT_PAGE)) {
            fragment = getIntent().getIntExtra(Params.INTENT_PAGE, 0);
            addFragment(fragment);
        } else
            Timber.e("no fragment registered");
    }

    private void addFragment(int page) {
        Fragment fragment;
    }

    private void setViewModel() {
        viewModel = new DetailsActivityViewModel();
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(this, this);
    }

//    public ProgressBar getProgressBar() {
//        return binding.appBarDetails.contentDetails.pbDetails;
//    }

    public Toolbar getToolBar() {
        return binding.appBarDetails.toolbar;
    }

    public LottieAnimationView getAnimationView() {
        return binding.appBarDetails.contentDetails.animView;
    }

    public TextView getToolbarTitle() {
        return binding.appBarDetails.toolbarTitle;
    }



    @Override
    public void onChanged(Object o) {
        //mutable live data changes
        int result = (Integer) o;
        if (result == Codes.PRESS_BACK) {
            onBackPressed();
        }else if (result == Codes.ON_TEXT_CHANGED) {
            searchViewListener.onQueryTextSubmit(viewModel.getMessage());
        }
    }
}
