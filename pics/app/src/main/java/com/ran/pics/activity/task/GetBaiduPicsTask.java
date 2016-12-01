package com.ran.pics.activity.task;

import android.content.Context;

import com.ran.pics.bean.BaiduJson;
import com.ran.pics.bean.Pic;
import com.ran.pics.util.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public class GetBaiduPicsTask {
	private final int ONEPAGENUM = 30;
	private Context context;
	private OnCompleteListener onCompleteListener;
	private Call<BaiduJson> repos;

	public interface OnCompleteListener{
		void onFailure();
		void onSuccess(ArrayList<? extends Pic> pics);
	}
	public interface BaiduPicsService {
		@GET(Constant.UrlInterface.URL_BAIDU)
		Call<BaiduJson> listRepos(@QueryMap Map<String,String> options);
	}
	
	public GetBaiduPicsTask(Context context,OnCompleteListener onCompleteListener) {
		this.context = context;
		this.onCompleteListener = onCompleteListener;
	}

	public void execute(String searchWord, int pageNum) {
		execute(searchWord,ONEPAGENUM,pageNum);
	}

	public void execute(String searchWord,int onePageNum, int pageNum) {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(Constant.UrlInterface.URL_BAIDU_BASE)
//				.addConverterFactory(ScalarsConverterFactory.create())
//				增加返回值为Gson的支持(以实体类返回)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		Map<String,String> optionsMap = new HashMap<>();
		optionsMap.put("tn","resultjsonavatarnew");
		optionsMap.put("ie","utf-8");
		optionsMap.put("word",searchWord+"手机高清");
//		optionsMap.put("cg","girl");
		optionsMap.put("pn",pageNum+"");
		optionsMap.put("rn",onePageNum+"");
		optionsMap.put("width","1080");
		optionsMap.put("height","1920");
		BaiduPicsService service = retrofit.create(BaiduPicsService.class);
		repos = service.listRepos(optionsMap);
		repos.enqueue(new Callback<BaiduJson>() {
			@Override
			public void onResponse(Call<BaiduJson> call, Response<BaiduJson> response) {
				ArrayList<? extends Pic> picListTemp = (ArrayList<? extends Pic>) response.body().getImgs();
				if(onCompleteListener != null)
					onCompleteListener.onSuccess(picListTemp);
			}

			@Override
			public void onFailure(Call<BaiduJson> call, Throwable t) {
				if(onCompleteListener != null)
					onCompleteListener.onFailure();
			}
		});
	}

	public void cancleTask() {
		repos.cancel();
	}
}
