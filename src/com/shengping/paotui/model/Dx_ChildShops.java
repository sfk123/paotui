package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_ChildShops {
//商家基本信息表
	private int MD_ID;
	private String MD_Title;//商家名称
	private String MD_Address;//商家地址
	private int MD_IsDelete=0;//是否删除  1已删除  0正常
	private Date MD_CreateTime;//创建时间
	private String MD_Phone;//商家电话
	private String MD_Images;//商家图片
	private String MD_Maps;//商家折扣
	private int MD_Type;//行业大类 0美食 1宠物  2超市 3水果 4情趣店 5鲜花  6酒柜 7 药房
	private double MD_PSF;
	private String MD_YYSJ;//营业时间
	private String MD_Area;//城市编码
	private int MD_ISTJ=1;//是否营业  0歇业/1营业
	private int MD_OrderIndex;//排序
	private int MD_CTXJ;//星级
	private String MD_CTLB;//餐厅类别 1中餐 2西餐 3面食4小吃 5甜点 6饮品(以,分割)
	private String MD_CTXZ;//餐厅性质   1早餐 2正餐 3夜宵
	private String Areaid;//跑腿公司城市编码
	private int userid;
	private int MD_GLS;
	private double MD_MRPTF;
	private double MD_CHF;
	private String MD_LoName;//商家用户名
	private String MD_LoPawss;//商家密码
	private String MD_LoEMail;
	private String MD_Longitude;
	private int MD_Clearing;
	private String MD_Bank;//开户行名称
	private String MD_BankNumber;//银行卡号
	private String MD_BankName;//账号名称
	private double MD_BankTell=0;//营业额
	private double MD_KeTiXian=0;//可提现金额度
	private String MD_GPRS;//商家坐标
	private float MD_SALE;//销售数量
	private int status=0;//商家状态  0审核  1通过
	private String realname;//商家联系人
	private String hotline;//服务热线
	private String token;//登陆后的操作令牌 （退出后 设置令牌为空,非数据库字段）
	private String pushTag;//极光推送标识
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getMD_ID() {
		return MD_ID;
	}
	public void setMD_ID(int mD_ID) {
		MD_ID = mD_ID;
	}
	public String getMD_Title() {
		return MD_Title;
	}
	public void setMD_Title(String mD_Title) {
		MD_Title = mD_Title;
	}
	public String getMD_Address() {
		return MD_Address;
	}
	public void setMD_Address(String mD_Address) {
		MD_Address = mD_Address;
	}
	public int getMD_IsDelete() {
		return MD_IsDelete;
	}
	public void setMD_IsDelete(int mD_IsDelete) {
		MD_IsDelete = mD_IsDelete;
	}
	public Date getMD_CreateTime() {
		return MD_CreateTime;
	}
	public void setMD_CreateTime(Date mD_CreateTime) {
		MD_CreateTime = mD_CreateTime;
	}
	public String getMD_Phone() {
		return MD_Phone;
	}
	public void setMD_Phone(String mD_Phone) {
		MD_Phone = mD_Phone;
	}
	public String getMD_Images() {
		return MD_Images;
	}
	public void setMD_Images(String mD_Images) {
		MD_Images = mD_Images;
	}
	public String getMD_Maps() {
		return MD_Maps;
	}
	public void setMD_Maps(String mD_Maps) {
		MD_Maps = mD_Maps;
	}
	public int getMD_Type() {
		return MD_Type;
	}
	public void setMD_Type(int mD_Type) {
		MD_Type = mD_Type;
	}
	public double getMD_PSF() {
		return MD_PSF;
	}
	public void setMD_PSF(double mD_PSF) {
		MD_PSF = mD_PSF;
	}
	public String getMD_YYSJ() {
		return MD_YYSJ;
	}
	public void setMD_YYSJ(String mD_YYSJ) {
		MD_YYSJ = mD_YYSJ;
	}
	public String getMD_Area() {
		return MD_Area;
	}
	public void setMD_Area(String mD_Area) {
		MD_Area = mD_Area;
	}
	public int getMD_ISTJ() {
		return MD_ISTJ;
	}
	public void setMD_ISTJ(int mD_ISTJ) {
		MD_ISTJ = mD_ISTJ;
	}
	public int getMD_OrderIndex() {
		return MD_OrderIndex;
	}
	public void setMD_OrderIndex(int mD_OrderIndex) {
		MD_OrderIndex = mD_OrderIndex;
	}
	public int getMD_CTXJ() {
		return MD_CTXJ;
	}
	public void setMD_CTXJ(int mD_CTXJ) {
		MD_CTXJ = mD_CTXJ;
	}
	public String getMD_CTLB() {
		return MD_CTLB;
	}
	public void setMD_CTLB(String mD_CTLB) {
		MD_CTLB = mD_CTLB;
	}
	public String getMD_CTXZ() {
		return MD_CTXZ;
	}
	public void setMD_CTXZ(String mD_CTXZ) {
		MD_CTXZ = mD_CTXZ;
	}
	public String getAreaid() {
		return Areaid;
	}
	public void setAreaid(String areaid) {
		Areaid = areaid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMD_GLS() {
		return MD_GLS;
	}
	public void setMD_GLS(int mD_GLS) {
		MD_GLS = mD_GLS;
	}
	public double getMD_MRPTF() {
		return MD_MRPTF;
	}
	public void setMD_MRPTF(double mD_MRPTF) {
		MD_MRPTF = mD_MRPTF;
	}
	public double getMD_CHF() {
		return MD_CHF;
	}
	public void setMD_CHF(double mD_CHF) {
		MD_CHF = mD_CHF;
	}
	public String getMD_LoName() {
		return MD_LoName;
	}
	public void setMD_LoName(String mD_LoName) {
		MD_LoName = mD_LoName;
	}
	public String getMD_LoPawss() {
		return MD_LoPawss;
	}
	public void setMD_LoPawss(String mD_LoPawss) {
		MD_LoPawss = mD_LoPawss;
	}
	public String getMD_LoEMail() {
		return MD_LoEMail;
	}
	public void setMD_LoEMail(String mD_LoEMail) {
		MD_LoEMail = mD_LoEMail;
	}
	public String getMD_Longitude() {
		return MD_Longitude;
	}
	public void setMD_Longitude(String mD_Longitude) {
		MD_Longitude = mD_Longitude;
	}
	public int getMD_Clearing() {
		return MD_Clearing;
	}
	public void setMD_Clearing(int mD_Clearing) {
		MD_Clearing = mD_Clearing;
	}
	public String getMD_Bank() {
		return MD_Bank;
	}
	public void setMD_Bank(String mD_Bank) {
		MD_Bank = mD_Bank;
	}
	public String getMD_BankNumber() {
		return MD_BankNumber;
	}
	public void setMD_BankNumber(String mD_BankNumber) {
		MD_BankNumber = mD_BankNumber;
	}
	public String getMD_BankName() {
		return MD_BankName;
	}
	public void setMD_BankName(String mD_BankName) {
		MD_BankName = mD_BankName;
	}
	public double getMD_BankTell() {
		return MD_BankTell;
	}
	public void setMD_BankTell(double mD_BankTell) {
		MD_BankTell = mD_BankTell;
	}
	public double getMD_KeTiXian() {
		return MD_KeTiXian;
	}
	public void setMD_KeTiXian(double mD_KeTiXian) {
		MD_KeTiXian = mD_KeTiXian;
	}
	public String getMD_GPRS() {
		return MD_GPRS;
	}
	public void setMD_GPRS(String mD_GPRS) {
		MD_GPRS = mD_GPRS;
	}
	public float getMD_SALE() {
		return MD_SALE;
	}
	public void setMD_SALE(float mD_SALE) {
		MD_SALE = mD_SALE;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	@Transient
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPushTag() {
		return pushTag;
	}
	public void setPushTag(String pushTag) {
		this.pushTag = pushTag;
	}
	
}
