package com.example.mahdihs76.flatiq.view.page.login;

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


import com.example.mahdihs76.flatiq.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class LoginActivity extends FragmentActivity{

    private static int pagePosition = 0;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/BRoyaBd.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        registerButton = (Button) findViewById(R.id.register_btn);

        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }
                @Override
                public void onPageSelected(int position) {
                    if (position == 0)
                        registerButton.setText("ورود");
                    else
                        registerButton.setText("ثبت نام");

                    pagePosition = position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

        SwipeAdabtor swipeAdabtor = new SwipeAdabtor(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdabtor);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        TabLayout.Tab tab1 = tabLayout.getTabAt(0);
        tab1.setText("ورود");

        TabLayout.Tab tab2 = tabLayout.getTabAt(1);
        tab2.setText("ثبت نام");

        registerButton.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View v) {
                    switch (pagePosition) {
                        case 0:
                            break;
                        case 1:
                            break;
                    }
                }
            });




    }




}
