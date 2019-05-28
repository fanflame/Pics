/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.ran.pics.activity.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.ran.pics.R;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Utils;
import com.ran.pics.util.imageload.ImageLoaderUtils;
import com.ran.pics.view.ScaleAnimationImageView;

public class ImageDetailFragment extends Fragment {
    private static final String IMAGE_DATA_EXTRA = "resId";
    private static final String PIC = "pic";
    public static final int DETAIL_IMG_TAG = R.id.tag_img_detail;

    private int mImageNum;
    private ScaleAnimationImageView mImageView;
    private Pic pic;
    private View rootView;
    private ScaleAnimationImageView.SingleTapListener singleTapListener;

    public ImageDetailFragment() {
    }

    public static ImageDetailFragment newInstance(int imageNum, Pic pic,ScaleAnimationImageView.SingleTapListener singleTapListener) {
        final ImageDetailFragment f = new ImageDetailFragment();

        final Bundle args = new Bundle();
        args.putInt(IMAGE_DATA_EXTRA, imageNum);
        args.putSerializable(PIC, pic);
        f.setArguments(args);
        f.singleTapListener = singleTapListener;

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageNum = getArguments() != null ? getArguments().getInt(
                IMAGE_DATA_EXTRA) : -1;
        pic = (Pic) (getArguments() != null ? getArguments().getSerializable(
                PIC) : null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        if(rootView != null){
//            ViewGroup parent = (ViewGroup) rootView.getParent();
//            if (parent != null) {
//                parent.removeView(rootView);
//            }
//        }else{
            rootView = inflater.inflate(R.layout.fragment_image_detail,
                    container, false);
            initView(rootView);
            initEvent();
//        }
        return rootView;
    }

    private void initView(View v){
        mImageView = (ScaleAnimationImageView) v.findViewById(R.id.imageView);
        mImageView.setSingleTapListener(singleTapListener);
        mImageView.setTag(DETAIL_IMG_TAG,pic);
    }

    private void initEvent(){

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageLoaderUtils.getInstance().loadImage(getActivity(),pic.getLinkUrl(), mImageView);
        if (OnClickListener.class.isInstance(getActivity())
                && Utils.hasActionBar()) {
            mImageView.setOnClickListener((OnClickListener) getActivity());
        }
    }

    public Pic getPic(){
        return pic;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void cancelWork() {
        ImageLoaderUtils.getInstance().cancelLoad(mImageView);
    }
}
