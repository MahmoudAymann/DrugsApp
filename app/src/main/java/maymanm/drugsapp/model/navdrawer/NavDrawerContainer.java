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
        items.add(new NavDrawerItem(Codes.FAVOURITE_SCREEN, getString(R.string.saved_drugs), 0));
        items.add(new NavDrawerItem(Codes.CONTACT_US_SCREEN, getString(R.string.rate), 0));
        items.add(new NavDrawerItem(Codes.ADD_NEW_DRUG, getString(R.string.add_new_drug), 0));
        items.add(new NavDrawerItem(Codes.DOWNLOAD_UPDATES, getString(R.string.download_updates), 0));
        items.add(new NavDrawerItem(Codes.SETTINGS_SCREEN, getString(R.string.settings), 0));
//        items.add(new NavDrawerItem(Codes.RATE_SCREEN, getString(R.string.rate), 0));
        items.add(new NavDrawerItem(Codes.SHARE_SCREEN, getString(R.string.share), 0));

        return items;
    }

}
