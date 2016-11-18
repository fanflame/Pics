/*******************************************************************************
 * Copyright 2011-2014 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ran.pics.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ran.pics.R;
import com.ran.pics.activity.task.DeletePicsTask;
import com.ran.pics.activity.task.DeletePicsTask.OnDeletePicsCompleteListener;
import com.ran.pics.activity.task.GetCollectionPicsTask;
import com.ran.pics.adapter.ImageCollectionAdapter;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Constant;
import com.ran.pics.util.ToastUtil;
import com.ran.pics.view.progressbar.CircularProgressBar;

import java.util.ArrayList;

//收藏
public class ImageCollectionFragment extends Fragment implements GetCollectionPicsTask.OnGetCollectionPicsListener,OnDeletePicsCompleteListener {
    private ImageCollectionAdapter gridAdapter;
    private RecyclerView mPullRefreshGridView;
    private View rootView;
    private CircularProgressBar progressBar;
    private GetCollectionPicsTask collectionPicsTask;
    private DeletePicsTask deletePicsTask;

    private ArrayList<Pic> allPics;

    public static ImageCollectionFragment newInstance() {
        final ImageCollectionFragment f = new ImageCollectionFragment();
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
            initEvent();
            initData();
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
        mPullRefreshGridView = (RecyclerView) rootView.findViewById(R.id.gvRefresh);
        mPullRefreshGridView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        progressBar = (CircularProgressBar) rootView
                .findViewById(R.id.progressBar);
    }

    private void initEvent() {
//        mPullRefreshGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Intent intent = new Intent(getActivity(), ImageDetailActivity.class);
//                intent.putExtra(Constant.Extra.IMAGE_POSITION, position);
//                intent.putExtra(ImageDetailActivity.PIC_LIST, gridAdapter.getList());
//                startActivity(intent);
//            }
//        });
//        mPullRefreshGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                gridAdapter.setShowCheckBox(!gridAdapter.getShowCheckBox());
//                return false;
//            }
//        });
    }

    private void initData() {
        gridAdapter = new ImageCollectionAdapter(getActivity());
        mPullRefreshGridView.setAdapter(gridAdapter);
    }

    @Override
    public void onGetCollectionPics(ArrayList<Pic> result) {
        progressBar.setVisibility(View.GONE);
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
        if(collectionPicsTask != null)
            collectionPicsTask.cancleTask();
    }

    private void deletePics(){
        if(deletePicsTask == null)
            deletePicsTask = new DeletePicsTask(getActivity(),this);
        deletePicsTask.execute(gridAdapter.getPicCheckedList());
    }

    @Override
    public void onDeletePicsComplete(boolean result){
        ToastUtil.show(getActivity(),result ? "删除成功" :"删除失败");
    }
}