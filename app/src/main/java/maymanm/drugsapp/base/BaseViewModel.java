package maymanm.drugsapp.base;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import maymanm.drugsapp.R;
import maymanm.drugsapp.application.BaseApplication;

public class BaseViewModel extends ViewModel implements Observable {
    private MutableLiveData<Object> mutableLiveData;
    private String message;
    private PropertyChangeRegistry mCallBacks;
    public ObservableBoolean obsShowNoData = new ObservableBoolean();
    public ObservableBoolean isLoading = new ObservableBoolean();
    public ObservableBoolean showProgressBar = new ObservableBoolean();
    public ObservableField<String> obsCityName = new ObservableField<>(getString(R.string.select_city));
    public ObservableField<String> obsCountryName = new ObservableField<>(getString(R.string.select_country));
    public ObservableField<String> obsCategoryName = new ObservableField<>(getString(R.string.select_category));
    public ObservableField<String> obsTypeName = new ObservableField<>(getString(R.string.select_type));
    public ObservableBoolean obsShowCountryMenu = new ObservableBoolean();
    public ObservableBoolean obsImageArrowCountryUp = new ObservableBoolean();
    public ObservableBoolean obsShowCityMenu = new ObservableBoolean();
    public ObservableBoolean obsImageArrowCityUp = new ObservableBoolean();

    public ObservableBoolean obsShowCategoryMenu = new ObservableBoolean();
    public ObservableBoolean obsImageArrowCategoryUp = new ObservableBoolean();

    public ObservableField<String> obsLocation = new ObservableField<>();


    public BaseViewModel() {
        mCallBacks = new PropertyChangeRegistry();
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<Object> getMutableLiveData() {
        return mutableLiveData == null ? mutableLiveData = new MutableLiveData<>() : mutableLiveData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(int messageRes) {
        this.message = getString(messageRes);
    }

    public String getString(int stringRes) {
        return BaseApplication.getInstance().getString(stringRes);
    }

    public void accessLoadingBar(int visible) {
        setValue(visible);
    }

    public void setValue(Object item) {
        mutableLiveData.setValue(item);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mCallBacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mCallBacks.remove(callback);
    }

    public void notifyChange() {
        mCallBacks.notifyChange(this, 0);
    }

    public void notifyChange(int viewId) {
        mCallBacks.notifyChange(this, viewId);
    }


}
