package com.ran.pics.activity.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
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
        Fragment fragment = ImageGridFragment.newInstance("精选");
        Bundle args = new Bundle();
        args.putString(FRAGMENT_NAME, "精选");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        fragment = ImageGridFragment.newInstance("最新");
        args = new Bundle();
        args.putString(FRAGMENT_NAME, "最新");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        fragment = ImageGridFragment.newInstance("吴亦凡");
        args = new Bundle();
        args.putString(FRAGMENT_NAME, "吴亦凡");
        fragment.setArguments(args);
        fragmentList.add(fragment);

//        adapter = new MainPagerAdapter(getFr  agmentManager(),
//                fragmentList);
//        pager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(pager);
    }
}
