package com.shengping.paotui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.shengping.paotui.dao.Dx_ChildShopsDao;
import com.shengping.paotui.model.Dx_ChildShops;
import com.shengping.paotui.model.Dx_Goods;
import com.shengping.paotui.service.ApplicationService;
import com.shengping.paotui.service.Dx_ChildShops_Service;
@Service
public class Dx_ChildShops_ServiceImpl implements Dx_ChildShops_Service{

	@Autowired
	private Dx_ChildShopsDao shopDao;
	@Autowired
	private ApplicationService applicationService;
	@Override
	public int ShopRegister(Dx_ChildShops shop) {
		// TODO Auto-generated method stub
		return shopDao.shopRegister(shop);
	}

	@Override
	public Dx_ChildShops Login(String name, String pwd,String pushtag) {
		Dx_ChildShops shop=shopDao.Login(name, pwd);
		if(shop!=null){
			if(shop.getPushTag()!=null&&!shop.getPushTag().equals("")){//提示当前登陆者退出
				JsonObject data=new JsonObject();
				data.addProperty("type", "shop_logout");
				List<String> alias=new ArrayList<String>();
				alias.add(shop.getPushTag());
				applicationService.JPush(alias, data.toString());
			}
			shopDao.setPushTag(pushtag, shop.getMD_ID());
		}
		return shop;
	}

	@Override
	public Dx_ChildShops getById(int id) {
		// TODO Auto-generated method stub
		return shopDao.getById(id);
	}

	@Override
	public int updateLogo(String logoname, int id) {
		// TODO Auto-generated method stub
		return shopDao.updateLogo(logoname, id);
	}

	@Override
	public int setTime(int id, String time) {
		// TODO Auto-generated method stub
		return shopDao.setTime(id, time);
	}

	@Override
	public int setAddress(int id, String address, String latlong) {
		// TODO Auto-generated method stub
		return shopDao.setAddress(id, address, latlong);
	}

	@Override
	public int setPhone(int id, String phone) {
		// TODO Auto-generated method stub
		return shopDao.setPhone(id, phone);
	}

	@Override
	public boolean ResetPwd(int id, String old, String newpwd) {
		// TODO Auto-generated method stub
		return shopDao.ResetPwd(id, old, newpwd);
	}

	@Override
	public int setStatus(int id, int status) {
		// TODO Auto-generated method stub
		return shopDao.setStatus(id, status);
	}

	@Override
	public int setCardInfo(int id, String oner, String cardnumber,
			String bankaddress) {
		// TODO Auto-generated method stub
		return shopDao.setCardInfo(id, oner, cardnumber, bankaddress);
	}

	@Override
	public boolean testPhone(String phone) {
		// TODO Auto-generated method stub
		return shopDao.testPhone(phone);
	}

	@Override
	public void logout(String phone) {
		shopDao.logout(phone);
	}


}
