package com.ran.pics.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainPagerAdapter extends FragmentPagerAdapter {
	public static final String FRAGMENT_NAME = "FRAGMENT_NAME";
	private ArrayList<Fragment> fragmentList;

	public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return fragmentList == null ? "" : fragmentList.get(position)
				.getArguments().getString(FRAGMENT_NAME);
	}

	@Override
	public int getCount() {
		return fragmentList == null ? 0 : fragmentList.size();
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentList == null ? null : fragmentList.get(position);
	}

}