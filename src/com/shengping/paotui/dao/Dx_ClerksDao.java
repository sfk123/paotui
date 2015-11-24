package com.shengping.paotui.dao;

import com.shengping.paotui.model.Dx_Clerks;

public interface Dx_ClerksDao {
	public int register(Dx_Clerks clerk);
	public Dx_Clerks login(String username,String pwd);
	public void update(Dx_Clerks clerk);
	public int updateStatus(int status,int pusherid);
	public boolean testPhone(String phone);
}
