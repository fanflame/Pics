package com.ran.pics.bean;

import com.google.gson.annotations.SerializedName;
import com.ran.pics.adapter.itemtype.ItemTypeConstants;
import com.ran.pics.adapter.itemtype.PicItem;

import java.io.Serializable;
import java.util.List;

public class BaiduJson implements Serializable {
    /**
     * lifeTrackHead :
     * pageType : 0
     * setNumber : 0
     * IsAvatarQuery : 0
     * avatarCategory :
     * tagZero :
     * tagOne :
     * tagTwo :
     * tagFatherSelected :
     * tagSelected :
     * tags : []
     * simgs : []
     * tag :
     * AVnum : 0
     * imgtotal : 495
     * displayNum :
     * gsm : 20
     * listNum : 495
     * headPic : {"status":"","query":"","desc":"","sign":"","obj_url":"","from_url":"","url":"","summary":"","pageNum":"-1","tagTwo":"","thumbURL":"","width":"","height":""}
     * imgs : [{"thumbURL":"http://img1.imgtn.bdimg.com/it/u=2374521578,3153644073&fm=15&gp=0.jpg","middleURL":"http://img1.imgtn.bdimg.com/it/u=2374521578,3153644073&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img1.imgtn.bdimg.com/it/u=2374521578,3153644073&fm=15&gp=0.jpg","pageNum":2,"objURL":"http://g.hiphotos.baidu.com/zhidao/pic/item/ac345982b2b7d0a272c2dc63ceef76094a369ac1.jpg","fromURL":"http://zhidao.baidu.com/question/1883823328250134868.html","fromURLHost":"zhidao.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"178389184721","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"<strong>手机壁纸<\/strong>图片 谢谢 采纳(最好有适合白天用的 壁纸 ","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2374521578,3153644073","os":"390561859,4046965488","simid":"89903807,859037147","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img4.imgtn.bdimg.com/it/u=2333132733,2038312055&fm=15&gp=0.jpg","middleURL":"http://img4.imgtn.bdimg.com/it/u=2333132733,2038312055&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img4.imgtn.bdimg.com/it/u=2333132733,2038312055&fm=15&gp=0.jpg","pageNum":3,"objURL":"http://d.hiphotos.baidu.com/zhidao/pic/item/279759ee3d6d55fbf1f5aed868224f4a20a4dd19.jpg","fromURL":"http://zhidao.baidu.com/question/1883823328250134868.html","fromURLHost":"zhidao.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"288589035031","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"<strong>手机壁纸<\/strong>图片 谢谢 采纳(最好有适合白天用的 壁纸 ","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2333132733,2038312055","os":"409386661,3464307071","simid":"3405553354,140081647","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img1.imgtn.bdimg.com/it/u=691953622,1204322187&fm=21&gp=0.jpg","middleURL":"http://img1.imgtn.bdimg.com/it/u=691953622,1204322187&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img1.imgtn.bdimg.com/it/u=691953622,1204322187&fm=23&gp=0.jpg","pageNum":4,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/04/1104102348878252981.jpg","fromURL":"http://wow.17173.com/content/2014-11-04/20141104101905087_1.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"134351262100","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图冲击波:最适合做<strong>手机壁纸<\/strong>的魔兽图片集","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"691953622,1204322187","os":"850736515,3236295944","simid":"3347392329,263171636","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img3.imgtn.bdimg.com/it/u=1168386451,2033021648&fm=15&gp=0.jpg","middleURL":"http://img3.imgtn.bdimg.com/it/u=1168386451,2033021648&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img3.imgtn.bdimg.com/it/u=1168386451,2033021648&fm=15&gp=0.jpg","pageNum":5,"objURL":"http://imgsrc.baidu.com/forum/pic/item/1e30e924b899a901617a9e841d950a7b0208f531.jpg","fromURL":"http://tieba.baidu.com/p/1393261003","fromURLHost":"tieba.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"281638726611","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"但这个也可以作<strong>手机壁纸<\/strong>","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"1168386451,2033021648","os":"121034527,2141081090","simid":"3399536287,289016677","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img4.imgtn.bdimg.com/it/u=59388456,2297225908&fm=21&gp=0.jpg","middleURL":"http://img4.imgtn.bdimg.com/it/u=59388456,2297225908&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img4.imgtn.bdimg.com/it/u=59388456,2297225908&fm=23&gp=0.jpg","pageNum":6,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/05/1105115031433258827.jpg","fromURL":"http://wow.17173.com/content/2014-11-05/20141105114835570_all.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"120417160160","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图:最适合做<strong>手机壁纸<\/strong>的魔兽图片第二波","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"59388456,2297225908","os":"709462656,3196357787","simid":"4028002230,581834492","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img5.imgtn.bdimg.com/it/u=3259834798,2942709251&fm=15&gp=0.jpg","middleURL":"http://img5.imgtn.bdimg.com/it/u=3259834798,2942709251&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img5.imgtn.bdimg.com/it/u=3259834798,2942709251&fm=15&gp=0.jpg","pageNum":7,"objURL":"http://g.hiphotos.baidu.com/zhidao/pic/item/4bed2e738bd4b31c5177975c81d6277f9f2ff88a.jpg","fromURL":"http://zhidao.baidu.com/question/1497002887460546739.html","fromURLHost":"zhidao.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"206995574401","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"求推荐一张非主流的<strong>手机壁纸<\/strong>","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"3259834798,2942709251","os":"4209647641,918997448","simid":"0,0","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img4.imgtn.bdimg.com/it/u=1278564316,1813138884&fm=15&gp=0.jpg","middleURL":"http://img4.imgtn.bdimg.com/it/u=1278564316,1813138884&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img4.imgtn.bdimg.com/it/u=1278564316,1813138884&fm=15&gp=0.jpg","pageNum":8,"objURL":"http://f.hiphotos.baidu.com/zhidao/pic/item/314e251f95cad1c8daf2ffc0793e6709c83d518f.jpg","fromURL":"http://zhidao.baidu.com/question/1497002887460546739.html","fromURLHost":"zhidao.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"198762216741","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"求推荐一张非主流的<strong>手机壁纸<\/strong>","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"1278564316,1813138884","os":"4252593876,3667224692","simid":"4121831012,573516122","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img3.imgtn.bdimg.com/it/u=476633517,3426317388&fm=21&gp=0.jpg","middleURL":"http://img3.imgtn.bdimg.com/it/u=476633517,3426317388&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img3.imgtn.bdimg.com/it/u=476633517,3426317388&fm=23&gp=0.jpg","pageNum":9,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/04/1104102428558253001.jpg","fromURL":"http://wow.17173.com/content/2014-11-04/20141104101905087_5.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"64843780100","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图冲击波:最适合做<strong>手机壁纸<\/strong>的魔兽图片集","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"476633517,3426317388","os":"608923185,3049876984","simid":"4200335142,696958422","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img3.imgtn.bdimg.com/it/u=2645141125,3831181776&fm=21&gp=0.jpg","middleURL":"http://img3.imgtn.bdimg.com/it/u=2645141125,3831181776&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img3.imgtn.bdimg.com/it/u=2645141125,3831181776&fm=23&gp=0.jpg","pageNum":10,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/05/1105115031483258830.jpg","fromURL":"http://wow.17173.com/content/2014-11-05/20141105114835570_all.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"92130275270","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图:最适合做<strong>手机壁纸<\/strong>的魔兽图片第二波","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2645141125,3831181776","os":"694813301,3178149370","simid":"4170735833,502383021","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img2.imgtn.bdimg.com/it/u=1320805181,3562118995&fm=21&gp=0.jpg","middleURL":"http://img2.imgtn.bdimg.com/it/u=1320805181,3562118995&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img2.imgtn.bdimg.com/it/u=1320805181,3562118995&fm=23&gp=0.jpg","pageNum":11,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/04/1104102428566253006.jpg","fromURL":"http://wow.17173.com/content/2014-11-04/20141104101905087_4.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"106517895770","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图冲击波:最适合做<strong>手机壁纸<\/strong>的魔兽图片集","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"1320805181,3562118995","os":"689633434,3104957118","simid":"4206300722,753686117","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img1.imgtn.bdimg.com/it/u=2004891650,833526023&fm=21&gp=0.jpg","middleURL":"http://img1.imgtn.bdimg.com/it/u=2004891650,833526023&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img1.imgtn.bdimg.com/it/u=2004891650,833526023&fm=23&gp=0.jpg","pageNum":12,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/05/1105115151167258872.jpg","fromURL":"http://wow.17173.com/content/2014-11-05/20141105114835570_all.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"24381123360","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图:最适合做<strong>手机壁纸<\/strong>的魔兽图片第二波","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2004891650,833526023","os":"742311283,3225783243","simid":"3373636774,429656562","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img0.imgtn.bdimg.com/it/u=4003874200,4036203534&fm=15&gp=0.jpg","middleURL":"http://img0.imgtn.bdimg.com/it/u=4003874200,4036203534&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img0.imgtn.bdimg.com/it/u=4003874200,4036203534&fm=15&gp=0.jpg","pageNum":13,"objURL":"http://download.pchome.net/wallpaper/pic-8603-1.jpg","fromURL":"http://download.pchome.net/wallpaper/info-8603-1-4.html","fromURLHost":"download.pchome.net","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"256337739691","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"e乐园12月月历<strong>手机壁纸<\/strong>","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"4003874200,4036203534","os":"2754982484,1685910927","simid":"0,0","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img0.imgtn.bdimg.com/it/u=3022274730,1384482100&fm=21&gp=0.jpg","middleURL":"http://img0.imgtn.bdimg.com/it/u=3022274730,1384482100&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img0.imgtn.bdimg.com/it/u=3022274730,1384482100&fm=23&gp=0.jpg","pageNum":14,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/04/1104102348881252982.jpg","fromURL":"http://wow.17173.com/content/2014-11-04/20141104101905087_1.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"108570969210","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图冲击波:最适合做<strong>手机壁纸<\/strong>的魔兽图片集","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"3022274730,1384482100","os":"868118574,3222607153","simid":"3465770871,400706677","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img5.imgtn.bdimg.com/it/u=918640590,1647888239&fm=21&gp=0.jpg","middleURL":"http://img5.imgtn.bdimg.com/it/u=918640590,1647888239&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img5.imgtn.bdimg.com/it/u=918640590,1647888239&fm=23&gp=0.jpg","pageNum":15,"objURL":"http://img.pcgames.com.cn/images/piclib/201208/14/batch/1/144254/134493587779771oufbbkwr.jpg","fromURL":"http://photos.pcgames.com.cn/source/494650.html","fromURLHost":"photos.pcgames.com.cn","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"36496306220","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"九周年<strong>手机壁纸<\/strong>推荐","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"918640590,1647888239","os":"3547556593,2509423144","simid":"3396050608,251854091","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img3.imgtn.bdimg.com/it/u=3776196458,750392027&fm=21&gp=0.jpg","middleURL":"http://img3.imgtn.bdimg.com/it/u=3776196458,750392027&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img3.imgtn.bdimg.com/it/u=3776196458,750392027&fm=23&gp=0.jpg","pageNum":16,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/04/1104102428562253004.jpg","fromURL":"http://wow.17173.com/content/2014-11-04/20141104101905087_5.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"134220054650","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图冲击波:最适合做<strong>手机壁纸<\/strong>的魔兽图片集","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"3776196458,750392027","os":"655652454,3062940570","simid":"4176511278,838990085","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img1.imgtn.bdimg.com/it/u=700509139,1447307256&fm=15&gp=0.jpg","middleURL":"http://img1.imgtn.bdimg.com/it/u=700509139,1447307256&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img1.imgtn.bdimg.com/it/u=700509139,1447307256&fm=15&gp=0.jpg","pageNum":17,"objURL":"http://img5.duitang.com/uploads/item/201401/23/20140123153317_N5VMj.jpeg","fromURL":"http://www.duitang.com/people/mblog/124924747/detail/","fromURLHost":"www.duitang.com","currentIndex":"","width":768,"height":1024,"type":"jpeg","filesize":"","bdSrcType":"15","di":"59102217031","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"<strong>手机壁纸<\/strong>分享～看看有没有自己的二次元本命中枪了吧","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"700509139,1447307256","os":"1545468303,1376700556","simid":"3440385048,368266744","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img0.imgtn.bdimg.com/it/u=971726516,588602362&fm=21&gp=0.jpg","middleURL":"http://img0.imgtn.bdimg.com/it/u=971726516,588602362&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img0.imgtn.bdimg.com/it/u=971726516,588602362&fm=23&gp=0.jpg","pageNum":18,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/04/1104102428615253010.jpg","fromURL":"http://wow.17173.com/content/2014-11-04/20141104101905087_4.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"79014832050","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图冲击波:最适合做<strong>手机壁纸<\/strong>的魔兽图片集","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"971726516,588602362","os":"553184127,2983154528","simid":"3406915614,441125629","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img5.imgtn.bdimg.com/it/u=2273796697,1943827318&fm=15&gp=0.jpg","middleURL":"http://img5.imgtn.bdimg.com/it/u=2273796697,1943827318&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img5.imgtn.bdimg.com/it/u=2273796697,1943827318&fm=15&gp=0.jpg","pageNum":19,"objURL":"http://hiphotos.baidu.com/minee%D4%F3%E6%A4/pic/item/186b819e71b64947d31b7048.jpg","fromURL":"http://tieba.baidu.com/p/1063636484","fromURLHost":"tieba.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"11987719051","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"<strong>手机<\/strong>品牌:诺基亚","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2273796697,1943827318","os":"2974941060,1190308166","simid":"4175651980,803652181","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img4.imgtn.bdimg.com/it/u=3320292926,3328870056&fm=21&gp=0.jpg","middleURL":"http://img4.imgtn.bdimg.com/it/u=3320292926,3328870056&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img4.imgtn.bdimg.com/it/u=3320292926,3328870056&fm=23&gp=0.jpg","pageNum":20,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/04/1104102428604253008.jpg","fromURL":"http://wow.17173.com/content/2014-11-04/20141104101905087_4.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"120515306450","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图冲击波:最适合做<strong>手机壁纸<\/strong>的魔兽图片集","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"3320292926,3328870056","os":"637361718,3051488840","simid":"3479057209,353454232","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img1.imgtn.bdimg.com/it/u=2407744713,2433714758&fm=21&gp=0.jpg","middleURL":"http://img1.imgtn.bdimg.com/it/u=2407744713,2433714758&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img1.imgtn.bdimg.com/it/u=2407744713,2433714758&fm=23&gp=0.jpg","pageNum":21,"objURL":"http://att.cespc.com/2014/1023/20141023111214237.jpg","fromURL":"http://www.cespc.com/html/2014/DOTA_1023/464_10.html","fromURLHost":"www.cespc.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"74721366940","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"dota2精品<strong>手机壁纸<\/strong>第3弹","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2407744713,2433714758","os":"4120209016,1632805369","simid":"4139621809,560878169","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img0.imgtn.bdimg.com/it/u=2806320304,1131261590&fm=21&gp=0.jpg","middleURL":"http://img0.imgtn.bdimg.com/it/u=2806320304,1131261590&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img0.imgtn.bdimg.com/it/u=2806320304,1131261590&fm=23&gp=0.jpg","pageNum":22,"objURL":"http://i8.17173.itc.cn/v3/wow/2014/11/05/1105115031490258836.jpg","fromURL":"http://wow.17173.com/content/2014-11-05/20141105114835570_1.shtml","fromURLHost":"wow.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"38249992990","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"美图:最适合做<strong>手机壁纸<\/strong>的魔兽图片第二波","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2806320304,1131261590","os":"787880270,3238973607","simid":"4225420876,708832135","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img4.imgtn.bdimg.com/it/u=157954480,1012331622&fm=21&gp=0.jpg","middleURL":"http://img4.imgtn.bdimg.com/it/u=157954480,1012331622&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img4.imgtn.bdimg.com/it/u=157954480,1012331622&fm=23&gp=0.jpg","pageNum":23,"objURL":"http://h.hiphotos.baidu.com/zhidao/pic/item/1e30e924b899a901332df41619950a7b0208f5f2.jpg","fromURL":"http://zhidao.baidu.com/question/263834386143013485.html","fromURLHost":"zhidao.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"197911883730","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"东京喰种三星<strong>手机壁纸<\/strong>","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"157954480,1012331622","os":"2965627504,1566602125","simid":"4120641871,660268346","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img5.imgtn.bdimg.com/it/u=4165021693,655237982&fm=21&gp=0.jpg","middleURL":"http://img5.imgtn.bdimg.com/it/u=4165021693,655237982&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img5.imgtn.bdimg.com/it/u=4165021693,655237982&fm=23&gp=0.jpg","pageNum":24,"objURL":"http://img3.duitang.com/uploads/item/201401/17/20140117094411_2niCW.jpeg","fromURL":"http://www.duitang.com/people/mblog/115128430/detail/","fromURLHost":"www.duitang.com","currentIndex":"","width":768,"height":1024,"type":"jpeg","filesize":"","bdSrcType":"0","di":"160046427200","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"命锁进<strong>手机<\/strong>屏幕-堆糖","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"4165021693,655237982","os":"1663875216,1779271930","simid":"3333092102,225102690","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img0.imgtn.bdimg.com/it/u=2215406947,3032553807&fm=15&gp=0.jpg","middleURL":"http://img0.imgtn.bdimg.com/it/u=2215406947,3032553807&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img0.imgtn.bdimg.com/it/u=2215406947,3032553807&fm=15&gp=0.jpg","pageNum":25,"objURL":"http://c.hiphotos.baidu.com/zhidao/pic/item/6f061d950a7b0208895d22ee6ad9f2d3572cc82d.jpg","fromURL":"http://zhidao.baidu.com/question/1543623967637495347.html","fromURLHost":"zhidao.baidu.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"109116798791","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"求下面这张<strong>手机壁纸<\/strong>原图!~急~~重赏","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2215406947,3032553807","os":"3107633963,3689557451","simid":"3357255456,388660188","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img0.imgtn.bdimg.com/it/u=4026892883,2770156451&fm=21&gp=0.jpg","middleURL":"http://img0.imgtn.bdimg.com/it/u=4026892883,2770156451&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img0.imgtn.bdimg.com/it/u=4026892883,2770156451&fm=23&gp=0.jpg","pageNum":26,"objURL":"http://img.7xz.com/img/picimg/201605/20160520153649_92fc21789324619993.jpg","fromURL":"http://www.7xz.com/pictures/92.html","fromURLHost":"www.7xz.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"1762298780","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"东条希<strong>手机壁纸<\/strong>欣赏","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"4026892883,2770156451","os":"1382044682,506571733","simid":"0,0","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img2.imgtn.bdimg.com/it/u=2840832911,2342794261&fm=21&gp=0.jpg","middleURL":"http://img2.imgtn.bdimg.com/it/u=2840832911,2342794261&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img2.imgtn.bdimg.com/it/u=2840832911,2342794261&fm=23&gp=0.jpg","pageNum":27,"objURL":"http://n1.itc.cn/img8/wb/recom/2016/04/18/146099194969317122.JPEG","fromURL":"http://mt.sohu.com/20160418/n444822911.shtml","fromURLHost":"mt.sohu.com","currentIndex":"","width":768,"height":1024,"type":"jpeg","filesize":"","bdSrcType":"0","di":"69617842470","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"动漫<strong>手机壁纸<\/strong>下载","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2840832911,2342794261","os":"1685267187,2626763938","simid":"3451254044,262494555","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img3.imgtn.bdimg.com/it/u=608803554,2111935587&fm=15&gp=0.jpg","middleURL":"http://img3.imgtn.bdimg.com/it/u=608803554,2111935587&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img3.imgtn.bdimg.com/it/u=608803554,2111935587&fm=15&gp=0.jpg","pageNum":28,"objURL":"http://n1.itc.cn/img8/wb/recom/2016/05/06/146254918386421476.JPEG","fromURL":"http://mt.sohu.com/20160506/n448141416.shtml","fromURLHost":"mt.sohu.com","currentIndex":"","width":768,"height":1024,"type":"jpeg","filesize":"","bdSrcType":"15","di":"291807327251","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"动漫<strong>手机壁纸<\/strong>下载","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"608803554,2111935587","os":"1854510601,2595802922","simid":"4187935725,545081056","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img2.imgtn.bdimg.com/it/u=1095286371,813382355&fm=21&gp=0.jpg","middleURL":"http://img2.imgtn.bdimg.com/it/u=1095286371,813382355&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img2.imgtn.bdimg.com/it/u=1095286371,813382355&fm=23&gp=0.jpg","pageNum":29,"objURL":"http://img4.91huo.cn/zf/images/2012/wallpaper/9/768X1024.jpg","fromURL":"http://zf.99.com/download/wallpaper/jmbz.shtml","fromURLHost":"zf.99.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"0","di":"39158132860","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"精美<strong>壁纸<\/strong>-《征服-11周年》武侠从心开始-永久免费-zf","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"1095286371,813382355","os":"3847979873,3468344085","simid":"98530214,668469709","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img0.imgtn.bdimg.com/it/u=2091182149,994933271&fm=21&gp=0.jpg","middleURL":"http://img0.imgtn.bdimg.com/it/u=2091182149,994933271&fm=21&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img0.imgtn.bdimg.com/it/u=2091182149,994933271&fm=23&gp=0.jpg","pageNum":30,"objURL":"http://img5.duitang.com/uploads/item/201411/10/20141110180626_MzMcj.jpeg","fromURL":"http://www.duitang.com/people/mblog/241499793/detail/","fromURLHost":"www.duitang.com","currentIndex":"","width":768,"height":1024,"type":"jpeg","filesize":"","bdSrcType":"0","di":"106558893100","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"减肥 励志 <strong>手机壁纸<\/strong>","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2091182149,994933271","os":"2057515026,2352733948","simid":"4057940190,539837287","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"},{"thumbURL":"http://img1.imgtn.bdimg.com/it/u=2357760375,713577580&fm=15&gp=0.jpg","middleURL":"http://img1.imgtn.bdimg.com/it/u=2357760375,713577580&fm=15&gp=0.jpg","largeTnImageUrl":"","hasLarge":true,"hoverURL":"http://img1.imgtn.bdimg.com/it/u=2357760375,713577580&fm=15&gp=0.jpg","pageNum":31,"objURL":"http://image.17173.com/bbs/v1/2011/06/09/1307599581597.jpg","fromURL":"http://bbs.17173.com/forum.php?mod=viewthread&amp;tid=4986129","fromURLHost":"bbs.17173.com","currentIndex":"","width":768,"height":1024,"type":"jpg","filesize":"","bdSrcType":"15","di":"179033054101","is":"0,0","bdSetImgNum":0,"bdImgnewsDate":"1970-01-01 08:00","fromPageTitle":"剑灵高清素材初次公布","bdSourceName":"","bdFromPageTitlePrefix":"","isAspDianjing":false,"token":"","source_type":"","tagTwo":"","cs":"2357760375,713577580","os":"3548838537,3888391975","simid":"3387458791,290517247","pi":"0","adType":"0","setDowloadURL":"","setTittle":"","DecorateCompanyName":"","DecorateCompanyLocation":"","DecorateWantuUrl":"","DecorateCompanyId":"","DecorateCompanyGrade":"","personalized":"0"}]
     */

