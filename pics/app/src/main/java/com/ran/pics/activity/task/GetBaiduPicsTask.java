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
	private final String ONEPAGENUM = "30";
	private Context context;
	private OnCompleteListener onCompleteListener;

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
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(Constant.UrlInterface.URL_BAIDU_BASE)
//				.addConverterFactory(ScalarsConverterFactory.create())
//				增加返回值为Gson的支持(以实体类返回)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		Map<String,String> optionsMap = new HashMap<>();
		optionsMap.put("tn","resultjsonavatarnew");
		optionsMap.put("ie","utf-8");
		optionsMap.put("word",searchWord);
		optionsMap.put("cg","girl");
		optionsMap.put("pn",pageNum+"");
		optionsMap.put("rn",ONEPAGENUM+"");
		optionsMap.put("width","768");
		optionsMap.put("height","1024");
		BaiduPicsService service = retrofit.create(BaiduPicsService.class);
		Call<BaiduJson> repos = service.listRepos(optionsMap);
		repos.enqueue(new Callback<BaiduJson>() {
			@Override
			public void onResponse(Call<BaiduJson> call, Response<BaiduJson> response) {
				ArrayList<? extends Pic> picListTemp = (ArrayList<? extends Pic>) response.body().getImgs();
//				try {
//					picListTemp = JsonAnalyze.getBaiduAllPic(new JSONObject(response.body()),context);
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}

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
	}
}
