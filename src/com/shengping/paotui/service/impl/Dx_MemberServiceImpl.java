package com.shengping.paotui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shengping.paotui.dao.Dx_MemberDao;
import com.shengping.paotui.model.Dx_Member;
import com.shengping.paotui.service.Dx_MemberService;
import com.shengping.paotui.util.MyUtil;

@Service
public class Dx_MemberServiceImpl implements Dx_MemberService{

	@Autowired
	private Dx_MemberDao dx_MemberDao;
	@Override
	public int register(Dx_Member member) {
		// TODO Auto-generated method stub
		return dx_MemberDao.register(member);
	}
	@Override
	public boolean testPhone(String phone) {
		// TODO Auto-generated method stub
		return dx_MemberDao.testPhone(phone);
	}
	@Override
	public Dx_Member Login(String phone, String pwd) {
		Dx_Member member=dx_MemberDao.getByPhone(phone);
		if(MyUtil.stringToMD5(member.getM_PsW()).equals(pwd)){
			return member;
		}
		return null;
	}
	@Override
	public Dx_Member getByPhone(String phone) {
		// TODO Auto-generated method stub
		return dx_MemberDao.getByPhone(phone);
	}

}
