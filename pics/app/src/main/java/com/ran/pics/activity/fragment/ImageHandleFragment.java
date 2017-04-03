package com.ran.pics.activity.fragment;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ran.pics.R;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Constant;
import com.ran.pics.util.ToastUtil;
import com.ran.pics.util.Utils;
import com.ran.pics.util.imageload.ImageLoaderUtils;

import java.io.File;

//操作
public class ImageHandleFragment extends Fragment implements View.OnClickListener{
    private View rootView;
    private TextView tvDown;
    private TextView tvWallpaper;
    private Pic pic;

    public static ImageHandleFragment newInstance() {
        final ImageHandleFragment f = new ImageHandleFragment();
        return f;
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
            initView(inflater, container);
            initEvent();
        }

        getAllCollectionImages();

        return rootView;
    }

    private void getAllCollectionImages() {
    }

    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_image_handle,
                container, false);
        tvDown = (TextView)rootView.findViewById(R.id.tvDown);
        tvWallpaper = (TextView)rootView.findViewById(R.id.tvWallpaper);
    }

    private void initEvent() {
        tvDown.setOnClickListener(this);
        tvWallpaper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tvDown:
                onDownWallpaperClick(v);
                break;
            case R.id.tvWallpaper:
                onSetWallpaperClick(v);
                break;
        }
    }

    public void setPic(Pic pic){
        this.pic = pic;
    }
    public void onSetWallpaperClick(View v) {
        if(pic == null)
            return;
        ToastUtil.showShort(rootView, "请稍后");
        File f = ImageLoaderUtils.getInstance().getDiskCache(pic.getLinkUrl());
        if (f == null || !f.exists()) {
            ToastUtil.showShort(rootView, "设置失败,请重试");
            return;
        }
        File temp = new File(Environment.getExternalStorageDirectory()
                + Constant.Config.DOWN_BMP_PATH);
        if (!temp.exists())
            temp.mkdirs();
        File t = new File(Environment.getExternalStorageDirectory()
                + Constant.Config.DOWN_BMP_PATH + f.getName() + ".jpg");
        if (t.exists() || Utils.fileChannelCopy(f, t)) {
            Utils.setWallPaper(getActivity(), t.getAbsolutePath(), rootView);
        }
    }

    public void onLockWallpaperClick(View v) {
        if(pic == null)
            return;
        try {
            File f = ImageLoaderUtils.getInstance().getDiskCache(pic.getLinkUrl());
            if (f == null || !f.exists())
                return;
            File temp = new File(Environment.getExternalStorageDirectory()
                    + Constant.Config.DOWN_BMP_PATH);
            if (!temp.exists())
                temp.mkdirs();
            File t = new File(Environment.getExternalStorageDirectory()
                    + Constant.Config.DOWN_BMP_PATH + f.getName() + ".jpg");
            if (t.exists() || Utils.fileChannelCopy(f, t)) {
                Utils.setLockPaper(getActivity(), t.getAbsolutePath(), rootView);
            }
        } catch (Throwable e) { // TODO Auto-generated catch block
            e.printStackTrace();
            ToastUtil.showShort(rootView, "待开发");
        }
    }

    public void onDownWallpaperClick(View v) {
        if(pic == null)
            return;
        File f = ImageLoaderUtils.getInstance().getDiskCache(pic.getLinkUrl());
        if (f == null || !f.exists()) {
            ToastUtil.showShort(rootView, "下载失败,请重试");
            return;
        }
        File temp = new File(Environment.getExternalStorageDirectory()
                + Constant.Config.DOWN_BMP_PATH);
        if (!temp.exists())
            temp.mkdirs();
        File t = new File(Environment.getExternalStorageDirectory()
                + Constant.Config.DOWN_BMP_PATH + f.getName() + ".jpg");
        if (t.exists() || Utils.fileChannelCopy(f, t)) {
            ToastUtil.showShort(rootView, "下载成功:" + t.getAbsolutePath());
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}