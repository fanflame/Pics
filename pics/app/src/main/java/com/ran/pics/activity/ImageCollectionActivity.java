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

package com.ran.pics.activity;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.ran.pics.R;
import com.ran.pics.activity.fragment.ImageCollectionFragment;
import com.ran.pics.activity.fragment.ImageOperateFloatFragment;

import butterknife.ButterKnife;

public class ImageCollectionActivity extends BaseActivity
        implements ImageCollectionFragment.OnCollectLongClickListener{
    private ImageCollectionFragment collectionFragment;
    private ImageOperateFloatFragment imageOperateFloatFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ButterKnife.bind(this);

        initView();
        initEvent();
    }

    private void initView() {
        collectionFragment = ImageCollectionFragment.newInstance(this);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentReplace, collectionFragment).commit();
        imageOperateFloatFragment = ImageOperateFloatFragment.getInstance(collectionFragment);
        manager.beginTransaction().replace(R.id.llFloatContainer, imageOperateFloatFragment).commit();
    }

    private void initEvent() {
    }

    @Override
    public void onLongClick() {
        imageOperateFloatFragment.startAnimation();
    }
}
