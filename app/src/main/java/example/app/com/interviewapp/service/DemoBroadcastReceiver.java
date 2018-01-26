package example.app.com.interviewapp.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by hung on 1/25/18.
 */

public class DemoBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        switch(intent.getAction()) {
            case "bind":
                break;
            case "unbind":
                break;
            case "start":
                break;
            case "stop":
                break;
            default:
        }
    }
}
