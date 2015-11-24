package com.shengping.paotui.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_MemberDao;
import com.shengping.paotui.model.Dx_Member;
@Repository
public class Dx_MemberDaoImpl implements Dx_MemberDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int register(Dx_Member member) {
		// TODO Auto-generated method stub
		return (Integer)getSession().save(member);
	}
	@Override
	public boolean testPhone(String phone) {
		String hql="from Dx_Member where M_Mobile=?";
		Query query=getSession().createQuery(hql).setString(0, phone);
		if(query.list().size()>0){
			return false;
		}
		return true;
	}
	@Override
	public Dx_Member getByPhone(String phone) {
		String hql="from Dx_Member where M_Mobile=?";
		Query query=getSession().createQuery(hql).setString(0, phone);
		return (Dx_Member)query.uniqueResult();
	}

}
