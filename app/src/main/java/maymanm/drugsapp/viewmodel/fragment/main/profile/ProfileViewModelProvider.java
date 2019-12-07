package maymanm.drugsapp.viewmodel.fragment.main.profile;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ProfileViewModelProvider implements ViewModelProvider.Factory {

    private int fragmentNameInt;

    public ProfileViewModelProvider(int fragmentNameInt) {
        this.fragmentNameInt = fragmentNameInt;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ProfileViewModel(fragmentNameInt);
    }
}
