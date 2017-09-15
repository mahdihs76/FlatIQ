package com.example.mahdihs76.flatiq.view.page.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.constant.LogTag;
import com.example.mahdihs76.flatiq.model.Group;
import com.example.mahdihs76.flatiq.model.Person;
import com.example.mahdihs76.flatiq.server.BacktoryConnection;
import com.example.mahdihs76.flatiq.server.ViewHandler;
import com.example.mahdihs76.flatiq.server.WebService;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupMemberAdapter;
import com.example.mahdihs76.flatiq.view.page.findgroup.FindGroupFragment;
import com.example.mahdihs76.flatiq.view.page.findgroup.GroupFragment;
import com.example.mahdihs76.flatiq.view.page.shop.ShopFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    public static final String LONGITUDES = "longitudes";
    public static final String LATITUDES = "latitudes";
    public static final String ACTIVITIES = "activities";
    public static final String NAMES = "names";
    public static final String IDS = "ids";
    Fragment findGroupFragment;
    Fragment shopFragment;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/YEKAN.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());

//        ArrayList<Group> groups = new ArrayList<>();
//        groups.add(new Group("1000","حاج تقی","2000","51.3731899-35.7145295", "پارک ملت","دوچرخه سواری","حامد","دوشنبه صبح","http://www.waikato.ac.nz/__data/assets/image/0007/292840/fields.jpg"));
//        Group.groupList = groups;

//        ArrayList<Person> persons = new ArrayList<>();
//        persons.add(new Person("حامد", "شیروانی", "", "", "", "1001", "http://www.beytoote.com/images/stories/sport/hhs879.jpg", "1000"));
//        Person.personList = persons;

//        fillGroups();

        GroupMemberAdapter groupMemberAdapter = new GroupMemberAdapter(this, Person.personList);

        ViewHandler.groupMemberAdapter = groupMemberAdapter;

        findGroupFragment = new FindGroupFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, findGroupFragment);
        fragmentTransaction.commit();

        shopFragment = new ShopFragment();
        findGroupFragment = new FindGroupFragment();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Fragment groupFragment = new GroupFragment();
            Bundle bundle = new Bundle();
            bundle.putString("groupId", getIntent().getExtras().getString("groupId"));
            groupFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, groupFragment).commit();
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigationview);
        bottomNavigationView.setSelectedItemId(R.id.find_group);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.find_group:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,findGroupFragment).commit();
                        break;

                    case R.id.gallerypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,shopFragment).commit();
                        break;
                }
                return true;
            }
        });

        BacktoryConnection.connect2Server(this);


    }

    public static void fillGroups() {
        Group.groupList.add(new Group("1000", "varzesh3", "3", "51.3731899-35.7145295", "Tarasht", "volleyball", "2-3", "9shanbe ha", "sth.png"));
        Group.groupList.add(new Group("1001", "VarzeshKaran", "2", "51.3752824-35.7382281", "Milad Tower", "basketball", "2-1", "5shanbe ha", "sth.png"));
        Group.groupList.add(new Group("1002", "HamRekaban", "1", "51.3919707-35.6770522", "Allameh Helli High School", "football", "1-3", "shanbe ha", "sth.png"));
        Group.groupList.add(new Group("1003", "footballistHa", "0", "51.4002982-35.7116288", "Bustan e Laleh", "ping-pong", "4", "hichvaght", "sth.png"));
    }

    public static class BottomNavigationViewHelper {

        static void removeShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    item.setShiftingMode(false);
                    // set once again checked value, so view will be updated
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
            } catch (IllegalAccessException e) {
                Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
            }
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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

