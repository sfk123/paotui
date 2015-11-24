package com.shengping.paotui.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class TokenProcessor {
	 private TokenProcessor(){}  
	    private static TokenProcessor instance = new TokenProcessor();  
	    public static TokenProcessor getInstance(){  
	        return instance;  
	    }  
	    public String generateTokeCode(){  
	        String value = System.currentTimeMillis()+new Random().nextInt()+"";  
	        //��ȡ����ָ�ƣ�ָ����Ψһ��  
	        try {  
	            MessageDigest md = MessageDigest.getInstance("md5");  
	            byte[] b = md.digest(value.getBytes());//�������ݵ�ָ��  
	            //Base64����  
	            BASE64Encoder be = new BASE64Encoder();  
	            be.encode(b);  
	            return be.encode(b);//�ƶ�һ������  
	        } catch (NoSuchAlgorithmException e) {  
	            e.printStackTrace();  
	        }  
	          
	        return null;  
	    }  
}
