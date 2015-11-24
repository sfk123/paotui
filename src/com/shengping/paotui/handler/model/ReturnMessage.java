package com.shengping.paotui.handler.model;

public class ReturnMessage {
	public boolean status;//执行状态  true成功   false失败
	public String message;//返回提示
	public Object data;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
