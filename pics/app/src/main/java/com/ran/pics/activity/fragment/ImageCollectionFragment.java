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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ran.pics.R;
import com.ran.pics.activity.ImageDetailActivity;
import com.ran.pics.activity.task.DeletePicsTask;
import com.ran.pics.activity.task.DeletePicsTask.OnDeletePicsCompleteListener;
import com.ran.pics.activity.task.GetCollectionPicsTask;
import com.ran.pics.adapter.ImageCollectionAdapter;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Constant;
import com.ran.pics.util.ToastUtil;

import java.util.ArrayList;
import java.util.Iterator;

import butterknife.BindView;
import butterknife.ButterKnife;

//收藏
public class ImageCollectionFragment extends Fragment
        implements GetCollectionPicsTask.OnGetCollectionPicsListener
        , OnDeletePicsCompleteListener
        , ImageCollectionAdapter.OnItemListener
        , ImageOperateFloatFragment.OnFloatFragmentClickListener {
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.gvRefresh)
    RecyclerView mPullRefreshGridView;
    private ImageCollectionAdapter gridAdapter;
    private View rootView;
    //    private CircularProgressBar progressBar;
    private GetCollectionPicsTask collectionPicsTask;
    private DeletePicsTask deletePicsTask;

    private ArrayList<Pic> allPics;
    private OnCollectLongClickListener onCollectLongClickListener;

    public interface OnCollectLongClickListener {
        void onLongClick();
    }

    public static ImageCollectionFragment newInstance(OnCollectLongClickListener onCollectLongClickListener) {
        final ImageCollectionFragment f = new ImageCollectionFragment();
        f.onCollectLongClickListener = onCollectLongClickListener;
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if (rootView != null) {
//            ViewGroup parent = (ViewGroup) rootView.getParent();
//            if (parent != null) {
//                parent.removeView(rootView);
//            }
//        } else {
        initView(inflater, container);
        initData();
        initEvent();
//        }

        getAllCollectionImages();

        return rootView;
    }

    private void getAllCollectionImages() {
        if (collectionPicsTask == null)
            collectionPicsTask = new GetCollectionPicsTask(getActivity(), this);
        collectionPicsTask.execute(Constant.Config.DOWN_BMP_PATH);
    }

    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_image_collection,
                container, false);
        ButterKnife.bind(this, rootView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        mPullRefreshGridView.setLayoutManager(gridLayoutManager);
//        progressBar = (CircularProgressBar) rootView
//                .findViewById(progressBar);
    }

    private void initData() {
        gridAdapter = new ImageCollectionAdapter(getActivity(), this);
        mPullRefreshGridView.setAdapter(gridAdapter);
    }

    private void initEvent() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllCollectionImages();
            }
        });
    }

    @Override
    public void onGetCollectionPics(ArrayList<Pic> result) {
//        progressBar.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
        gridAdapter.setList(result);
    }

    @Override
    public void onDestroyView() {
        cancelWork();
        super.onDestroyView();
    }

    private void cancelWork() {
//        if (gridAdapter != null)
//            gridAdapter.cancel();
        if (collectionPicsTask != null)
            collectionPicsTask.cancleTask();
    }

    private void deletePics() {
        if (deletePicsTask == null)
            deletePicsTask = new DeletePicsTask(getActivity(), this);
        deletePicsTask.execute(gridAdapter.getPicCheckedList());
    }

    @Override
    public void onDeletePicsComplete(boolean result) {
        ToastUtil.show(getActivity(), result ? "删除成功" : "删除失败");
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ImageDetailActivity.class);
        intent.putExtra(Constant.Extra.IMAGE_POSITION, position);
        intent.putExtra(ImageDetailActivity.PIC_LIST, gridAdapter.getList());
        startActivity(intent);
    }

    @Override
    public void onItemLongClick() {
        gridAdapter.setShowCheckBox(!gridAdapter.getShowCheckBox());
        if (onCollectLongClickListener != null) {
            onCollectLongClickListener.onLongClick();
        }
    }

    @Override
    public void onFloatFragmentDeleteClick() {
        ArrayList<Pic> checkedList = gridAdapter.getPicCheckedList();
        if(checkedList != null){
            //TODO 是否放到线程中
            Iterator<Pic> picIterator = checkedList.iterator();
            Pic picTemp;
            while (picIterator.hasNext()){
                picTemp = picIterator.next();
                picTemp.getLocalFile().delete();
            }
            gridAdapter.deleteCheckedList();
        }else{
            ToastUtil.show(getContext(),"您为选中任何一张图片");
        }

    }
}