    private String lifeTrackHead;
    private String pageType;
    private int setNumber;
    private String IsAvatarQuery;
    private String avatarCategory;
    private String tagZero;
    private String tagOne;
    private String tagTwo;
    private String tagFatherSelected;
    private String tagSelected;
    private String tag;
    private String AVnum;
    private String imgtotal;
    private String displayNum;
    private String gsm;
    private String listNum;
    private HeadPicBean headPic;
    private List<?> tags;
    private List<?> simgs;
    private List<ImgsBean> imgs;


    public BaiduJson() {

    }

    public String getLifeTrackHead() {
        return lifeTrackHead;
    }

    public void setLifeTrackHead(String lifeTrackHead) {
        this.lifeTrackHead = lifeTrackHead;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }

    public String getIsAvatarQuery() {
        return IsAvatarQuery;
    }

    public void setIsAvatarQuery(String IsAvatarQuery) {
        this.IsAvatarQuery = IsAvatarQuery;
    }

    public String getAvatarCategory() {
        return avatarCategory;
    }

    public void setAvatarCategory(String avatarCategory) {
        this.avatarCategory = avatarCategory;
    }

    public String getTagZero() {
        return tagZero;
    }

    public void setTagZero(String tagZero) {
        this.tagZero = tagZero;
    }

