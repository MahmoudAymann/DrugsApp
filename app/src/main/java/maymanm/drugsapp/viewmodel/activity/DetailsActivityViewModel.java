package maymanm.drugsapp.viewmodel.activity;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.databinding.ObservableBoolean;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.base.constantsutils.Codes;

public class DetailsActivityViewModel extends BaseViewModel {

    public DetailsActivityViewModel() {
    }

    public void onButtonBackClick() {
        setValue(Codes.PRESS_BACK);
    }

    public void onSearchButtonClick() {
        setValue(Codes.TOOLBAR_SEARCH_CLICK);
    }

    public TextWatcher textWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().isEmpty()) {
                    setMessage(charSequence.toString());
                    setValue(Codes.ON_TEXT_CHANGED);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }

}
