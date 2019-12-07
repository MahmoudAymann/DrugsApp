package maymanm.drugsapp.view.adapter.itemviewmodel;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.chat.ChatItem;

public class ItemChatViewModel extends BaseViewModel {
    public ChatItem ChatItem;
    public ItemChatViewModel(ChatItem ChatItem) {
        this.ChatItem = ChatItem;
    }



}
