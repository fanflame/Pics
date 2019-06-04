/*******************************************************************************
 * Copyright 2011-2014 Sergey Tarasevich
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ran.pics.activity.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ran.pics.R;
import com.ran.pics.activity.ImageDetailActivity;
import com.ran.pics.activity.task.GetBaiduPicsTask;
import com.ran.pics.adapter.GridViewAdapter;
import com.ran.pics.bean.Pic;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageGridFragment extends Fragment implements View.OnClickListener {
    private static final int START_PAGE = 2;
    private int currentPageNum = START_PAGE;
    private String keyword = "";
    private GridViewAdapter gridAdapter;
    private View rootView;
    @BindView(R.id.pull_refresh_grid)
    RecyclerView mPullRefreshGridView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tvSearch)
    TextView tvSearch;

    private boolean isShowSearch = false;
    private int lastVisibleItem;
    private StaggeredGridLayoutManager mLayoutManager;

//    private SparseArray<ArrayList<Pic>> allPics;

    private GetBaiduPicsTask postBaiduPicsTask;

    public static ImageGridFragment newInstance(String keyword) {
        final ImageGridFragment f = new ImageGridFragment();
        f.keyword = keyword;
        return f;
    }

    public static ImageGridFragment newInstance(String keyword, boolean isShowSearch) {
        final ImageGridFragment f = new ImageGridFragment();
        f.keyword = keyword;
        f.isShowSearch = isShowSearch;
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initView(inflater, container);
        initEvent();
        initData();

        postBaiduAllPics(keyword, currentPageNum);

        return rootView;
    }

    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.image_grid_fragment,
                container, false);

        ButterKnife.bind(this, rootView);
        if (!isShowSearch)
            tvSearch.setVisibility(View.GONE);
    }

    private void initEvent() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                                    @Override
                                                    public void onRefresh() {
                                                        if (gridAdapter != null)
                                                            gridAdapter.clear();
                                                        postBaiduAllPics(keyword, currentPageNum = START_PAGE);
                                                    }
                                                }
        );

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), ImageClassifiActivity.class);
//                startActivity(intent);
            }
        });

        mPullRefreshGridView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 >= gridAdapter.getItemCount() - 5) {
                    swipeRefreshLayout.setRefreshing(true);
                    postBaiduAllPics(keyword, ++currentPageNum);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPositions(new int[]{0, 1})[1];
            }
        });
    }

    private void initData() {
        gridAdapter = new GridViewAdapter(getActivity(), this, null);
        mLayoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        mPullRefreshGridView.setLayoutManager(mLayoutManager);
        mPullRefreshGridView.setAdapter(gridAdapter);
    }

    public void search(String searchWord) {
        if (gridAdapter != null)
            gridAdapter.clear();
        keyword = searchWord;
        postBaiduAllPics(searchWord, 1);
    }

    /**
     * 百度搜索图片
     */
    private void postBaiduAllPics(String searchWord, int pageNum) {
        swipeRefreshLayout.setRefreshing(true);
        if (postBaiduPicsTask == null)
            postBaiduPicsTask = new GetBaiduPicsTask(getActivity(), new GetBaiduPicsTask.OnCompleteListener() {
                @Override
                public void onFailure() {
                    swipeRefreshLayout.setRefreshing(false);
                }

                @Override
                public void onSuccess(ArrayList<? extends Pic> picList) {
//                    if (allPics == null) {
//                        allPics = new SparseArray<>();
//                    }
//                    allPics.put(currentPageNum, picList);
                    gridAdapter.addData(picList);
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        postBaiduPicsTask.execute(searchWord, pageNum);
    }

    @Override
    public void onDestroyView() {
//        pauseTask();
        super.onDestroyView();
        if (gridAdapter != null)
            gridAdapter.destory();
    }

    private void pauseTask() {
//        if (gridAdapter != null)
//            gridAdapter.pause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image:
                onGridItemViewClick((Integer) v.getTag(R.id.gridfragment_img_tag_id));
                break;
        }
    }

    private void onGridItemViewClick(int position) {
        ImageDetailActivity.startActivity(getContext(), position, gridAdapter.getData());
    }
}