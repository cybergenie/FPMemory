package com.example.android.fpmemory;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * Created by Lee on 2017/07/04.
 */

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener{

    //UI Objects
    private TextView txt_topbar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_protection;
    private RadioButton rb_training;
    private RadioButton rb_recover;
    private RadioButton rb_emergency;
    private ViewPager vpager;

    private fgPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new fgPagerAdapter(getSupportFragmentManager());
        bindViews();
        rb_protection.setChecked(true);
    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_protection = (RadioButton) findViewById(R.id.rb_protection);
        rb_training = (RadioButton) findViewById(R.id.rb_training);
        rb_recover = (RadioButton) findViewById(R.id.rb_recover);
        rb_emergency = (RadioButton) findViewById(R.id.rb_emergency);
        rg_tab_bar.setOnCheckedChangeListener(this);


        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_protection:
                vpager.setCurrentItem(PAGE_ONE);
                txt_topbar.setText("安全防护");
                break;
            case R.id.rb_training:
                vpager.setCurrentItem(PAGE_TWO);
                txt_topbar.setText("健康教育");
                break;
            case R.id.rb_recover:
                vpager.setCurrentItem(PAGE_THREE);
                txt_topbar.setText("康复管理");
                break;
            case R.id.rb_emergency:
                vpager.setCurrentItem(PAGE_FOUR);
                txt_topbar.setText("紧急救护");
                break;
        }
    }


    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_protection.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_training.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_recover.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_emergency.setChecked(true);
                    break;
            }
        }
    }


}