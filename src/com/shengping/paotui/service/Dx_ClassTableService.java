package com.shengping.paotui.service;

import java.util.List;

import com.shengping.paotui.model.Dx_ClassTable;
//�̼Ҳ�Ʒ����
public interface Dx_ClassTableService {
	public int addClass(Dx_ClassTable class_);
	public List<Dx_ClassTable> getByShop(int shopid);
	public Dx_ClassTable getById(int id);
}