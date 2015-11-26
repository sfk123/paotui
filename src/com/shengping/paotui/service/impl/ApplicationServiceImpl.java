package com.shengping.paotui.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.handler.model.PhoneCode;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.TimerService;
@Service
public class ApplicationServiceImpl implements ApplicationService{
	/**
	 * key shopid,value  token
	 */
	private Map<String,String> tokens_shop;
	private Map<String,String> randomCode;
	private Map<String,PhoneCode> phoneCode;
	private Map<String ,Map> field;
	private final String masterSecret="22cae51079c5b39dbef28135";//极光推送密钥
	private final String appKey="99b227a657672d7dfe060822";//极光推送Appkey
	@Autowired
	private TimerService timerService;
	public ApplicationServiceImpl(){
		tokens_shop=new HashMap<String, String>();
		randomCode=new HashMap<String, String>();
		phoneCode=new HashMap<String, PhoneCode>();
		field=new HashMap<String, Map>();
		field.put("randomCode", randomCode);
		field.put("phoneCode", phoneCode);
		
	}
	@Override
	public boolean checkTokenOfShop(String token) {
		boolean contains=false;
		for (Map.Entry<String, String> entry : tokens_shop.entrySet()) {
			if(entry.getValue().equals(token)){
				contains=true;
				break;
			}
		}
		return contains;
	}
	@Override
	public void addToken_Shop(String username,String token) {
		tokens_shop.put(username, token);
	}
	@Override
	public void ShopLogOut(String username) {
		tokens_shop.remove(username);
	}
	@Override
	public void addRandomCode(String uuid, String code) {
		randomCode.put(uuid, code);
		timerService.putRemove(uuid, "randomCode");
	}
	@Override
	public boolean testRandomCode(String uuid, String code) {
		if(randomCode.containsKey(uuid)){
			String code_right=randomCode.get(uuid);
	//		System.out.println(code_right+"<>"+code);
			return code_right.equalsIgnoreCase(code);
		}else{
			return false;
		}
	}
	@Override
	public void removeRandomCode(String uuid) {
		randomCode.remove(uuid);
	}
	
	@Override
	public boolean sendPhoneCode(String phone,String code) {
		PhoneCode code_map=phoneCode.get(phone);
		if(code_map!=null){
			if(code_map.getCount()>5)//同一手机短信发送5次后就不再发送
			return false;
			else{
				code_map.setCode(code);
				code_map.setCount(code_map.getCount()+1);
			}
		}else{
			code_map=new PhoneCode();
			code_map.setCode(code);
			code_map.setCount(1);
			code_map.setPhone(phone);
			phoneCode.put(phone, code_map);
		}
		timerService.putRemove(phone, "phoneCode");
		System.out.println("验证码："+code);
		return true;
	}
	@Override
	public boolean testPhoneCode(String phone, String code) {
		if(phoneCode.containsKey(phone)){
			PhoneCode code_map=phoneCode.get(phone);
			if(code_map.getCode().equals(code)){
				return true;
			}
		}
		return false;
	}
	@Override
	public void removeMapKey(String key, String map) {
		if(field.get(map).containsKey(key)){
			field.get(map).remove(key);
		}
	}
	@Override
	public void removePhoneCode(String phone) {
		if(phoneCode.containsKey(phone)){
			phoneCode.remove(phone);
		}
	}
	@Override
	public String getPushMasterSecret() {
		return masterSecret;
	}
	@Override
	public String getPushAppKey() {
		return appKey;
	}
	
}
