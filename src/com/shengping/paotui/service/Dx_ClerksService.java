package com.shengping.paotui.service;

import java.util.List;

import com.shengping.paotui.model.Dx_Clerks;

public interface Dx_ClerksService {

	public int register(Dx_Clerks clerk);
	public Dx_Clerks login(String username,String pwd,String pushTag);
	public int updateStatus(int status,int pusherid);
	public int updateStatus(int status,String phone);
	public boolean testPhone(String phone);
	public List<Dx_Clerks> getOnlineOfBusiness(int businessid);
	public void logout(int userid);
}
