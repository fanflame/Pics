package com.ran.pics.util.tietuapi;

/**
 * @author wanghuanhuan
 *         创建请求token
 */
public class TokenFactory {
    /**
     * 创建   相冊 TOKEN
     *
     * @param deadlineTime
     * @param albumId
     * @param uid用户ID      不填写为查询自己的相册列表
     */
    public static String createAlbumToken(long deadlineTime,
                                          String uid) {
        String action = "get";
        String json;
        if (uid == null) {
            json = "{\"deadline\":%s,\"action\":\"%s\",\"uid\":\"%s\"}";
            json = String.format(json, deadlineTime, action, uid);
        } else {
            json = "{\"deadline\":%s,\"action\":\"%s\"}";
            json = String.format(json, deadlineTime, action);
        }
        json = String.format(json, deadlineTime, action);
        return Util.codeToken(json);
    }

    /**
     * 创建   随机30张图片TOKEN
     *
     * @param deadlineTime
     * @param albumId
     * @param cid          图片类型ID可参考分类接口获取
     */
    public static String createRandomPicsToken(long deadlineTime,
                                               String cid) {
        String action = "getrandrec";
        String json;
        if (cid == null) {
            json = "{\"deadline\":%s,\"action\":\"%s\"}";
            json = String.format(json, deadlineTime, action);
        } else {
            json = "{\"deadline\":%s,\"action\":\"%s\",\"cid\":\"%s\"}";
            json = String.format(json, deadlineTime, action, cid);
        }
        return Util.codeToken(json);
    }

    /**
     * 创建   全部图片TOKEN
     *
     * @param deadlineTime
     * @param albumId
     * @param page_no      页数(每页固定30张图片)
     * @param cid          图片类型ID可参考分类接口获取
     */
    public static String createAllPicsToken(long deadlineTime, String pageNum,
                                            String cid) {
        String action = "getnewpic";
        String json;
//		if(cid == null){
//			json = "{\"deadline\":%s,\"action\":\"%s\",\"page_no\":\"%s\"}";
//			json = String.format(json, deadlineTime,action, pageNum);
//		}else{
        json = "{\"deadline\":%s,\"action\":\"%s\",\"page_no\":\"%s\",\"cid\":\"%s\"}";
        json = String.format(json, deadlineTime, action, pageNum, cid);
//		}
//		json = "{\"deadline\":1420041600,\"action\":\"getall\"}";
        System.out.println("fq json:" + json);
        return Util.codeToken(json);
    }

    /**
     * 创建   相册内图片TOKEN
     *
     * @param deadlineTime
     * @param albumId
     * @param aid          相册ID可参考相册接口
     * @param page_no      页数(每页固定30张图片)
     */
    public static String createAlbumPicsToken(long deadlineTime,
                                              String aid, String pageNum) {
        String action = "album";
        String json;
        json = "{\"deadline\":%s,\"action\":\"%s\",\"aid\":\"%s\",\"page_no\":\"%s\"}";
        json = String.format(json, deadlineTime, action, aid, pageNum);
        return Util.codeToken(json);
    }

    /**
     * 创建   喜欢图片TOKEN
     *
     * @param deadlineTime
     * @param albumId
     * @param page_no 页数(每页固定30张图片)
     */
    /*public static String createLikePicsToken(long deadlineTime,String pageNum) {
		String action = "getlovepic";
		String json;
		json = "{\"deadline\":%s,\"action\":\"%s\",\"page_no\":\"%s\"}";
		json = String.format(json, deadlineTime,action, pageNum);
		return Util.codeToken(json);
	}*/

    /**
     * 创建  分类图片TOKEN
     *
     * @param deadlineTime
     * @param albumId
     * @param page_no      页数(每页固定30张图片)
     */
    public static String createClassificationToken(long deadlineTime) {
        String action = "getall";
        String json;
        json = "{\"deadline\":%s,\"action\":\"%s\"}";
        json = String.format(json, deadlineTime, action);
        return Util.codeToken(json);
    }
}
