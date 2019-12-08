package maymanm.drugsapp.viewmodel.fragment.main;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;

/**
 * Created by MahmoudAyman on 12/8/2019.
 **/
public class DiscoverViewModel extends BaseViewModel {


    @OnClick
    public void onCardClick(int cardNumber) {
        switch (cardNumber) {
            case 1:
                setValue(Codes.ONE);
                break;
            case 2:
                setValue(Codes.TWO);
                break;
            case 3:
                setValue(Codes.THREE);
                break;
        }
    }

}
