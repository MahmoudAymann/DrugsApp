package maymanm.drugsapp.viewmodel.fragment.main;

import android.widget.Toast;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.util.RxUtils;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/**
 * Created by MahmoudAyman on 12/3/2019.
 **/
public class AlertDialogViewModel extends BaseViewModel {

    public ObservableInt obsIcon = new ObservableInt();
    public ObservableField<String> obsTitle = new ObservableField<>();
    public ObservableField<String> obsDescription = new ObservableField<>();
    private Disposable disposable;


    public AlertDialogViewModel(int iconCode, String title, String description) {
        obsIcon.set(iconCode);
        obsTitle.set(title);
        obsDescription.set(description);
    }

    public void setAutoClose() {
        disposable = RxUtils.delay(3, () -> {
            setValue(Codes.PRESS_BACK);
        });
    }


    @Override
    protected void onCleared() {
        if (disposable != null)
            disposable.dispose();
        super.onCleared();
    }
}
