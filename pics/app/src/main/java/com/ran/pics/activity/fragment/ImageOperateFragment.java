package com.ran.pics.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ran.pics.R;

import butterknife.ButterKnife;

/**
 * Created by fanyiran on 16/11/20.
 */

public class ImageOperateFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_operate,container,false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }
}