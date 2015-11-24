package com.shengping.paotui.dao;

import java.util.List;

import com.shengping.paotui.model.Dx_ClassTable;
//商家产品分类
public interface Dx_ClassTableDao {
	public int addClass(Dx_ClassTable class_);
	public List<Dx_ClassTable> getByShop(int shopid);
	public Dx_ClassTable getById(int id);
}
