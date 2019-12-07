package maymanm.drugsapp.base.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.util.LocalHelper;
import maymanm.drugsapp.util.PreferenceHelperManager;
import timber.log.Timber;

public class ParentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        LocalHelper.changeLanguage(this);
        setLayoutLanguage(PreferenceHelperManager.getLanguage());
        LocalHelper.setLocale(this, PreferenceHelperManager.getLanguage());
    }

    public void showMessage(Object message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
    }

    public void setLayoutLanguage(String language) {
        if (language.equals("ar") || language.equals("ku"))
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        else
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        //refresh things as u need
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_home_container);
            Objects.requireNonNull(fragment).onActivityResult(requestCode, resultCode, data);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_home_container);
            if (fragment != null) {
                fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }


}
