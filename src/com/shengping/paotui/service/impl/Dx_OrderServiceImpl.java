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
import com.shengping.paotui.model.Dx_RecAddress;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dt_SysConfigService;
import com.shengping.paotui.service.Dx_ClerksService;
import com.shengping.paotui.service.Dx_OrderService;
import com.shengping.paotui.service.Dx_RecAddressService;
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
	@Override
	public int addOrder(Dx_Order order) {
		int id=dx_OrderDao.addOrder(order);
		if(id>0){
			Dt_SysConfig business_paotui=dt_SysConfigService.getByArea(order.getAreaid());
			System.out.println("跑腿公司："+business_paotui.getCompanyName());
			List<Dx_Clerks> clerks_online=dx_ClerksService.getOnlineOfBusiness(business_paotui.getId());
			System.out.println("在线跑腿哥数量："+clerks_online.size());
			List<String> alias=new ArrayList<String>();
			for(Dx_Clerks clerks:clerks_online){
				alias.add(clerks.getPushTag());
			}
			if(alias.size()>0){//当跑腿哥在线数量大于零时才推送
				JSONObject data=new JSONObject();
				data.put("type", "order_pusher");
				data.put("orderid", id);
				applicationService.JPush(alias, data.toString());
			}
		}
		return id;
	}
	
	@Override
	public Dx_Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return dx_OrderDao.getOrderById(id);
	}
	@Override
	public List<Dx_Order> getOrder_new(int areaid,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return dx_OrderDao.getOrder_new(areaid,pageNo,pageSize);
	}
}
