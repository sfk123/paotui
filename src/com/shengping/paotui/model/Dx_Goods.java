package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_Goods {

	private int goodsId;
	private int ClassId;//分类ID(Dx_ClassTable.C_ID)
	private String ClassPathType;
	private int BrandID;
	private String Title;//商品名称
	private String ABC;
	private String NKeys ;//关键词
	private String NDes;//摘要
	private String GoodsCode;//编码
	private double GoodsMarkPrice;//销售价格
	private double GoodsPrice;
	private double GoodsCxPrice;
	private double GoodsTGPrice;
	private double GoodsMSPrice;
	private Date CXStime;
	private Date CXEtime;
	private String GoodsMaxPic;//商品图片
	private String GoodsMinPic;
	private String GoodsVoide;
	private int SellCount;//销售量
	private int ViewCount;//点击量
	private int goodsKc;
	private int goodsWeight;
	private String WxDes;
	private String Des;
	private int IsOnline;//是否上架  1上架  0下架
	private String DefaultTj;
	private int Isdelete;//是否删除  1删除   0正常
	private Date CreateTime;//添加时间
	private int adminId;
	private int orderindex;
	private String GoodsPropetty;
	private String GoodsPrices;//详情
	private int IsUsePriceGroup;
	private int GoodsSellState;
	private String Units;//单位
	private double JiTuanPrice;
	private int DHPoint;
	private String Areaid;//跑腿公司城市编码
	private int userid;
	private String bigimg;//大图
	private double BZF;//包装费
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	public String getClassPathType() {
		return ClassPathType;
	}
	public void setClassPathType(String classPathType) {
		ClassPathType = classPathType;
	}
	public int getBrandID() {
		return BrandID;
	}
	public void setBrandID(int brandID) {
		BrandID = brandID;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getABC() {
		return ABC;
	}
	public void setABC(String aBC) {
		ABC = aBC;
	}
	public String getNKeys() {
		return NKeys;
	}
	public void setNKeys(String nKeys) {
		NKeys = nKeys;
	}
	public String getNDes() {
		return NDes;
	}
	public void setNDes(String nDes) {
		NDes = nDes;
	}
	public String getGoodsCode() {
		return GoodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		GoodsCode = goodsCode;
	}
	public double getGoodsMarkPrice() {
		return GoodsMarkPrice;
	}
	public void setGoodsMarkPrice(double goodsMarkPrice) {
		GoodsMarkPrice = goodsMarkPrice;
	}
	public double getGoodsPrice() {
		return GoodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		GoodsPrice = goodsPrice;
	}
	public double getGoodsCxPrice() {
		return GoodsCxPrice;
	}
	public void setGoodsCxPrice(double goodsCxPrice) {
		GoodsCxPrice = goodsCxPrice;
	}
	public double getGoodsTGPrice() {
		return GoodsTGPrice;
	}
	public void setGoodsTGPrice(double goodsTGPrice) {
		GoodsTGPrice = goodsTGPrice;
	}
	public double getGoodsMSPrice() {
		return GoodsMSPrice;
	}
	public void setGoodsMSPrice(double goodsMSPrice) {
		GoodsMSPrice = goodsMSPrice;
	}
	public Date getCXStime() {
		return CXStime;
	}
	public void setCXStime(Date cXStime) {
		CXStime = cXStime;
	}
	public Date getCXEtime() {
		return CXEtime;
	}
	public void setCXEtime(Date cXEtime) {
		CXEtime = cXEtime;
	}
	public String getGoodsMaxPic() {
		return GoodsMaxPic;
	}
	public void setGoodsMaxPic(String goodsMaxPic) {
		GoodsMaxPic = goodsMaxPic;
	}
	public String getGoodsMinPic() {
		return GoodsMinPic;
	}
	public void setGoodsMinPic(String goodsMinPic) {
		GoodsMinPic = goodsMinPic;
	}
	public String getGoodsVoide() {
		return GoodsVoide;
	}
	public void setGoodsVoide(String goodsVoide) {
		GoodsVoide = goodsVoide;
	}
	public int getSellCount() {
		return SellCount;
	}
	public void setSellCount(int sellCount) {
		SellCount = sellCount;
	}
	public int getViewCount() {
		return ViewCount;
	}
	public void setViewCount(int viewCount) {
		ViewCount = viewCount;
	}
	public int getGoodsKc() {
		return goodsKc;
	}
	public void setGoodsKc(int goodsKc) {
		this.goodsKc = goodsKc;
	}
	public int getGoodsWeight() {
		return goodsWeight;
	}
	public void setGoodsWeight(int goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	public String getWxDes() {
		return WxDes;
	}
	public void setWxDes(String wxDes) {
		WxDes = wxDes;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	public int getIsOnline() {
		return IsOnline;
	}
	public void setIsOnline(int isOnline) {
		IsOnline = isOnline;
	}
	public String getDefaultTj() {
		return DefaultTj;
	}
	public void setDefaultTj(String defaultTj) {
		DefaultTj = defaultTj;
	}
	public int getIsdelete() {
		return Isdelete;
	}
	public void setIsdelete(int isdelete) {
		Isdelete = isdelete;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getOrderindex() {
		return orderindex;
	}
	public void setOrderindex(int orderindex) {
		this.orderindex = orderindex;
	}
	public String getGoodsPropetty() {
		return GoodsPropetty;
	}
	public void setGoodsPropetty(String goodsPropetty) {
		GoodsPropetty = goodsPropetty;
	}
	public String getGoodsPrices() {
		return GoodsPrices;
	}
	public void setGoodsPrices(String goodsPrices) {
		GoodsPrices = goodsPrices;
	}
	public int getIsUsePriceGroup() {
		return IsUsePriceGroup;
	}
	public void setIsUsePriceGroup(int isUsePriceGroup) {
		IsUsePriceGroup = isUsePriceGroup;
	}
	public int getGoodsSellState() {
		return GoodsSellState;
	}
	public void setGoodsSellState(int goodsSellState) {
		GoodsSellState = goodsSellState;
	}
	public String getUnits() {
		return Units;
	}
	public void setUnits(String units) {
		Units = units;
	}
	public double getJiTuanPrice() {
		return JiTuanPrice;
	}
	public void setJiTuanPrice(double jiTuanPrice) {
		JiTuanPrice = jiTuanPrice;
	}
	public int getDHPoint() {
		return DHPoint;
	}
	public void setDHPoint(int dHPoint) {
		DHPoint = dHPoint;
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
	public String getBigimg() {
		return bigimg;
	}
	public void setBigimg(String bigimg) {
		this.bigimg = bigimg;
	}
	public double getBZF() {
		return BZF;
	}
	public void setBZF(double bZF) {
		BZF = bZF;
	}
	
}
