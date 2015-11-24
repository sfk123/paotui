package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dt_SysConfig {
	//跑腿公司基本表
	private int id;
	private String title;//公司名称
	private String keywords;//关键词
	private String  description;//描述
	private String shoufei;//年费
	private String areaid;//跑腿公司城市编码
	private int userid;
	private int MRGLS;//默认公里数
	private double LJPTF;//超出每公里费用
	private String CompanyName;//公司名称
	private String KeFuTell;//客服电话
	private String YinYeTime;//营业时间
	private String SanPTF;//
	private double qibujia;//起步价
	private String tianqi;//天气情况
	private double tianqifei;//天气费用
	private double Youhui;//每单优惠金额
	private Date Youhui_time;//优惠到期时间
	private String midnight_time;//午夜服务时间{"start":"23:00","end":"4:00"}
	private double midnight_cost;//午夜服务费
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShoufei() {
		return shoufei;
	}
	public void setShoufei(String shoufei) {
		this.shoufei = shoufei;
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
	public int getMRGLS() {
		return MRGLS;
	}
	public void setMRGLS(int mRGLS) {
		MRGLS = mRGLS;
	}
	public double getLJPTF() {
		return LJPTF;
	}
	public void setLJPTF(double lJPTF) {
		LJPTF = lJPTF;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getKeFuTell() {
		return KeFuTell;
	}
	public void setKeFuTell(String keFuTell) {
		KeFuTell = keFuTell;
	}
	public String getYinYeTime() {
		return YinYeTime;
	}
	public void setYinYeTime(String yinYeTime) {
		YinYeTime = yinYeTime;
	}
	public String getSanPTF() {
		return SanPTF;
	}
	public void setSanPTF(String sanPTF) {
		SanPTF = sanPTF;
	}
	public double getQibujia() {
		return qibujia;
	}
	public void setQibujia(double qibujia) {
		this.qibujia = qibujia;
	}
	public String getTianqi() {
		return tianqi;
	}
	public void setTianqi(String tianqi) {
		this.tianqi = tianqi;
	}
	public double getTianqifei() {
		return tianqifei;
	}
	public void setTianqifei(double tianqifei) {
		this.tianqifei = tianqifei;
	}
	public double getYouhui() {
		return Youhui;
	}
	public void setYouhui(double youhui) {
		Youhui = youhui;
	}
	public Date getYouhui_time() {
		return Youhui_time;
	}
	public void setYouhui_time(Date youhui_time) {
		Youhui_time = youhui_time;
	}
	public String getMidnight_time() {
		return midnight_time;
	}
	public void setMidnight_time(String midnight_time) {
		this.midnight_time = midnight_time;
	}
	public double getMidnight_cost() {
		return midnight_cost;
	}
	public void setMidnight_cost(double midnight_cost) {
		this.midnight_cost = midnight_cost;
	}
	
}
