package com.ran.pics.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ran.pics.R;
import com.ran.pics.adapter.MainPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.ran.pics.adapter.MainPagerAdapter.FRAGMENT_NAME;

/**
 * Created by fanyiran on 16/11/14.
 */

public class HomeFragment extends Fragment{
    @BindView(R.id.homepager)
    ViewPager pager;
    @BindView(R.id.hometabLayout)
    TabLayout tabLayout;
    private MainPagerAdapter adapter;

    public static HomeFragment newInstance(){
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,rootView);
        initData();
        return rootView;
    }

    private void initData() {
        ArrayList<Fragment> fragmentList = new ArrayList<>(3);
        Fragment fragment = ImageGridFragment.newInstance("手机壁纸");
        Bundle args = new Bundle();
        args.putString(FRAGMENT_NAME, "精选");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        fragment = ImageGridFragment.newInstance("最新手机壁纸");
        args = new Bundle();
        args.putString(FRAGMENT_NAME, "最新");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        fragment = ImageGridFragment.newInstance("吴亦凡手机壁纸");
        args = new Bundle();
        args.putString(FRAGMENT_NAME, "吴亦凡");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        adapter = new MainPagerAdapter(getFragmentManager(),
                fragmentList);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }
}
