/*
 * Copyright (C) 2013 Andreas Stuetz <andreas.stuetz@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ran.pics.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ran.pics.R;
import com.ran.pics.activity.fragment.HomeFragment;
import com.ran.pics.activity.fragment.ImageClassifiGridFragment;
import com.ran.pics.activity.fragment.SettingFragment;
import com.ran.pics.adapter.MainPagerAdapter;
import com.ran.pics.util.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;

import static com.ran.pics.adapter.MainPagerAdapter.FRAGMENT_NAME;

public class MainActivity extends BaseActivity{
    private final int PRESS_EXIT_INTERVAL= 1000;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private MainPagerAdapter adapter;
    private long lastPressBackTime;

    public static void startActivity(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initData();
    }

    private void initData() {
        ArrayList<Fragment> fragmentList = new ArrayList<>(3);
        Fragment fragment = HomeFragment.newInstance();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_NAME, "首页");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        fragment = ImageClassifiGridFragment.newInstance();
        args = new Bundle();
        args.putString(FRAGMENT_NAME, "分类");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        fragment = new SettingFragment();
        args = new Bundle();
        args.putString(FRAGMENT_NAME, "设置");
        fragment.setArguments(args);
        fragmentList.add(fragment);

        adapter = new MainPagerAdapter(getSupportFragmentManager(),
                fragmentList);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() - lastPressBackTime <= PRESS_EXIT_INTERVAL){
            super.onBackPressed();
        }else {
            ToastUtil.show(this,"再按一次退出");
            lastPressBackTime = System.currentTimeMillis();
        }
    }
}