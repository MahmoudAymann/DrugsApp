package maymanm.drugsapp.viewmodel.fragment.auth;

import android.view.View;

import com.android.volley.Request;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.GeneralResponse;
import maymanm.drugsapp.model.forgetpass.ForgetPasswordRequest;
import maymanm.drugsapp.util.ErrorsUtil;

public class ForgotPassViewModel extends BaseViewModel {
     public ForgetPasswordRequest request = new ForgetPasswordRequest();

     @OnClick
     public void onSubmitClick() {
          if (ErrorsUtil.checkForgetPassword(this, request)) {
               setValue(Codes.SHOW_MESSAGE);
               return;
          }
          resetPassword();
     }

     private void resetPassword() {
          accessLoadingBar(View.VISIBLE);
          new ConnectionHelper(new ConnectionListener() {
               @Override
               public void onRequestSuccess(Object response) {
                    GeneralResponse loginResponse = (GeneralResponse) response;
                    switch (loginResponse.getStatus()) {
                         case WebServices.SUCCESS:
                              setMessage(loginResponse.getMessage());
                              setValue(Codes.SHOW_MESSAGE);
                              setValue(Codes.LOGIN_SCREEN);
                              break;
                         case WebServices.FAILED:
                              setMessage(loginResponse.getMessage());
                              setValue(Codes.SHOW_MESSAGE);
                              break;
                    }
                    accessLoadingBar(View.GONE);
               }
          }).requestJsonObject(Request.Method.POST, WebServices.CHANGE_PASSWORD, request, GeneralResponse.class);
     }
}
