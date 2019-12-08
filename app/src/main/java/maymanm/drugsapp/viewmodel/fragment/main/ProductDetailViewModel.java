package maymanm.drugsapp.viewmodel.fragment.main;

import maymanm.drugsapp.R;
import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.model.drugs.DrugsItem;
import maymanm.drugsapp.model.drugs.DrugsResponse;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.parent.TabletsAdapter;
import timber.log.Timber;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class ProductDetailViewModel extends BaseViewModel {

    public TabletsAdapter tabletsAdapter = new TabletsAdapter();
    public DrugsItem item;
    private DrugsResponse drugsResponse;

    public ProductDetailViewModel(int pos) {
        drugsResponse = PreferenceHelperManager.getDrugsResponse();
        Timber.e(drugsResponse.toString());
        getData(pos);
    }

    private void getData(int pos) {
        for (int i = 0; i < drugsResponse.getData().getDrugs().size(); i++) {
            if (pos == drugsResponse.getData().getDrugs().get(i).getId()) {
                item = drugsResponse.getData().getDrugs().get(i);
                break;
            }
        }
        notifyChange();
        if (item.getCategory() == 1)
            obsCategoryName.set(getString(R.string.brand));
        else
            obsCategoryName.set(getString(R.string.genrics));
        try {
            tabletsAdapter.updateDataList(drugsResponse.getData().getDrugs().get(pos).getTablets());
        } catch (Exception e) {
            Timber.e(e);
        }
    }


    @OnClick
    public void clickButton(int button) {
        switch (button) {
            case 1:
                setValue(Codes.COMPOSITION);
                break;
            case 2:
                setValue(Codes.INDICATION);
                break;
            case 3:
                setValue(Codes.CONTRAINDICATION);
                break;
            case 4:
                setValue(Codes.PRECAUTIONS);
                break;
            case 5:
                setValue(Codes.PREGNANCY);
                break;
            case 6:
                setValue(Codes.INTERACTIONS);
                break;
            case 7:
                setValue(Codes.SIDE_EFFECTS);
                break;
            case 8:
                setValue(Codes.DOSE);
        }
    }
}
