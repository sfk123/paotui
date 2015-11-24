package com.shengping.paotui.dao;

import com.shengping.paotui.model.Dx_Member;

public interface Dx_MemberDao {
	public boolean testPhone(String phone);
	public int register(Dx_Member member);
	public Dx_Member getByPhone(String phone);
}
