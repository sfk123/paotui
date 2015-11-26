package com.shengping.paotui.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_OrderDao;
import com.shengping.paotui.model.Dx_Order;
@Repository
public class Dx_OrderDaoImpl implements Dx_OrderDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int addOrder(Dx_Order order) {
		// TODO Auto-generated method stub
		return (Integer)getSession().save(order);
	}

}
