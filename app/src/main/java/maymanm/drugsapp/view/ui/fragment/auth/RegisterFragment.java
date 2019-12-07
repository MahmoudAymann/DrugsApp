package maymanm.drugsapp.view.ui.fragment.auth;

import android.content.Intent;
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
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentRegisterBinding;
import maymanm.drugsapp.view.ui.activity.AuthActivity;
import maymanm.drugsapp.viewmodel.fragment.auth.RegisterViewModel;

/**
 * A simple {@link Fragment} subclass.
 */

public class RegisterFragment extends BaseFragment implements Observer<Object> {

    private FragmentRegisterBinding binding;
    private RegisterViewModel viewModel;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        settingViewModel();
        return binding.getRoot();
    }

    private void settingViewModel() {
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Codes.LOCATION_SCREEN_REQUEST_CODE) {
            setData(data.getExtras());
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void setData(Bundle data) {
        if (data != null) {
            double lat = data.getDouble(Params.LATITUDE, 0);
            double lng = data.getDouble(Params.LONGITUDE, 0);
            String address = data.getString(Params.ADDRESS);
            viewModel.registerRequest.setLat(lat);
            viewModel.registerRequest.setLng(lng);
            viewModel.obsLocation.set(address);
        }
    }

    @Override
    public void onChanged(Object o) {
        int result = (Integer) o;
        if (result == View.GONE || result == View.VISIBLE) {
            showProgressAnimation(result);
        }else if (result == Codes.SHOW_MESSAGE){
            showMessage(viewModel.getMessage());
        }else if (result == Codes.PRESS_BACK){
            requireActivity().finish();
        }else if (result == Codes.LOCATION_SCREEN){
            MovementManager.startActivityForResult(requireActivity(), AuthActivity.class,
                    Codes.LOCATION_SCREEN_REQUEST_CODE, Codes.MAP_SCREEN);
        }else if (result == Codes.TERMS_SCREEN){
            MovementManager.startDetailsActivity(getContext(), Codes.TERMS_SCREEN);
        }else if (result == Codes.HOME_SCREEN){
            MovementManager.startMainActivity(getContext(), Codes.HOME_SCREEN);
            requireActivity().finishAffinity();
        }

    }
}
