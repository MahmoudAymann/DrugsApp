package maymanm.drugsapp.view.ui.fragment.details;


import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentFavouriteBinding;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.viewmodel.fragment.main.FavouriteViewModel;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends BaseFragment implements Observer<Object> {

    private FragmentFavouriteBinding binding;
    private FavouriteViewModel viewModel;

    private Bundle bundle;
    private int shopId;
    public FavouriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false);
        setupViewModel();
        return binding.getRoot();
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(FavouriteViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
        viewModel.favouriteAdapter.getMutableLiveData().observe(getViewLifecycleOwner(), item->{
            Bundle bundle = new Bundle();
            bundle.putInt(Params.PRODUCT_ID, item.getId());
            PreferenceHelperManager.setDrugId(item.getId());
            MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_DETAILS, bundle);
        });
    }



    @Override
    public void onChanged(Object o) {
        if (o instanceof Integer) {
            int result = (Integer) o;
            if (result == View.VISIBLE || result == View.GONE) {
                showProgressAnimation(result);
            } else if (result == Codes.SHOW_MESSAGE) {
                showMessage(viewModel.getMessage());
            }
        }
    }
}
