package com.example.agneev.service_test3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Agneev on 29-04-2016.
 */
public class myservice extends Service {
    private final IBinder iBinder  = new localserv();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public class localserv extends Binder
    {
        myservice getServ()
        {
            return myservice.this;
        }
    }

    public String getFirstmsg()
    {
        return "hello all";
    }

    public String getsecmsg()
    {
        return "binded";
    }
}