    public String getTagOne() {
        return tagOne;
    }

    public void setTagOne(String tagOne) {
        this.tagOne = tagOne;
    }

    public String getTagTwo() {
        return tagTwo;
    }

    public void setTagTwo(String tagTwo) {
        this.tagTwo = tagTwo;
    }

    public String getTagFatherSelected() {
        return tagFatherSelected;
    }

    public void setTagFatherSelected(String tagFatherSelected) {
        this.tagFatherSelected = tagFatherSelected;
    }

    public String getTagSelected() {
        return tagSelected;
    }

    public void setTagSelected(String tagSelected) {
        this.tagSelected = tagSelected;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAVnum() {
        return AVnum;
    }

    public void setAVnum(String AVnum) {
        this.AVnum = AVnum;
    }

    public String getImgtotal() {
        return imgtotal;
    }

    public void setImgtotal(String imgtotal) {
        this.imgtotal = imgtotal;
    }

    public String getDisplayNum() {
        return displayNum;
    }

    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getListNum() {
        return listNum;
    }

    public void setListNum(String listNum) {
        this.listNum = listNum;
    }

    public HeadPicBean getHeadPic() {
        return headPic;
    }

    public void setHeadPic(HeadPicBean headPic) {
        this.headPic = headPic;
    }

    public List<?> getTags() {
        return tags;
    }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    public List<?> getSimgs() {
        return simgs;
    }

    public void setSimgs(List<?> simgs) {
        this.simgs = simgs;
    }

    public List<ImgsBean> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgsBean> imgs) {
        this.imgs = imgs;
    }

