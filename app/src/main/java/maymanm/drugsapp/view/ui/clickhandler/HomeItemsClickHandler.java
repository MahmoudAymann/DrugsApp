package maymanm.drugsapp.view.ui.clickhandler;

import android.os.Bundle;

import androidx.lifecycle.Observer;

import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.model.home.HomeItem;
import maymanm.drugsapp.view.ui.fragment.main.HomeFragment;

public class HomeItemsClickHandler implements Observer<HomeItem> {
    private HomeFragment context;

    public HomeItemsClickHandler(HomeFragment homeFragment) {
        context = homeFragment;
    }

    @Override
    public void onChanged(HomeItem homeItem) {
        if (homeItem.getId() == 2) {
            //when click on shops save categories in bundle (from viewModel) and pass page name Codes.SHOP_CATEGORIES
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(Params.SHOP_CATEGORIES, context.viewModel.servicesResponse.getServicesData().getServices());
            bundle.putInt(Params.GET_PAGE, Codes.SHOP_CATEGORIES);
            MovementManager.startDetailsActivity(context.getContext(), Codes.SHOP_CATEGORIES, bundle);
        }else if (homeItem.getId() == 3){ //send money
            MovementManager.startDetailsActivity(context.getContext(), Codes.TRANSFER_PACKING_CARD);
        }else if (homeItem.getId() == 4){ //receive money
            MovementManager.startDetailsActivity(context.getContext(), Codes.RECEIVE_PACKING_CARD);
        }else if (homeItem.getId() == 5){ //deposit money
            MovementManager.startDetailsActivity(context.getContext(), Codes.ADD_PACKING_CARD);
        }
    }

}
