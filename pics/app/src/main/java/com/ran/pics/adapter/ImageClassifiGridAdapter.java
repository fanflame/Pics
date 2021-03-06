package com.ran.pics.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.bean.Album;
import com.ran.pics.util.imageload.ImageLoaderUtils;

import java.util.ArrayList;


/**
 * Created by fanyiran on 15/5/9.
 */
public class ImageClassifiGridAdapter extends RecyclerView.Adapter<ImageClassifiGridAdapter.Holder> {
    private ArrayList<Album> albumArrayList;
    private int width;
    private Activity activity;
    private View.OnClickListener onClickListener;

    public ImageClassifiGridAdapter(Activity activity, View.OnClickListener onClickListener) {
        this.activity = activity;
        this.onClickListener = onClickListener;
        width = UILApplication.getPicWidth(activity);
    }

    public void setList(ArrayList<Album> albumArrayList) {
        this.albumArrayList = albumArrayList;
        this.notifyDataSetChanged();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Holder holder = new Holder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_classifi, parent, false));
        return holder;
    }


    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        Album album = albumArrayList.get(position);
        ViewGroup.LayoutParams layoutParams = holder.ivShow.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        holder.ivShow.setLayoutParams(layoutParams);
        holder.tvName.setText(album.getAlbumName());
        holder.itemView.setOnClickListener(onClickListener);
        holder.itemView.setTag(album);
        if(album.getPicPath() != null){
            ImageLoaderUtils.getInstance().loadImage(activity,
                    album.getPicPath(), holder.ivShow, new ImageLoaderUtils.OnLoadListener() {
                        @Override
                        public void onLoadingStarted() {
                            holder.ivProgressBar.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onLoadingFailed(String failMessage) {
                            holder.ivProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onLoadingComplete(Drawable resource) {
                            holder.ivProgressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onProgressUpdate() {

                        }
                    });
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return albumArrayList == null ? 0 : albumArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView ivShow;
        ImageView ivProgressBar;
        TextView tvName;

        public Holder(View itemView) {
            super(itemView);
            ivShow = (ImageView) itemView.findViewById(R.id.ivShow);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            ivProgressBar = (ImageView) itemView.findViewById(R.id.ivProgressBar);
        }
    }

    public void insert(Album album, int index) {
        if (albumArrayList == null)
            albumArrayList = new ArrayList<>();
        albumArrayList.set(index, album);
        notifyDataSetChanged();
//        notifyItemInserted(index);
    }
}
