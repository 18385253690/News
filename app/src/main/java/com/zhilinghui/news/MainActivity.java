package com.zhilinghui.news;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;
import com.zhilinghui.news.adapter.TabIndicatorAdapter;


public class MainActivity extends FragmentActivity {

    private TabPageIndicator indicator;
    private ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        fragmentPagerAdapter=new TabIndicatorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragmentPagerAdapter);
        indicator.setViewPager(viewPager,0);
    }

    public void initView(){
        indicator=(TabPageIndicator) findViewById(R.id.indicator);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
    }
}
