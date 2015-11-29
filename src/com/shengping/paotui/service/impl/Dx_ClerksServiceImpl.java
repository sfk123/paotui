package com.shengping.paotui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.shengping.paotui.dao.Dx_ClerksDao;
import com.shengping.paotui.model.Dx_Clerks;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dx_ClerksService;
@Service
public class Dx_ClerksServiceImpl implements Dx_ClerksService{

	@Autowired
	private Dx_ClerksDao dx_ClerksDao;
	
	@Autowired
	private ApplicationService applicationService;
	@Override
	public int register(Dx_Clerks clerk) {
		// TODO Auto-generated method stub
		return dx_ClerksDao.register(clerk);
	}
	@Override
	public Dx_Clerks login(String username, String pwd,String pushTag) {
		Dx_Clerks clerks=dx_ClerksDao.login(username, pwd);
		if(clerks!=null){
			if(clerks.getPushTag()!=null&&!clerks.getPushTag().equals("")){//提示当前登陆者退出
				JsonObject data=new JsonObject();
				data.addProperty("type", "pusher_logout");
				List<String> alias=new ArrayList<String>();
				alias.add(clerks.getPushTag());
				applicationService.JPush(alias, data.toString());
			}
			dx_ClerksDao.setPushTag(pushTag, clerks.getCL_ID());
		}
		return clerks;
	}
	@Override
	public int updateStatus(int status, int pusherid) {
		// TODO Auto-generated method stub
		return dx_ClerksDao.updateStatus(status, pusherid);
	}
	@Override
	public int updateStatus(int status, String phone) {
		// TODO Auto-generated method stub
		return dx_ClerksDao.updateStatus(status, phone);
	}
	@Override
	public boolean testPhone(String phone) {
		// TODO Auto-generated method stub
		return dx_ClerksDao.testPhone(phone);
	}
	@Override
	public List<Dx_Clerks> getOnlineOfBusiness(int businessid) {
		// TODO Auto-generated method stub
		return dx_ClerksDao.getOnlineOfBusiness(businessid);
	}
	@Override
	public void logout(int userid) {
		dx_ClerksDao.logout(userid);
	}

}
