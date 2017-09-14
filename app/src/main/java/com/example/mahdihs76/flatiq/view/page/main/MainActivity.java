package com.example.mahdihs76.flatiq.view.page.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.backtory.java.internal.BacktoryCallBack;
import com.backtory.java.internal.BacktoryObject;
import com.backtory.java.internal.BacktoryQuery;
import com.backtory.java.internal.BacktoryResponse;
import com.bumptech.glide.Glide;
import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.constant.LogTag;
import com.example.mahdihs76.flatiq.model.Person;
import com.example.mahdihs76.flatiq.server.BacktoryConnection;
import com.example.mahdihs76.flatiq.server.WebService;
import com.example.mahdihs76.flatiq.view.page.findgroup.FindGroupFragment;

import java.util.Arrays;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment findGroupFragment = new FindGroupFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, findGroupFragment);

        fragmentTransaction.commit();




        BacktoryConnection.connect2Server(this);


        WebService.setPersons();
        for(Person p : Person.personList) {
            Log.i(LogTag.TAG, "onCreate: " + p.getFirstName());
        }
    }

}

/**
 * HELP
 */

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

// Backtory

//BacktoryConnection.connect2Server(this);
//
//BacktoryQuery query = new BacktoryQuery(Database.TABLE_CONSULTANT);
//query.selectKeys(Arrays.asList(Database.COLUMN_FIRST_NAME, Database.COLUMN_LAST_NAME));
//query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
//    @Override
//    public void onResponse(BacktoryResponse<List<BacktoryObject>> response) {
//        if (response.isSuccessful()) {
//            List<BacktoryObject> list = response.body();
//            for (BacktoryObject o : list) {
//                Toast.makeText(MainActivity.this, o.get(Database.COLUMN_FIRST_NAME).toString(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//});

