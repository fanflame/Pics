package com.ran.pics.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ran.pics.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fanyiran on 16/11/20.
 */

public class ImageOperateFloatFragment extends Fragment{
    @BindView(R.id.tvDelete)
    TextView tvDelete;

    private OnFloatFragmentClickListener onFloatFragmentClickListener;
    public interface OnFloatFragmentClickListener{
        void onFloatFragmentDeleteClick();
    }

    public static ImageOperateFloatFragment getInstance(OnFloatFragmentClickListener onFloatFragmentClickListener){
        ImageOperateFloatFragment fragment = new ImageOperateFloatFragment();
        fragment.onFloatFragmentClickListener = onFloatFragmentClickListener;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_operate,container,false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @OnClick(R.id.tvDelete)
    public void onTvDeleteClick(){
        if(onFloatFragmentClickListener != null){
            onFloatFragmentClickListener.onFloatFragmentDeleteClick();
        }
    }

    public void setOnFloatFragmentClickListener(OnFloatFragmentClickListener onFloatFragmentClickListener){
        this.onFloatFragmentClickListener = onFloatFragmentClickListener;
    }

    public void startAnimation(){

    }
}
