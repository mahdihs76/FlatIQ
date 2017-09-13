package com.example.mahdihs76.flatiq.view.page;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mahdihs76.flatiq.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Calligraphy

        // 1- Add it to onCreate() activity :

        //CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        //        .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
        //        .setFontAttrId(R.attr.fontPath)
        //        .build()
        //);

        // 2- Add it to activity class :

        //@Override
        //protected void attachBaseContext(Context newBase) {
        //    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        //}

        // 3- usage (Add font to assets/fonts:
        // <TextView fontPath="fonts/MyFont.ttf"/>

    }



}
