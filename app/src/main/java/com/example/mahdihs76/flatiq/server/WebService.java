package com.example.mahdihs76.flatiq.server;

import android.app.Activity;

import com.backtory.java.internal.BacktoryCallBack;
import com.backtory.java.internal.BacktoryObject;
import com.backtory.java.internal.BacktoryQuery;
import com.backtory.java.internal.BacktoryResponse;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.model.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kosar on 9/14/17.
 */

public class WebService {
    public static void setGroups(Activity activity) {

        BacktoryConnection.connect2Server(activity);

        BacktoryQuery query = new BacktoryQuery(Database.TABLE_GROUP);
        query.selectKeys(Arrays.asList(Database.COLUMN_GROUP_ID, Database.COLUMN_NAME, Database.COLUMN_ADMIN_ID, Database.COLUMN_LOCATION, Database.COLUMN_ACTIVITY, Database.COLUMN_MEMBERS, Database.COLUMN_SCHEDULE, Database.COLUMN_IMAGE_SRC));
        query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> response) {
                if (response.isSuccessful()) {
                    List<BacktoryObject> list = response.body();
                    for (BacktoryObject o : list) {
                        Group.groupList.add(new Group(o.get(Database.COLUMN_GROUP_ID).toString(), o.get(Database.COLUMN_NAME).toString(), o.get(Database.COLUMN_ADMIN_ID).toString(), o.get(Database.COLUMN_LOCATION).toString(), o.get(Database.COLUMN_ACTIVITY).toString(), o.get(Database.COLUMN_MEMBERS).toString(), o.get(Database.COLUMN_SCHEDULE).toString(), o.get(Database.COLUMN_IMAGE_SRC).toString()));
                    }
                }
            }
        });

    }



    public static void setPersons() {



        BacktoryQuery query = new BacktoryQuery(Database.TABLE_PERSON);
        query.selectKeys(Arrays.asList(Database.COLUMN_FIRST_NAME, Database.COLUMN_LAST_NAME, Database.COLUMN_PERSON_ID, Database.COLUMN_EMAIL, Database.COLUMN_PASSWORD, Database.COLUMN_SCORE, Database.COLUMN_IMAGE));
        query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> response) {
                if (response.isSuccessful()) {
                    List<BacktoryObject> list = response.body();
                    for (BacktoryObject o : list) {
//                        Log.i(LogTag.TAG, "onResponse: o" + o.get(Database.COLUMN_FIRST_NAME));
                        Person.personList.add(new Person(o.get(Database.COLUMN_FIRST_NAME).toString(), o.get(Database.COLUMN_LAST_NAME).toString(), o.get(Database.COLUMN_EMAIL).toString(), o.get(Database.COLUMN_PASSWORD).toString(), o.get(Database.COLUMN_PERSON_ID).toString(), o.get(Database.COLUMN_SCORE).toString(), o.get(Database.COLUMN_IMAGE).toString()));
                    }
                }
            }
        });

    }
}


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
