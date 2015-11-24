package com.shengping.paotui.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_ChildShopsDao;
import com.shengping.paotui.model.Dx_ChildShops;
import com.shengping.paotui.util.MyUtil;
@Repository
public class Dx_ChildShopsDaoImpl implements Dx_ChildShopsDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int shopRegister(Dx_ChildShops shop) {
		
		return (Integer)getSession().save(shop);
	}
	@Override
	public Dx_ChildShops Login(String name, String pwd) {
		String hql="from Dx_ChildShops where MD_LoName=?";
		Query query=getSession().createQuery(hql).setString(0, name);
		Object result=query.uniqueResult();
		if(result==null)
		return null;
		else{
			Dx_ChildShops shop=(Dx_ChildShops)result;
			String pwd_db=MyUtil.stringToMD5(shop.getMD_LoPawss());
			if(pwd_db.equals(pwd)){
				return shop;
			}else {
				return null;
			}
		}
	}
	@Override
	public Dx_ChildShops getById(int id) {
		String hql="from Dx_ChildShops where MD_ID=?";
		Query query=getSession().createQuery(hql).setInteger(0, id);
		Object result=query.uniqueResult();
		if(result!=null){
			return (Dx_ChildShops)result;
		}
		return null;
	}
	@Override
	public int updateLogo(String logoname,int id) {
		String hql="update Dx_ChildShops set MD_Images=? where MD_ID=?";
		Query query=getSession().createQuery(hql).setString(0, logoname).setInteger(1, id);
		return query.executeUpdate();
	}
	@Override
	public int setTime(int id, String time) {
		String hql="update Dx_ChildShops set MD_YYSJ=? where MD_ID=?";
		Query query=getSession().createQuery(hql).setString(0, time).setInteger(1, id);
		return query.executeUpdate();
	}
	@Override
	public int setAddress(int id, String address, String latlong) {
		String hql="update Dx_ChildShops set MD_Address=?,MD_GPRS=? where MD_ID=?";
		Query query=getSession().createQuery(hql).setString(0, address).setString(1, latlong).setInteger(2, id);
		return query.executeUpdate();
	}
	@Override
	public int setPhone(int id, String phone) {
		String hql="update Dx_ChildShops set hotline=? where MD_ID=?";
		Query query=getSession().createQuery(hql).setString(0, phone).setInteger(1, id);
		return query.executeUpdate();
	}
	@Override
	public boolean ResetPwd(int id, String old, String newpwd) {
		Dx_ChildShops shop= getById(id);
		if(shop==null){
			return false;
		}else{
			if(MyUtil.stringToMD5(shop.getMD_LoPawss()).equals(old)){
				String hql="update Dx_ChildShops set MD_LoPawss=? where MD_ID=?";
				Query query=getSession().createQuery(hql).setString(0, newpwd).setInteger(1, id);
				if(query.executeUpdate()!=1){
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	@Override
	public int setStatus(int id, int status) {
		String hql="update Dx_ChildShops set MD_ISTJ=? where MD_ID=?";
		Query query=getSession().createQuery(hql).setInteger(0, status).setInteger(1, id);
		return query.executeUpdate();
	}
	@Override
	public int setCardInfo(int id, String oner, String cardnumber,
			String bankaddress) {
		if(bankaddress==null)
			bankaddress="";
		String hql="update Dx_ChildShops set MD_BankName=?,MD_BankNumber=?,MD_Bank=? where MD_ID=?";
		Query query=getSession().createQuery(hql).setString(0, oner).setString(1, cardnumber).setString(2, bankaddress).setInteger(3, id);
		return query.executeUpdate();
	}
	@Override
	public boolean testPhone(String phone) {
		String hql="from Dx_ChildShops where MD_Phone=?";
		Query query=getSession().createQuery(hql).setString(0, phone);
		if(query.list().size()>0){
			return false;
		}
		return true;
	}
	

}
