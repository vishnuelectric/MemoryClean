package com.vishnu.memoryclean;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by vishnuprasad on 09/08/15.
 */
public class MyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println(intent.getAction());
        Notification builder = new Notification.Builder(context).setSmallIcon(R.drawable.circle).setContentTitle("sda").setContentText(intent.getAction()).build();
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1,builder);



    }
}
