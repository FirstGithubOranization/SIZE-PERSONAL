package z.util;

import java.util.UUID;

public class UUIDUtil {

	public static String getUUID(){
		return UUID.randomUUID().toString().trim().replace("-", "");
	}
	
	public static String getAlubumID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getArticleID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getBannerID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getSectionID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getDownLoadID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getCollectionID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getSubscribeID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getRecommendID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}

	public static String getActivityID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}
	public static String getOrderAlbumID() {
		return UUID.randomUUID().toString().trim().replace("-", "");
	}
	
	public static String getKedaQuestionID(){
		return UUID.randomUUID().toString().trim().replace("-", "");
	}
}
