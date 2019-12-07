package maymanm.drugsapp.view.ui.fragment.main;


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

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentHomeBinding;
import maymanm.drugsapp.view.ui.activity.MainActivity;
import maymanm.drugsapp.view.ui.clickhandler.HomeItemsClickHandler;
import maymanm.drugsapp.viewmodel.fragment.main.HomeViewModel;

//import maymanm.drugsapp.model.home.CategoriesItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements Observer<Object> {

    private FragmentHomeBinding binding;
    public HomeViewModel viewModel;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setupViewModel();
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity)getContext()).getViewModel().showSearchIcon.set(true);
    }

    @Override
    public void onDestroyView() {
        viewModel.accessLoadingBar(View.GONE);
        super.onDestroyView();
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
        viewModel.sliderAdapter.getMutableLiveData().observe(getViewLifecycleOwner(), item -> {
            MovementManager.startImageView(requireActivity(),item.getSliderImage(), binding.sliderViewPager, new Bundle());
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
        } else if (o instanceof SparseIntArray) {
            binding.sliderViewPager.setCurrentItem(((SparseIntArray) o)
                    .get(Codes.MOVE_SLIDER), true);
        }
    }
}
