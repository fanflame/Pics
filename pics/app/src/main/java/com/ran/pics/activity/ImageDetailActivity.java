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

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager.LayoutParams;

import com.ran.pics.R;
import com.ran.pics.activity.fragment.ImageHandleFragment;
import com.ran.pics.adapter.ImagePagerAdapter;
import com.ran.pics.animation.DepthPageTransformer;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Constant;
import com.ran.pics.util.ToastUtil;
import com.ran.pics.util.Utils;
import com.ran.pics.util.imageload.ImageLoaderUtils;
import com.ran.pics.view.ScaleAnimationImageView;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuObject;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageDetailActivity extends BaseActivity
        implements ScaleAnimationImageView.SingleTapListener, OnMenuItemClickListener {
    public static final String EXTRA_IMAGE = "extra_image";
    public static final String PIC_LIST = "pic_list";

    private ImagePagerAdapter mAdapter;
    private ViewPager mPager;
    private ArrayList<Pic> picList;
    private ImageHandleFragment imageHandleFragment;
    private ContextMenuDialogFragment mMenuDialogFragment;
    private Pic tapPic;

    static public void startActivity(Context context, int position, ArrayList<Pic> data) {
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.putExtra(Constant.Extra.IMAGE_POSITION, position);
        intent.putExtra(ImageDetailActivity.PIC_LIST, data);
        context.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail_pager);
        getWindow().addFlags(LayoutParams.FLAG_FULLSCREEN);

        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mPager = (ViewPager) findViewById(R.id.pager);
        initMenuFragment();
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

    private void initEvent() {
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (imageHandleFragment != null && imageHandleFragment.isAdded()) {
                    getSupportFragmentManager().beginTransaction().remove(imageHandleFragment).commit();
                }
            }
        });
    }

    @Override
    public void onSingleTap(ScaleAnimationImageView imageView) {
        if (mMenuDialogFragment.isDetached()) {
            mMenuDialogFragment.dismissAllowingStateLoss();
        } else {
            mMenuDialogFragment.show(getSupportFragmentManager(), "dialogFragment");
            tapPic = (Pic) imageView.getTag();
        }
    }

    private void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.tab_height));
        menuParams.setMenuObjects(getMenuObjects());
        menuParams.setClosableOutside(false);
        mMenuDialogFragment = ContextMenuDialogFragment.newInstance(menuParams);
        mMenuDialogFragment.setItemClickListener(this);
    }

    private List<MenuObject> getMenuObjects() {

        List<MenuObject> menuObjects = new ArrayList<>();

        MenuObject close = new MenuObject();
        close.setResource(R.drawable.icn_close);

        MenuObject like = new MenuObject("设置为桌面壁纸");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.icn_2);
        like.setBitmap(b);

        MenuObject addFr = new MenuObject("设置为锁屏壁纸");
        BitmapDrawable bd = new BitmapDrawable(getResources(),
                BitmapFactory.decodeResource(getResources(), R.drawable.icn_3));
        addFr.setDrawable(bd);

        MenuObject addFav = new MenuObject("收藏");
        addFav.setResource(R.drawable.icn_4);

        menuObjects.add(close);
        menuObjects.add(like);
        menuObjects.add(addFr);
        menuObjects.add(addFav);
        return menuObjects;
    }

//    @Override
//    public boolean onCreateOptionsMenu(final Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.context_menu:
//                mMenuDialogFragment.show(getSupportFragmentManager(), "ContextMenuDialogFragment");
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onMenuItemClick(View clickedView, int position) {
        switch (position) {
            case 1:
                File file;
                if (tapPic != null
                        && (file = ImageLoaderUtils.getInstance().getDiskCache(tapPic.getLinkUrl())) != null)
                    Utils.setWallPaper(this, file.getPath(), mPager);
                else
                    ToastUtil.showShort(mPager, "设置失败");
                break;
            case 2:
                if (tapPic != null
                        && (file = ImageLoaderUtils.getInstance().getDiskCache(tapPic.getLinkUrl())) != null)
                    Utils.setLockPaper(this, file.getPath(), mPager);
                else
                    ToastUtil.showShort(mPager, "设置失败");
                break;
            case 3:
                if (tapPic != null
                        && (file = ImageLoaderUtils.getInstance().getDiskCache(tapPic.getLinkUrl())) != null
                        && Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File fileTemp = new File(Environment.getExternalStorageDirectory() + Constant.Config.DOWN_BMP_PATH);
                    if (!fileTemp.exists())
                        fileTemp.mkdirs();
                    fileTemp = new File(fileTemp.getAbsolutePath() + "/" + file.getName());
                    if (Utils.fileChannelCopy(file, fileTemp)) {
                        ToastUtil.showShort(mPager, "收藏成功");
                    }
                } else
                    ToastUtil.showShort(mPager, "收藏失败");
                break;
            default:
        }
    }
}
