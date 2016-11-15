package com.ran.pics.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.bean.Album;

import java.util.ArrayList;

/**
 * Created by fanyiran on 15/5/9.
 */
public class ImageClassifiGridAdapter extends RecyclerView.Adapter<ImageClassifiGridAdapter.Holder> {
    private ArrayList<Album> albumArrayList;
    private int width;
    private Activity activity;

    public ImageClassifiGridAdapter(Activity activity) {
        this.activity = activity;
        width = UILApplication.getPicWidth(activity);
        ;
    }

    public void setList(ArrayList<Album> albumArrayList) {
        this.albumArrayList = albumArrayList;
        this.notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Holder holder = new Holder(View.inflate(parent.getContext(), R.layout.item_grid_classifi, null));
        return holder;
    }


    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        Album album = albumArrayList.get(position);
        ViewGroup.LayoutParams layoutParams = holder.ivShow.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        holder.ivShow.setLayoutParams(layoutParams);
        holder.tvName.setText(album.getName());
        ImageLoader.getInstance().displayImage(
                album.getPicList().get(0).getUrl(), holder.ivShow, UILApplication.initImageOption(),
                new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingStarted(String imageUri, View view) {
                        holder.ivProgressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String imageUri, View view,
                                                FailReason failReason) {
                        holder.ivProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingComplete(String imageUri, View view,
                                                  Bitmap loadedImage) {
                        holder.ivProgressBar.setVisibility(View.GONE);
                    }
                }, new ImageLoadingProgressListener() {
                    @Override
                    public void onProgressUpdate(String imageUri, View view,
                                                 int current, int total) {
                    }
                });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return albumArrayList == null ? 0 : albumArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        ImageView ivShow;
        ImageView ivProgressBar;
        TextView tvName;

        public Holder(View itemView) {
            super(itemView);
            ivShow = (ImageView) itemView.findViewById(R.id.ivShow);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            ivProgressBar = (ImageView) itemView.findViewById(R.id.ivProgressBar);
        }
    }
}
