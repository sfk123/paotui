package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_Member {
	//用户表
	private int M_ID;
	private int M_UserType;//用户类型
	private String M_UserName;//用户名
	private String M_TjUserName;
	private String M_PsW;//密码
	private String M_PayWord;//支付密码
	private int M_UserState;//状态
	private double M_XfMoney;
	private double M_SYMoney;//账号余额
	private int M_SYPoint;
	private int M_GradeId;
	private String M_RealName;//真实姓名
	private String M_IDCode;
	private String M_ZFBCode;
	private String M_BankName;
	private String M_BankCode;
	private String M_Email;
	private String M_Mobile;//手机号
	private String M_Phone;
	private String M_QQ;
	private String M_WangWang;
	private int M_Sex;//性别
	private Date M_Birthday;//生日
	private int M_ProvinceId;//省份
	private int M_CityId;//城市
	private int M_DistrictId;//县区
	private String M_Address;
	private String M_Zip;
	private Date M_CreateTime;//注册时间
	private Date M_LastTime;
	private int M_LoginCount;//登录次数
	private String M_PwdQuestion;
	private String M_PwdAnswer;
	private int M_IsJTYH;
	private String M_WxOpenId;
	private double M_WXTJYJ;
	private String areaid;//跑腿公司城市编码
	private String M_img;
	private String token;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getM_ID() {
		return M_ID;
	}
	public void setM_ID(int m_ID) {
		M_ID = m_ID;
	}
	public int getM_UserType() {
		return M_UserType;
	}
	public void setM_UserType(int m_UserType) {
		M_UserType = m_UserType;
	}
	public String getM_UserName() {
		return M_UserName;
	}
	public void setM_UserName(String m_UserName) {
		M_UserName = m_UserName;
	}
	public String getM_TjUserName() {
		return M_TjUserName;
	}
	public void setM_TjUserName(String m_TjUserName) {
		M_TjUserName = m_TjUserName;
	}
	public String getM_PsW() {
		return M_PsW;
	}
	public void setM_PsW(String m_PsW) {
		M_PsW = m_PsW;
	}
	public String getM_PayWord() {
		return M_PayWord;
	}
	public void setM_PayWord(String m_PayWord) {
		M_PayWord = m_PayWord;
	}
	public int getM_UserState() {
		return M_UserState;
	}
	public void setM_UserState(int m_UserState) {
		M_UserState = m_UserState;
	}
	public double getM_XfMoney() {
		return M_XfMoney;
	}
	public void setM_XfMoney(double m_XfMoney) {
		M_XfMoney = m_XfMoney;
	}
	public double getM_SYMoney() {
		return M_SYMoney;
	}
	public void setM_SYMoney(double m_SYMoney) {
		M_SYMoney = m_SYMoney;
	}
	public int getM_SYPoint() {
		return M_SYPoint;
	}
	public void setM_SYPoint(int m_SYPoint) {
		M_SYPoint = m_SYPoint;
	}
	public int getM_GradeId() {
		return M_GradeId;
	}
	public void setM_GradeId(int m_GradeId) {
		M_GradeId = m_GradeId;
	}
	public String getM_RealName() {
		return M_RealName;
	}
	public void setM_RealName(String m_RealName) {
		M_RealName = m_RealName;
	}
	public String getM_IDCode() {
		return M_IDCode;
	}
	public void setM_IDCode(String m_IDCode) {
		M_IDCode = m_IDCode;
	}
	public String getM_ZFBCode() {
		return M_ZFBCode;
	}
	public void setM_ZFBCode(String m_ZFBCode) {
		M_ZFBCode = m_ZFBCode;
	}
	public String getM_BankName() {
		return M_BankName;
	}
	public void setM_BankName(String m_BankName) {
		M_BankName = m_BankName;
	}
	public String getM_BankCode() {
		return M_BankCode;
	}
	public void setM_BankCode(String m_BankCode) {
		M_BankCode = m_BankCode;
	}
	public String getM_Email() {
		return M_Email;
	}
	public void setM_Email(String m_Email) {
		M_Email = m_Email;
	}
	public String getM_Mobile() {
		return M_Mobile;
	}
	public void setM_Mobile(String m_Mobile) {
		M_Mobile = m_Mobile;
	}
	public String getM_Phone() {
		return M_Phone;
	}
	public void setM_Phone(String m_Phone) {
		M_Phone = m_Phone;
	}
	public String getM_QQ() {
		return M_QQ;
	}
	public void setM_QQ(String m_QQ) {
		M_QQ = m_QQ;
	}
	public String getM_WangWang() {
		return M_WangWang;
	}
	public void setM_WangWang(String m_WangWang) {
		M_WangWang = m_WangWang;
	}
	public int getM_Sex() {
		return M_Sex;
	}
	public void setM_Sex(int m_Sex) {
		M_Sex = m_Sex;
	}
	public Date getM_Birthday() {
		return M_Birthday;
	}
	public void setM_Birthday(Date m_Birthday) {
		M_Birthday = m_Birthday;
	}
	public int getM_ProvinceId() {
		return M_ProvinceId;
	}
	public void setM_ProvinceId(int m_ProvinceId) {
		M_ProvinceId = m_ProvinceId;
	}
	public int getM_CityId() {
		return M_CityId;
	}
	public void setM_CityId(int m_CityId) {
		M_CityId = m_CityId;
	}
	public int getM_DistrictId() {
		return M_DistrictId;
	}
	public void setM_DistrictId(int m_DistrictId) {
		M_DistrictId = m_DistrictId;
	}
	public String getM_Address() {
		return M_Address;
	}
	public void setM_Address(String m_Address) {
		M_Address = m_Address;
	}
	public String getM_Zip() {
		return M_Zip;
	}
	public void setM_Zip(String m_Zip) {
		M_Zip = m_Zip;
	}
	public Date getM_CreateTime() {
		return M_CreateTime;
	}
	public void setM_CreateTime(Date m_CreateTime) {
		M_CreateTime = m_CreateTime;
	}
	public Date getM_LastTime() {
		return M_LastTime;
	}
	public void setM_LastTime(Date m_LastTime) {
		M_LastTime = m_LastTime;
	}
	public int getM_LoginCount() {
		return M_LoginCount;
	}
	public void setM_LoginCount(int m_LoginCount) {
		M_LoginCount = m_LoginCount;
	}
	public String getM_PwdQuestion() {
		return M_PwdQuestion;
	}
	public void setM_PwdQuestion(String m_PwdQuestion) {
		M_PwdQuestion = m_PwdQuestion;
	}
	public String getM_PwdAnswer() {
		return M_PwdAnswer;
	}
	public void setM_PwdAnswer(String m_PwdAnswer) {
		M_PwdAnswer = m_PwdAnswer;
	}
	public int getM_IsJTYH() {
		return M_IsJTYH;
	}
	public void setM_IsJTYH(int m_IsJTYH) {
		M_IsJTYH = m_IsJTYH;
	}
	public String getM_WxOpenId() {
		return M_WxOpenId;
	}
	public void setM_WxOpenId(String m_WxOpenId) {
		M_WxOpenId = m_WxOpenId;
	}
	public double getM_WXTJYJ() {
		return M_WXTJYJ;
	}
	public void setM_WXTJYJ(double m_WXTJYJ) {
		M_WXTJYJ = m_WXTJYJ;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getM_img() {
		return M_img;
	}
	public void setM_img(String m_img) {
		M_img = m_img;
	}
	@Transient
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
