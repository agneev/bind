package com.example.agneev.service_test3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    myservice myservice;
    boolean isbind = false;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView2);
        Intent intent = new Intent(this,myservice.class);
        bindService(intent, msrvcnc, Context.BIND_AUTO_CREATE);


    }

    public void first(View view)
    {
        String msg;
        msg = myservice.getFirstmsg();
        textView.setText(msg);
    }
    public void sec(View view)
    {
        String msg;
        msg = myservice.getsecmsg();
        textView.setText(msg);
    }

    private ServiceConnection msrvcnc  = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myservice.localserv localserv = (myservice.localserv)service;
            myservice = localserv.getServ();
            isbind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isbind=false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if(isbind)
        {
            unbindService(msrvcnc);
            isbind=false;
        }
    }
}
