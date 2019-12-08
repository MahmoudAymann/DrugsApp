package maymanm.drugsapp.view.ui.fragment.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentDiscoverBinding;
import maymanm.drugsapp.databinding.FragmentDrugsBinding;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.viewmodel.fragment.main.DiscoverViewModel;
import maymanm.drugsapp.viewmodel.fragment.main.DrugsViewModel;

//import maymanm.drugsapp.model.home.CategoriesItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment implements Observer<Object> {

    private FragmentDiscoverBinding binding;
    public DiscoverViewModel viewModel;

    public DiscoverFragment() {

    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_discover, container, false);
        setupViewModel();
        return binding.getRoot();
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(DiscoverViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
    }

    @Override
    public void onChanged(Object o) {
        if (o instanceof Integer) {
            int result = (Integer) o;
            if (result == View.VISIBLE || result == View.GONE) {
                showProgressAnimation(result);
            } else if (result == Codes.SHOW_MESSAGE) {
                showMessage(viewModel.getMessage());
            }else if (result == Codes.ONE){
                ApplicationUtil.openWebIntent(requireActivity(), "https://www.omnicalculator.com/health/dosage");
            }else if (result == Codes.TWO){
                ApplicationUtil.openWebIntent(requireActivity(), "http://www.medical-events.info");
            }else if (result == Codes.THREE){
                ApplicationUtil.openWebIntent(requireActivity(), "https://study.com/medical_field_education.html");
            }
        }
    }
}
