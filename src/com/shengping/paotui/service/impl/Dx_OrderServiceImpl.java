package com.shengping.paotui.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

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
import cn.jpush.api.push.model.notification.Notification;

import com.shengping.paotui.dao.Dx_OrderDao;
import com.shengping.paotui.model.Dt_SysConfig;
import com.shengping.paotui.model.Dx_Clerks;
import com.shengping.paotui.model.Dx_Order;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dt_SysConfigService;
import com.shengping.paotui.service.Dx_ClerksService;
import com.shengping.paotui.service.Dx_OrderService;
@Service
public class Dx_OrderServiceImpl implements Dx_OrderService{

	@Autowired
	private Dx_OrderDao dx_OrderDao;
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private Dt_SysConfigService dt_SysConfigService;
	@Autowired
	private Dx_ClerksService dx_ClerksService;
	private Log log = LogFactory.getLog(Dx_OrderServiceImpl.class);
	@Override
	public int addOrder(Dx_Order order) {
		int id=dx_OrderDao.addOrder(order);
		if(id>0){
			order.setId(id);
			Dt_SysConfig business_paotui=dt_SysConfigService.getByArea(order.getAreaid());
			System.out.println("跑腿公司："+business_paotui.getCompanyName());
			List<Dx_Clerks> clerks_online=dx_ClerksService.getOnlineOfBusiness(business_paotui.getId());
			log.info("在线跑腿哥数量："+clerks_online);
			List<String> alias=new ArrayList<String>();
			for(Dx_Clerks clerks:clerks_online){
				log.info("alias:"+clerks.getPushTag());
				alias.add(clerks.getPushTag());
			}
			JPushClient jpushClient = new JPushClient(applicationService.getPushMasterSecret(), applicationService.getPushAppKey(), 3);
			
			JSONObject data=new JSONObject();
			data.put("type", "order_pusher");
			data.put("data", JSONObject.fromObject(order));
	        // For push, all you need do is to build PushPayload object.
	        PushPayload payload = buildPushObject_all_alias_alert(alias,data.toString());

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
		return id;
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
