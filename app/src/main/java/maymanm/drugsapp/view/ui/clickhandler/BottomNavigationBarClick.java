package maymanm.drugsapp.view.ui.clickhandler;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.view.ui.activity.MainActivity;
import maymanm.drugsapp.view.ui.fragment.main.HomeFragment;

public class BottomNavigationBarClick implements BottomNavigationView.OnNavigationItemSelectedListener {

    private MainActivity mContext;

    public BottomNavigationBarClick(MainActivity mainActivity) {
        mContext = mainActivity;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_notification:
//                MovementManager.replaceFragment(mContext, new NotificationsFragment(), "NotificationsFragment");
                break;
            case R.id.nav_question:
                break;
            case R.id.nav_house:
                MovementManager.replaceFragment(mContext, new HomeFragment(), "HomeFragment");
                break;
            case R.id.nav_add:

                break;
            case R.id.nav_rewards:

                break;
            default:
                return false;
        }
        return true;
    }
}
