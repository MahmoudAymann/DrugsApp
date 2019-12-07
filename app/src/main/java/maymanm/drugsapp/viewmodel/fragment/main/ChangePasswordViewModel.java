package maymanm.drugsapp.viewmodel.fragment.main;

import android.view.View;

import com.android.volley.Request;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.GeneralResponse;
import maymanm.drugsapp.model.changepassword.ChangePasswordRequest;
import maymanm.drugsapp.util.ErrorsUtil;

public class ChangePasswordViewModel extends BaseViewModel {

    public ChangePasswordRequest passwordRequest = new ChangePasswordRequest();

    public ChangePasswordViewModel() {
    }

    @OnClick
    public void onSubmitClick(){
        if (ErrorsUtil.checkChangePasswordErrors(this, passwordRequest)){
            setValue(Codes.SHOW_MESSAGE);
            return;
        }

        accessLoadingBar(View.VISIBLE);
        new ConnectionHelper(new ConnectionListener() {
            @Override
            public void onRequestSuccess(Object response) {
                GeneralResponse chatResponse = ((GeneralResponse) response);
                switch (chatResponse.getStatus()) {
                    case WebServices.SUCCESS:
                        setMessage(chatResponse.getMessage());
                        setValue(Codes.SHOW_MESSAGE);
                        setValue(Codes.PRESS_BACK);
                        break;
                    case WebServices.FAILED:
                        setMessage(chatResponse.getMessage());
                        setValue(Codes.SHOW_MESSAGE);
                        break;
                }
                accessLoadingBar(View.GONE);
                isLoading.set(false);
            }
        }).requestJsonObject(Request.Method.POST, WebServices.CHANGE_PASSWORD, passwordRequest, GeneralResponse.class);

    }

}
