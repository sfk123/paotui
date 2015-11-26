package com.shengping.paotui.service;

/**
 * ����û��ķǷ���½
 * @author Administrator
 *
 */
public interface ApplicationService {
	public boolean  checkTokenOfShop(String token);
	public void addToken_Shop(String username,String token);
	public void ShopLogOut(String username);
	public void addRandomCode(String uuid,String code);
	public boolean testRandomCode(String uuid,String code);
	public void removeRandomCode(String uuid);
	public boolean sendPhoneCode(String phone,String code);
	public void removePhoneCode(String phone);
	public boolean testPhoneCode(String phone,String code);
	public void removeMapKey(String key,String map);
	public String getPushMasterSecret();
	public String getPushAppKey();
}
