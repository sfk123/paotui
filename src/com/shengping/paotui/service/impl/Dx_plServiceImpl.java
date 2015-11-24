package com.shengping.paotui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.dao.Dx_plDao;
import com.shengping.paotui.model.Dx_pl;
import com.shengping.paotui.service.Dx_plService;
@Service
public class Dx_plServiceImpl implements Dx_plService{

	@Autowired
	private Dx_plDao dx_plDao;
	@Override
	public List<Dx_pl> getBuyShop(int shopid) {
		// TODO Auto-generated method stub
		return dx_plDao.getBuyShop(shopid);
	}

}
