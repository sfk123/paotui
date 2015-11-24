package com.shengping.paotui.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_RecAddress {
//�û��ջ���ַ��
	private int Id;
	private int UserId;//�û����(Dx_Member.M_ID)
	private String RealName;//����
	private int ProvinceId;//
	private int CityId;
	private int DistrictId;
	private String Address;
	private String Zip;
	private String Phone;
	private String Mobile;
	private String QQ;
	private int OrderIndex;//����
	private String sGPRS;//�ջ�����
	private String sdizhi;//�ջ���ַ
	private String sAddress;//��ϸ��ַ
	private String jtgj;//��ͨ����
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getRealName() {
		return RealName;
	}
	public void setRealName(String realName) {
		RealName = realName;
	}
	public int getProvinceId() {
		return ProvinceId;
	}
	public void setProvinceId(int provinceId) {
		ProvinceId = provinceId;
	}
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public int getDistrictId() {
		return DistrictId;
	}
	public void setDistrictId(int districtId) {
		DistrictId = districtId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getZip() {
		return Zip;
	}
	public void setZip(String zip) {
		Zip = zip;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public int getOrderIndex() {
		return OrderIndex;
	}
	public void setOrderIndex(int orderIndex) {
		OrderIndex = orderIndex;
	}
	public String getsGPRS() {
		return sGPRS;
	}
	public void setsGPRS(String sGPRS) {
		this.sGPRS = sGPRS;
	}
	public String getSdizhi() {
		return sdizhi;
	}
	public void setSdizhi(String sdizhi) {
		this.sdizhi = sdizhi;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	public String getJtgj() {
		return jtgj;
	}
	public void setJtgj(String jtgj) {
		this.jtgj = jtgj;
	}
	
}
