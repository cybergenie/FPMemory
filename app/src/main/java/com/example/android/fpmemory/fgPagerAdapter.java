package com.example.android.fpmemory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Created by Lee on 2017/07/05.
 */

public class fgPagerAdapter extends FragmentPagerAdapter{

    private final int PAGER_COUNT = 4;
    private Fragment_Sports fgSports = null;
    private Fragment_Health fgHealth = null;
    private Fragment_Find fgFind = null;
    private Fragment_Me fgMe = null;

    public fgPagerAdapter (FragmentManager fm){
        super(fm);
        fgSports = new Fragment_Sports();
        fgHealth = new Fragment_Health();
        fgFind = new Fragment_Find();
        fgMe = new Fragment_Me();
    }

    @Override
    public Object instantiateItem(ViewGroup vg,int postion){
        return super.instantiateItem(vg,postion);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = fgSports;
                break;
            case MainActivity.PAGE_TWO:
                fragment = fgHealth;
                break;
            case MainActivity.PAGE_THREE:
                fragment = fgFind;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = fgMe;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}


