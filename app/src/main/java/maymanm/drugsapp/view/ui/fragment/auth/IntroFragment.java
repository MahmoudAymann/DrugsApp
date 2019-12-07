package maymanm.drugsapp.view.ui.fragment.auth;


import android.os.Bundle;

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
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentIntroBinding;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.viewmodel.fragment.auth.IntroViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends BaseFragment implements Observer<Object> {

    private FragmentIntroBinding binding;
    private IntroViewModel viewModel;

    public IntroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container, false);
        ApplicationUtil.underlined(binding.tvSignIn);
        viewModel = new IntroViewModel();
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
        return binding.getRoot();
    }

    @Override
    public void onChanged(Object o) {
        int result = (Integer) o;
        switch (result) {
            case Codes.LOGIN_SCREEN:
            case Codes.REGISTER_SCREEN:
                MovementManager.startAuthActivity(getContext(), result);
                break;
        }
    }
}
