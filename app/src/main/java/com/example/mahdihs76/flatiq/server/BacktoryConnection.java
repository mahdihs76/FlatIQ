package com.example.mahdihs76.flatiq.server;

import android.app.Activity;
import android.util.Log;

import com.backtory.java.internal.BacktoryClient;
import com.backtory.java.internal.BacktoryUser;
import com.backtory.java.internal.Config;
import com.example.mahdihs76.flatiq.constant.BacktoryAdminUser;
import com.example.mahdihs76.flatiq.constant.BacktoryKey;
import com.example.mahdihs76.flatiq.constant.LogTag;
import com.example.mahdihs76.flatiq.server.callbacks.BacktoryLoginCallBack;


/**
 * Created by mahdihs76 on 9/12/17.
 */

public class BacktoryConnection {
    public static void connect2Server(Activity activity){
        BacktoryClient.Android.init(Config.newBuilder()
                .initAuth(BacktoryKey.BACKTORY_AUTHENTICATION_ID, BacktoryKey.BACKTORY_AUTHENTICATION_KEY_CLIENT)
                .initObjectStorage(BacktoryKey.BACKTORY_OBJECT_STORAGE_ID)
                .build(), activity);

       BacktoryUser.loginInBackground(BacktoryAdminUser.USERNAME, BacktoryAdminUser.PASSWORD, new BacktoryLoginCallBack());
    }
}
