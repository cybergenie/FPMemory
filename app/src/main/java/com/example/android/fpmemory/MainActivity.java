package com.example.android.fpmemory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * Created by JW.Lee on 2017.10.05
 * tansfer the pageviewer to Fragment
 *
 */

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

    private TextView txt_topbar;
    private LinearLayout ly_top_bar;
    private RadioGroup rg_tab_bar;
    private RadioButton rb_sports;
    private RadioButton rb_health;
    private RadioButton rb_find;
    private RadioButton rb_me;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private Fragment_Sports fgSports = null;
    private Fragment_Health fgHealth = null;
    private Fragment_Find fgFind = null;
    private Fragment_Me fgMe = null;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        rb_sports.setChecked(true);
    }

    private void bindViews() {
        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        ly_top_bar = (LinearLayout)findViewById(R.id.ly_top_bar);
        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_sports = (RadioButton) findViewById(R.id.rb_sports);
        rb_health = (RadioButton) findViewById(R.id.rb_health);
        rb_find = (RadioButton) findViewById(R.id.rb_find);
        rb_me = (RadioButton) findViewById(R.id.rb_me);
        rg_tab_bar.setOnCheckedChangeListener(this);

//        定义图片大小，单位是dx
        int imagesize = 35;
//        定义rb_sports标签图片大小和位置
        Drawable drawable_sports = getResources().getDrawable(R.drawable.tab_menu_sports, null);
        drawable_sports.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_sports.setCompoundDrawables(null, drawable_sports, null, null);

//        定义rb_sports标签图片大小和位置
        Drawable drawable_health = getResources().getDrawable(R.drawable.tab_menu_health, null);
        drawable_health.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_health.setCompoundDrawables(null, drawable_health, null, null);

//        定义rb_sports标签图片大小和位置
        Drawable drawable_find = getResources().getDrawable(R.drawable.tab_menu_find, null);
        drawable_find.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_find.setCompoundDrawables(null, drawable_find, null, null);

//        定义rb_sports标签图片大小和位置
        Drawable drawable_me = getResources().getDrawable(R.drawable.tab_menu_me, null);
        drawable_me.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
        rb_me.setCompoundDrawables(null, drawable_me, null, null);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        hideFragment(ft);
        switch (checkedId) {
            case R.id.rb_sports:
                if(fgSports==null){
                    fgSports = new Fragment_Sports();
                    ft.add(R.id.fragment_content,fgSports);
                }
                else {
                    ft.show(fgSports);
                }
                txt_topbar.setText(this.getResources().getString(R.string.tab_menu_sports));
                ly_top_bar.setBackgroundColor(this.getResources().getColor(R.color.bg_menu_sports,null));
                break;
            case R.id.rb_health:
                if(fgHealth==null){
                    fgHealth = new Fragment_Health();
                    ft.add(R.id.fragment_content,fgHealth);
                }
                else {
                    ft.show(fgHealth);
                }
                txt_topbar.setText(this.getResources().getString(R.string.tab_menu_health));
                ly_top_bar.setBackgroundColor(this.getResources().getColor(R.color.bg_menu_health,null));
                break;
            case R.id.rb_find:
                if(fgFind==null){
                    fgFind = new Fragment_Find();
                    ft.add(R.id.fragment_content,fgFind);
                }
                else {
                    ft.show(fgFind);
                }
                txt_topbar.setText(this.getResources().getString(R.string.tab_menu_find));
                ly_top_bar.setBackgroundColor(this.getResources().getColor(R.color.bg_menu_find,null));
                break;
            case R.id.rb_me:
                if(fgMe==null){
                    fgMe = new Fragment_Me();
                    ft.add(R.id.fragment_content,fgMe);
                }
                else {
                    ft.show(fgMe);
                }
                txt_topbar.setText(this.getResources().getString(R.string.tab_menu_me));
                ly_top_bar.setBackgroundColor(this.getResources().getColor(R.color.bg_menu_me,null));
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        if (fgSports!=null){
            transaction.hide(fgSports);
        }
        if (fgHealth!=null) {
            transaction.hide(fgHealth);
        }
        if (fgFind!=null) {
            transaction.hide(fgFind);
        }
        if (fgMe!=null) {
            transaction.hide(fgMe);
        }

    }
}

