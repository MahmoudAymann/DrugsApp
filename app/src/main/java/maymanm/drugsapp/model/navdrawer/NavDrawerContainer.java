package maymanm.drugsapp.model.navdrawer;

import java.util.ArrayList;

import maymanm.drugsapp.R;
import maymanm.drugsapp.application.BaseApplication;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.util.PreferenceHelperManager;

public class NavDrawerContainer {

    private NavHeaderItem navHeaderItem;
    private NavDrawerItem navDrawerItem;
    public NavHeaderItem getNavHeaderItem() {
        return navHeaderItem == null ? navHeaderItem = new NavHeaderItem() : navHeaderItem;
    }
    public void setNavHeaderItem(NavHeaderItem navHeaderItem) {
        this.navHeaderItem = navHeaderItem;
    }
    public NavDrawerItem getNavDrawerItem() {
        return navDrawerItem;
    }
    public void setNavDrawerItem(NavDrawerItem navDrawerItem) {
        this.navDrawerItem = navDrawerItem;
    }

    private String getString(int resId) {
        return BaseApplication.getInstance().getApplicationContext().getString(resId);
    }

    public ArrayList<NavDrawerItem> getDrawerItemsData() {
        ArrayList<NavDrawerItem> items = new ArrayList<>();
//        if (PreferenceHelperManager.isLogged()) {
            items.add(new NavDrawerItem(Codes.PROFILE_SCREEN, getString(R.string.profile), R.drawable.ic_account));
            items.add(new NavDrawerItem(Codes.CHANGE_LEVEL_SCREEN, getString(R.string.change_level), R.drawable.ic_exchange));
            items.add(new NavDrawerItem(Codes.EXAM_SCREEN, getString(R.string.do_exam), R.drawable.ic_exam));
            items.add(new NavDrawerItem(Codes.SUGGESTION_SCREEN, getString(R.string.suggestion_and_complain), R.drawable.ic_suggestions));
//        }
        items.add(new NavDrawerItem(Codes.RATE_SCREEN, getString(R.string.rate), R.drawable.ic_star_full));
        items.add(new NavDrawerItem(Codes.TERMS_SCREEN, getString(R.string.privacy_policy), R.drawable.ic_privacy_lock));
        items.add(new NavDrawerItem(Codes.SHARE_SCREEN, getString(R.string.share), R.drawable.ic_share_circle));
        if (PreferenceHelperManager.isLogged())
            items.add(new NavDrawerItem(Codes.LOGOUT_SCREEN, getString(R.string.log_out), R.drawable.ic_logout));
        else
            items.add(new NavDrawerItem(Codes.LOGOUT_SCREEN, getString(R.string.login), R.drawable.ic_logout));
        return items;
    }

}
