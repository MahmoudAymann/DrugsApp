package maymanm.drugsapp.util;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

import timber.log.Timber;

public abstract class ArgsUtil {

    public static Integer getIntArg(Bundle bundle, String key){
        if (bundle != null){
            if (bundle.containsKey(key)){
                return bundle.getInt(key,0);
            }else {
                Timber.e("key not found");
                return 0;
            }
        }else {
            Timber.e("bundle is null");
            return 0;
        }
    }

    public static String getStringArg(Bundle bundle, String key){
        if (bundle != null){
            if (bundle.containsKey(key)){
                return bundle.getString(key,"n/a");
            }else {
                Timber.e("key not found");
                return "n/a";
            }
        }else {
            Timber.e("bundle is null");
            return "n/a";
        }
    }

    public static boolean getBooleanArg(Bundle bundle, String key){
        if (bundle != null){
            if (bundle.containsKey(key)){
                return bundle.getBoolean(key,false);
            }else {
                Timber.e("key not found");
                return false;
            }
        }else {
            Timber.e("bundle is null");
            return false;
        }
    }

    public static Serializable getSerializable(Bundle bundle, String key) {
        if (bundle != null){
            if (bundle.containsKey(key)){
                Timber.e(bundle.getSerializable(key).toString());
                return bundle.getSerializable(key);
            }else {
                Timber.e("key not found");
                return null;
            }
        }else {
            Timber.e("bundle is null");
            return null;
        }
    }

    public static <T extends Parcelable> ArrayList<T> getParcelableArrayList(Bundle bundle, String key) {
        if (bundle != null){
            if (bundle.containsKey(key)){
                return bundle.getParcelableArrayList(key);
            }else {
                Timber.e("key not found");
                return new ArrayList<>();
            }
        }else {
            Timber.e("bundle is null");
            return new ArrayList<>();
        }
    }

    public static float getFloat(Bundle bundle, String key) {
        if (bundle != null){
            if (bundle.containsKey(key)){
                return bundle.getFloat(key);
            }else {
                Timber.e("key not found");
                return 0f;
            }
        }else {
            Timber.e("bundle is null");
            return 0f;
        }
    }
}
