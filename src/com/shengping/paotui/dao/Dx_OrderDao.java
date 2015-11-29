package com.shengping.paotui.dao;

import java.util.List;

import com.shengping.paotui.model.Dx_Order;

public interface Dx_OrderDao {
	public int addOrder(Dx_Order order);
	public Dx_Order getOrderById(int id);
	public List<Dx_Order> getOrder_new(int areaid,int pageNo,int pageSize);
}
