package maymanm.drugsapp.view.ui.fragment.auth;

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
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentForgotPasswordBinding;
import maymanm.drugsapp.viewmodel.fragment.auth.ForgotPassViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForgotPasswordFragment extends BaseFragment implements Observer<Object> {

    private FragmentForgotPasswordBinding binding;
    private ForgotPassViewModel viewModel;

    public ForgotPasswordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_password, container, false);
        viewModel = new ViewModelProvider(this).get(ForgotPassViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
        return binding.getRoot();
    }

    @Override
    public void onChanged(Object o) {
        int result = (Integer) o;
        if (result == View.VISIBLE || result == View.GONE) {
            showProgressAnimation(result);
        }  else if (result == Codes.LOGIN_SCREEN) {
            MovementManager.startAuthActivity(getContext(), Codes.LOGIN_SCREEN);
            requireActivity().finish();
        } else if (result == Codes.SHOW_MESSAGE) {
            showMessage(viewModel.getMessage());
        }
    }
}
