package com.ran.pics.util;//package com.ran.bitmapfun.util;
//
//
//import java.util.HashSet;
//
//import android.content.Context;
//import android.content.SharedPreferences;
//
//
//public class SharePreferenceUtil {
//	private SharedPreferences sp;
//	private SharedPreferences.Editor editor;
//
//	public SharePreferenceUtil(Context context) {
////		sp = context.getSharedPreferences(Constant.SharePrefer.SHAREPREFERENCEFILE,
////				Context.MODE_PRIVATE);
////		editor = sp.edit();
////		initData();
//	}
//
//	private void initData(){
//		HashSet<String> data = (HashSet<String>) sp.getStringSet(Constant.SharePrefer.SHOW, null);
//		if(data == null){
//			editor.putStringSet(Constant.SharePrefer.SHOW, Constant.initSharePreferenceShowData());
//			editor.commit();
//
//			editor.putStringSet(Constant.SharePrefer.UNSHOW, Constant.initSharePreferenceUnShowData());
//			editor.commit();
//		}
//	}
//
//	public void addShowData(String id) {
//		HashSet<String> data = (HashSet<String>) sp.getStringSet(Constant.SharePrefer.SHOW, null);
//		data.add(id);
//		editor.clear();
//		editor.putStringSet(Constant.SharePrefer.SHOW, data);
//
//		HashSet<String> unShowdata = (HashSet<String>) sp.getStringSet(Constant.SharePrefer.UNSHOW, null);
//		unShowdata.remove(id);
//		editor.clear();
//		editor.putStringSet(Constant.SharePrefer.UNSHOW, unShowdata);
//		editor.commit();
//	}
//
//	public void deltShowData(String id) {
//		HashSet<String> unShowdata = (HashSet<String>) sp.getStringSet(Constant.SharePrefer.UNSHOW, null);
//		unShowdata.add(id);
//		editor.clear();
//		editor.putStringSet(Constant.SharePrefer.UNSHOW, unShowdata);
//
//		HashSet<String> data = (HashSet<String>) sp.getStringSet(Constant.SharePrefer.SHOW, null);
//		data.remove(id);
//		editor.clear();
//		editor.putStringSet(Constant.SharePrefer.SHOW, data);
//		editor.commit();
//	}
//
//	public HashSet<String> getShowData(){
//		return (HashSet<String>) sp.getStringSet(Constant.SharePrefer.SHOW, null);
//	}
//
//	public HashSet<String> getUnShowData(){
//		return (HashSet<String>) sp.getStringSet(Constant.SharePrefer.UNSHOW, null);
//	}
//}
