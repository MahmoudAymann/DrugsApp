package maymanm.drugsapp.base;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.zxing.integration.android.IntentIntegrator;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.DialogActivity;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.view.ui.activity.AuthActivity;
import maymanm.drugsapp.view.ui.activity.DetailsActivity;
import maymanm.drugsapp.view.ui.activity.MainActivity;
import timber.log.Timber;


public abstract class MovementManager {


    //---------Fragments----------//
    private static final int CONTAINER_ID = R.id.fl_home_container;

    public static void popAllFragments(Context context) {
        FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public static void addFragment(Context context, Fragment fragment, String backStackText) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(CONTAINER_ID, fragment);
        if (!backStackText.equals("")) {
            fragmentTransaction.addToBackStack(backStackText);
        }
        fragmentTransaction.commit();
    }


    public static void replaceFragment(Context context, Fragment fragment, String backStackText) {
        try {
            FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(CONTAINER_ID, fragment);
            if (!backStackText.equals("")) {
                fragmentTransaction.addToBackStack(backStackText);
            }
            fragmentTransaction.commit();
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public static void replaceFragment(Context context, Fragment fragment, Bundle bundle, String backStackText) {
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().replace(CONTAINER_ID, fragment);
        if (!backStackText.equals("")) {
            fragmentTransaction.addToBackStack(backStackText);
        }
        fragmentTransaction.commit();
    }


    public static void popLastFragment(Context context) {
        ((FragmentActivity) context).getSupportFragmentManager().popBackStack();
    }


    //-----------Activities-----------------//

    public static void startActivityFragment(Context context, Class<?> activity, int page) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(Params.INTENT_PAGE, page);
        context.startActivity(intent);
    }

    public static void startActivityFragment(Context context, Class<?> activity, int page, Bundle bundle) {
        Intent intent = new Intent(context, activity);
        intent.putExtra(Params.INTENT_PAGE, page);
        intent.putExtra(Params.BUNDLE_PAGE, bundle);
        context.startActivity(intent);
    }

    public static void setResult(Activity activity, int requestCode, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        activity.setResult(requestCode, intent);
        activity.finish();
    }

    public static void setResult(Activity activity, int requestCode, Intent intent) {
        activity.setResult(requestCode, intent);
        activity.finish();
    }

    public static void startActivityForResult(Activity currentActivity, Class<? extends Activity> destination, int requestCode,
                                              int codePage) {
        Intent intent = new Intent(currentActivity, destination);
        intent.putExtra(Params.INTENT_PAGE, codePage);
        currentActivity.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> destination, int requestCode,
                                              int codePage) {
        Intent intent = new Intent(fragment.requireActivity(), destination);
        intent.putExtra(Params.INTENT_PAGE, codePage);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> destination, int requestCode,
                                              int codePage, Bundle bundle) {
        Intent intent = new Intent(fragment.requireActivity(), destination);
        intent.putExtra(Params.INTENT_PAGE, codePage);
        intent.putExtra(Params.BUNDLE_PAGE, bundle);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void startAuthActivity(Context context, int page) {
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        context.startActivity(intent);
    }

    public static void startAuthActivity(Context context, int page, Bundle bundle) {
        Intent intent = new Intent(context, AuthActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        intent.putExtra(Params.BUNDLE_PAGE, bundle);
        context.startActivity(intent);
    }

    public static void startDialogActivity(FragmentActivity context, int page, Bundle bundle) {
        Intent intent = new Intent(context, DialogActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        intent.putExtra(Params.BUNDLE_PAGE, bundle);
        context.startActivityForResult(intent, Codes.DIALOG_REQUEST_CODE);
    }

    public static void startMainActivity(Context context, int page) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        context.startActivity(intent);
    }

    public static void startMainActivity(Context context, int page, Bundle bundle) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        intent.putExtra(Params.BUNDLE_PAGE, bundle);
        context.startActivity(intent);
    }

    public static void startDetailsActivity(Context context, int page) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        context.startActivity(intent);
    }

    public static void startDetailsActivity(Context context, int page, Bundle bundle) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(Params.INTENT_PAGE, page);
        intent.putExtra(Params.BUNDLE_PAGE, bundle);
        context.startActivity(intent);
    }


    public static void startWebPage(Context context, String page) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(page)));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void startQrScan(Activity activity) {
        new IntentIntegrator(activity).initiateScan();
    }

    public static void openGPSSetting(Fragment fragment) {
        Intent callGPSSettingIntent = new Intent(
                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        fragment.startActivityForResult(callGPSSettingIntent, Codes.GPS_SETTINGS_REQ_CODE);
    }

    public static void logOut(Activity context, boolean clearTopActivities) {
        Intent intent;
        intent = new Intent(context, AuthActivity.class);
        intent.putExtra(Params.INTENT_PAGE, Codes.LOGIN_SCREEN);
        if (clearTopActivities) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            context.finishAffinity();
        } else {
            context.startActivity(intent);
        }
    }

    public static void startImageView(FragmentActivity activity, String image, View view, Bundle bundle) {
        if (bundle == null)
            bundle = new Bundle();
        bundle.putString(Params.IMAGE, image);
        MyAnimation.starDialogWithAnim(activity, Codes.IMAGE_DIALOG_SCREEN, view, bundle);
    }
}
