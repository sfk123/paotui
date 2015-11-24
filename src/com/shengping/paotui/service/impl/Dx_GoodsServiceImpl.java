package com.shengping.paotui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.dao.Dx_ClassTableDao;
import com.shengping.paotui.dao.Dx_GoodsDao;
import com.shengping.paotui.model.Dx_ClassTable;
import com.shengping.paotui.model.Dx_Goods;
import com.shengping.paotui.service.Dx_GoodsService;
@Service
public class Dx_GoodsServiceImpl implements Dx_GoodsService{

	@Autowired
	private Dx_GoodsDao dx_GoodsDao;
	@Autowired
	private Dx_ClassTableDao dx_ClassTableDao;
	@Override
	public int add(Dx_Goods good) {
		
		return dx_GoodsDao.add(good);
	}
	@Override
	public List<Dx_Goods> getGoodByType(int classid) {
		// TODO Auto-generated method stub
		return dx_GoodsDao.getGoodByType(classid);
	}
	@Override
	public Dx_Goods getByid(int id) {
		// TODO Auto-generated method stub
		return dx_GoodsDao.getByid(id);
	}
	@Override
	public void updateGood(Dx_Goods good) {
		dx_GoodsDao.updateGood(good);
	}
	@Override
	public List<Dx_Goods> getGoods_undercarriage(int shopid) {
		List<Dx_ClassTable> classList=dx_ClassTableDao.getByShop(shopid);
		List<Integer> classids=new ArrayList<Integer>();
		for(Dx_ClassTable class_:classList){
			classids.add(class_.getC_ID());
		}
		return dx_GoodsDao.getGoods_undercarriage(shopid,classids);
	}

}
