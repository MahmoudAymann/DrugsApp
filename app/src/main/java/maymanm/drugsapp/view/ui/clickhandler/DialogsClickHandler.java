package maymanm.drugsapp.view.ui.clickhandler;

import android.Manifest;
import android.content.Intent;

import androidx.fragment.app.FragmentActivity;

import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.DialogActivity;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.PermissionManager;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.util.SettingsManager;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class DialogsClickHandler {
    private DialogActivity dialogActivity;
    private Disposable disposable;

    public DialogsClickHandler(FragmentActivity dialogActivity) {
        try {
            this.dialogActivity = (DialogActivity) dialogActivity;
        } catch (Exception e) {
            Timber.e("wrong parent activity");
            e.printStackTrace();
        }
    }

    public void onCancelClick() {
        dialogActivity.onBackPressed();   //to show exit animation (don't use finish())
    }

    public void onExitAppClick() {
        dialogActivity.finishAffinity();
    }

    public void onOuterViewClick() {
        dialogActivity.onBackPressed();
    }

    public void onChangeLangClick(String lang) {
        Intent n = new Intent();
        n.putExtra(Params.LANGUAGE_CHANGE, true);
        if (lang.equals("ar") && !PreferenceHelperManager.getLanguage().equals("ar")) {
            PreferenceHelperManager.setLanguage("ar");
            dialogActivity.setResult(Codes.DIALOG_REQUEST_CODE, n);
        } else if (lang.equals("en") && !PreferenceHelperManager.getLanguage().equals("en")) {
            PreferenceHelperManager.setLanguage("en");
            dialogActivity.setResult(Codes.DIALOG_REQUEST_CODE, n);
        }
        dialogActivity.onBackPressed();
    }


    public void onWhatsAppClick() {
        SettingsManager.whatsAppMsg(dialogActivity, ApplicationUtil.getString(R.string.grand_phone));
    }


    public void onCallClick() {
        SettingsManager.makeCall(dialogActivity, ApplicationUtil.getString(R.string.grand_phone));
    }

    public void onOpenLocationSettings() {
        MovementManager.openGPSSetting(Objects.requireNonNull(dialogActivity.getSupportFragmentManager()
                .findFragmentById(R.id.fl_home_container)));
    }

    public void onLogoutClick() {
        if (PreferenceHelperManager.isLogged()) {
            PreferenceHelperManager.clearSharedPref();
            MovementManager.logOut(dialogActivity, true);
        } else {
            MovementManager.logOut(dialogActivity, false);
        }
    }

    public void onAskAgainClick() {
        Intent n = new Intent();
        n.putExtra(Params.DIALOG_RESULT, Params.PERMISSION_RESULT);
        dialogActivity.setResult(Codes.DIALOG_REQUEST_CODE, n);
        dialogActivity.onBackPressed();
    }

    public void onGoToCart() {
        MovementManager.startDetailsActivity(dialogActivity, Codes.CART_SCREEN);
        dialogActivity.finish();
    }

    public void onSaveImageClick() {
        if (PermissionManager.isGranted(dialogActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ApplicationUtil.takeScreenshot(dialogActivity);
        } else {
            disposable = PermissionManager.request(dialogActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe(granted -> {
                        if (granted) {
                            ApplicationUtil.takeScreenshot(dialogActivity);
                            disposable.dispose();
                        }else
                            disposable.dispose();
                    });
        }
    }

}
