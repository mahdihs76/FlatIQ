package com.example.mahdihs76.flatiq.view.page.login;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.constant.BacktoryAdminUser;
import com.example.mahdihs76.flatiq.constant.Constant;
import com.example.mahdihs76.flatiq.view.page.main.MainActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends FragmentActivity{

    private static int pagePosition = 0;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView userName;
    private TextView password;
    private TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/YEKAN.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());

        registerButton = (TextView) findViewById(R.id.register_button);
        userName = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals(BacktoryAdminUser.USERNAME) && password.getText().toString().equals(BacktoryAdminUser.PASSWORD))
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "نام کاربری و رمز عبور مطابقت ندارند", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }




}
