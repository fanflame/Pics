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
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.ran.pics.R;
import com.ran.pics.activity.ImageSearchResultActivity;
import com.ran.pics.adapter.ImageClassifiGridAdapter;
import com.ran.pics.application.UILApplication;
import com.ran.pics.util.ToastUtil;


//分类
public class ImageClassifiGridFragment extends Fragment {
    private View rootView;
    private RecyclerView gvRefresh;
    private EditText etSearch;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ImageClassifiGridAdapter classifiGridAdapter;


    public static ImageClassifiGridFragment newInstance() {
        final ImageClassifiGridFragment f = new ImageClassifiGridFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        } else {
            initView(inflater);
            initEvent();
            initData();
        }
        loadClassify();
        return rootView;
    }

    private void loadClassify() {
        swipeRefreshLayout.setRefreshing(true);
//        if (postBaiduPicsTask == null)
//            postBaiduPicsTask = new GetBaiduPicsTask(getActivity(), new GetBaiduPicsTask.OnCompleteListener() {
//                @Override
//                public void onFailure() {
//                    swipeRefreshLayout.setRefreshing(false);
//                }
//
//                @Override
//                public void onSuccess(ArrayList<? extends Pic> picList) {
////                    if (allPics == null) {
////                        allPics = new SparseArray<>();
////                    }
////                    allPics.put(currentPageNum, picList);
//                    gridAdapter.addData(picList);
//                    swipeRefreshLayout.setRefreshing(false);
//                }
//            });
//        postBaiduPicsTask.execute(searchWord, pageNum);
    }

    private void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.fragment_classifi_grid, null);
        etSearch = (EditText) rootView.findViewById(R.id.etSearch);
        gvRefresh = (RecyclerView) rootView.findViewById(R.id.gvRefresh);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
        etSearch.setOnEditorActionListener(
                new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                            if (etSearch.getText().toString().trim().equals("")) {
                                ToastUtil.show(getActivity(), "请输入有效关键字");
                                return false;
                            }
                            UILApplication.missKeyBoard(getActivity());
                            ImageSearchResultActivity.startImageSearchResultActivity(getActivity(), etSearch.getText().toString().trim());
                            return true;
                        }
                        return false;
                    }
                }
        );
    }

    private void initEvent() {
//        gvRefresh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Intent intent = new Intent(getActivity(), ImageSearchResultActivity.class);
//                intent.putExtra(ImageSearchResultActivity.KEY_WORD,((Album)classifiGridAdapter.getItem(position)).getName());
//                startActivity(intent);
//            }
//        });
    }

    private void initData() {
        classifiGridAdapter = new ImageClassifiGridAdapter(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        gvRefresh.setLayoutManager(gridLayoutManager);
        gvRefresh.setAdapter(classifiGridAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}