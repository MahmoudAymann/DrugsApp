package maymanm.drugsapp.viewmodel.fragment.main;

import androidx.databinding.ObservableField;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.view.adapter.parent.ChatAdapter;

/**
 * Created by MahmoudAyman on 12/7/2019.
 **/
public class DisabledViewModel extends BaseViewModel {

    public ChatAdapter chatAdapter = new ChatAdapter();
    public ObservableField<String> obsMessage = new ObservableField<>();

    public DisabledViewModel() {

    }

    public void onSendClick() {
        chatAdapter.addItem(obsMessage.get());
        obsMessage.set("");
    }
}
