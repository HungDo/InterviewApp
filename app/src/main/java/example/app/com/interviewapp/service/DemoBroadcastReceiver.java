package example.app.com.interviewapp.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by hung on 1/25/18.
 */

public class DemoBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch(intent.getAction()) {
            case "bind":
                Log.e(DemoBroadcastReceiver.class.toString(), "bind");
                break;
            case "unbind":
                Log.e(DemoBroadcastReceiver.class.toString(), "unbind");
                break;
            case "start":
                Log.e(DemoBroadcastReceiver.class.toString(), "start");
                break;
            case "stop":
                Log.e(DemoBroadcastReceiver.class.toString(), "stop");
                break;
            default:
        }
    }
}
