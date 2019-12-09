package maymanm.drugsapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.application.BaseApplication;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.model.drugs.DrugsResponse;
import timber.log.Timber;

public class PreferenceHelperManager {

    //here you can find shared preference operations like get saved data for user

    private static SharedPreferences getSharedPreferenceInstance() {
        return BaseApplication.getInstance().getApplicationContext()
                .getSharedPreferences(Params.PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences getSharedPreferenceInstance(Context context) {
        return context.getSharedPreferences(Params.PREF_FILE_NAME, Context.MODE_PRIVATE);
    }


    static String getLanguage(Context context) {
        return getSharedPreferenceInstance(context).getString(Params.PREF_LANG, Params.DEFAULT_LANG);
    }
    static void setLanguage(Context context, String lang) {
        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance(context).edit();
        prefsEditor.putString(Params.PREF_LANG, lang);
        prefsEditor.apply();
    }

    public static void setLanguage(String lang) {
        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance().edit();
        prefsEditor.putString(Params.PREF_LANG, lang);
        prefsEditor.apply();
    }

    public static String getLanguage() {
        return getSharedPreferenceInstance().getString(Params.PREF_LANG, Params.DEFAULT_LANG);
    }

    public static boolean isLogged() {
        return false;
    }

    public static void setFirstTime(boolean isFirstTime){
        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance().edit();
        prefsEditor.putBoolean(Params.PREF_FIRST_TIME, isFirstTime);
        prefsEditor.apply();
    }

    public static boolean isFirstTime() {
        return getSharedPreferenceInstance().getBoolean(Params.PREF_FIRST_TIME, true);
    }


    public static void saveDrugs(DrugsResponse userModel) {
        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance().edit();
        Gson gson = new Gson();
        String json = gson.toJson(userModel);
        prefsEditor.putString(Params.PREF_DRUGS, json);
        prefsEditor.apply();
    }

    public static DrugsResponse getDrugsResponse() {
        Gson gson = new Gson();
        String json = getSharedPreferenceInstance().getString(Params.PREF_DRUGS, "");
        if (json.equals("")) return new DrugsResponse();
        return gson.fromJson(json, DrugsResponse.class);
    }

    public static void clear(String key) {
        getSharedPreferenceInstance().edit().remove(key).apply();
    }

    public static void clearSharedPref() {
        getSharedPreferenceInstance().edit().clear().apply();
    }

    public static void savePhoneNumber(String phone) {
        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance().edit();
        prefsEditor.putString(Params.PREF_PHONE, phone);
        prefsEditor.apply();
    }

   public static String getPhoneNumber() {
        return getSharedPreferenceInstance().getString(Params.PREF_PHONE, "n/a");
    }

    public static void setOrderId(int orderId) {
        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance().edit();
        prefsEditor.putInt(Params.PREF_ORDER_ID, orderId);
        prefsEditor.apply();
    }

    public static int getOrderId() {
        return getSharedPreferenceInstance().getInt(Params.PREF_ORDER_ID, 0);
    }

    public static void saveGoogleToken(String token) {
        if (token != null && !token.isEmpty()) {
            SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
            editor.putString(Params.PREF_GOOGLE_TOKEN, token);
            editor.apply();
        }
    }

    public static String getGoogleToken() {
        return  getSharedPreferenceInstance().getString(Params.PREF_GOOGLE_TOKEN, "n/a");
    }


    public static void setCountryId(int token) {
            SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
            editor.putInt(Params.PREF_CATEGORY, token);
            editor.apply();
    }

    public static int getCountryId() {
        return getSharedPreferenceInstance().getInt(Params.PREF_CATEGORY, 0);
    }

    public static void setLangPos(int position) {
        SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
        editor.putInt(Params.PREF_LANG_POS, position);
        editor.apply();
    }

    public static int getLangPos() {
        return getSharedPreferenceInstance().getInt(Params.PREF_LANG_POS, 2);
    }


    public static void setUserRate(String rate) {
        SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
        editor.putString(Params.PREF_RATE, rate);
        editor.apply();
    }

    public static String getUserRate() {
        return getSharedPreferenceInstance().getString(Params.PREF_RATE, "0");
    }


    public static void setShipping(String shipping) {
        SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
        editor.putString(Params.PREF_SHIPPING, shipping);
        editor.apply();
    }

    public static String getShipping() {
        return getSharedPreferenceInstance().getString(Params.PREF_SHIPPING, "00.0");
    }


    public static void setAddressId(String id) {
        SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
        editor.putString(Params.PREF_ADDRESS_ID, id);
        editor.apply();
    }

    public static String getAddressId() {
        return getSharedPreferenceInstance().getString(Params.PREF_ADDRESS_ID, null);
    }

    public static void removeCheckout() {
        clear(Params.PREF_ADDRESS_ID);
        clear(Params.PREF_CART_ITEMS);
        Timber.e(getAddressId());
    }


    public static void setPhone(String phone) {
        SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
        editor.putString(Params.PREF_PHONE, phone);
        editor.apply();
    }

    public static String getPhone() {
        return getSharedPreferenceInstance().getString(Params.PREF_PHONE, "n/a");
    }

    public static void setDrugId(int code) {
        SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
        editor.putInt(Params.PREF_CODE, code);
        editor.apply();
    }

    public static int getDrugId() {
        return getSharedPreferenceInstance().getInt(Params.PREF_CODE, 0);
    }


    public static void saveIds(List<Integer> items) {
        SharedPreferences.Editor prefsEditor = getSharedPreferenceInstance().edit();
        Gson gson = new Gson();
        String json = gson.toJson(items);
        prefsEditor.putString(Params.PREF_CART_ITEMS, json);
        prefsEditor.apply();
    }

    public static List<Integer> getIds() {
        Gson gson = new Gson();
        List<Integer> companyList;
        String string = getSharedPreferenceInstance().getString(Params.PREF_CART_ITEMS, "n/a");
        if(!string.equals("n/a")) {
            Type type = new TypeToken<List<Integer>>() {
            }.getType();
            companyList = gson.fromJson(string, type);
        }else {
            companyList = new ArrayList<>();
        }
        return companyList;
    }


    public static int getDrugCategory() {
        return getSharedPreferenceInstance().getInt(Params.PREF_CATEGORY, 0);
    }


    public static void setDrugCategory(int category) {
        SharedPreferences.Editor editor = getSharedPreferenceInstance().edit();
        editor.putInt(Params.PREF_CATEGORY, category);
        editor.apply();
    }
}