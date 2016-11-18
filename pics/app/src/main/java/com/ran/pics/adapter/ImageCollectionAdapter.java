package com.ran.pics.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.imageload.ImageLoaderUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fanyiran on 15/5/9.
 */
public class ImageCollectionAdapter extends RecyclerView.Adapter<ImageCollectionAdapter.Holder> {
    private ArrayList<Pic> picList;
    private ArrayList<Pic> picCheckedList;
    private int width;
    private boolean isShowCheckBox;

    public ImageCollectionAdapter(Activity activity) {
        width = UILApplication.getPicWidth(activity);
        ;
    }

    public void setList(ArrayList<Pic> albumArrayList) {
        this.picList = albumArrayList;
        this.notifyDataSetChanged();
    }

    public ArrayList<Pic> getList() {
        return picList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new Holder(inflater.inflate(R.layout.item_grid_collect, parent, false));
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        final Pic pic = picList.get(position);
        ViewGroup.LayoutParams layoutParams = holder.ivShow.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        holder.ivShow.setLayoutParams(layoutParams);
        ImageLoaderUtils.getInstance().loadImage(
                pic.getLinkUrl(), holder.ivShow, new ImageLoaderUtils.OnLoadListener() {
                    @Override
                    public void onLoadingStarted() {
                        holder.ivProgressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onLoadingFailed(String failMessage) {
                        holder.ivProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onLoadingComplete() {
                        holder.ivProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onProgressUpdate() {

                    }
                });

        if (isShowCheckBox) {
            holder.cbChoice.setVisibility(View.VISIBLE);
            holder.cbChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    pic.setChecked(isChecked);
                    if (picCheckedList == null)
                        picCheckedList = new ArrayList<Pic>();
                    picCheckedList.add(pic);
                }
            });

            holder.cbChoice.setChecked(pic.isChecked());
        } else {
            holder.cbChoice.setVisibility(View.GONE);
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

    public ArrayList<Pic> getPicCheckedList() {
        return picCheckedList;
    }

    public void setShowCheckBox(boolean isShowCheckBox) {
        this.isShowCheckBox = isShowCheckBox;
        if (!isShowCheckBox && picCheckedList != null)
            picCheckedList.clear();
        notifyDataSetChanged();
    }

    public boolean getShowCheckBox() {
        return isShowCheckBox;
    }
//    public void cancel(){
//        ImageLoader.newInstance().pause();
//    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivShow)
        ImageView ivShow;
        @BindView(R.id.ivProgressBar)
        ImageView ivProgressBar;
        @BindView(R.id.cbChoice)
        CheckBox cbChoice;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
