package com.shengping.paotui.dao.impl;

import java.util.List;

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
	public int updateStatus(int status,String phone) {
		String hql="update Dx_Clerks set CL_State=? where CL_LoginName=?";
		Query query=getSession().createQuery(hql).setInteger(0, status).setString(1, phone);
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
	@Override
	public void setPushTag(String tag,int userid) {
		String hql="update Dx_Clerks set pushTag=? where CL_ID=?";
		Query query=getSession().createQuery(hql).setString(0, tag).setInteger(1, userid);
		query.executeUpdate();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dx_Clerks> getOnlineOfBusiness(int businessid) {
		String hql="from Dx_Clerks where CL_State=(:state) and userid=(:businessid)";
		Query query=getSession().createQuery(hql).setParameter("state", 1).setParameter("businessid", businessid);
		return query.list();
	}
	@Override
	public void logout(int userid) {//ÅÜÍÈ¸çÍË³ö
		String hql="update Dx_Clerks set pushTag=(:tag) ,CL_State=(:state) where CL_ID=(:id)";
		Query query=getSession().createQuery(hql).setString("tag", "").setParameter("state", 0).setParameter("id", userid);
		query.executeUpdate();
	}

}
