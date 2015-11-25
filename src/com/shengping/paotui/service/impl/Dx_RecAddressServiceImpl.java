package com.shengping.paotui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.dao.Dx_RecAddressDao;
import com.shengping.paotui.model.Dx_RecAddress;
import com.shengping.paotui.service.Dx_RecAddressService;
@Service
public class Dx_RecAddressServiceImpl implements Dx_RecAddressService{

	@Autowired
	private Dx_RecAddressDao dx_RecAddressDao;
	@Override
	public int creatAddress(Dx_RecAddress address) {
		// TODO Auto-generated method stub
		return dx_RecAddressDao.creatAddress(address);
	}
	@Override
	public List<Dx_RecAddress> getAddressList(int userid) {
		// TODO Auto-generated method stub
		return dx_RecAddressDao.getAddressList(userid);
	}

}
