package com.example.mahdihs76.flatiq.server;

import android.content.Context;
import android.util.Log;

import com.backtory.java.internal.BacktoryCallBack;
import com.backtory.java.internal.BacktoryObject;
import com.backtory.java.internal.BacktoryQuery;
import com.backtory.java.internal.BacktoryResponse;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.model.Person;
import com.example.mahdihs76.flatiq.tool.Queries;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupMemberAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kosar on 9/14/17.
 */

public class WebService {
    public static void setGroups() {


        Group.groupList = new ArrayList<>();

        BacktoryQuery query = new BacktoryQuery(Database.TABLE_GROUP);
        query.selectKeys(Arrays.asList(Database.COLUMN_GROUP_ID, Database.COLUMN_NAME, Database.COLUMN_ADMIN_ID, Database.COLUMN_LOCATION, Database.COLUMN_ACTIVITY, Database.COLUMN_MEMBERS, Database.COLUMN_SCHEDULE, Database.COLUMN_IMAGE_SRC, Database.COLUMN_LOCATION_NAME));
        query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> response) {
                if (response.isSuccessful()) {
                    List<BacktoryObject> list = response.body();
                    for (BacktoryObject o : list) {
                        Group.groupList.add(new Group(o.get(Database.COLUMN_GROUP_ID).toString(), o.get(Database.COLUMN_NAME).toString(), o.get(Database.COLUMN_ADMIN_ID).toString(), o.get(Database.COLUMN_LOCATION).toString(), o.get(Database.COLUMN_LOCATION_NAME).toString(), o.get(Database.COLUMN_ACTIVITY).toString(), o.get(Database.COLUMN_MEMBERS).toString(), o.get(Database.COLUMN_SCHEDULE).toString(), o.get(Database.COLUMN_IMAGE_SRC).toString()));
                    }
                    ViewHandler.groupsAdapter.notifyDataSetChanged();
                }
            }
        });

    }


    public static void setPersons() {


        Person.personList = new ArrayList<>();

        BacktoryQuery query = new BacktoryQuery(Database.TABLE_PERSON);
        query.selectKeys(Arrays.asList(Database.COLUMN_FIRST_NAME, Database.COLUMN_LAST_NAME, Database.COLUMN_PERSON_ID, Database.COLUMN_EMAIL, Database.COLUMN_PASSWORD, Database.COLUMN_SCORE, Database.COLUMN_IMAGE, Database.COLUMN_GROUPS));
        query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> response) {
                if (response.isSuccessful()) {
                    List<BacktoryObject> list = response.body();
                    for (BacktoryObject o : list) {
                        Person.personList.add(new Person(o.get(Database.COLUMN_FIRST_NAME).toString(), o.get(Database.COLUMN_LAST_NAME).toString(), o.get(Database.COLUMN_EMAIL).toString(), o.get(Database.COLUMN_PASSWORD).toString(), o.get(Database.COLUMN_PERSON_ID).toString(), o.get(Database.COLUMN_SCORE).toString(), o.get(Database.COLUMN_IMAGE).toString(), o.get(Database.COLUMN_GROUPS).toString()));

                        ViewHandler.groupMemberAdapter.notifyDataSetChanged();

                    }
                }
            }
        });

    }


    public static void addMember(final String memberID, final String groupID, final Context context) {


        BacktoryQuery query1 = new BacktoryQuery(Database.TABLE_GROUP);
        query1.selectKeys(Arrays.asList(Database.COLUMN_MEMBERS));
        query1.whereEqualTo(Database.COLUMN_GROUP_ID, groupID);
        query1.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> response) {
                if (response.isSuccessful()) {
                    List<BacktoryObject> list = response.body();
                    BacktoryObject result = list.get(0);
                    result.put(Database.COLUMN_MEMBERS, result.get(Database.COLUMN_MEMBERS) + "-" + memberID);
                    result.saveInBackground(new BacktoryCallBack<Void>() {
                        @Override
                        public void onResponse(BacktoryResponse<Void> backtoryResponse) {
                            //do sth?
                            //this is group
                            Queries.getGroupWithId(groupID).setMembers(Queries.getGroupWithId(groupID).getMembers() + "-" + memberID);
                            ViewHandler.groupMemberAdapter.setPersons(Queries.getGroupMembers(groupID));
                            ViewHandler.groupMemberAdapter.notifyDataSetChanged();
                        }
                    });

                }
            }
        });

        BacktoryQuery query2 = new BacktoryQuery(Database.TABLE_PERSON);
        query1.selectKeys(Arrays.asList(Database.COLUMN_GROUPS));
        query2.whereEqualTo(Database.COLUMN_PERSON_ID, memberID);
        query2.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> backtoryResponse) {
                if (backtoryResponse.isSuccessful()) {
                    List<BacktoryObject> list = backtoryResponse.body();
                    BacktoryObject result = list.get(0);
                    result.put(Database.COLUMN_GROUPS, result.get(Database.COLUMN_GROUPS) + "-" + groupID);
                    result.saveInBackground(new BacktoryCallBack<Void>() {
                        @Override
                        public void onResponse(BacktoryResponse<Void> backtoryResponse) {
                            //do sth?
                            //this is person
                            Queries.getPersonWithId(memberID).setGroups(Queries.getPersonWithId(memberID).getGroups() + "-" + groupID);
                            try {
                                Log.i("debug", "onResponse: members of group " + Queries.getGroupWithId(groupID).getMembers());
                                Log.i("debug", "onResponse: groups of person " + Queries.getPersonWithId(memberID).getGroups());
                                Log.i("debug", "onResponse: groupid: " + groupID + " personid: " + memberID);
                            } catch (NullPointerException n) {
                                Log.i("debug", "onResponse: null " + Person.personList);
                            }
                            ViewHandler.groupMemberAdapter.setPersons(Queries.getGroupMembers(groupID));
                            ViewHandler.groupMemberAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });

    }


    public static void getPersonGroups(String personId) {
        BacktoryQuery query = new BacktoryQuery(Database.TABLE_PERSON);
        query.selectKeys(Arrays.asList(Database.COLUMN_FIRST_NAME, Database.COLUMN_LAST_NAME, Database.COLUMN_EMAIL, Database.COLUMN_PASSWORD, Database.COLUMN_PERSON_ID, Database.COLUMN_SCORE, Database.COLUMN_IMAGE, Database.COLUMN_GROUPS));
        query.whereEqualTo(Database.COLUMN_PERSON_ID, personId);
        query.findInBackground(new BacktoryCallBack<List<BacktoryObject>>() {
            @Override
            public void onResponse(BacktoryResponse<List<BacktoryObject>> backtoryResponse) {
                if (backtoryResponse.isSuccessful()) {
                    List<BacktoryObject> list = backtoryResponse.body();
                    BacktoryObject person = list.get(0);
                    //TODO fill and notify adapter
                }
            }
        });
    }


}
