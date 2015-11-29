package com.shengping.paotui.dao;

import com.shengping.paotui.model.Dx_ChildShops;

public interface Dx_ChildShopsDao {
	public int shopRegister(Dx_ChildShops shop);
	public Dx_ChildShops Login(String name,String pwd);
	public Dx_ChildShops getById(int id);
	public int updateLogo(String logoname,int id);
	public int setTime(int id,String time);
	public int setAddress(int id,String address,String latlong);
	public int setPhone(int id,String phone);
	public boolean ResetPwd(int id,String old,String newpwd);
	public int setStatus(int id,int status);
	public int setCardInfo(int id,String oner,String cardnumber,String bankaddress);
	public boolean testPhone(String phone);
	public void setPushTag(String tag,int userid);
	public void logout(String phone);
}
