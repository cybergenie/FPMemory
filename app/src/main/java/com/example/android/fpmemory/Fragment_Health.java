package com.example.android.fpmemory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class Fragment_Health extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private Fragment heartrate;
    private Fragment bloodpressure;
    private Fragment bloodoxygen;

    private RadioGroup rg_sports_bar;
    private RadioButton rb_heartrate, rb_bloodpressure,rb_bloodoxygen;

    public Fragment_Health() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_health,container,false);
        InitViewPager(view);
        InitSportsTopView(view);
        rb_heartrate.setChecked(true);
        return view;
    }

    private void InitSportsTopView(View parentView) {
        rg_sports_bar = (RadioGroup) parentView.findViewById(R.id.rg_sports_bar);
        rb_heartrate = (RadioButton) parentView.findViewById(R.id.rb_heartrate);
        rb_bloodpressure = (RadioButton) parentView.findViewById(R.id.rb_bloodpressure);
        rb_bloodoxygen = (RadioButton) parentView.findViewById(R.id.rb_bloodoxygen);
        rg_sports_bar.setOnCheckedChangeListener(this);

//        定义图片大小，单位是dx
        int imagesize = 65;
//        定义rb_heartrate标签图片大小和位置
        Drawable drawable_heartrate = getResources().getDrawable(R.drawable.tab_health_heartrate,null);
        drawable_heartrate.setBounds(0, 0, DensityUtil.dip2px(this.getActivity(),imagesize), DensityUtil.dip2px(this.getActivity(),imagesize));
        rb_heartrate.setCompoundDrawables(null, drawable_heartrate, null, null);

//        定义rb_bloodpressure标签图片大小和位置
        Drawable drawable_bloodpressure= getResources().getDrawable(R.drawable.tab_health_bloodpressure, null);
        drawable_bloodpressure.setBounds(0, 0, DensityUtil.dip2px(this.getActivity(),imagesize), DensityUtil.dip2px(this.getActivity(),imagesize));
        rb_bloodpressure.setCompoundDrawables(null, drawable_bloodpressure, null, null);

//        定义rb_bloodoxygen标签图片大小和位置
        Drawable drawable_bloodoxygen = getResources().getDrawable(R.drawable.tab_health_bloodoxygen, null);
        drawable_bloodoxygen.setBounds(0, 0, DensityUtil.dip2px(this.getActivity(),imagesize), DensityUtil.dip2px(this.getActivity(),imagesize));
        rb_bloodoxygen.setCompoundDrawables(null, drawable_bloodoxygen, null, null);

    }

    private void InitViewPager(View parentView){
        mPager = (ViewPager)parentView.findViewById(R.id.vPager);
        fragmentsList = new ArrayList<Fragment>();
        heartrate = new Heartrate_Content();
        bloodpressure = new Bloodpressure_Content();
        bloodoxygen = new Bloodoxygen_Content();

        fragmentsList.add(heartrate);
        fragmentsList.add(bloodpressure);
        fragmentsList.add(bloodoxygen);

        mPager.setAdapter(new fgPagerAdapter(getChildFragmentManager(),fragmentsList));
        mPager.addOnPageChangeListener(new Fragment_Health.setOnPageChangeListener());
        mPager.setCurrentItem(0);
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_sports:
                mPager.setCurrentItem(0);
                break;
            case R.id.rb_health:
                mPager.setCurrentItem(1);
                break;
            case R.id.rb_find:
                mPager.setCurrentItem(2);
                break;
        }
    }

    public class setOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:
                    rb_heartrate.setChecked(true);
                    break;
                case 1:
                    rb_bloodpressure.setChecked(true);
                    break;
                case 2:
                    rb_bloodoxygen.setChecked(true);
                    break;
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}
