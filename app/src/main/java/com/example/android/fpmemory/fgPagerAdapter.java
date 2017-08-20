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
    private Fragment_Protection fgProtection = null;
    private Fragment_Training fgTraining = null;
    private Fragment_Recover fgRecover = null;
    private Fragment_Emergency fgEmergency = null;

    public fgPagerAdapter (FragmentManager fm){
        super(fm);
        fgProtection = new Fragment_Protection();
        fgTraining = new Fragment_Training();
        fgRecover = new Fragment_Recover();
        fgEmergency = new Fragment_Emergency();
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
                fragment = fgProtection;
                break;
            case MainActivity.PAGE_TWO:
                fragment = fgTraining;
                break;
            case MainActivity.PAGE_THREE:
                fragment = fgRecover;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = fgEmergency;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
