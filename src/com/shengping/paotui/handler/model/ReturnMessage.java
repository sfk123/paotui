package com.shengping.paotui.handler.model;

public class ReturnMessage {
	public boolean status;//ִ��״̬  true�ɹ�   falseʧ��
	public String message;//������ʾ
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
