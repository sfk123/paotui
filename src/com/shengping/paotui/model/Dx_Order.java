package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_Order {
//������
	private int id;
	private int UserId;//�û�ID (Dx_Member.M_ID)
	private String OrderNumber;//������
	private Date CreateTime;//�µ�ʱ��
	private int GoodsJF;//����
	private double GoodsMoney;//��Ʒ�ܶ�
	private double ALLGoodsCount;//��Ʒ����
	private double GoodsYf;//��Ʒ�˷�
	private int UseDHJF;
	private double UseDHJE;
	private double UserDJZK;
	private double PayMoney;//�����ܶ�
	private int PayJF;
	private int FwType;//��������  1��ʳ 2������ 3������4
	private int Qrzt;
	private int FKzt;//���ʽ  0�������� ��1�Ѿ�֧��
	private Date Fktime;//����ʱ��
	private int Djzt;
	private int PSYID;//���ȸ�id��Dx_Clerks.CL_ID��
	private String  Areaid;//���ȹ�˾���б���
	private String useridd;
	private int Chick;
	private double BaoZhuang;//��װ��
	private int OrderIsOk;//����״̬
	private String Ordercontent;//������ע
	private int addressid;//�ջ���ַ
	/**
	 * ���·�����ַ  �����͵��õ�
	 */
	private String StartAddress;//������ַ
	private String StartAddress_detail;//������ַ��ϸ
	private String StartLocation;//������ַ����
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
