package com.shengping.paotui.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shengping.paotui.dao.Dx_GoodsDao;
import com.shengping.paotui.model.Dx_Goods;
@Repository
public class Dx_GoodsDaoImpl implements Dx_GoodsDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public int add(Dx_Goods good) {
		// TODO Auto-generated method stub
		return (Integer)getSession().save(good);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dx_Goods> getGoodByType(int classid) {
		String hql="from Dx_Goods where ClassId=? and IsOnline=1 and Isdelete=0 order by orderindex desc";
		Query query=getSession().createQuery(hql).setInteger(0, classid);
		return query.list();
	}
	@Override
	public Dx_Goods getByid(int id) {
		String hql="from Dx_Goods where goodsId=? ";
		Query query=getSession().createQuery(hql).setInteger(0, id);
		return (Dx_Goods)query.uniqueResult();
	}
	@Override
	public void updateGood(Dx_Goods good) {
		// TODO Auto-generated method stub
		getSession().update(good);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Dx_Goods> getGoods_undercarriage(int shopid,List<Integer> classids) {
		String sql="from Dx_Goods where ClassId in (:ids) and IsOnline=(:online) and Isdelete=(:delete)";
		Query query=getSession().createQuery(sql).setParameterList("ids", classids).setParameter("online", 0).setParameter("delete", 0);
		return query.list();
	}

}
