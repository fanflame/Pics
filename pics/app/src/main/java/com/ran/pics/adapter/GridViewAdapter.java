package com.ran.pics.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baidu.appx.BDNativeAd;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.bean.Pic;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.Holder> {
    private final int LOAD_AD = 0;
    private final int LOAD_IMAGE = 1;
    private ArrayList<Pic> picList;
    private LayoutInflater inflater;
    private int width;
    private Activity context;
    private float mDensity;
    private View.OnClickListener onClickListener;
    private BDNativeAd nativeAd;

    public GridViewAdapter(Activity context, View.OnClickListener onClickListener, ArrayList<Pic> picList) {
        this.context = context;
        this.onClickListener = onClickListener;
        inflater = LayoutInflater.from(context);
        this.picList = picList;
        width = UILApplication.getPicWidth(context);
        nativeAd = new BDNativeAd(context, context.getString(R.string.baidu_app_key),
                context.getString(R.string.baidu_ad_id));
        nativeAd.loadAd();
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == LOAD_IMAGE) {//image
                view = inflater
                        .inflate(R.layout.item_grid_image, parent, false);
        } else {
            view = inflater.inflate(R.layout.item_grid_image,
                            null);
        }
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder,int position) {
        if(getItemViewType(position) == LOAD_AD && nativeAd != null && nativeAd.isLoaded()){
            loadAd(holder,position);
        }else if(getItemViewType(position) == LOAD_IMAGE){
            loadImage(holder,position);
        }
    }

    private void loadImage(final Holder holder,final int position){
        ViewGroup.LayoutParams layoutParams = holder.imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
//        holder.imageView.setLayoutParams(layoutParams);
        ImageLoader.getInstance().displayImage(
                picList.get(position).getLinkUrl(), holder.imageView, UILApplication.initImageOption(),
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        holder.progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {
                        holder.progressBar.setVisibility(View.GONE);
//                        picList.get(position).setLoadFailed(true);
                        //TODO 局部更新
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view,
                                                  Bitmap loadedImage) {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view,
                                                 int current, int total) {
                    }
                });
        holder.imageView.setTag(R.id.gridfragment_img_tag_id,position);
        holder.imageView.setOnClickListener(onClickListener);
    }

    private void loadAd(final Holder holder,final int position){
        ArrayList<BDNativeAd.AdInfo> adArray = nativeAd.getAdInfos();
        //... 自定义展示UI,其中BDNativeAd.AdInfo里的
        // didShow() 和 didClick()
        // 需要相应的UI响应逻辑中触发调用。
        ImageLoader.getInstance().displayImage(
                adArray.get(0).getImageUrl(), holder.imageView, UILApplication.initImageOption(),
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        holder.progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {
                        holder.progressBar.setVisibility(View.GONE);
//                        picList.get(position).setLoadFailed(true);
                        //TODO 局部更新
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view,
                                                  Bitmap loadedImage) {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view,
                                                 int current, int total) {
                    }
                });
    }

    @Override
    public int getItemViewType(int position) {
//        return picList.get(position).isLoadFailed() ? LOAD_AD:LOAD_IMAGE;
        if(nativeAd.isLoaded()){
            return LOAD_AD;
        }else {
            return LOAD_IMAGE;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return picList == null ? 0 : picList.size();
    }

    public void clear() {
        if (picList != null)
            picList.clear();
    }



    public void addData(ArrayList<Pic> picListTemp) {
        if (picList == null) {
            picList = new ArrayList<Pic>();
        }
        picList.addAll(picListTemp);
        this.notifyDataSetChanged();
    }

    public ArrayList<Pic> getData() {
        return this.picList;
    }

    public void setData(ArrayList<Pic> picList) {
        this.picList = picList;
        this.notifyDataSetChanged();
    }

//    public void pause() {
//        ImageLoader.newInstance().pause();
//    }

    public void resume() {
        ImageLoader.getInstance().resume();
    }

    public void cancle(){
        ImageLoader.getInstance().stop();
        ImageLoader.getInstance().destroy();
    }

    private String convertStatus(int status) {
        String strStatus = "";
        switch (status) {
            case 0:
                strStatus = "点击重试";
                break;
            case 2:
                strStatus = "下载中";
                break;
            case 3:
                strStatus = "点击安装";
                break;
            case 4:
                strStatus = "点击启动";
                break;
            case 1:
            default:
                strStatus = "下载";
        }
        return strStatus;
    }

    class Holder extends RecyclerView.ViewHolder{
        @BindView(R.id.image)
        ImageView imageView;
        @BindView(R.id.progressBar)
        ImageView progressBar;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void destory(){
        //销毁广告对象
        if(nativeAd != null){
            nativeAd.destroy();
            nativeAd = null;
        }
    }
}
