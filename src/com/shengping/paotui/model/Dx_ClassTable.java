package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_ClassTable {
//商家产品分类表
	private int C_ID;
	private String C_Title;//名称
	private int C_ParentId;
	private String C_PathTree;
	private String C_Unit;
	private String C_ConfigIsUseByList;
	private String C_Brands;
	private String C_Prices;
	private int C_NewsTypeId;//商家ID(Dx_ChildShops.MD_ID)
	private String C_NewsPathTree;
	private int C_OrderIndex;//排序
	private int C_IsDelete;//是否删除
	private int C_AdminId;
	private Date C_CreateTime;
	private String Areaid;//跑腿公司城市编码
	private int userid;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getC_ID() {
		return C_ID;
	}
	public void setC_ID(int c_ID) {
		C_ID = c_ID;
	}
	public String getC_Title() {
		return C_Title;
	}
	public void setC_Title(String c_Title) {
		C_Title = c_Title;
	}
	public int getC_ParentId() {
		return C_ParentId;
	}
	public void setC_ParentId(int c_ParentId) {
		C_ParentId = c_ParentId;
	}
	public String getC_PathTree() {
		return C_PathTree;
	}
	public void setC_PathTree(String c_PathTree) {
		C_PathTree = c_PathTree;
	}
	public String getC_Unit() {
		return C_Unit;
	}
	public void setC_Unit(String c_Unit) {
		C_Unit = c_Unit;
	}
	public String getC_ConfigIsUseByList() {
		return C_ConfigIsUseByList;
	}
	public void setC_ConfigIsUseByList(String c_ConfigIsUseByList) {
		C_ConfigIsUseByList = c_ConfigIsUseByList;
	}
	public String getC_Brands() {
		return C_Brands;
	}
	public void setC_Brands(String c_Brands) {
		C_Brands = c_Brands;
	}
	public String getC_Prices() {
		return C_Prices;
	}
	public void setC_Prices(String c_Prices) {
		C_Prices = c_Prices;
	}
	public int getC_NewsTypeId() {
		return C_NewsTypeId;
	}
	public void setC_NewsTypeId(int c_NewsTypeId) {
		C_NewsTypeId = c_NewsTypeId;
	}
	public String getC_NewsPathTree() {
		return C_NewsPathTree;
	}
	public void setC_NewsPathTree(String c_NewsPathTree) {
		C_NewsPathTree = c_NewsPathTree;
	}
	public int getC_OrderIndex() {
		return C_OrderIndex;
	}
	public void setC_OrderIndex(int c_OrderIndex) {
		C_OrderIndex = c_OrderIndex;
	}
	public int getC_IsDelete() {
		return C_IsDelete;
	}
	public void setC_IsDelete(int c_IsDelete) {
		C_IsDelete = c_IsDelete;
	}
	public int getC_AdminId() {
		return C_AdminId;
	}
	public void setC_AdminId(int c_AdminId) {
		C_AdminId = c_AdminId;
	}
	public Date getC_CreateTime() {
		return C_CreateTime;
	}
	public void setC_CreateTime(Date c_CreateTime) {
		C_CreateTime = c_CreateTime;
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
	
}
