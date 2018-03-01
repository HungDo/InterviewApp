package example.app.com.interviewapp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import example.app.com.interviewapp.service.DemoBroadcastReceiver;
import example.app.com.interviewapp.service.DemoService;

/**
 * Created by hung on 1/25/18.
 */

public class ServiceDemoActivity extends AppCompatActivity {
    TextView counter;
    DemoService demoService;
    DemoBroadcastReceiver receiver;

    IntentFilter bind = new IntentFilter("bind");
    IntentFilter unbind = new IntentFilter("unbind");
    IntentFilter start = new IntentFilter("start");
    IntentFilter stop = new IntentFilter("stop");

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(ServiceDemoActivity.class.toString(), "onServiceConnected");
            DemoService.LocalBinder binder = (DemoService.LocalBinder) service;
            demoService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(ServiceDemoActivity.class.toString(), "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        counter = (TextView) findViewById(R.id.tv_counter);
        receiver = new DemoBroadcastReceiver();
        demoService = new DemoService();

        Button startBtn = (Button) findViewById(R.id.btn_service_starter);
        startBtn.setOnClickListener( view -> {
            Log.d(ServiceDemoActivity.class.toString(), "clicked");
            startService(new Intent(getApplicationContext(), DemoService.class));
        });

        registerReceiver(receiver, bind);
        registerReceiver(receiver, unbind);
        registerReceiver(receiver, start);
        registerReceiver(receiver, stop);
    }

    protected void onResume() {
        super.onResume();
//        bindService(new Intent(this, DemoService.class), conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);
        unregisterReceiver(receiver);
    }
}
