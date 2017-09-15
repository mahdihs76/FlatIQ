package com.example.mahdihs76.flatiq.view.page.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

/**
 * Created by mahdihs76 on 7/31/17.
 */

public class SwipeAdabtor extends FragmentPagerAdapter {


    public SwipeAdabtor(FragmentManager fm) {

        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                Log.i("debug","1");
                fragment = new LoginFragment();
                break;
            case 1:
                Log.i("debug","2");
                fragment = new RegisterFragment();
                break;

        }
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position + 1);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
