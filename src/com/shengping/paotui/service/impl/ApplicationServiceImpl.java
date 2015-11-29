package com.shengping.paotui.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;

import com.shengping.paotui.handler.model.PhoneCode;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.TimerService;
import com.shengping.paotui.util.MyUtil;
@Service
public class ApplicationServiceImpl implements ApplicationService{

	private Log log = LogFactory.getLog(ApplicationServiceImpl.class);
	/**
	 * key shopid,value  token
	 */
	private Map<String,String> tokens_shop;
	private Map<String,String> tokens_customer;
	private Map<String,String> tokens_pusher;
	private Map<String,String> randomCode;
	private Map<String,PhoneCode> phoneCode;
	private Map<String ,Map> field;
	private final String masterSecret="22cae51079c5b39dbef28135";//极光推送密钥
	private final String appKey="99b227a657672d7dfe060822";//极光推送Appkey
	@Autowired
	private TimerService timerService;
	@SuppressWarnings("unchecked")
	public ApplicationServiceImpl(){
		Object temp=MyUtil.StringToObj("tokens_shop");
		if(temp==null)
		tokens_shop=new HashMap<String, String>();
		else{
			tokens_shop=(Map<String,String>)temp;
			System.out.println("商家缓存数据------------------------");
			for (Map.Entry<String, String> entry : tokens_shop.entrySet()) {
				System.out.println("key:"+entry.getKey());
			}
		}
		randomCode=new HashMap<String, String>();
		phoneCode=new HashMap<String, PhoneCode>();

		temp=MyUtil.StringToObj("tokens_customer");
		if(temp==null)
		tokens_customer=new HashMap<String, String>();
		else{
			tokens_customer=(Map<String,String>)temp;
			System.out.println("用户缓存数据------------------------");
			for (Map.Entry<String, String> entry : tokens_customer.entrySet()) {
				System.out.println("key:"+entry.getKey());
			}
		}
		temp=MyUtil.StringToObj("tokens_pusher");
		if(temp==null)
		tokens_pusher=new HashMap<String, String>();
		else{
			tokens_pusher=(Map<String,String>)temp;
			System.out.println("跑腿哥缓存数据------------------------");
			for (Map.Entry<String, String> entry : tokens_pusher.entrySet()) {
				System.out.println("key:"+entry.getKey());
			}
		}
		field=new HashMap<String, Map>();
		field.put("randomCode", randomCode);
		field.put("phoneCode", phoneCode);
		
	}
	@Override
	public String checkTokenOfShop(String token) {
		boolean contains=false;
		for (Map.Entry<String, String> entry : tokens_shop.entrySet()) {
			if(entry.getValue().equals(token)){
				return entry.getKey();
			}
		}
		return null;
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
	public void addToken_Customer(String username, String token) {
		tokens_customer.put(username, token);
	}
	@Override
	public void addToken_Pusher(String username, String token) {
		tokens_pusher.put(username, token);
		
	}
	@Override
	public void CustomerLogOut(String username) {
		if(tokens_customer.containsKey(username)){
			tokens_customer.remove(username);
		}
		
	}
	@Override
	public void PusherLogOut(String username) {
		if(tokens_pusher.containsKey(username)){
			tokens_pusher.remove(username);
		}
	}
	@Override
	public boolean checkTokenOfCustomer(String token) {
		boolean contains=false;
		for (Map.Entry<String, String> entry : tokens_customer.entrySet()) {
			if(entry.getValue().equals(token)){
				contains=true;
				break;
			}
		}
		return contains;
	}
	@Override
	public String checkTokenOfPusher(String token) {
		for (Map.Entry<String, String> entry : tokens_pusher.entrySet()) {
			if(entry.getValue().equals(token)){
				return entry.getKey();
			}
		}
		return null;
	}
	@Override
	public void applicationStop() {//服务器停止后保存用户缓存数据
		MyUtil.saveObject(tokens_shop, "tokens_shop");
		MyUtil.saveObject(tokens_customer, "tokens_customer");
		MyUtil.saveObject(tokens_pusher, "tokens_pusher");
		System.out.println("文件保存成功");
	}
	@Override
	public synchronized String getOrderNumber() {//生成订单号
		// TODO Auto-generated method stub
		return new Date().getTime()+"";
	}
	@Override
	public void JPush(List<String> alias, String content) {
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);
		
        PushPayload payload = buildPushObject_all_alias_alert(alias,content);

        try {
            PushResult result = jpushClient.sendPush(payload);
            log.debug("Got result - " + result);

        } catch (APIConnectionException e) {
            // Connection error, should retry later
        	log.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
        	log.error("Should review the error, and fix the request", e);
        	log.info("HTTP Status: " + e.getStatus());
        	log.info("Error Code: " + e.getErrorCode());
        	log.info("Error Message: " + e.getErrorMessage());
        }
	}
	private PushPayload buildPushObject_all_alias_alert(List<String> alias,String content) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
//                .setNotification(Notification.alert(ALERT))
                .setMessage(Message.content(content))
                .build();
    }
}
