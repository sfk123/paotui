package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_youhui {
//优惠券表
	private int id;
	private String Yh_bianma;//优惠券编码
	private double Yh_jine;//金额
	private Date Yh_addtime;//添加时间
	private String areaid;//跑腿公司城市编码
	private int passed;//是否兑换  0未兑换  1已兑换
	private int daysum;//到期天数
	private int userid;//所属用户
	private int businessid;//所属跑腿公司
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYh_bianma() {
		return Yh_bianma;
	}
	public void setYh_bianma(String yh_bianma) {
		Yh_bianma = yh_bianma;
	}
	public double getYh_jine() {
		return Yh_jine;
	}
	public void setYh_jine(double yh_jine) {
		Yh_jine = yh_jine;
	}
	public Date getYh_addtime() {
		return Yh_addtime;
	}
	public void setYh_addtime(Date yh_addtime) {
		Yh_addtime = yh_addtime;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public int getPassed() {
		return passed;
	}
	public void setPassed(int passed) {
		this.passed = passed;
	}
	public int getDaysum() {
		return daysum;
	}
	public void setDaysum(int daysum) {
		this.daysum = daysum;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	
}
