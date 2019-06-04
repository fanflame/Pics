package com.ran.pics.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ran.pics.activity.fragment.ImageFragment;
import com.ran.pics.bean.Pic;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
	public static final String FRAGMENT_NAME = "FRAGMENT_NAME";
	private List<? extends Pic> picList;

	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
	}


	@Override
	public int getCount() {
		return picList == null ? 0 : picList.size();
	}

	@Override
	public Fragment getItem(int position) {
		return getFragment(position);
	}

	public void setPicList(List<? extends Pic> picList) {
		this.picList = picList;
		notifyDataSetChanged();
	}

	// TODO: 2019-05-29 复用fragment
	public Fragment getFragment(int position) {
		return ImageFragment.newInstance(picList.get(position));
	}


}