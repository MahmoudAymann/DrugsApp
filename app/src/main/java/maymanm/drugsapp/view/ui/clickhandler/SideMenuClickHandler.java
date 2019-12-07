package maymanm.drugsapp.view.ui.clickhandler;

import androidx.core.view.GravityCompat;
import androidx.lifecycle.Observer;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.model.navdrawer.NavDrawerItem;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.util.SettingsManager;
import maymanm.drugsapp.view.ui.activity.DetailsActivity;
import maymanm.drugsapp.view.ui.activity.MainActivity;
import maymanm.drugsapp.view.ui.fragment.main.DrugsFragment;
import timber.log.Timber;

/**
 * Created by MahmoudAyman on 8/23/2019.
 **/
public class SideMenuClickHandler implements Observer<NavDrawerItem> {

    private MainActivity context;

    public SideMenuClickHandler(MainActivity context) {
        this.context = context;
    }

    @Override
    public void onChanged(NavDrawerItem navDrawerItem) {
        context.getDrawerLayout().closeDrawer(GravityCompat.START);
        switch (navDrawerItem.getId()) {
            case Codes.DOWNLOAD_UPDATES:
                MyAnimation.starDialogWithAnim(context, Codes.UPDATE_DIALOG, ApplicationUtil.getRootView(context));
                break;
            case Codes.FAVOURITE_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.FAVOURITE_SCREEN);
                break;
            case Codes.ADD_NEW_DRUG:
                ApplicationUtil.openWebIntent(context, "https://docs.google.com/forms/d/e/1FAIpQLSc5Kr_eQ1zi0eH7FwU1nC4Xzf8iQT94vKSaNWqbnHWDwB1piA/viewform");
                break;
            case Codes.CONTACT_US_SCREEN:
                ApplicationUtil.openWebIntent(context, "https://docs.google.com/forms/d/e/1FAIpQLSfBy5xzQGNbg_dZ1vwaGI4CAk83bOIGj7Fo_0kaoDJXB4YALQ/viewform");
                break;
        }
    }
}
