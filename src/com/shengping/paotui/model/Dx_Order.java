package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_Order {
//订单表
	private int id;
	private int UserId;//用户ID (Dx_Member.M_ID)
	private String OrderNumber;//订单号
	private Date CreateTime;//下单时间
	private int GoodsJF;//积分
	private double GoodsMoney;//商品总额
	private double ALLGoodsCount;//商品数量
	private double GoodsYf;//商品运费
	private int UseDHJF;
	private double UseDHJE;
	private double UserDJZK;
	private double PayMoney;//订单总额
	private int PayJF;
	private int FwType;//订单类型  1美食 2帮我买 3帮我送4
	private int Qrzt;
	private int FKzt;//付款方式  0货到付款 、1已经支付
	private Date Fktime;//付款时间
	private int Djzt;
	private int PSYID;//跑腿哥id（Dx_Clerks.CL_ID）
	private String  Areaid;//跑腿公司城市编码
	private String useridd;
	private int Chick;
	private double BaoZhuang;//包装费
	private int OrderIsOk;//订单状态
	private String Ordercontent;//订单备注
	private int addressid;//收货地址
	/**
	 * 以下发货地址  帮我送等用到
	 */
	private String StartAddress;//发货地址
	private String StartAddress_detail;//发货地址详细
	private String StartLocation;//发货地址坐标
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public int getGoodsJF() {
		return GoodsJF;
	}
	public void setGoodsJF(int goodsJF) {
		GoodsJF = goodsJF;
	}
	public double getGoodsMoney() {
		return GoodsMoney;
	}
	public void setGoodsMoney(double goodsMoney) {
		GoodsMoney = goodsMoney;
	}
	public double getALLGoodsCount() {
		return ALLGoodsCount;
	}
	public void setALLGoodsCount(double aLLGoodsCount) {
		ALLGoodsCount = aLLGoodsCount;
	}
	public double getGoodsYf() {
		return GoodsYf;
	}
	public void setGoodsYf(double goodsYf) {
		GoodsYf = goodsYf;
	}
	public int getUseDHJF() {
		return UseDHJF;
	}
	public void setUseDHJF(int useDHJF) {
		UseDHJF = useDHJF;
	}
	public double getUseDHJE() {
		return UseDHJE;
	}
	public void setUseDHJE(double useDHJE) {
		UseDHJE = useDHJE;
	}
	public double getUserDJZK() {
		return UserDJZK;
	}
	public void setUserDJZK(double userDJZK) {
		UserDJZK = userDJZK;
	}
	public double getPayMoney() {
		return PayMoney;
	}
	public void setPayMoney(double payMoney) {
		PayMoney = payMoney;
	}
	public int getPayJF() {
		return PayJF;
	}
	public void setPayJF(int payJF) {
		PayJF = payJF;
	}
	public int getFwType() {
		return FwType;
	}
	public void setFwType(int fwType) {
		FwType = fwType;
	}
	public int getQrzt() {
		return Qrzt;
	}
	public void setQrzt(int qrzt) {
		Qrzt = qrzt;
	}
	public int getFKzt() {
		return FKzt;
	}
	public void setFKzt(int fKzt) {
		FKzt = fKzt;
	}
	public Date getFktime() {
		return Fktime;
	}
	public void setFktime(Date fktime) {
		Fktime = fktime;
	}
	public int getDjzt() {
		return Djzt;
	}
	public void setDjzt(int djzt) {
		Djzt = djzt;
	}
	public int getPSYID() {
		return PSYID;
	}
	public void setPSYID(int pSYID) {
		PSYID = pSYID;
	}
	public String getAreaid() {
		return Areaid;
	}
	public void setAreaid(String areaid) {
		Areaid = areaid;
	}
	public String getUseridd() {
		return useridd;
	}
	public void setUseridd(String useridd) {
		this.useridd = useridd;
	}
	public int getChick() {
		return Chick;
	}
	public void setChick(int chick) {
		Chick = chick;
	}
	public double getBaoZhuang() {
		return BaoZhuang;
	}
	public void setBaoZhuang(double baoZhuang) {
		BaoZhuang = baoZhuang;
	}
	public int getOrderIsOk() {
		return OrderIsOk;
	}
	public void setOrderIsOk(int orderIsOk) {
		OrderIsOk = orderIsOk;
	}
	public String getOrdercontent() {
		return Ordercontent;
	}
	public void setOrdercontent(String ordercontent) {
		Ordercontent = ordercontent;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getStartAddress() {
		return StartAddress;
	}
	public void setStartAddress(String startAddress) {
		StartAddress = startAddress;
	}
	public String getStartAddress_detail() {
		return StartAddress_detail;
	}
	public void setStartAddress_detail(String startAddress_detail) {
		StartAddress_detail = startAddress_detail;
	}
	public String getStartLocation() {
		return StartLocation;
	}
	public void setStartLocation(String startLocation) {
		StartLocation = startLocation;
	}
	
}
