package com.shengping.paotui.dao;

import java.util.List;

import com.shengping.paotui.model.Dx_Goods;

//²úÆ·±í
public interface Dx_GoodsDao {
	public int add(Dx_Goods good);
	public List<Dx_Goods> getGoodByType(int classid);
	public Dx_Goods getByid(int id);
	public void updateGood(Dx_Goods good);
	public List<Dx_Goods> getGoods_undercarriage(int shopid,List<Integer> classids);
}
