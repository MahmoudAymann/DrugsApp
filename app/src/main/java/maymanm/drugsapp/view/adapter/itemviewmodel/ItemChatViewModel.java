package maymanm.drugsapp.view.adapter.itemviewmodel;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.chat.ChatItem;

public class ItemChatViewModel extends BaseViewModel {
    public ChatItem item;
    public ItemChatViewModel(ChatItem item) {
        this.item = item;
    }



}
