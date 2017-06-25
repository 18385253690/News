package com.zhilinghui.news.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhilinghui.news.fragment.MainFragment;

public class TabIndicatorAdapter extends FragmentPagerAdapter {

	public static final String [] NEWTYPE=new String[]{"中国","国际","文娱","体育","生活","旅游","科技","倍儿逗"};

	public TabIndicatorAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int newsType) {
		MainFragment mainFragment=new MainFragment(newsType);
		return mainFragment;
	}

	//返回数组长度
	@Override
	public int getCount() {
		return NEWTYPE.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return NEWTYPE[position%NEWTYPE.length];
	}

}
