package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_youhui {
//�Ż�ȯ��
	private int id;
	private String Yh_bianma;//�Ż�ȯ����
	private double Yh_jine;//���
	private Date Yh_addtime;//���ʱ��
	private String areaid;//���ȹ�˾���б���
	private int passed;//�Ƿ�һ�  0δ�һ�  1�Ѷһ�
	private int daysum;//��������
	private int userid;//�����û�
	private int businessid;//�������ȹ�˾
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
