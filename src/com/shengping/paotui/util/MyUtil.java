package com.shengping.paotui.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.output.ByteArrayOutputStream;

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
	 * 生成验证码
	 * 返回值key是验证码值，value是图片
	 * 
	 */
	public static Map<String, BufferedImage> getRandomCode(){
		int width = 120;//定义图片的width
	    int height = 40;//定义图片的height
	    int codeCount = 4;//定义图片上显示验证码的个数
	    int xx = 22;
	    int fontHeight = 30;
	    int codeY = 30;
	    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
	            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
	            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	 // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
//      Graphics2D gd = buffImg.createGraphics();
        //Graphics2D gd = (Graphics2D) buffImg.getGraphics();
        Graphics gd = buffImg.getGraphics();
        // 创建一个随机数生成器类
        Random random = new Random();
        // 将图像填充为白色
        gd.setColor(Color.WHITE);
        gd.fillRect(0, 0, width, height);
 
        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        // 设置字体。
        gd.setFont(font);
 
        // 画边框。
        gd.setColor(Color.BLACK);
        gd.drawRect(0, 0, width - 1, height - 1);
 
        // 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
        gd.setColor(Color.BLACK);
        for (int i = 0; i < 40; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
 
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
 
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
            // 得到随机产生的验证码数字。
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
 
            // 用随机产生的颜色将验证码绘制到图像中。
            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, i* xx+15, codeY);
 
            // 将产生的四个随机数组合在一起。
            randomCode.append(code);
        }
        Map<String, BufferedImage> temp=new HashMap<String, BufferedImage>();
        temp.put(randomCode.toString(), buffImg);
        return temp;
	}
	/**
     * 将对象转换成base64编码的字符串
     * @return
     */
    public static void saveObject(Object obj,String fileName){
 	   // 创建字节输出流  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        try {  
            // 创建对象输出流，并封装字节流  
            ObjectOutputStream oos = new ObjectOutputStream(baos);  
            // 将对象写入字节流  
            oos.writeObject(obj);  
            // 将字节流编码成base64的字符窜  
            String obj_Base64 = new String(Base64.encodeBase64(baos.toByteArray()));  
            FileWriter fwriter = null;
            try {
             fwriter = new FileWriter("D:/"+fileName+".txt");
             fwriter.write(obj_Base64);
            } catch (IOException ex) {
             ex.printStackTrace();
            } finally {
             try {
              fwriter.flush();
              fwriter.close();
             } catch (IOException ex) {
              ex.printStackTrace();
             }
            }
        } catch (IOException e) {  
            e.printStackTrace();
        }  
    }
    /**
     * 将base64编码的字符串 转换成对象
     */
    @SuppressWarnings("unused")
	public static Object StringToObj(String fileName){
        StringBuffer strbuffer=new StringBuffer();
    	try {
            String encoding="utf-8";
            File file=new File("D:/"+fileName+".txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                while((lineTxt = bufferedReader.readLine()) != null){
//                    System.out.println(lineTxt);
                    strbuffer.append(lineTxt);
                }
                read.close();
    }else{
        System.out.println("找不到指定的文件");
        return null;
    }
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
        return null;
    }
        Object obj=null;
    	if(strbuffer.toString().length()>0){
 	   //读取字节  
        byte[] base64 = Base64.decodeBase64(strbuffer.toString().getBytes());  
        //封装到字节流  
        ByteArrayInputStream bais = new ByteArrayInputStream(base64);  
        try {  
            //再次封装  
            ObjectInputStream bis = new ObjectInputStream(bais);  
            try {  
                //读取对象  
         	   obj = (Object) bis.readObject();  
            } catch (ClassNotFoundException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } catch (StreamCorruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } 
    	}
        return obj;
    }
}
