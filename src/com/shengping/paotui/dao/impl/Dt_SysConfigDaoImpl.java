package com.shengping.paotui.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dt_SysConfigDao;
import com.shengping.paotui.model.Dt_SysConfig;
@Repository
public class Dt_SysConfigDaoImpl implements Dt_SysConfigDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public Dt_SysConfig getByArea(String areaid) {
		String hql="from Dt_SysConfig where areaid like ?";
		Query query=getSession().createQuery(hql).setString(0,"%"+areaid+"%");
		return (Dt_SysConfig)query.uniqueResult();
	}

}
