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
import android.support.v4.app.FragmentManager;

import com.ran.pics.R;
import com.ran.pics.activity.fragment.ImageCollectionFragment;

public class ImageCollectionActivity extends BaseActivity {
    private ImageCollectionFragment collectionFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        initView();
        initEvent();
    }

    private void initView() {
        collectionFragment = ImageCollectionFragment.newInstance();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentReplace, collectionFragment).commit();
    }

    private void initEvent() {
    }
}