/**
 * Created by Lee on 2017/07/04.
 */

//public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
//        ViewPager.OnPageChangeListener{
//
//    //UI Objects
//    private TextView txt_topbar;
//    private RadioGroup rg_tab_bar;
//    private RadioButton rb_sports;
//    private RadioButton rb_health;
//    private RadioButton rb_find;
//    private RadioButton rb_me;
//    private ViewPager vpager;
//
//    private fgPagerAdapter mAdapter;
//
//    //几个代表页面的常量
//    public static final int PAGE_ONE = 0;
//    public static final int PAGE_TWO = 1;
//    public static final int PAGE_THREE = 2;
//    public static final int PAGE_FOUR = 3;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mAdapter = new fgPagerAdapter(getSupportFragmentManager());
//        bindViews();
//        initView();
//        rb_sports.setChecked(true);
//    }
//
//    private void bindViews() {
//        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
//        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
//        rb_sports = (RadioButton) findViewById(R.id.rb_sports);
//        rb_health = (RadioButton) findViewById(R.id.rb_health);
//        rb_find = (RadioButton) findViewById(R.id.rb_find);
//        rb_me = (RadioButton) findViewById(R.id.rb_me);
//        rg_tab_bar.setOnCheckedChangeListener(this);
//
//
//        vpager = (ViewPager) findViewById(R.id.vpager);
//        vpager.setAdapter(mAdapter);
//        vpager.setCurrentItem(0);
//        vpager.addOnPageChangeListener(this);
//    }
//
//    private void initView() {
//
//        int imagesize = 35;
////        定义rb_sports标签图片大小和位置
//        Drawable drawable_sports = getResources().getDrawable(R.drawable.tab_menu_sports, getTheme());
//        drawable_sports.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
//        rb_sports.setCompoundDrawables(null, drawable_sports, null, null);
//
////        定义rb_sports标签图片大小和位置
//        Drawable drawable_health = getResources().getDrawable(R.drawable.tab_menu_health, getTheme());
//        drawable_health.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
//        rb_health.setCompoundDrawables(null, drawable_health, null, null);
//
////        定义rb_sports标签图片大小和位置
//        Drawable drawable_find = getResources().getDrawable(R.drawable.tab_menu_find, getTheme());
//        drawable_find.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
//        rb_find.setCompoundDrawables(null, drawable_find, null, null);
//
////        定义rb_sports标签图片大小和位置
//        Drawable drawable_me = getResources().getDrawable(R.drawable.tab_menu_me, getTheme());
//        drawable_me.setBounds(0, 0, DensityUtil.dip2px(this,imagesize), DensityUtil.dip2px(this,imagesize));
//        rb_me.setCompoundDrawables(null, drawable_me, null, null);
//    }
//
//
//        @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        switch (checkedId) {
//            case R.id.rb_sports:
//                vpager.setCurrentItem(PAGE_ONE);
//                txt_topbar.setText("安全防护");
//                break;
//            case R.id.rb_health:
//                vpager.setCurrentItem(PAGE_TWO);
//                txt_topbar.setText("健康教育");
//                break;
//            case R.id.rb_find:
//                vpager.setCurrentItem(PAGE_THREE);
//                txt_topbar.setText("康复管理");
//                break;
//            case R.id.rb_me:
//                vpager.setCurrentItem(PAGE_FOUR);
//                txt_topbar.setText("紧急救护");
//                break;
//        }
//    }
//
//
//    //重写ViewPager页面切换的处理方法
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
//        if (state == 2) {
//            switch (vpager.getCurrentItem()) {
//                case PAGE_ONE:
//                    rb_sports.setChecked(true);
//                    break;
//                case PAGE_TWO:
//                    rb_health.setChecked(true);
//                    break;
//                case PAGE_THREE:
//                    rb_find.setChecked(true);
//                    break;
//                case PAGE_FOUR:
//                    rb_me.setChecked(true);
//                    break;
//            }
//        }
//    }
//
//
//}