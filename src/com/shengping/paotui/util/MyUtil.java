package com.shengping.paotui.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyUtil {
	public static String stringToMD5(String string) {  
	    byte[] hash;  
	  
	    try {  
	        hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));  
	    } catch (NoSuchAlgorithmException e) {  
	        e.printStackTrace();  
	        return null;  
	    } catch (UnsupportedEncodingException e) {  
	        e.printStackTrace();  
	        return null;  
	    }  
	  
	    StringBuilder hex = new StringBuilder(hash.length * 2);  
	    for (byte b : hash) {  
	        if ((b & 0xFF) < 0x10)  
	            hex.append("0");  
	        hex.append(Integer.toHexString(b & 0xFF));  
	    }  
	  
	    return hex.toString();  
	}
	/*
	 * ������֤��
	 * ����ֵkey����֤��ֵ��value��ͼƬ
	 * 
	 */
	public static Map<String, BufferedImage> getRandomCode(){
		int width = 120;//����ͼƬ��width
	    int height = 40;//����ͼƬ��height
	    int codeCount = 4;//����ͼƬ����ʾ��֤��ĸ���
	    int xx = 22;
	    int fontHeight = 30;
	    int codeY = 30;
	    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
	            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
	            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	 // ����ͼ��buffer
        BufferedImage buffImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
//      Graphics2D gd = buffImg.createGraphics();
        //Graphics2D gd = (Graphics2D) buffImg.getGraphics();
        Graphics gd = buffImg.getGraphics();
        // ����һ���������������
        Random random = new Random();
        // ��ͼ�����Ϊ��ɫ
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);
 
        // �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // �������塣
        gd.setFont(font);
 
        // ���߿�
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);
 
        // �������40�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽��
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 40; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
 
        // randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
 
        // �������codeCount���ֵ���֤�롣
        for (int i = 0; i < codeCount; i++) {
            // �õ������������֤�����֡�
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            // �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
 
            // �������������ɫ����֤����Ƶ�ͼ���С�
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, i* xx+15, codeY);
 
            // ���������ĸ�����������һ��
            randomCode.append(code);
        }
        Map<String, BufferedImage> temp=new HashMap<String, BufferedImage>();
        temp.put(randomCode.toString(), buffImg);
        return temp;
	}
}
