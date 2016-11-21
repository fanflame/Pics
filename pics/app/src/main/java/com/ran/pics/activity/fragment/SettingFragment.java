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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ran.pics.R;
import com.ran.pics.activity.AboutActivity;
import com.ran.pics.activity.ImageCollectionActivity;
import com.ran.pics.util.Utils;

//设置
public class SettingFragment extends Fragment implements View.OnClickListener{
    private View rootView;
    private TextView tvCollection;
    private TextView tvClearCache;
    private TextView tvAboutMe;

    public static SettingFragment newInstance() {
        final SettingFragment f = new SettingFragment();
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
        }
        return rootView;
    }

    private void initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.fragment_setting, null);
        tvCollection = (TextView)rootView.findViewById(R.id.tvCollection);
        tvClearCache = (TextView)rootView.findViewById(R.id.tvClearCache);
        tvAboutMe = (TextView)rootView.findViewById(R.id.tvAboutMe);
    }

    private void initEvent() {
        tvCollection.setOnClickListener(this);
        tvClearCache.setOnClickListener(this);
        tvAboutMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tvCollection:
                Intent intent = new Intent(getActivity(), ImageCollectionActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.tvClearCache:
                Utils.clearCache(getFragmentManager());
                break;
            case R.id.tvAboutMe:
                intent = new Intent(getActivity(), AboutActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}