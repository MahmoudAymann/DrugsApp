package maymanm.drugsapp.view.adapter.itemviewmodel;

import androidx.databinding.Bindable;

import maymanm.drugsapp.base.BaseViewModel;
import maymanm.drugsapp.model.notification.NotificationItem;

public class ItemNotificationViewModel extends BaseViewModel {

    private NotificationItem notificationItem;

    public ItemNotificationViewModel(NotificationItem notificationItem) {
        this.notificationItem = notificationItem;
    }

    @Bindable
    public NotificationItem getNotificationItem() {
        return notificationItem;
    }




}
