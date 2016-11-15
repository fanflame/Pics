package com.ran.pics.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.bean.Pic;

import java.util.ArrayList;

/**
 * Created by fanyiran on 15/5/9.
 */
public class ImageCollectionAdapter extends BaseAdapter {
    private ArrayList<Pic> picList;
    private ArrayList<Pic> picCheckedList;
    private int width;
    private Activity activity;
    private boolean isShowCheckBox;

    public ImageCollectionAdapter(Activity activity) {
        this.activity = activity;
        width = UILApplication.getPicWidth(activity);;
    }

    public void setList(ArrayList<Pic> albumArrayList) {
        this.picList = albumArrayList;
        this.notifyDataSetChanged();
    }

    public ArrayList<Pic> getList(){
        return picList;
    }

    @Override
    public int getCount() {
        return picList == null ? 0 : picList.size();
    }

    @Override
    public Object getItem(int position) {
        return picList == null ? -1 : picList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_grid_collect, null);
            initHolder(convertView);
        }
        holder = (ViewHolder) convertView.getTag();
        initHolderData(holder, picList.get(position));
        return convertView;
    }

    private void initHolderData(final ViewHolder holder, final Pic pic) {
        ViewGroup.LayoutParams layoutParams = holder.ivShow.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        holder.ivShow.setLayoutParams(layoutParams);
        ImageLoader.getInstance().displayImage(
                pic.getLinkUrl(), holder.ivShow, UILApplication.initImageOption(),
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

        if(isShowCheckBox){
            holder.cbChoice.setVisibility(View.VISIBLE);
            holder.cbChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    pic.setChecked(isChecked);
                    if(picCheckedList == null)
                        picCheckedList = new ArrayList<Pic>();
                    picCheckedList.add(pic);
                }
            });

            holder.cbChoice.setChecked(pic.isChecked());
        }
        else{
            holder.cbChoice.setVisibility(View.GONE);
        }
    }

    private void initHolder(View convertView) {
        ViewHolder holder = new ViewHolder();
        holder.ivShow = (ImageView) convertView.findViewById(R.id.ivShow);
        holder.ivProgressBar = (ImageView) convertView.findViewById(R.id.ivProgressBar);
        holder.cbChoice = (CheckBox)convertView.findViewById(R.id.cbChoice);
        convertView.setTag(holder);
    }

    class ViewHolder {
        ImageView ivShow;
        ImageView ivProgressBar;
        CheckBox cbChoice;
    }

    public ArrayList<Pic> getPicCheckedList(){
        return picCheckedList;
    }

    public void setShowCheckBox(boolean isShowCheckBox){
        this.isShowCheckBox = isShowCheckBox;
        if(!isShowCheckBox && picCheckedList != null)
            picCheckedList.clear();
        notifyDataSetChanged();
    }

    public boolean getShowCheckBox(){
        return isShowCheckBox;
    }
//    public void cancel(){
//        ImageLoader.newInstance().pause();
//    }
}