    public static class HeadPicBean {
        /**
         * status :
         * query :
         * desc :
         * sign :
         * obj_url :
         * from_url :
         * url :
         * summary :
         * pageNum : -1
         * tagTwo :
         * thumbURL :
         * width :
         * height :
         */

        private String status;
        private String query;
        private String desc;
        private String sign;
        private String obj_url;
        private String from_url;
        @SerializedName("url")
        private String urlX;
        private String summary;
        private String pageNum;
        private String tagTwo;
        private String thumbURL;
        @SerializedName("width")
        private String widthX;
        @SerializedName("height")
        private String heightX;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getObj_url() {
            return obj_url;
        }

        public void setObj_url(String obj_url) {
            this.obj_url = obj_url;
        }

        public String getFrom_url() {
            return from_url;
        }

        public void setFrom_url(String from_url) {
            this.from_url = from_url;
        }

        public String getUrlX() {
            return urlX;
        }

        public void setUrlX(String urlX) {
            this.urlX = urlX;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getPageNum() {
            return pageNum;
        }

        public void setPageNum(String pageNum) {
            this.pageNum = pageNum;
        }

        public String getTagTwo() {
            return tagTwo;
        }

        public void setTagTwo(String tagTwo) {
            this.tagTwo = tagTwo;
        }

        public String getThumbURL() {
            return thumbURL;
        }

        public void setThumbURL(String thumbURL) {
            this.thumbURL = thumbURL;
        }

        public String getWidthX() {
            return widthX;
        }

        public void setWidthX(String widthX) {
            this.widthX = widthX;
        }

        public String getHeightX() {
            return heightX;
        }

        public void setHeightX(String heightX) {
            this.heightX = heightX;
        }
    }

