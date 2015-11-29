package com.shengping.paotui.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
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
	@Override
	public Dx_Order getOrderById(int id) {
		String hql="from Dx_Order where id=(:id)";
		Query query=getSession().createQuery(hql).setParameter("id", id);
		return (Dx_Order)query.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dx_Order> getOrder_new(int areaid,int pageNo,int pageSize) {
		System.out.println("pageSize:"+pageSize);
		String hql="from Dx_Order where Areaid=(:areaid) and OrderIsOk=0 order by CreateTime desc";
		Query query=getSession().createQuery(hql).setParameter("areaid", areaid);

        query.setFirstResult((pageNo - 1) * pageSize);  

        query.setMaxResults(pageSize);  
		return query.list();
	}

}
