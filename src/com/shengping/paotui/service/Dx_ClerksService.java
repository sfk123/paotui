package com.shengping.paotui.service;

import com.shengping.paotui.model.Dx_Clerks;

public interface Dx_ClerksService {

	public int register(Dx_Clerks clerk);
	public Dx_Clerks login(String username,String pwd);
	public int updateStatus(int status,int pusherid);
	public boolean testPhone(String phone);
}