    public static class ImgsBean extends Pic {
        /**
         * thumbURL : http://img1.imgtn.bdimg.com/it/u=2374521578,3153644073&fm=15&gp=0.jpg
         * middleURL : http://img1.imgtn.bdimg.com/it/u=2374521578,3153644073&fm=15&gp=0.jpg
         * largeTnImageUrl :
         * hasLarge : true
         * hoverURL : http://img1.imgtn.bdimg.com/it/u=2374521578,3153644073&fm=15&gp=0.jpg
         * pageNum : 2
         * objURL : http://g.hiphotos.baidu.com/zhidao/pic/item/ac345982b2b7d0a272c2dc63ceef76094a369ac1.jpg
         * fromURL : http://zhidao.baidu.com/question/1883823328250134868.html
         * fromURLHost : zhidao.baidu.com
         * currentIndex :
         * width : 768
         * height : 1024
         * type : jpg
         * filesize :
         * bdSrcType : 15
         * di : 178389184721
         * is : 0,0
         * bdSetImgNum : 0
         * bdImgnewsDate : 1970-01-01 08:00
         * fromPageTitle : <strong>手机壁纸</strong>图片 谢谢 采纳(最好有适合白天用的 壁纸
         * bdSourceName :
         * bdFromPageTitlePrefix :
         * isAspDianjing : false
         * token :
         * source_type :
         * tagTwo :
         * cs : 2374521578,3153644073
         * os : 390561859,4046965488
         * simid : 89903807,859037147
         * pi : 0
         * adType : 0
         * setDowloadURL :
         * setTittle :
         * DecorateCompanyName :
         * DecorateCompanyLocation :
         * DecorateWantuUrl :
         * DecorateCompanyId :
         * DecorateCompanyGrade :
         * personalized : 0
         */

