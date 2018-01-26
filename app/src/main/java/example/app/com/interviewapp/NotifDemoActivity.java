package example.app.com.interviewapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;

/**
 * Created by hung on 1/9/17.
 */
public class NotifDemoActivity extends Activity {
//    android.support.v4.app.NotificationCompat.Builder supV4Builder;
//    android.support.v7.app.NotificationCompat.Builder supV7Builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Notification.BigPictureStyle style = new Notification.BigPictureStyle()
                .bigPicture(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_face_24dp));

        android.support.v4.app.NotificationCompat.Builder mBuilder =
                new android.support.v4.app.NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_face_24dp)
                    .setContentTitle("My notification")
                    .setContentText("Hello World!");

        Intent resultIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pendingIntent);

        // Sets an ID for the notification
        int mNotificationId = 001;

        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
