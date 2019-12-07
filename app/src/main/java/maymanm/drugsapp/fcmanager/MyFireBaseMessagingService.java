package maymanm.drugsapp.fcmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.ui.activity.MainActivity;
import timber.log.Timber;

public class MyFireBaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

//        if (remoteMessage.getData().containsKey("message")){
//            if (remoteMessage.getData().get("message")!= null){
//                Timber.e(remoteMessage.getData().get("message"));
//                Gson gson = new Gson();
//                FirebaseResponse response = gson.fromJson(remoteMessage.getData().get("message"), FirebaseResponse.class);
//                Timber.e(response.toString());
//                sendNotification(response.getTitle(), response.getBody(), response.getType());
//            }
//        }
        Timber.e(remoteMessage.toString());
        sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody(),"1");
    }

    @Override
    public void onNewToken(@NotNull String token) {
        PreferenceHelperManager.saveGoogleToken(token);
        System.out.println("Refreshed token:" + token);
    }

    private void sendNotification(String title, String body, String type) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Params.INTENT_PAGE, Codes.HOME_SCREEN);

//        Timber.e("type: %s", type);
//        if (Integer.valueOf(type) == 1) {
//            intent.putExtra(Params.INTENT_PAGE, Codes.ORDERS_SCREEN);
//        }
//        else if (Integer.valueOf(type) == 2) {
//            intent.putExtra(Params.INTENT_PAGE, Codes.TRANSITION_SCREEN);
//        }else{
//        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0 /* Request code */,
                intent,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = "channelId";
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        if (notificationManager != null) {
            notificationManager.notify(0, notificationBuilder.build());
        }
    }
}