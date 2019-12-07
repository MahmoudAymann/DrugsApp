package maymanm.drugsapp.viewmodel.fragment.main;


import android.util.SparseIntArray;
import android.view.View;

import androidx.databinding.ObservableBoolean;

import com.android.volley.Request;

import java.util.List;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.WebServices;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.base.volleyutils.ConnectionListener;
import maymanm.drugsapp.model.home.HomeItem;
import maymanm.drugsapp.model.home.ServicesResponse;
import maymanm.drugsapp.model.home.SlidersItem;
import maymanm.drugsapp.util.RxUtils;
import maymanm.drugsapp.view.adapter.parent.HomeAdapter;
import maymanm.drugsapp.view.adapter.parent.SliderAdapter;
import io.reactivex.disposables.Disposable;

public class HomeViewModel extends BaseViewModel {

    public SliderAdapter sliderAdapter = new SliderAdapter();
    public HomeAdapter homeAdapter = new HomeAdapter();
    private Disposable sliderDis;
    public ServicesResponse servicesResponse;
    public ObservableBoolean obsIsSearch = new ObservableBoolean();

    public HomeViewModel() {
        startPopulateData();
    }


    private void startPopulateData() {

    }


    private void startSlider(List<SlidersItem> sliders) {
        sliderAdapter.updateDataList(sliders);
        final int[] currentPager = {0};
        sliderDis = RxUtils.repeat(3, aLong -> {
            if (currentPager[0] == sliders.size()) {
                currentPager[0] = 0;
            }
            SparseIntArray map = new SparseIntArray();
            map.put(Codes.MOVE_SLIDER, currentPager[0]++);
            setValue(map);
        });
    }


    @Override
    protected void onCleared() {
        if (sliderDis != null)
            sliderDis.dispose();
        super.onCleared();
    }
}
