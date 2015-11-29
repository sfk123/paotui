package com.shengping.paotui.service;

import java.util.List;

/**
 * 监控用户的非法登陆以及验证码的检验
 * @author Administrator
 *
 */
public interface ApplicationService {
	public String  checkTokenOfShop(String token);
	public boolean  checkTokenOfCustomer(String token);
	public String  checkTokenOfPusher(String token);
	public void addToken_Shop(String username,String token);
	public void addToken_Customer(String username,String token);
	public void addToken_Pusher(String username,String token);
	public void ShopLogOut(String username);
	public void CustomerLogOut(String username);
	public void PusherLogOut(String username);
	public void addRandomCode(String uuid,String code);
	public boolean testRandomCode(String uuid,String code);
	public void removeRandomCode(String uuid);
	public boolean sendPhoneCode(String phone,String code);
	public void removePhoneCode(String phone);
	public boolean testPhoneCode(String phone,String code);
	public void removeMapKey(String key,String map);
	public void applicationStop();
	public String getOrderNumber();
	public void JPush(List<String> alias,String content);
}
