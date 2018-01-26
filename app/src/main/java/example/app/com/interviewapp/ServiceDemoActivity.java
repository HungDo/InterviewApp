package example.app.com.interviewapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import example.app.com.interviewapp.service.DemoBroadcastReceiver;
import example.app.com.interviewapp.service.DemoService;

/**
 * Created by hung on 1/25/18.
 */

public class ServiceDemoActivity extends AppCompatActivity {
    TextView counter;
    DemoService service;
    DemoBroadcastReceiver receiver;

    IntentFilter bind = new IntentFilter("bind");
    IntentFilter unbind = new IntentFilter("unbind");
    IntentFilter start = new IntentFilter("start");
    IntentFilter stop = new IntentFilter("stop");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);

        counter = (TextView) findViewById(R.id.tv_counter);
        receiver = new DemoBroadcastReceiver();
        service = new DemoService();

        Button start = (Button) findViewById(R.id.btn_service_starter);
        start.setOnClickListener( view -> {
            startService(service);
        });
    }

    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, bind);
        registerReceiver(receiver, unbind);
        registerReceiver(receiver, start);
        registerReceiver(receiver, stop);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
