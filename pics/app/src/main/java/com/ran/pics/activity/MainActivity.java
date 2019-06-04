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

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.fanyiran.utils.LogUtil;
import com.fanyiran.utils.recycleadapter.RvBaseAdapter;
import com.fanyiran.utils.recycleadapter.RvViewHolder;
import com.ran.pics.R;
import com.ran.pics.activity.task.GetBaiduPicsTask;
import com.ran.pics.adapter.MainPagerAdapter;
import com.ran.pics.adapter.RecycleViewAdapter;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.CustPagerTransformer;
import com.ran.pics.util.ToastUtil;
import com.ran.pics.util.Utils;
import com.ran.pics.view.PaletteLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MainActivity extends BaseActivity {
    private static final int START_PAGE = 2;
    private static final String TAG = "MainActivity";
    private int currentPageNum = START_PAGE;

    private final int PRESS_EXIT_INTERVAL = 1000;
    private long lastPressBackTime;
    private String keyword = "";
    private RecycleViewAdapter recycleViewAdapter;
    private ArrayList<Pic> baseDataList;
    private GetBaiduPicsTask postBaiduPicsTask;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Utils.setFullScreenWindowLayoutInDisplayCutout(getWindow());
        setContentView(R.layout.activity_main);

//        OverScrollDecoratorHelper.setUpOverScroll(getRecycleView(),OverScrollDecoratorHelper.ORIENTATION_VERTICAL);

        postBaiduAllPics(keyword, currentPageNum);

        initEvent();
    }

    private void initEvent() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                currentPageNum = 0;
                postBaiduAllPics(keyword, currentPageNum);
            }
        });

        getRecycleView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    long originTag = System.currentTimeMillis();
                    View childAtFirst = getRecycleView().getChildAt(0);
                    if (childAtFirst == null) {
                        return;
                    }
                    int[] position = new int[2];
                    childAtFirst.getLocationInWindow(position);
                    if (position[1] < 0) {
                        if (getRecycleView().getChildCount() <= 1) {
                            return;
                        }
                        childAtFirst = getRecycleView().getChildAt(1);
                    }
                    RvViewHolder childViewHolder = (RvViewHolder) getRecycleView().getChildViewHolder(childAtFirst);
                    PaletteLinearLayout view = (PaletteLinearLayout) childViewHolder.getView(R.id.linearLayout);
                    view.getPaletteColor(originTag, (long tag, int color) -> {
                                if (tag == originTag) {
                                    startAnim(color);
                                }
                            }
                    );
                }
            }
        });
    }

    private void startAnim(int newBgColor) {
        int currentColor = 0;
        Drawable background = getRecycleView().getBackground();
        if (background instanceof ColorDrawable) {
            currentColor = ((ColorDrawable) background).getColor();
        }
        ObjectAnimator animator = ObjectAnimator.ofArgb(this,"changeBgColor",currentColor,newBgColor);
        animator.setDuration(500);
        animator.start();
    }

    public void setChangeBgColor(int color) {
        getRecycleView().setBackgroundColor(color);
    }

    /**
     * 百度搜索图片
     */
    private void postBaiduAllPics(String searchWord, int pageNum) {
        if (postBaiduPicsTask == null)
            postBaiduPicsTask = new GetBaiduPicsTask(this, new GetBaiduPicsTask.OnCompleteListener() {
                @Override
                public void onFailure() {
                    ToastUtil.showShort(getRecycleView(), "加载失败");
                }

                @Override
                public void onSuccess(ArrayList<? extends Pic> picList) {
                    baseDataList.addAll(picList);
                    recycleViewAdapter.notifyDataSetChanged();
                }
            });
        postBaiduPicsTask.execute(searchWord, pageNum);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastPressBackTime <= PRESS_EXIT_INTERVAL) {
            super.onBackPressed();
        } else {
            ToastUtil.showShort(getRecycleView(), "再按一次退出");
            lastPressBackTime = System.currentTimeMillis();
        }
    }

    @Override
    protected boolean supportRecycleView() {
        return true;
    }

    @Override
    public RecyclerView getRecycleView() {
        return findViewById(R.id.recyclerView);
    }

    @Override
    public RvBaseAdapter getAdapter() {
        if (recycleViewAdapter == null) {
            baseDataList = new ArrayList<>();
            recycleViewAdapter = new RecycleViewAdapter(baseDataList);
        }
        return recycleViewAdapter;
    }
}