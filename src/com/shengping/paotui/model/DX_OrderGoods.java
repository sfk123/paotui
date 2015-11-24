package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class DX_OrderGoods {
//订单商品表
	private int id;
	private int OrderId;//订单号
	private int GoodsId;//商品ID(Dx_Goods.GoodsId)
	private String GoodsName;//商品名称
	private String GoodsSX;
	private double GoodsCount;//数量
	private double GoodsPrice;//价格
	private double GoodsPriceSum;//总价
	private int GoodsJF;
	private int GoodsJFSum;
	private String PL_Contents;
	private int PL_DJ;
	private Date PL_CreateTime;
	private int IsDH;
	private int GoodsSellState;
	private int StoreID;//商家ID （Dx_ChildShops.MD_ID）
	private double StoreZK;
	private double StorePSF;
	private String Areaid;//跑腿公司城市编码
	private double BaoZhuang;//包装费
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getGoodsId() {
		return GoodsId;
	}
	public void setGoodsId(int goodsId) {
		GoodsId = goodsId;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public String getGoodsSX() {
		return GoodsSX;
	}
	public void setGoodsSX(String goodsSX) {
		GoodsSX = goodsSX;
	}
	public double getGoodsCount() {
		return GoodsCount;
	}
	public void setGoodsCount(double goodsCount) {
		GoodsCount = goodsCount;
	}
	public double getGoodsPrice() {
		return GoodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		GoodsPrice = goodsPrice;
	}
	public double getGoodsPriceSum() {
		return GoodsPriceSum;
	}
	public void setGoodsPriceSum(double goodsPriceSum) {
		GoodsPriceSum = goodsPriceSum;
	}
	public int getGoodsJF() {
		return GoodsJF;
	}
	public void setGoodsJF(int goodsJF) {
		GoodsJF = goodsJF;
	}
	public int getGoodsJFSum() {
		return GoodsJFSum;
	}
	public void setGoodsJFSum(int goodsJFSum) {
		GoodsJFSum = goodsJFSum;
	}
	public String getPL_Contents() {
		return PL_Contents;
	}
	public void setPL_Contents(String pL_Contents) {
		PL_Contents = pL_Contents;
	}
	public int getPL_DJ() {
		return PL_DJ;
	}
	public void setPL_DJ(int pL_DJ) {
		PL_DJ = pL_DJ;
	}
	public Date getPL_CreateTime() {
		return PL_CreateTime;
	}
	public void setPL_CreateTime(Date pL_CreateTime) {
		PL_CreateTime = pL_CreateTime;
	}
	public int getIsDH() {
		return IsDH;
	}
	public void setIsDH(int isDH) {
		IsDH = isDH;
	}
	public int getGoodsSellState() {
		return GoodsSellState;
	}
	public void setGoodsSellState(int goodsSellState) {
		GoodsSellState = goodsSellState;
	}
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeID) {
		StoreID = storeID;
	}
	public double getStoreZK() {
		return StoreZK;
	}
	public void setStoreZK(double storeZK) {
		StoreZK = storeZK;
	}
	public double getStorePSF() {
		return StorePSF;
	}
	public void setStorePSF(double storePSF) {
		StorePSF = storePSF;
	}
	public String getAreaid() {
		return Areaid;
	}
	public void setAreaid(String areaid) {
		Areaid = areaid;
	}
	public double getBaoZhuang() {
		return BaoZhuang;
	}
	public void setBaoZhuang(double baoZhuang) {
		BaoZhuang = baoZhuang;
	}
	
}
