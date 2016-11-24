package com.ran.pics.util;

import com.ran.pics.bean.Classification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Constant {

	public static class Config {
		public static final boolean DEVELOPER_MODE = true;
		public static final String DOWN_BMP_PATH = "/pics/downBmp/";
	}
	
	public static class Extra {
		public static final String IMAGE_POSITION = "com.ran.pics.util.universalimageloader.IMAGE_POSITION";
	}
	public static final String ERROR_DENY = "<h1>WARN!!! YOUR REQ IS DENY!!!</h1>";
	public static final String LINKURL = "linkurl";
	public static final String ThumbnailUrl = "Thumbnailurl";
	public class SharePrefer{
	}
	public class Key{
		public static final String accessKey = "18315006bade1ecd9d9c3f8e0e62424438bef50d";
		public static final String secretKey = "4a7e431824cf345ea0092b7ac45b3398fddc337a";
		public static final String APP_ID = "0b968a4dfe2bd2cd15f583e5d6fddde1";
	}
	
	public class UrlInterface{
		
		/**
		 * 相册列表
		 */
		public static final String URL_ALBUM = "http://api.tietuku.com/v1/Album";
		/**
		 * 随机\全部\相册内 列表
		 */
		public static final String URL_LISTPIC = "http://api.tietuku.com/v1/List";
		/**
		 * 喜欢
		 */
		public static final String URL_LIKE = "http://api.tietuku.com/v1/Collect";
		/**
		 * 分类
		 */
		public static final String URL_CLASSIFICATION = "http://api.tietuku.com/v1/Catalog";
		
		/**
		 * 百度搜索 
		 * lm:指定时间内百度收录情况查询，lm=1 最近24小时;lm=7 最近7天;lm=30 最近1个月;lm=360 最近1年;
		 * pn:显示结果的页数;
		 * rn:搜索结果显示条数(Record Number)，取值范围在10–100条之间，缺省设置rn=10
		 */
//		public static final String URL_BAIDU = "http://image.baidu.com/search/avatarjson?tn=resultjsonavatarnew&ie=utf-8&word=‘THESEARCHWORD’&cg=girl&pn=PAGENUM&rn=ONEPAGENUM&itg=0&z=0&fr=&width=WIDTH&height=HEIGHT&lm=-1&ic=0&s=0&st=-1&gsm=7107000078";
//		public static final String URL_BAIDU = "http://image.baidu.com/i?tn=baiduimagejson&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=index&fr=&sf=1&fmq=&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&word=‘THESEARCHWORD’&rn=ONEPAGENUM&pn=PAGENUM&rsp=-1";
//		public static final String URL_BAIDU = "http://image.baidu.com/i?tn=baiduimagejson&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1349413075627_R&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&word=THESEARCHWORD&rn=ONEPAGENUM&pn=PAGENUM";
		public static final String URL_BAIDU = "avatarjson";
		public static final String URL_BAIDU_BASE = "http://image.baidu.com/search/";
	}
	
	/**
	 * @return 初始化抽屜分類 cid:素描 cName:46 cid:诱惑 cName:34 cid:小清新 cName:33 cid:自拍
	 *         cName:32 cid:萝莉 cName:31 cid:性感 cName:30 cid:卡通 cName:29 cid:唯美
	 *         cName:28 cid:书刊 cName:27 cid:建筑 cName:26 cid:写真 cName:35
	 *         cid:插画 cName:36 cid:漫画 cName:45 cid:糕点 cName:44 cid:甜品
	 *         cName:43 cid:剧照 cName:42 cid:雕塑 cName:41 cid:油画 cName:40
	 *         cid:绘画 cName:39 cid:海报 cName:38 cid:小说 cName:37 cid:美食
	 *         cName:25 cid:帅哥 cName:24 cid:亲子 cName:10 cid:明星 cName:9
	 *         cid:汽车 cName:8 cid:宠物 cName:7 cid:服饰 cName:6 cid:搞笑
	 *         cName:5 cid:旅游 cName:4 cid:家居 cName:3 cid:影视 cName:2
	 *         cid:摄影 cName:11 cid:数码 cName:12 cid:壁纸 cName:23 cid:风景
	 *         cName:20 cid:科技 cName:19 cid:艺术 cName:18 cid:DIY cName:17
	 *         cid:美妆 cName:16 cid:体育 cName:15 cid:军事 cName:14 cid:动漫
	 *         cName:13 cid:美女 cName:1
	 */
	
	public static HashMap<String,String> initClassificationDataMap(){
		HashMap<String,String> hashMap = new HashMap<String, String>();
//		hashMap.put("46", "素描");
		hashMap.put("45", "漫画");
		hashMap.put("42", "剧照");
		hashMap.put("41", "雕塑");
		hashMap.put("40", "油画");
		hashMap.put("36", "插画");
		hashMap.put("35", "写真");
		hashMap.put("34", "诱惑");
		hashMap.put("33", "小清新");
		hashMap.put("32", "自拍");
		hashMap.put("31", "萝莉");
		hashMap.put("30", "性感");
		hashMap.put("29", "卡通");
		hashMap.put("28", "唯美");
		hashMap.put("26", "建筑");
		hashMap.put("23", "壁纸");
		hashMap.put("20", "风景");
		hashMap.put("24", "帅哥");
		hashMap.put("14", "军事");
		hashMap.put("13", "动漫");
		hashMap.put("9", "明星");
		
		hashMap.put("8", "汽车");
		hashMap.put("7", "宠物");
		hashMap.put("5", "搞笑");
		hashMap.put("4", "旅游");
		hashMap.put("3", "家居");
		hashMap.put("1", "美女");
		
		//百度专有
		hashMap.put("100", "火影");
		hashMap.put("101", "死神");
		hashMap.put("102", "海贼王");
		hashMap.put("103", "黄晓明");
		hashMap.put("104", "周杰伦");
		hashMap.put("105", "杨幂");
		hashMap.put("106", "壁纸设计");
		hashMap.put("107", "创意摄影");
		hashMap.put("108", "白富美");
//		hashMap.put("27", "书刊");
//		hashMap.put("44", "糕点");
//		hashMap.put("43", "甜品");
//		hashMap.put("39", "绘画");
//		hashMap.put("38", "海报");
//		hashMap.put("37", "小说");
//		hashMap.put("25", "美食");
//		hashMap.put("10", "亲子");
//		hashMap.put("6", "服饰");
//		hashMap.put("2", "影视");
//		hashMap.put("11", "摄影");
//		hashMap.put("12", "数码");
//		hashMap.put("19", "科技");
//		hashMap.put("18", "艺术");
//		hashMap.put("17", "DIY");
//		hashMap.put("16", "美妆");
//		hashMap.put("15", "体育");
		
		return hashMap;
	}
	public static ArrayList<Classification> initListData(HashSet<String> data) {
		ArrayList<Classification> classifList = new ArrayList<Classification>();
		Classification classifi;
		HashMap<String,String> map = initClassificationDataMap();
		Iterator<String> i = data.iterator();
		String temp;
		while(i.hasNext()){
			temp = i.next();
			classifi = new Classification();
			classifi.setId(temp);
			classifi.setName(map.get(temp));
			classifList.add(classifi);
		}
		return classifList;
	}
	
	public static HashSet<String> initSharePreferenceShowData(){
		HashSet<String> showData = new HashSet<String>();
//		showData.add("46");
		showData.add("45");
		showData.add("42");
		showData.add("41");
		showData.add("40");
		showData.add("36");
		showData.add("29");
		showData.add("26");
		showData.add("24");
		showData.add("9");
		showData.add("8");
		showData.add("7");
		showData.add("5");
		showData.add("4");
		showData.add("3");
		
		showData.add("100");
		showData.add("101");
		showData.add("102");
		showData.add("103");
		showData.add("104");
		showData.add("105");
		showData.add("106");
		showData.add("107");
		showData.add("108");
//		showData.add("27");
//		showData.add("44");
//		showData.add("43");
//		showData.add("39");
//		showData.add("38");
//		showData.add("37");
//		showData.add("25");
//		showData.add("10");
//		showData.add("6");
//		showData.add("2");
		return showData;
	}
	
	public static HashSet<String> initSharePreferenceUnShowData(){
		HashSet<String> showData = new HashSet<String>();
//		showData.add("11");
//		showData.add("12");
		showData.add("35");
		showData.add("34");
		showData.add("33");
		showData.add("32");
		showData.add("31");
		showData.add("30");
		showData.add("28");
		showData.add("23");
		showData.add("20");
		showData.add("14");
		showData.add("13");
		showData.add("1");
		
//		showData.add("19");
//		showData.add("18");
//		showData.add("17");
//		showData.add("16");
//		showData.add("15");
		return showData;
	}
	
	/**
	 * @return 需要积分的分类
	 */
	public static HashSet<String> getIntegralClassification(){
		HashSet<String> showData = new HashSet<String>();
		showData.add("34");
		showData.add("33");
		showData.add("32");
		showData.add("31");
		showData.add("30");
		showData.add("28");
		showData.add("35");
		showData.add("1");
		return showData;
	}
	
}
