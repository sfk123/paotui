package com.shengping.paotui.handler.model;

public class PhoneCode {
	private String phone;//手机号
	private String code;//发送的验证码
	private int count;//验证码发送次数
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
