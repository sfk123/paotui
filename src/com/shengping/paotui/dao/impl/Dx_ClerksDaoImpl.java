package com.shengping.paotui.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_ClerksDao;
import com.shengping.paotui.model.Dx_ChildShops;
import com.shengping.paotui.model.Dx_Clerks;
import com.shengping.paotui.util.MyUtil;
@Repository
public class Dx_ClerksDaoImpl implements Dx_ClerksDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int register(Dx_Clerks clerk) {
		// TODO Auto-generated method stub
		return (Integer)getSession().save(clerk);
	}
	@Override
	public Dx_Clerks login(String username, String pwd) {
		String hql="from Dx_Clerks where CL_LoginName=?";
		Query query=getSession().createQuery(hql).setString(0, username);
		Object result=query.uniqueResult();
		if(result==null)
			return null;
		else{
			Dx_Clerks clerks=(Dx_Clerks)result;
			String pwd_db=MyUtil.stringToMD5(clerks.getCL_LoginPassword());
			if(pwd_db.equals(pwd)){
					return clerks;
			}else {
					return null;
			}
		}
	}
	@Override
	public void update(Dx_Clerks clerk) {
		getSession().update(clerk);
	}
	@Override
	public int updateStatus(int status,int pusherid) {
		String hql="update Dx_Clerks set CL_State=? where id=?";
		Query query=getSession().createQuery(hql).setInteger(0, status).setInteger(1, pusherid);
		return query.executeUpdate();
	}
	@Override
	public boolean testPhone(String phone) {
		String hql="from Dx_Clerks where CL_Tell=?";
		Query query=getSession().createQuery(hql).setString(0, phone);
		if(query.list().size()>0){
			return false;
		}
		return true;
	}

}
