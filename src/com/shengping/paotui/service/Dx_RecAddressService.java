package com.shengping.paotui.service;

import java.util.List;

import com.shengping.paotui.model.Dx_RecAddress;

public interface Dx_RecAddressService {
	public int creatAddress(Dx_RecAddress address);
	public List<Dx_RecAddress> getAddressList(int userid);
	public Dx_RecAddress getDefaultAddress(int userid);
}
