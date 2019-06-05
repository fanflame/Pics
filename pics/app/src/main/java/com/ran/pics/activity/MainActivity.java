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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.fanyiran.utils.LogUtil;
import com.fanyiran.utils.recycleadapter.RvBaseAdapter;
import com.fanyiran.utils.recycleadapter.RvListener;
import com.fanyiran.utils.recycleadapter.RvViewHolder;
import com.ran.pics.R;
import com.ran.pics.activity.task.GetBaiduPicsTask;
import com.ran.pics.adapter.MainPagerAdapter;
import com.ran.pics.adapter.RecycleViewAdapter;
import com.ran.pics.adapter.itemtype.LoadMoreItem;
import com.ran.pics.adapter.itemtype.PicItem;
import com.ran.pics.bean.BaiduJson;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.CustPagerTransformer;
import com.ran.pics.util.ToastUtil;
import com.ran.pics.util.Utils;
import com.ran.pics.view.PaletteLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MainActivity extends BaseActivity implements RvListener<Pic> {
    private static final int START_PAGE = 2;
    private static final int REQUEST_CODE_DETAIL = 367;
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
    @BindView(R.id.tvSearch)
    TextView tvSearch;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.leftContainer)
    FrameLayout leftContainer;
    @BindView(R.id.searchContainer)
    LinearLayout searchContainer;
    private boolean isLoadMore;

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
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Utils.setStatusBarColor(getWindow(),getColor(R.color.red_btn_bg_color));
//        Utils.setFullScreenWindowLayoutInDisplayCutout(getWindow());
        setContentView(R.layout.activity_main);
        loadFirstPage();

        initEvent();
    }

    private void initEvent() {
        swipeRefreshLayout.setOnRefreshListener(() -> loadFirstPage());

        getRecycleView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    changeBgColor();
                } else {
                    LinearLayoutManager layoutManager = (LinearLayoutManager)getRecycleView().getLayoutManager();
                    int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                    if (lastVisibleItemPosition >= baseDataList.size() - 10) {
                        loadNextPage();
                    }
                }
            }
        });
    }

    private void changeBgColor() {
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

    private void startAnim(int newBgColor) {
        int currentColor = 0;
        Drawable background = getRecycleView().getBackground();
        if (background instanceof ColorDrawable) {
            currentColor = ((ColorDrawable) background).getColor();
        }
        ObjectAnimator animator = ObjectAnimator.ofArgb(this, "changeBgColor", currentColor, newBgColor);
        animator.setDuration(500);
        animator.start();
    }

    public void setChangeBgColor(int color) {
        getRecycleView().setBackgroundColor(color);
        searchContainer.setBackgroundColor(color + 0xaa000000);
        Utils.setStatusBarColor(getWindow(),(color + (0xaa000000)));
    }

    private void loadNextPage() {
        if (!swipeRefreshLayout.isRefreshing() && !isLoadMore) {
            postBaiduAllPics(keyword,++currentPageNum);
            isLoadMore = true;
        }

    }

    private void loadFirstPage() {
        currentPageNum = 0;
        postBaiduAllPics(keyword, currentPageNum);
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
                    swipeRefreshLayout.setRefreshing(false);
                    currentPageNum --;
                    isLoadMore = false;
                }

                @Override
                public void onSuccess(ArrayList<? extends Pic> picList) {
                    swipeRefreshLayout.setRefreshing(false);
                    refreshAdapter(picList);
                    isLoadMore = false;
                }
            });
        postBaiduPicsTask.execute(searchWord, pageNum);
    }

    private void refreshAdapter(ArrayList<? extends Pic> picList) {
        if (baseDataList.size() != 0) {
            baseDataList.remove(baseDataList.size() - 1);
        }
        if (currentPageNum == 0) {
            baseDataList.clear();
        }
        baseDataList.addAll(picList);
        BaiduJson.ImgsBean imgsBean = new BaiduJson.ImgsBean();
        imgsBean.setItemType(LoadMoreItem.TYPE_LOAD_MORE);
        baseDataList.add(imgsBean);
        recycleViewAdapter.notifyDataSetChanged();
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
            recycleViewAdapter.setRvListener(this);
        }
        return recycleViewAdapter;
    }

    @Override
    public void onClick(Pic data, int position) {
        switch (baseDataList.get(position).getItemType()) {
            case PicItem.TYPE_PIC:
                ImageDetailActivity.startActivity(this, position,REQUEST_CODE_DETAIL, baseDataList);
                break;
            case LoadMoreItem
                    .TYPE_LOAD_MORE:
                loadNextPage();
                break;
        }
    }

    @OnClick(R.id.tvSearch)
    public void onTvSearchClick() {

    }

    @OnClick(R.id.ivMenu)
    public void onIvMenuClick() {
        drawerLayout.openDrawer(leftContainer);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (REQUEST_CODE_DETAIL == requestCode) {

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}