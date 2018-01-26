package example.app.com.interviewapp.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by hung on 1/25/18.
 */

public class DemoService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(DemoService.class.toString(), "onBind");

        Intent msg = new Intent("bind");
        sendBroadcast(msg);

        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        boolean isUnbound = super.onUnbind(intent);

        Intent msg = new Intent("unbind");
        sendBroadcast(msg);

        return isUnbound;
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return super.bindService(service, conn, flags);
    }

    @Override
    public ComponentName startService(Intent service) {
        ComponentName name = super.startService(service);

        Intent msg = new Intent("start");
        sendBroadcast(msg);

        return name;
    }

    @Override
    public boolean stopService(Intent name) {
        boolean status = super.stopService(name);

        Intent msg = new Intent("stop");
        sendBroadcast(msg);

        return status;
    }
}
