package com.ran.pics.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ran.pics.R;
import com.ran.pics.bean.Classification;
import com.ran.pics.view.MaterialSytle.LButton;

import java.util.ArrayList;
import java.util.HashMap;

public class GridClassificationAdapter extends BaseAdapter {
	private ArrayList<Classification> classifList;
	private HashMap<Integer,Integer> colorMap;
	private OnButtonItemClickListener buttonListener;
	
	public interface OnButtonItemClickListener{
		void onButtonItemClickListener(int position);
	}
	
	public GridClassificationAdapter(ArrayList<Classification> classifList, OnButtonItemClickListener buttonListener){
		this.classifList = classifList;
		this.buttonListener = buttonListener;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return classifList == null?0:classifList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = View.inflate(parent.getContext(), R.layout.classification, null);
			viewHolder.classificationTv = (LButton) convertView.findViewById(R.id.classificationTv);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.classificationTv.setText(classifList.get(position).getName());
		viewHolder.classificationTv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				buttonListener.onButtonItemClickListener(position);	
			}
		});
		if(colorMap == null){
			colorMap = new HashMap<Integer, Integer>();
		}
		if(colorMap.get(position) == null){
//			colorMap.put(position, Utils.initBgColor(parent.getContext(), viewHolder.classificationTv));
		}
		else{
			viewHolder.classificationTv.setBackgroundColor(colorMap.get(position));
		}
		return convertView;
	}
	
	private class ViewHolder{
		LButton classificationTv;
	} 
	
	public void setData(ArrayList<Classification> classifList){
		this.classifList = classifList;
	}
	
	public ArrayList<Classification> getData(){
		return this.classifList;
	}
	public void deltData(String id){
		if(classifList != null){
			int size = classifList.size();
			for (int i = 0; i < size; i++) {
				if(classifList.get(i).getId().equals(id)){
					classifList.remove(i);
					break;
				}
			}
		}
		this.notifyDataSetChanged();
	}
	
	public void addData(Classification classifi){
		if(classifList != null){
			classifList.add(classifi);
		}
		this.notifyDataSetChanged();
	}
}