        private String thumbURL;
        private String middleURL;
        private String largeTnImageUrl;
        private boolean hasLarge;
        private String hoverURL;
        private int pageNum;
        private String objURL;
        private String fromURL;
        private String fromURLHost;
        private String currentIndex;
        @SerializedName("width")
        private int widthX;
        @SerializedName("height")
        private int heightX;
        private String type;
        private String filesize;
        private String bdSrcType;
        private String di;
        private String is;
        private int bdSetImgNum;
        private String bdImgnewsDate;
        private String fromPageTitle;
        private String bdSourceName;
        private String bdFromPageTitlePrefix;
        private boolean isAspDianjing;
        private String token;
        private String source_type;
        private String tagTwo;
        private String cs;
        private String os;
        private String simid;
        private String pi;
        private String adType;
        private String setDowloadURL;
        private String setTittle;
        private String DecorateCompanyName;
        private String DecorateCompanyLocation;
        private String DecorateWantuUrl;
        private String DecorateCompanyId;
        private String DecorateCompanyGrade;
        private String personalized;
        private int itemType = ItemTypeConstants.TYPE_PIC;

        public String getThumbURL() {
            return thumbURL;
        }

        public void setThumbURL(String thumbURL) {
            this.thumbURL = thumbURL;
        }

        public String getMiddleURL() {
            return middleURL;
        }

