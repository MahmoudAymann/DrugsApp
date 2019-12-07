package maymanm.drugsapp.util;

import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.model.changepassword.ChangePasswordRequest;
import maymanm.drugsapp.model.forgetpass.ForgetPasswordRequest;
import maymanm.drugsapp.model.register.RegisterRequest;
import maymanm.drugsapp.viewmodel.fragment.auth.ForgotPassViewModel;
import maymanm.drugsapp.viewmodel.fragment.auth.RegisterViewModel;
import maymanm.drugsapp.viewmodel.fragment.main.ChangePasswordViewModel;

import static maymanm.drugsapp.util.ApplicationUtil.getString;

public abstract class ErrorsUtil {

    public static boolean isEmptyString(String text) {
        if (text == null) {
            return true;
        }
        return text.trim().length() == 0;
    }

    public static boolean checkRegisterErrors(RegisterViewModel viewModel, RegisterRequest request) {
        if (isEmptyString(request.getFirstName())) {
            viewModel.setMessage(getString(R.string.fname));
            return true;
        }
        if (isEmptyString(request.getLastName())) {
            viewModel.setMessage(getString(R.string.lname));
            return true;
        }
        if (isEmptyString(request.getPassword())) {
            viewModel.setMessage(getString(R.string.password));
            return true;
        }
        if (isEmptyString(request.getLocation())) {
            viewModel.setMessage(getString(R.string.location));
            return true;
        }
        if (isEmptyString(request.getCityId())) {
            viewModel.setMessage(getString(R.string.select_city));
            return true;
        }
        return false;
    }

    public static boolean checkChangePasswordErrors(ChangePasswordViewModel viewModel, ChangePasswordRequest request) {
        if (isEmptyString(request.getOldPassword())
                || isEmptyString(request.getNewPassword())
                || isEmptyString(request.getConfirmPassword())) {
            viewModel.setMessage(getString(R.string.fill_required_data_plz));
            return true;
        }

        if (!Objects.equals(request.getNewPassword(), request.getConfirmPassword())) {
            viewModel.setMessage(getString(R.string.new_password_isnt_match));
            return true;
        }
        return false;
    }


    public static boolean checkForgetPassword(ForgotPassViewModel viewModel, ForgetPasswordRequest request) {
        if (isEmptyString(request.getPassword())
                || isEmptyString(request.getConfirmPassword())) {
            viewModel.setMessage(getString(R.string.fill_required_data_plz));
            return true;
        }

        if (!Objects.equals(request.getPassword(), request.getConfirmPassword())) {
            viewModel.setMessage(getString(R.string.new_password_isnt_match));
            return true;
        }
        return false;
    }



}
