package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_PTContext {
//加盟表
	private int P_ID;
	private String P_Type;//类型    =加盟
	private String P_RealName;//联系人
	private String P_Tel;//电话
	private String P_QHAddress;//地址
	private String P_SHRName;//公司名字
	private String P_SHRHotLine;//服务热线
	private String P_SHRTime;//营业时间
	private String P_SHREmail;//邮箱
	private String P_Des;//备注
	private Date P_CreateTime;//提交时间
	private int P_IsDetail;//
	private int P_AdminID;
	private double P_Money;
	private String areaid;
	private int userid;
	private int Click;
	private int P_LeiXing;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getP_ID() {
		return P_ID;
	}
	public void setP_ID(int p_ID) {
		P_ID = p_ID;
	}
	public String getP_Type() {
		return P_Type;
	}
	public void setP_Type(String p_Type) {
		P_Type = p_Type;
	}
	public String getP_RealName() {
		return P_RealName;
	}
	public void setP_RealName(String p_RealName) {
		P_RealName = p_RealName;
	}
	public String getP_Tel() {
		return P_Tel;
	}
	public void setP_Tel(String p_Tel) {
		P_Tel = p_Tel;
	}
	public String getP_QHAddress() {
		return P_QHAddress;
	}
	public void setP_QHAddress(String p_QHAddress) {
		P_QHAddress = p_QHAddress;
	}
	public String getP_SHRName() {
		return P_SHRName;
	}
	public void setP_SHRName(String p_SHRName) {
		P_SHRName = p_SHRName;
	}
	public String getP_SHRHotLine() {
		return P_SHRHotLine;
	}
	public void setP_SHRHotLine(String p_SHRHotLine) {
		P_SHRHotLine = p_SHRHotLine;
	}
	public String getP_SHRTime() {
		return P_SHRTime;
	}
	public void setP_SHRTime(String p_SHRTime) {
		P_SHRTime = p_SHRTime;
	}
	public String getP_SHREmail() {
		return P_SHREmail;
	}
	public void setP_SHREmail(String p_SHREmail) {
		P_SHREmail = p_SHREmail;
	}
	public String getP_Des() {
		return P_Des;
	}
	public void setP_Des(String p_Des) {
		P_Des = p_Des;
	}
	public Date getP_CreateTime() {
		return P_CreateTime;
	}
	public void setP_CreateTime(Date p_CreateTime) {
		P_CreateTime = p_CreateTime;
	}
	public int getP_IsDetail() {
		return P_IsDetail;
	}
	public void setP_IsDetail(int p_IsDetail) {
		P_IsDetail = p_IsDetail;
	}
	public int getP_AdminID() {
		return P_AdminID;
	}
	public void setP_AdminID(int p_AdminID) {
		P_AdminID = p_AdminID;
	}
	public double getP_Money() {
		return P_Money;
	}
	public void setP_Money(double p_Money) {
		P_Money = p_Money;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getClick() {
		return Click;
	}
	public void setClick(int click) {
		Click = click;
	}
	public int getP_LeiXing() {
		return P_LeiXing;
	}
	public void setP_LeiXing(int p_LeiXing) {
		P_LeiXing = p_LeiXing;
	}
	
}
