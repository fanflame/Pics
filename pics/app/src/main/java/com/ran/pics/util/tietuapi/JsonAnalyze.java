//package com.ran.pics.util.tietuapi;
//
//import android.content.Context;
//
//import com.ran.pics.bean.Album;
//import com.ran.pics.bean.Classification;
//import com.ran.pics.bean.Pic;
//import com.ran.pics.util.ToastUtil;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//
//
///**
// * @author wanghuanhuan
// * 解析json
// */
//public class JsonAnalyze {
//
//	/**
//	 * @param jsonStr
//	 * 相冊列表 {
//			    "name": "admin",
//			    "album": [
//			        {
//			            "aid": "1",
//			            "albumname": "默认相册",
//			            "num": "24",
//			            "code": "200",
//			            "pic": [
//			                {
//			                    "id": "966948",
//			                    "url": "http://i1.tietuku.com/0b47cd8d23ed9ef2.gif"
//			                },
//			                {
//			                    "id": "602689",
//			                    "url": "http://i1.tietuku.com/e73303560c2b9aa2.jpg"
//			                },
//			                {
//			                    "id": "119940",
//			                    "url": "http://i1.tietuku.com/471abd114d913182.jpg"
//			                }
//			            ]
//			        }
//			    ]
//}
//	 */
//	public static ArrayList<Album> parseAlbumJson(Context context, String jsonStr) {
//        ArrayList<Album> albums = new ArrayList<Album>();
//		Album album = null;
//		JSONObject result;
//		try {
//			result = new JSONObject(jsonStr);
////			album.setOwner(result.getString("name"));
//            JSONArray albumArray = result.getJSONArray("album");
//            JSONArray picArray;
//            ArrayList<Pic> picList = null;
//            Pic pic;
//            JSONObject data;
//            int size = albumArray.length();
//            int picSize;
//            for (int i = 0; i < size; i++) {
//                album = new Album();
//                data = (JSONObject) albumArray.get(i);
//				album.setAlbumId(data.getString("aid"));
//				album.setName(data.getString("albumname"));
//				album.setNum(data.getString("num"));
//				album.setCode(data.getString("code"));
//				picArray = data.getJSONArray("pic");
//				picSize = picArray.length();
//                picList = new ArrayList<Pic>(picSize);
//				for (int j = 0; j < picSize; j++) {
////					data = picArray.getJSONObject(j);
////					pic = new Pic();
////					pic.setId(data.getString("id"));
////					pic.setUrl(data.getString("url"));
////                    picList.add(pic);
//				}
//				album.setPicList(picList);
//                albums.add(album);
//			}
//		} catch (JSONException e) {
//			ToastUtil.show(context, "获取相册失败");
//			e.printStackTrace();
//		}
//		return albums;
//	}
//
//	/**
//	 * @param jsonStr
//	 * 随机图片 [
//			    {
//			        "id": "71917",
//			        "name": "思u5ff5初u604b的味道",
//			        "linkurl": "http://i1.tietuku.com/3c7887e64dfe0ccb.jpg",
//			        "showurl": "http://tietuku.com/3c7887e64dfe0ccb",
//			        "ext": "jpg",
//			        "width": "1200",
//			        "height": "1715",
//			        "findurl": "3c7887e64dfe0ccb",
//			        "recommend": "1",
//			        "love": "0"
//			    },
//			    {
//			        "id": "68376",
//			        "name": "微博",
//			        "linkurl": "http://i1.tietuku.com/989f6c1f01ec7fb8.png",
//			        "showurl": "http://tietuku.com/989f6c1f01ec7fb8",
//			        "ext": "png",
//			        "width": "180",
//			        "height": "180",
//			        "findurl": "989f6c1f01ec7fb8",
//			        "recommend": "1",
//			        "love": "0"
//			    }
//			]
//	 */
//	public static ArrayList<Pic> parseRandomPicJson(String jsonStr, Context context) {
//		JSONArray result;
//		ArrayList<Pic> picList = null;
//		try {
//			result = new JSONArray(jsonStr);
//			JSONObject object;
//			int size = result.length();
//			picList = new ArrayList<Pic>();
//			Pic tempPic;
//			for (int i = 0; i < size; i++) {
//				tempPic = new Pic();
//				object = result.getJSONObject(i);
//				tempPic.setId(object.getString("id"));
//				tempPic.setName(object.getString("name"));
//				tempPic.setLinkUrl(object.getString("linkurl"));
//				tempPic.setWidth(object.getString("width"));
//				tempPic.setHeight(object.getString("height"));
//				picList.add(tempPic);
//			}
//		} catch (JSONException e) {
//			ToastUtil.show(context, "获取随机图片失败");
//			e.printStackTrace();
//		}
//		return picList;
//	}
//
//	/**
//	 * @param
//{
//    "total": "1",
//    "pic": [
//        {
//            "love": "1",
//            "id": "2761244",
//            "height": "1847",
//            "width": "1080",
//            "name": "device-2014-11-10-154624",
//            "linkurl": "http://i3.tietuku.com/b695d6951f3be2df.png",
//            "recommend": "0",
//            "findurl": "b695d6951f3be2df",
//            "ext": "png",
//            "showurl": "http://tietuku.com/b695d6951f3be2df"
//        }
//    ],
//    "pages": 1,
//    "album": {
//        "state": "1",
//        "uid": "6974",
//        "username": "梵依然",
//        "aid": "19807",
//        "albumname": "splash"
//    }
//}
//	 * @param context
//	 * @return 得到相册内图片
//	 */
//	public static ArrayList<Pic> getAlbumPic(JSONObject result, Context context){
//		JSONArray albumArray;
//		ArrayList<Pic> picList = new ArrayList<Pic>();
////		Album album;
//		try {
////			album = new Album();
////			album.setOwner(result.getString("username"));
////			album.setAlbumId(result.getString("aid"));
////			album.setCode(result.getString("state"));
////			album.setName(result.getString("albumname"));
////			album.setPage(result.getString("pages"));
//			Pic tempPic;
//			albumArray = result.getJSONArray("pic");
//			int size = albumArray.length();
//			for (int i = 0; i < size; i++) {
//				tempPic = new Pic();
//				result = albumArray.getJSONObject(i);
//				tempPic.setId(result.getString("id"));
//				tempPic.setName(result.getString("name"));
//				tempPic.setLinkUrl(result.getString("linkurl"));
//				tempPic.setShowUrl(result.getString("showurl"));
//				tempPic.setWidth(result.getString("width"));
//				tempPic.setHeight(result.getString("findurl"));
//				picList.add(tempPic);
//			}
////			album.setPicList(picList);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return picList;
//	}
//
//	/**
//	 * @param jsonStr{
//    "pages": 1,
//    "pic": [
//        {
//            "id": "14931",
//            "name": "提莫必须死",
//            "linkurl": "http://i1.tietuku.com/1cbe2550d39e5563.gif",
//            "showurl": "http://tietuku.com/1cbe2550d39e5563",
//            "ext": "gif",
//            "width": "250",
//            "height": "167",
//            "findurl": "1cbe2550d39e5563",
//            "recommend": "0"
//        }
//    ]
//}
//	 * @param context
//	 * @return 喜欢的图片列表
//	 */
//	public static Album getLikePics(String jsonStr, Context context){
//		Album album = null;
//		JSONArray albumArray;
//		Pic tempPic;
//		ArrayList<Pic> picList;
//		try {
//			JSONObject result = new JSONObject(jsonStr);
//			album = new Album();
//			album.setPage(result.getString("pages"));
//			albumArray = result.getJSONArray("pic");
//			int size = albumArray.length();
//			picList = new ArrayList<Pic>();
//			for (int i = 0; i < size; i++) {
//				tempPic = new Pic();
//				result = albumArray.getJSONObject(i);
//				tempPic.setId(result.getString("id"));
//				tempPic.setName(result.getString("name"));
//				tempPic.setLinkUrl(result.getString("linkurl"));
//				tempPic.setShowUrl(result.getString("showurl"));
//				tempPic.setWidth(result.getString("width"));
//				tempPic.setHeight(result.getString("findurl"));
//				picList.add(tempPic);
//			}
//			album.setPicList(picList);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			ToastUtil.show(context, "获取喜欢的图片列表失败");
//			e.printStackTrace();
//		}
//		return album;
//	}
//
//	/**
//	 * @param jsonStr{
//    "0": {
//        "cid": "46",
//        "name": "素描"
//    },
//    "1": {
//        "cid": "34",
//        "name": "诱惑"
//    },
//    "code": "200"
//}
//	 * @param context 分类
//	 */
//	public static ArrayList<Classification> getAllClassification(String jsonStr, Context context){
//		ArrayList<Classification> classsifiList = new ArrayList<Classification>();
//		Classification classifi;
//		try {
//			JSONObject result = new JSONObject(jsonStr);
//			JSONObject tempJson;
//			int i = 0;
//			while (true) {
//				classifi = new Classification();
//				tempJson = result.getJSONObject(""+i);
//				classifi.setId(tempJson.getString("cid"));
//				classifi.setName(tempJson.getString("name"));
//				classsifiList.add(classifi);
//				i++;
//			}
//		} catch (JSONException e) {
//			ToastUtil.show(context, "获取分类失败");
//			e.printStackTrace();
//		}
//		return classsifiList;
//	}
//
//	/**
//     * @param
//     *
//     * {
//    "pages": 1,
//    "pic": [
//    {
//    "id": "71917",
//    "name": "\u601du5ff5\u521du604b\u7684\u5473\u9053",
//    "linkurl": "http://i1.tietuku.com/3c7887e64dfe0ccb.jpg",
//    "showurl": "http://tietuku.com/3c7887e64dfe0ccb",
//    "ext": "jpg",
//    "width": "1200",
//    "height": "1715",
//    "findurl": "3c7887e64dfe0ccb",
//    "recommend": "1",
//    "love": "0"
//    },
//    {
//    "id": "68376",
//    "name": "\u5fae\u535a",
//    "linkurl": "http://i1.tietuku.com/989f6c1f01ec7fb8.png",
//    "showurl": "http://tietuku.com/989f6c1f01ec7fb8",
//    "ext": "png",
//    "width": "180",
//    "height": "180",
//    "findurl": "989f6c1f01ec7fb8",
//    "recommend": "1",
//    "love": "0"
//    }
//    ]
//     * @param context
//     * @return &#x5168;&#x90e8;&#x56fe;&#x7247;
//     */
//	public static ArrayList<Pic> getAllPic(JSONObject result, Context context){
//		JSONArray albumArray;
//		ArrayList<Pic> picList = new ArrayList<Pic>();
//		Album album;
//		try {
//			album = new Album();
//			album.setPage(result.getString("pages"));
//			Pic tempPic;
//			albumArray = result.getJSONArray("pic");
//			int size = albumArray.length();
//			for (int i = 0; i < size; i++) {
//				tempPic = new Pic();
//				result = albumArray.getJSONObject(i);
//				tempPic.setId(result.getString("id"));
//				tempPic.setName(result.getString("name"));
//				tempPic.setLinkUrl(result.getString("linkurl"));
//				tempPic.setShowUrl(result.getString("showurl"));
//				tempPic.setWidth(result.getString("width"));
//				tempPic.setHeight(result.getString("height"));
//				tempPic.setFindUrl(result.getString("findurl"));
//				picList.add(tempPic);
//			}
//			album.setPicList(picList);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			ToastUtil.show(context, "获取图片失败");
//			e.printStackTrace();
//		}
//		return picList;
//	}
//
//	/*
//	 * {
//    "queryEnc": "girl",
//    "queryExt": "girl",
//    "listNum": 1000,
//    "displayNum": 1578003,
//    "bdFmtDispNum": "约1,570,000",
//    "bdSearchTime": "0.000",
//    "bdIsClustered": "1",
//    "data": [
//        {
//            "thumbURL": "http://img5.imgtn.bdimg.com/it/u=3897388682,2158855543&fm=21&gp=0.jpg",
//            "middleURL": "http://img5.imgtn.bdimg.com/it/u=3897388682,2158855543&fm=21&gp=0.jpg",
//            "largeTnImageUrl": "http://img5.imgtn.bdimg.com/it/u=3897388682,2158855543&fm=21&gp=0.jpg",
//            "hasLarge": 0,
//            "hoverURL": "http://img5.imgtn.bdimg.com/it/u=3897388682,2158855543&fm=23&gp=0.jpg",
//            "pageNum": 1,
//            "objURL": "http://img3.fengniao.com/forum/attachpics/146/43/5808587.jpg",
//            "fromURL": "http://photo.fengniao.com/pic_5808587.html",
//            "fromURLHost": "http://photo.fengniao.com",
//            "currentIndex": "17409",
//            "width": 743,
//            "height": 1000,
//            "type": "jpg",
//            "filesize": "90",
//            "bdSrcType": "0",
//            "di": "181464552940",
//            "is": "0,0",
//            "simid_info": {
//                "card_pres_info": {
//                    "sucai": 1
//                }
//            },
//            "face_info": [],
//            "xiangshi_info": [],
//            "adPicId": "0",
//            "bdSetImgNum": 0,
//            "bdImgnewsDate": "1970-01-01 08:00",
//            "fromPageTitle": "【图片】cool <strong>girl</strong> 照片",
//            "fromPageTitleEnc": "【图片】cool girl 照片",
//            "bdSourceName": "",
//            "bdFromPageTitlePrefix": "",
//            "token": "7711"
//        },
//        {}
//    ]
//}
//	* @param context
//	 * @return 全部图片
//	 */
//	public static ArrayList<Pic> getBaiduAllPic(JSONObject result, Context context){
//		JSONArray albumArray;
//		ArrayList<Pic> picList = new ArrayList<Pic>();
//		try {
//			Pic tempPic;
//			albumArray = result.getJSONArray("imgs");
//			int size = albumArray.length();
//			for (int i = 0; i < size; i++) {
//				tempPic = new Pic();
//				result = albumArray.getJSONObject(i);
//				tempPic.setId(result.getString("di"));
//				tempPic.setName(result.getString("fromPageTitle"));
//				tempPic.setThumbnail(result.getString("thumbURL"));
//				tempPic.setLinkUrl(result.getString("objURL"));
//				tempPic.setWidth(result.getString("width"));
//				tempPic.setHeight(result.getString("height"));
//				tempPic.setFindUrl(result.getString("fromURL"));
//				picList.add(tempPic);
//			}
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			if(picList != null)
//				return picList;
//			e.printStackTrace();
//		}
//		return picList;
//	}
//
//
//
//}
