package maymanm.drugsapp.viewmodel.fragment.auth;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.model.verifycode.VerifyCodeRequest;
import maymanm.drugsapp.util.ErrorsUtil;
import maymanm.drugsapp.util.RxUtils;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class VerifyCodeViewModel extends BaseViewModel {
    public VerifyCodeRequest request = new VerifyCodeRequest();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String verificationId;
    public ObservableBoolean isSending = new ObservableBoolean();
    public ObservableField<String> obsTimer = new ObservableField<>();
    private Disposable disposable;
    private int timeout = 59;
    private int fragmentName;

    public VerifyCodeViewModel(int fragmentName) {
        this.fragmentName = fragmentName;
        startTimer();
    }

    public void onSubmitClick() {
        if (ErrorsUtil.isEmptyString(request.getActivateCode())) {
            setMessage(getString(R.string.enter_code));
            setValue(Codes.SHOW_MESSAGE);
            return;
        }
        verifyCode(request.getActivateCode());
    }

    private void startTimer() {
        isSending.set(true);
        disposable = RxUtils.repeat(1, aLong -> {
            if (timeout == 0) {
                resetTimer();
                disposable.dispose();
                return;
            }
            String builder = getString(R.string.resend_code_at) +
                    "00:" +
                    (timeout -= 1);
            obsTimer.set(builder);
        });
    }

    private void resetTimer() {
        timeout = 59;
        isSending.set(false);
    }

    public PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack() {
        return new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                Timber.e("onVerificationCompleted %s", phoneAuthCredential);
                String code = phoneAuthCredential.getSmsCode();
                if (code != null) { // if device detect code automatically;
                    verifyCode(code);
                }
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Timber.e("FAILED %s", e.getMessage());
                if (e.getMessage().equals("We have blocked all requests from this device due to unusual activity. Try again later.")) {
                    setMessage(getString(R.string.device_blocked));
                } else
                    setMessage(getString(R.string.wrong_phone_number));
                setValue(Codes.SHOW_MESSAGE);
                setValue(Codes.ENTER_PHONE_SCREEN);
            }

            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(verificationId, forceResendingToken);
                Timber.e("onCodeSent");
                VerifyCodeViewModel.this.verificationId = verificationId;
            }
        };
    }

    private void verifyCode(String code) {
        accessLoadingBar(View.VISIBLE);
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        mAuth.signInWithCredential(credential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Timber.e("successfully verified");
                if (fragmentName == Codes.FORGOT_PASSWORD_SCREEN) {
                    setValue(Codes.FORGOT_PASSWORD_SCREEN);
                } else if (fragmentName == Codes.REGISTER_SCREEN) {
                    setValue(Codes.REGISTER_SCREEN);
                }
            } else {
                Timber.e(task.getException());
            }
            accessLoadingBar(View.GONE);
        });
    }

    public void onResendCode() {
        startTimer();
        setValue(Codes.ON_RESEND_CODE);
    }


    @Override
    protected void onCleared() {
        if (disposable != null)
            disposable.dispose();
        super.onCleared();
    }
}
