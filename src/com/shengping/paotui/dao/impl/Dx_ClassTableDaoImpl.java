package com.shengping.paotui.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_ClassTableDao;
import com.shengping.paotui.model.Dx_ClassTable;
@Repository
public class Dx_ClassTableDaoImpl implements Dx_ClassTableDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int addClass(Dx_ClassTable class_) {
		// TODO Auto-generated method stub
		return (Integer)getSession().save(class_);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dx_ClassTable> getByShop(int shopid) {
		String hql="from Dx_ClassTable where C_ParentId=? order by C_OrderIndex desc";
		Query query=getSession().createQuery(hql).setInteger(0, shopid);
		return query.list();
	}
	@Override
	public Dx_ClassTable getById(int id) {
		String hql="from Dx_ClassTable where C_ID=?";
		Query query=getSession().createQuery(hql).setInteger(0, id);
		return (Dx_ClassTable)query.uniqueResult();
	}

}
