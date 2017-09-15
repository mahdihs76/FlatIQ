package com.example.mahdihs76.flatiq.server.callbacks;

import android.util.Log;

import com.backtory.java.internal.BacktoryCallBack;
import com.backtory.java.internal.BacktoryResponse;
import com.backtory.java.internal.LoginResponse;
import com.example.mahdihs76.flatiq.constant.LogTag;
import com.example.mahdihs76.flatiq.server.WebService;

/**
 * Created by mahdihs76 on 9/12/17.
 */

public class BacktoryLoginCallBack implements BacktoryCallBack<LoginResponse> {
    @Override
    public void onResponse(BacktoryResponse<LoginResponse> response) {
        if (response.isSuccessful()) {
            Log.i(LogTag.TAG, "application connected to server in admin login!");
            WebService.setGroups();
            WebService.setPersons();
        } else {
            Log.i(LogTag.TAG, "application login connection failed!");
        }
    }
}
