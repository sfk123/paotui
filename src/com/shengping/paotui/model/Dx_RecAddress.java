package com.shengping.paotui.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Dx_RecAddress {
//用户收货地址表
	private int Id;
	@NotNull(message="用户编号不能为空")
	private int UserId;//用户编号(Dx_Member.M_ID)
	@NotBlank(message="姓名不能为空")
	private String RealName;//姓名
	private int ProvinceId;//
	private int CityId;
	private int DistrictId;
	@NotBlank(message="收货地址不能为空")
	private String Address;//收货地址
	private String Zip;
	@NotBlank(message="手机不能为空")
	private String Mobile;//手机
	private String QQ;
	private int OrderIndex;//排序
	@NotBlank(message="坐标不能为空")
	private String sGPRS;//收货坐标
	@NotBlank(message="性别不能为空")
	private String sex;//先生或女士
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
