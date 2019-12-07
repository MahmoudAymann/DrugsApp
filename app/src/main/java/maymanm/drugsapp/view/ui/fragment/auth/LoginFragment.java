package maymanm.drugsapp.view.ui.fragment.auth;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentLoginBinding;
import maymanm.drugsapp.view.ui.activity.AuthActivity;
import maymanm.drugsapp.view.ui.activity.MainActivity;
import maymanm.drugsapp.viewmodel.fragment.auth.LoginViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment implements Observer<Object> {
    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
    }

    @Override
    public void onChanged(Object o) {
        int result = (Integer) o;
        if (result == View.GONE || result == View.VISIBLE) {
            showProgressAnimation(result);
        }else if (result == Codes.SHOW_MESSAGE){
            showMessage(viewModel.getMessage());
        }else if(result == Codes.HOME_SCREEN){
            MovementManager.startActivityFragment(getContext(), MainActivity.class, result);
            requireActivity().finishAffinity();
        }else if (result == Codes.ENTER_PHONE_SCREEN){
            Bundle bundle = new Bundle();
            bundle.putInt(Params.FRAG_NAME_INT, Codes.FORGOT_PASSWORD_SCREEN);
            MovementManager.startActivityFragment(getContext(), AuthActivity.class, result, bundle);
        }else if (result == Codes.FORGOT_PASSWORD_SCREEN){
            MovementManager.startActivityFragment(getContext(), AuthActivity.class, result);
        }else if (result == Codes.REGISTER_SCREEN){
            Bundle bundle = new Bundle();
            bundle.putInt(Params.FRAG_NAME_INT, Codes.REGISTER_SCREEN);
            MovementManager.startActivityFragment(getContext(), AuthActivity.class, Codes.ENTER_PHONE_SCREEN, bundle);

        }
    }
}
