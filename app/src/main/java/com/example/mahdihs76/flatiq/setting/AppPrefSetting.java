package com.example.mahdihs76.flatiq.setting;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.GeneralSecurityException;

/**
 * Created by mahdihs76 on 9/13/17.
 */

public class AppPrefSetting {

    private static final String PREFERENCE_KEY = "PREFERENCE_FILE_KEY";
    private static final String KEY_AUTHENTICATION_EMAIL = "KEY_AUTHENTICATION_EMAIL";

    private static SharedPreferences mSharedPreferences;

    public AppPrefSetting(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    public static void setAuthenticationEmail(String info) throws GeneralSecurityException {
        mSharedPreferences.edit().putString(KEY_AUTHENTICATION_EMAIL, info).apply();
    }

    public static String getAuthenticationEmail() throws GeneralSecurityException {
        return mSharedPreferences.getString(KEY_AUTHENTICATION_EMAIL, null);
    }

}
