package maymanm.drugsapp.application;

import android.app.Application;
import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.databinding.AppDataBindingComponent;
import maymanm.drugsapp.util.LocalHelper;
import maymanm.drugsapp.util.PreferenceHelperManager;
import io.reactivex.plugins.RxJavaPlugins;
import timber.log.Timber;

public class BaseApplication extends Application {

    private RequestQueue mRequestQueue;
    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
        initTimber();
        RxJavaPlugins.setErrorHandler(Timber::e);

        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocalHelper.onAttach(base));
    }

    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    private void initTimber() {
        Timber.plant(new Timber.DebugTree() {
            @Override
            protected String createStackElementTag(@NotNull StackTraceElement element) {
                return super.createStackElementTag(element) + " line: " + element.getLineNumber();
            }
        });
    }

}
