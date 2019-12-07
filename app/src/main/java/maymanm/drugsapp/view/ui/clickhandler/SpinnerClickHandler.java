package maymanm.drugsapp.view.ui.clickhandler;

import androidx.databinding.ObservableBoolean;

/**
 * Created by MahmoudAyman on 11/5/2019.
 **/
public abstract class SpinnerClickHandler {

    public static void clickOnTarget(ObservableBoolean targetMenu, ObservableBoolean targetArrow,
                              ObservableBoolean menu1, ObservableBoolean arrow1,
                              ObservableBoolean menu2, ObservableBoolean arrow2) {
        if (menu1.get()) {
            menu1.set(false);
            arrow1.set(false);
            return;
        }
        if (menu2.get()) {
            menu2.set(false);
            arrow2.set(false);
            return;
        }

        if (targetMenu.get()) {
            targetMenu.set(false);
            targetArrow.set(false);
        } else {
            targetMenu.set(true);
            targetArrow.set(true);
        }
    }


    public static void clickOnTarget(ObservableBoolean targetMenu, ObservableBoolean targetArrow,
                                     ObservableBoolean menu2, ObservableBoolean arrow2) {
        if (menu2.get()) {
            menu2.set(false);
            arrow2.set(false);
            return;
        }

        if (targetMenu.get()) {
            targetMenu.set(false);
            targetArrow.set(false);
        } else {
            targetMenu.set(true);
            targetArrow.set(true);
        }
    }

    public static void clickOnTarget(ObservableBoolean targetMenu, ObservableBoolean targetArrow) {
        if (targetMenu.get()) {
            targetMenu.set(false);
            targetArrow.set(false);
        } else {
            targetMenu.set(true);
            targetArrow.set(true);
        }
    }

}
