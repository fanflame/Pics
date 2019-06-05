package com.ran.pics.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ran.pics.R;
import com.ran.pics.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fanqiang on 2019-06-05.
 */
public class AboutFragment extends Fragment {
    @BindView(R.id.tvVersion)
    TextView tvVersion;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,true);
        ButterKnife.bind(this,view);
        initData();
        return view;
    }

    private void initData(){
        tvVersion.setText("版本号:" + Utils.getVersion(getContext()));
    }
}
