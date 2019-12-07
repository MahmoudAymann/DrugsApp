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
import maymanm.drugsapp.view.ui.fragment.main.HomeFragment;

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
            case Codes.HOME_SCREEN:
                context.getToolbarTitle().setText(context.getString(R.string.home));
                MovementManager.replaceFragment(context, new HomeFragment(), "");
                break;
            case Codes.FAVOURITE_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.FAVOURITE_SCREEN);
                break;
            case Codes.PROFILE_SCREEN:
                context.getToolbarTitle().setText(context.getString(R.string.profile));
                break;
            case Codes.ORDERS_SCREEN:
                MovementManager.startActivityFragment(context, DetailsActivity.class, Codes.ORDERS_SCREEN);
                break;
            case Codes.CART_SCREEN:
                MovementManager.startActivityFragment(context, DetailsActivity.class, Codes.CART_SCREEN);
                break;
            case Codes.PACKING_CARD_SCREEN:
                MovementManager.startActivityFragment(context, DetailsActivity.class, Codes.PACKING_CARD_SCREEN);
                break;
            case Codes.NOTIFICATION_SCREEN:
                context.getToolbarTitle().setText(context.getString(R.string.notification));
                MovementManager.startDetailsActivity(context, Codes.NOTIFICATION_SCREEN);
                break;
            case Codes.LANGUAGE_DIALOG:
                MovementManager.startActivityForResult(context, DetailsActivity.class, Codes.CHANGE_LANGUAGE_REQUEST_CODE,Codes.LANGUAGE_SCREEN);
                break;
            case Codes.RATE_SCREEN:
                SettingsManager.rateApp(context);
                break;
            case Codes.SHARE_SCREEN:
                SettingsManager.shareApp(context);
                break;
            case Codes.TERMS_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.TERMS_SCREEN);
                break;
            case Codes.CONTACT_US_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.CONTACT_US_SCREEN);
                break;
            case Codes.ABOUT_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.ABOUT_SCREEN);
                break;
            case Codes.SUGGESTION_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.SUGGESTION_SCREEN);
                break;
            case Codes.BE_DELEGATE_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.BE_DELEGATE_SCREEN);
                break;
            case Codes.BE_SHIPPING_COMPANY_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.BE_SHIPPING_COMPANY_SCREEN);
                break;
            case Codes.BE_A_DRIVER_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.BE_A_DRIVER_SCREEN);
                break;
            case Codes.BE_SHOP_SCREEN:
                MovementManager.startDetailsActivity(context, Codes.BE_SHOP_SCREEN);
                break;
            case Codes.PACKING_CARD_LOCATION:
                MovementManager.startDetailsActivity(context, Codes.PACKING_CARD_LOCATION);
                break;
            case Codes.LOGOUT_SCREEN:
                if (PreferenceHelperManager.isLogged()) {
                    MyAnimation.starDialogWithAnim(context, Codes.LOGOUT_SCREEN, ApplicationUtil.getRootView(context));
                } else {
                    MovementManager.logOut(context, false);
                }
                break;
        }
    }
}
