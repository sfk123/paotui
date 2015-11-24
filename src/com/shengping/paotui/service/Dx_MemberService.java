package com.shengping.paotui.service;

import com.shengping.paotui.model.Dx_Member;

public interface Dx_MemberService {
	public int register(Dx_Member member);
	public boolean testPhone(String phone);
	public Dx_Member Login(String phone,String pwd);
	public Dx_Member getByPhone(String phone);
}
