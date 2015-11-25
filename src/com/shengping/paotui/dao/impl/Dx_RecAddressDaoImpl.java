package com.shengping.paotui.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_RecAddressDao;
import com.shengping.paotui.model.Dx_RecAddress;
@Repository
public class Dx_RecAddressDaoImpl implements Dx_RecAddressDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int creatAddress(Dx_RecAddress address) {
		if(address.getOrderIndex()==-1){
			String hql="update Dx_RecAddress set OrderIndex=? where UserId=?";
			Query query=getSession().createQuery(hql).setParameter(0, 0).setParameter(1, address.getUserId());
			query.executeUpdate();
		}
		return (Integer)getSession().save(address);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dx_RecAddress> getAddressList(int userid) {
		String hql="from Dx_RecAddress where UserId=(:userid)";
		Query query=getSession().createQuery(hql).setParameter("userid", userid);
		return query.list();
	}

}
