package maymanm.drugsapp.viewmodel.fragment.main;

import androidx.databinding.ObservableBoolean;

import maymanm.drugsapp.application.OnClick;
import maymanm.drugsapp.base.BaseViewModel;

public class LearnViewModel extends BaseViewModel {

    public ObservableBoolean obsIsWords = new ObservableBoolean();


    @OnClick
    public void onRadioButtonsClick(boolean isWords) {
        obsIsWords.set(isWords);
    }



}
