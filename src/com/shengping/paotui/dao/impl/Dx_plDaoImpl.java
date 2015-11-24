package com.shengping.paotui.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_plDao;
import com.shengping.paotui.model.Dx_pl;
@Repository
public class Dx_plDaoImpl implements Dx_plDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dx_pl> getBuyShop(int shopid) {
		String hql="from Dx_pl where pl_type=? and target_id=?";
		Query query=getSession().createQuery(hql).setInteger(0, 1).setInteger(1, shopid);
		return query.list();
	}

}
