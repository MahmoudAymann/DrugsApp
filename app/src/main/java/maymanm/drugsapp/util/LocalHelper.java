package maymanm.drugsapp.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

import maymanm.drugsapp.application.BaseApplication;

/**
 * Created by MahmoudAyman on 14/10/2018.
 */
public abstract class LocalHelper {

    public static Context onAttach(Context context) {
        return setLocale(context, getLanguage(context));
    }

    private static String getLanguage(Context context) {
        return PreferenceHelperManager.getLanguage(context);
    }

    public static Context setLocale(Context context, String language) {
        PreferenceHelperManager.setLanguage(context, language);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResources(context, language);
        }

        return updateResourcesLegacy(context, language);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);

        return context.createConfigurationContext(configuration);
    }

    private static Context updateResourcesLegacy(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return context;
    }

    public static void changeLanguage(Activity activity) {
        Locale locale;
        locale = new Locale(PreferenceHelperManager.getLanguage());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        activity.getBaseContext().getResources().updateConfiguration(config,
                activity.getBaseContext().getResources().getDisplayMetrics());
        BaseApplication.getInstance().getApplicationContext().getResources().updateConfiguration(config,
                BaseApplication.getInstance().getApplicationContext().getResources().getDisplayMetrics());
    }

}