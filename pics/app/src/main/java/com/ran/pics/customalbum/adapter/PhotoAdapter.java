package com.ran.pics.customalbum.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.ran.pics.R;
import com.ran.pics.application.UILApplication;
import com.ran.pics.customalbum.bean.PhotoInfo;
import com.ran.pics.customalbum.imageaware.RotateImageViewAware;
import com.ran.pics.customalbum.util.ThumbnailsUtil;
import com.ran.pics.util.imageload.ImageLoaderUtils;

import java.util.List;


/**
 * 相片适配器
 * 
 * @author GuiLin
 */
public class PhotoAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private List<PhotoInfo> list;
	private ViewHolder viewHolder;
	private GridView gridView;
    private int width;

	public interface OnPhotoSelectClickListener {
		public void onPhotoSelectClickListener(List<PhotoInfo> list);

	}

	private OnPhotoSelectClickListener onPhotoSelectClickListener;

	public PhotoAdapter(Activity context, List<PhotoInfo> list,
						GridView gridView) {
		mInflater = LayoutInflater.from(context);
		this.list = list;
		this.gridView = gridView;
		if (onPhotoSelectClickListener == null) {
			onPhotoSelectClickListener = (OnPhotoSelectClickListener) context;
		}
		width = UILApplication.getPicWidth(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 刷新view
	 * 
	 * @param index
	 */
	public void refreshView(int index) {
		int visiblePos = gridView.getFirstVisiblePosition();
		View view = gridView.getChildAt(index - visiblePos);
		ViewHolder holder = (ViewHolder) view.getTag();

		if (list.get(index).isChoose()) {
			holder.selectImage
					.setImageResource(R.mipmap.btn_check_on_selected);
		} else {
			holder.selectImage
					.setImageResource(R.mipmap.btn_check_off_selected);
		}
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_selectphoto, null);
			viewHolder.image = (ImageView) convertView
					.findViewById(R.id.imageView);
			viewHolder.selectImage = (ImageView) convertView
					.findViewById(R.id.selectImage);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.selectImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				PhotoAdapter.this.refreshView(position);
				onPhotoSelectClickListener.onPhotoSelectClickListener(list);
			}
		});
		if (list.get(position).isChoose()) {
			viewHolder.selectImage
					.setImageResource(R.mipmap.btn_check_on_selected);
		} else {
			viewHolder.selectImage
					.setImageResource(R.mipmap.btn_check_off_selected);
		}
		LayoutParams layoutParams = viewHolder.image.getLayoutParams();
		layoutParams.width = width;
		layoutParams.height = width;
		viewHolder.image.setLayoutParams(layoutParams);
		final PhotoInfo photoInfo = list.get(position);
		if (photoInfo != null) {
			ImageLoaderUtils.getInstance().loadImage(
                    ThumbnailsUtil.MapgetHashValue(photoInfo.getImage_id(),
                            photoInfo.getPath_file()),
                    new RotateImageViewAware(viewHolder.image, photoInfo
                            .getPath_absolute()),null);
			// UniversalImageLoadTool.disPlay(ThumbnailsUtil.MapgetHashValue(photoInfo.getImage_id(),photoInfo.getPath_file()),
			// viewHolder.image, R.drawable.common_defalt_bg);
		}
		return convertView;
	}

	public class ViewHolder {
		public ImageView image;
		public ImageView selectImage;
	}


	public void refreshSelect() {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isChoose()) {
				list.get(i).setChoose(false);
				this.refreshView(i);
			}
		}
	}
}
