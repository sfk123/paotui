package com.shengping.paotui.dao;

import java.util.List;

import com.shengping.paotui.model.Dx_Clerks;

public interface Dx_ClerksDao {
	public int register(Dx_Clerks clerk);
	public Dx_Clerks login(String username,String pwd);
	public void update(Dx_Clerks clerk);
	public int updateStatus(int status,int pusherid);
	public boolean testPhone(String phone);
	public void setPushTag(String tag,int userid);
	public List<Dx_Clerks> getOnlineOfBusiness(int businessid);
}
