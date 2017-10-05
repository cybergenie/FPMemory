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
    private RadioButton rb_sports;
    private RadioButton rb_health;
    private RadioButton rb_find;
    private RadioButton rb_me;
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
        initView();
        rb_sports.setChecked(true);
    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_sports = (RadioButton) findViewById(R.id.rb_sports);
        rb_health = (RadioButton) findViewById(R.id.rb_health);
        rb_find = (RadioButton) findViewById(R.id.rb_find);
        rb_me = (RadioButton) findViewById(R.id.rb_me);
        rg_tab_bar.setOnCheckedChangeListener(this);


        vpager = (ViewPager) findViewById(R.id.vpager);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    private void initView() {

        int imagesize = 35;
//        定义rb_sports标签图片大小和位置
        Drawable drawable_sports = getResources().getDrawable(R.drawable.tab_menu_sports, getTheme());
        drawable_sports.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_sports.setCompoundDrawables(null, drawable_sports, null, null);

//        定义rb_sports标签图片大小和位置
        Drawable drawable_health = getResources().getDrawable(R.drawable.tab_menu_health, getTheme());
        drawable_health.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_health.setCompoundDrawables(null, drawable_health, null, null);

//        定义rb_sports标签图片大小和位置
        Drawable drawable_find = getResources().getDrawable(R.drawable.tab_menu_find, getTheme());
        drawable_find.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_find.setCompoundDrawables(null, drawable_find, null, null);

//        定义rb_sports标签图片大小和位置
        Drawable drawable_me = getResources().getDrawable(R.drawable.tab_menu_me, getTheme());
        drawable_me.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_me.setCompoundDrawables(null, drawable_me, null, null);
    }


        @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_sports:
                vpager.setCurrentItem(PAGE_ONE);
                txt_topbar.setText("安全防护");
                break;
            case R.id.rb_health:
                vpager.setCurrentItem(PAGE_TWO);
                txt_topbar.setText("健康教育");
                break;
            case R.id.rb_find:
                vpager.setCurrentItem(PAGE_THREE);
                txt_topbar.setText("康复管理");
                break;
            case R.id.rb_me:
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
                    rb_sports.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_health.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_find.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_me.setChecked(true);
                    break;
            }
        }
    }


}