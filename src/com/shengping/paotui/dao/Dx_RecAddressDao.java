package com.shengping.paotui.dao;

import java.util.List;

import com.shengping.paotui.model.Dx_RecAddress;

public interface Dx_RecAddressDao {
	public int creatAddress(Dx_RecAddress address);
	public List<Dx_RecAddress> getAddressList(int userid);
}
