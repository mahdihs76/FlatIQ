package com.example.mahdihs76.flatiq.view.page.main;

import android.content.Context;
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
import android.widget.Toast;

import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.model.Person;
import com.example.mahdihs76.flatiq.server.BacktoryConnection;
import com.example.mahdihs76.flatiq.view.ViewHandler;
import com.example.mahdihs76.flatiq.tool.CaseView;
import com.example.mahdihs76.flatiq.tool.GuideUtils;
import com.example.mahdihs76.flatiq.view.Adapters.findGroup.GroupMemberAdapter;
import com.example.mahdihs76.flatiq.view.page.findgroup.FindGroupFragment;
import com.example.mahdihs76.flatiq.view.page.findgroup.GroupFragment;
import com.example.mahdihs76.flatiq.view.page.shop.ShopFragment;
import com.github.amlcurran.showcaseview.targets.PointTarget;

import java.lang.reflect.Field;
import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {


    ArrayList<CaseView> targets = new ArrayList<>();

    Fragment findGroupFragment;
    Fragment shopFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/YEKAN.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());


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
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, findGroupFragment).commit();
                        break;

                    case R.id.gallerypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, shopFragment).commit();
                        break;
                    case R.id.newspage:
                        Toast.makeText(MainActivity.this, "این بخش به زودی فعال می گردد", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profile_page:
                        Toast.makeText(MainActivity.this, "این بخش به زودی فعال می گردد", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

        BacktoryConnection.connect2Server(this);

        setPointTargets();


    }

    private void setPointTargets() {
        int height = this.getWindow().getWindowManager().getDefaultDisplay().getHeight();
        int width = this.getWindow().getWindowManager().getDefaultDisplay().getWidth();
        targets.add(new CaseView("کاربر", "صفحه‌ی کاربری خود را مشاهده و شخصی‌سازی کنید.", new PointTarget(120, height - 100))); //karbar
//        targets.add(new CaseView("قسمت فروش", "از محصولات ورزشی دیدن کرده و خرید کنید.", new PointTarget(width - 120, height- 100))); //mahsulat
        targets.add(new CaseView("گروه‌ها", "گروه‌های مطلوب خود را بیابید", new PointTarget(width/2 - 120, height - 100))); //findgroup
        targets.add(new CaseView("اخبار", "از تازه‌های دنیای ورزش و سلامت مطلع شوید.", new PointTarget(width/2 + 120, height - 100))); //news
        GuideUtils.showGuide(this, targets, 0);

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

    @Override
    protected void onStart() {
        super.onStart();
        setIntent(null);
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

