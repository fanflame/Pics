package com.ran.pics.util.tietuapi;

import android.util.Base64;

import com.ran.pics.util.Constant;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Util {
	public static String hmacSha(String value, String key) {
        try {  
            byte[] keyBytes = key.getBytes();             
            SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);  
            byte[] rawHmac = mac.doFinal(value.getBytes());  
            return new String(base64(rawHmac)).trim();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }  
    }  
	
	public static String base64(byte[] target){
		return Base64.encodeToString(target, Base64.DEFAULT).replace('+', '-').replace('/', '_');
	}
	
	public static String codeToken(String json){
		String base64param = base64(json.getBytes()).trim();
		String sign = hmacSha(base64param , Constant.Key.secretKey);
		String token = Constant.Key.accessKey+":"+sign+":"+base64param;
		return token;
	}
}
