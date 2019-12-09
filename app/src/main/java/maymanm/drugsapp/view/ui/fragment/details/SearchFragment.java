package maymanm.drugsapp.view.ui.fragment.details;


import android.app.Application;
import android.hardware.Camera.Parameters;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentSearchBinding;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.ArgsUtil;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.viewmodel.fragment.main.SearchViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment implements Observer<Object> {

    private FragmentSearchBinding binding;
    private SearchViewModel viewModel;
    private String text;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = ArgsUtil.getStringArg(getArguments(), Params.SEARCH_TEXT);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        viewModel = new SearchViewModel(text);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);

        viewModel.drugsAdapter.getMutableLiveData().observe(getViewLifecycleOwner(), item->{
            Bundle bundle = new Bundle();
            bundle.putInt(Params.PRODUCT_ID, item.getId());
            PreferenceHelperManager.setDrugId(item.getId());
            MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_DETAILS, bundle);
        });
        return binding.getRoot();
    }


    @Override
    public void onChanged(Object o) {
        int result = (Integer) o;
        if (result == Codes.ON_TEXT_CHANGED){
            viewModel.drugsAdapter.getFilter().filter(viewModel.getMessage());
        }else if (result == Codes.PRESS_SKIP){
            ApplicationUtil.hideKeyboard(requireActivity());
        }
    }
}
