package com.ran.pics.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.appx.BDNativeAd;
import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.imageload.ImageLoaderUtils;

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
        initAd();
    }

    private void initAd(){
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
            view = inflater.inflate(R.layout.item_grid_ad,parent,
                            false);
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
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
//        holder.imageView.setLayoutParams(layoutParams);

        ImageLoaderUtils.getInstance().loadImage(picList.get(position).getThumbnail(), holder.imageView, new ImageLoaderUtils.OnLoadListener() {
            @Override
            public void onLoadingStarted() {
                holder.progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String failMessage) {
                holder.progressBar.setVisibility(View.GONE);
//                        picList.get(position).setLoadFailed(true);
                //TODO 局部更新
            }

            @Override
            public void onLoadingComplete() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onProgressUpdate() {

            }
        });
        holder.imageView.setTag(R.id.gridfragment_img_tag_id,position);
        holder.imageView.setOnClickListener(onClickListener);
    }

    private void loadAd(final Holder holder,final int position){
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        ArrayList<BDNativeAd.AdInfo> adArray = nativeAd.getAdInfos();
        BDNativeAd.AdInfo adInfo = adArray.get(0);
        //... 自定义展示UI,其中BDNativeAd.AdInfo里的
        // didShow() 和 didClick()
        // 需要相应的UI响应逻辑中触发调用。
        holder.tvTitle.setText(adInfo.getTitle());
        holder.tvDescription.setText(adInfo.getDescription());
        holder.tvDownloadNum.setVisibility(View.GONE);
        holder.tvFileSize.setVisibility(View.GONE);
//        holder.tvDownloadNum.setText(adInfo.getDownloadNum());
//        holder.tvFileSize.setText(adInfo.getFileSize());
        ImageLoaderUtils.getInstance().loadImage(
                adInfo.getImageUrl(), holder.imageView, null);
        ImageLoaderUtils.getInstance().loadImage(
                adInfo.getIconUrl(), holder.icon, null);
    }

    @Override
    public int getItemViewType(int position) {
        if(nativeAd != null && nativeAd.isLoaded() && position%30 == 3){
            return LOAD_AD;
        }else {
            if(nativeAd == null){
                initAd();
            }
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


    public void addData(ArrayList<? extends Pic> picListTemp) {
        if(picListTemp == null)
            return;
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
        ImageLoaderUtils.getInstance().resume();
    }

    public void cancle(){
        ImageLoaderUtils.getInstance().stop();
        ImageLoaderUtils.getInstance().destroy();
    }

    class Holder extends RecyclerView.ViewHolder{
        @Nullable
        @BindView(R.id.image)
        ImageView imageView;
        @Nullable
        @BindView(R.id.progressBar)
        ImageView progressBar;

        @Nullable
        @BindView(R.id.icon)
        ImageView icon;
        @Nullable
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @Nullable
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        @Nullable
        @BindView(R.id.tvDownloadNum)
        TextView tvDownloadNum;
        @Nullable
        @BindView(R.id.tvFileSize)
        TextView tvFileSize;

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
