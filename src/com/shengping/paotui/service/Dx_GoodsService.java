package com.shengping.paotui.service;

import java.util.List;

import com.shengping.paotui.model.Dx_Goods;

public interface Dx_GoodsService {
	public int add(Dx_Goods good);
	public List<Dx_Goods> getGoodByType(int classid);
	public Dx_Goods getByid(int id);
	public void updateGood(Dx_Goods good);
	public List<Dx_Goods> getGoods_undercarriage(int shopid);
}
