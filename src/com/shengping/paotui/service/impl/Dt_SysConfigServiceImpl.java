package com.shengping.paotui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.dao.Dt_SysConfigDao;
import com.shengping.paotui.model.Dt_SysConfig;
import com.shengping.paotui.service.Dt_SysConfigService;
@Service
public class Dt_SysConfigServiceImpl implements Dt_SysConfigService{

	@Autowired
	private Dt_SysConfigDao dt_SysConfigDao;
	@Override
	public Dt_SysConfig getByArea(String areaid) {
		// TODO Auto-generated method stub
		return dt_SysConfigDao.getByArea(areaid);
	}

}
