package com.example.android.fpmemory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Lee on 2017/07/05.
 */

public class fgPagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragmentsList;


    public fgPagerAdapter (FragmentManager fm){
        super(fm);
    }

    public fgPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}


