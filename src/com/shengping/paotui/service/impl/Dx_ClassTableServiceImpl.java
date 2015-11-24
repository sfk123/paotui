package com.shengping.paotui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.dao.Dx_ClassTableDao;
import com.shengping.paotui.model.Dx_ClassTable;
import com.shengping.paotui.service.Dx_ClassTableService;
@Service
public class Dx_ClassTableServiceImpl implements Dx_ClassTableService{

	@Autowired
	private Dx_ClassTableDao dx_ClassTableDao;
	@Override
	public int addClass(Dx_ClassTable class_) {
		// TODO Auto-generated method stub
		return dx_ClassTableDao.addClass(class_);
	}
	@Override
	public List<Dx_ClassTable> getByShop(int shopid) {
		// TODO Auto-generated method stub
		return dx_ClassTableDao.getByShop(shopid);
	}
	@Override
	public Dx_ClassTable getById(int id) {
		// TODO Auto-generated method stub
		return dx_ClassTableDao.getById(id);
	}

}
