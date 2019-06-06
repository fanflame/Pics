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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.ViewStub;

import com.ran.pics.R;
import com.ran.pics.activity.fragment.ImageDetailFragment;
import com.ran.pics.activity.fragment.ImageDetailMenuFragment;
import com.ran.pics.adapter.ImagePagerAdapter;
import com.ran.pics.animation.DepthPageTransformer;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Constant;
import com.ran.pics.util.ToastUtil;
import com.ran.pics.util.Utils;
import com.ran.pics.util.imageload.ImageLoaderUtils;
import com.ran.pics.view.ScaleAnimationImageView;

import android.view.WindowManager;
import android.view.Window;

import java.io.File;
import java.util.ArrayList;

public class ImageDetailActivity extends BaseActivity
        implements ScaleAnimationImageView.SingleTapListener {
    public static final String EXTRA_IMAGE = "extra_image";
    public static final String PIC_LIST = "pic_list";
    public static final String REQUEST_CODE = "REQUEST_CODE";
    private static final int RESULT_CODE = 280;
    private static final String DETAL_CURRENT_POSITION = "DETAL_CURRENT_POSITION";

    private ImagePagerAdapter mAdapter;
    private ViewPager mPager;
    private ArrayList<Pic> picList;
    private Pic tapPic;
    private ImageDetailMenuFragment imageDetailMenuFragment;
    private ViewStub vewStubMenu;

    static public void startActivity(Activity context, int position, int requestCode, ArrayList<Pic> data) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.putExtra(Constant.Extra.IMAGE_POSITION, position);
        intent.putExtra(ImageDetailActivity.PIC_LIST, data);
        intent.putExtra(REQUEST_CODE, requestCode);
        context.startActivityForResult(intent, requestCode);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Utils.setFullScreenWindowLayoutInDisplayCutout(getWindow());
        Utils.setNavigatorHidden(getWindow());
        setContentView(R.layout.image_detail_pager);

        initView();
        initData();
    }

    private void initView() {
        mPager = findViewById(R.id.pager);
    }

    private void initData() {
        picList = (ArrayList<Pic>) getIntent().getSerializableExtra(PIC_LIST);
        mAdapter = new ImagePagerAdapter(getSupportFragmentManager(),
                picList, this);
        mPager.setAdapter(mAdapter);
        mPager.setPageMargin((int) getResources().getDimension(
                R.dimen.image_detail_pager_margin));
        mPager.setPageTransformer(true, new DepthPageTransformer());
        final int extraCurrentItem = getIntent().getIntExtra(
                Constant.Extra.IMAGE_POSITION, -1);
        if (extraCurrentItem != -1) {
            mPager.setCurrentItem(extraCurrentItem);
        }
    }

    @Override
    public void onSingleTap(ScaleAnimationImageView imageView) {
        tapPic = (Pic) imageView.getTag(ImageDetailFragment.DETAIL_IMG_TAG);
        if (vewStubMenu == null) {
            vewStubMenu = findViewById(R.id.vewStubMenu);
            vewStubMenu.inflate();
            imageDetailMenuFragment = (ImageDetailMenuFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_image_detail_menu);
            imageDetailMenuFragment.setOnImageDetailMenuHandleListener(new ImageDetailMenuFragment.OnImageDetailMenuHandleListener() {

                @Override
                public void onCloseClick() {
                    ImageDetailActivity.this.finish();
                }

                @Override
                public void onDownLoadClick() {
                    downLoad();
                }

                @Override
                public void onSetWallPaperClick() {
                    setWallPaper();
                }

                @Override
                public void onSetLockPaperClick() {
                    setLockPaper();
                }
            });
        } else {
            imageDetailMenuFragment.changeVisible();
        }
    }

    private void setLockPaper() {
        File file;
        if (tapPic != null
                && (file = ImageLoaderUtils.getInstance().getDiskCache(this, tapPic.getLinkUrl())) != null)
            Utils.setLockPaper(this, file.getPath(), mPager);
        else
            ToastUtil.showShort(mPager, "设置失败");
    }

    private void setWallPaper() {
        File file;
        if (tapPic != null
                && (file = ImageLoaderUtils.getInstance().getDiskCache(this, tapPic.getLinkUrl())) != null)
            Utils.setWallPaper(this, file.getPath(), mPager);
        else
            ToastUtil.showShort(mPager, "设置失败");
    }

    private void downLoad() {
        File file;
        if (tapPic != null
                && (file = ImageLoaderUtils.getInstance().getDiskCache(this, tapPic.getLinkUrl())) != null
                && Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File fileTemp = new File(Environment.getExternalStorageDirectory() + Constant.Config.DOWN_BMP_PATH);
            if (!fileTemp.exists())
                fileTemp.mkdirs();
            fileTemp = new File(fileTemp.getAbsolutePath() + "/" + file.getName());
            if (Utils.fileChannelCopy(file, fileTemp)) {
                ToastUtil.showShort(mPager, "收藏成功");
                return;
            }
        }
        ToastUtil.showShort(mPager, "收藏失败");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent();
        intent.putExtra(DETAL_CURRENT_POSITION, 111);
        setResult(RESULT_CODE, intent);
    }
}