        public void setMiddleURL(String middleURL) {
            this.middleURL = middleURL;
        }

        public String getLargeTnImageUrl() {
            return largeTnImageUrl;
        }

        public void setLargeTnImageUrl(String largeTnImageUrl) {
            this.largeTnImageUrl = largeTnImageUrl;
        }

        public boolean isHasLarge() {
            return hasLarge;
        }

        public void setHasLarge(boolean hasLarge) {
            this.hasLarge = hasLarge;
        }

        public String getHoverURL() {
            return hoverURL;
        }

        public void setHoverURL(String hoverURL) {
            this.hoverURL = hoverURL;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public String getObjURL() {
            return objURL;
        }

        public void setObjURL(String objURL) {
            this.objURL = objURL;
        }

        public String getFromURL() {
            return fromURL;
        }

        public void setFromURL(String fromURL) {
            this.fromURL = fromURL;
        }

        public String getFromURLHost() {
            return fromURLHost;
        }

        public void setFromURLHost(String fromURLHost) {
            this.fromURLHost = fromURLHost;
        }

        public String getCurrentIndex() {
            return currentIndex;
        }

        public void setCurrentIndex(String currentIndex) {
            this.currentIndex = currentIndex;
        }

        public int getWidthX() {
            return widthX;
        }

        public void setWidthX(int widthX) {
            this.widthX = widthX;
        }

        public int getHeightX() {
            return heightX;
        }

        public void setHeightX(int heightX) {
            this.heightX = heightX;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFilesize() {
            return filesize;
        }

        public void setFilesize(String filesize) {
            this.filesize = filesize;
        }

        public String getBdSrcType() {
            return bdSrcType;
        }

        public void setBdSrcType(String bdSrcType) {
            this.bdSrcType = bdSrcType;
        }

        public String getDi() {
            return di;
        }

        public void setDi(String di) {
            this.di = di;
        }

        public String getIs() {
            return is;
        }

        public void setIs(String is) {
            this.is = is;
        }

        public int getBdSetImgNum() {
            return bdSetImgNum;
        }

        public void setBdSetImgNum(int bdSetImgNum) {
            this.bdSetImgNum = bdSetImgNum;
        }

        public String getBdImgnewsDate() {
            return bdImgnewsDate;
        }

        public void setBdImgnewsDate(String bdImgnewsDate) {
            this.bdImgnewsDate = bdImgnewsDate;
        }

        public String getFromPageTitle() {
            return fromPageTitle;
        }

        public void setFromPageTitle(String fromPageTitle) {
            this.fromPageTitle = fromPageTitle;
        }

        public String getBdSourceName() {
            return bdSourceName;
        }

        public void setBdSourceName(String bdSourceName) {
            this.bdSourceName = bdSourceName;
        }

        public String getBdFromPageTitlePrefix() {
            return bdFromPageTitlePrefix;
        }

        public void setBdFromPageTitlePrefix(String bdFromPageTitlePrefix) {
            this.bdFromPageTitlePrefix = bdFromPageTitlePrefix;
        }

        public boolean isIsAspDianjing() {
            return isAspDianjing;
        }

        public void setIsAspDianjing(boolean isAspDianjing) {
            this.isAspDianjing = isAspDianjing;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getSource_type() {
            return source_type;
        }

        public void setSource_type(String source_type) {
            this.source_type = source_type;
        }

        public String getTagTwo() {
            return tagTwo;
        }

        public void setTagTwo(String tagTwo) {
            this.tagTwo = tagTwo;
        }

        public String getCs() {
            return cs;
        }

        public void setCs(String cs) {
            this.cs = cs;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getSimid() {
            return simid;
        }

        public void setSimid(String simid) {
            this.simid = simid;
        }

        public String getPi() {
            return pi;
        }

        public void setPi(String pi) {
            this.pi = pi;
        }

        public String getAdType() {
            return adType;
        }

        public void setAdType(String adType) {
            this.adType = adType;
        }

        public String getSetDowloadURL() {
            return setDowloadURL;
        }

        public void setSetDowloadURL(String setDowloadURL) {
            this.setDowloadURL = setDowloadURL;
        }

        public String getSetTittle() {
            return setTittle;
        }

        public void setSetTittle(String setTittle) {
            this.setTittle = setTittle;
        }

        public String getDecorateCompanyName() {
            return DecorateCompanyName;
        }

        public void setDecorateCompanyName(String DecorateCompanyName) {
            this.DecorateCompanyName = DecorateCompanyName;
        }

        public String getDecorateCompanyLocation() {
            return DecorateCompanyLocation;
        }

        public void setDecorateCompanyLocation(String DecorateCompanyLocation) {
            this.DecorateCompanyLocation = DecorateCompanyLocation;
        }

        public String getDecorateWantuUrl() {
            return DecorateWantuUrl;
        }

        public void setDecorateWantuUrl(String DecorateWantuUrl) {
            this.DecorateWantuUrl = DecorateWantuUrl;
        }

        public String getDecorateCompanyId() {
            return DecorateCompanyId;
        }

        public void setDecorateCompanyId(String DecorateCompanyId) {
            this.DecorateCompanyId = DecorateCompanyId;
        }

        public String getDecorateCompanyGrade() {
            return DecorateCompanyGrade;
        }

        public void setDecorateCompanyGrade(String DecorateCompanyGrade) {
            this.DecorateCompanyGrade = DecorateCompanyGrade;
        }

        public String getPersonalized() {
            return personalized;
        }

        public void setPersonalized(String personalized) {
            this.personalized = personalized;
        }

        public String getId() {
            return di;
        }

        @Override
        public String getName() {
            return fromPageTitle;
        }

        @Override
        public String getLinkUrl() {
            return objURL;
        }


        @Override
        public String getWidth() {
            return widthX + "";
        }

        @Override
        public String getHeight() {
            return heightX + "";
        }

        @Override
        public String getFindUrl() {
            return fromURL;
        }


        @Override
        public String getThumbnail() {
            return thumbURL;
        }

        @Override
        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }
    }
}
