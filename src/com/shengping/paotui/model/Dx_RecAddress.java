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
//�û��ջ���ַ��
	private int Id;
	@NotNull(message="�û���Ų���Ϊ��")
	private int UserId;//�û����(Dx_Member.M_ID)
	@NotBlank(message="��������Ϊ��")
	private String RealName;//����
	private int ProvinceId;//
	private int CityId;
	private int DistrictId;
	@NotBlank(message="�ջ���ַ����Ϊ��")
	private String Address;//�ջ���ַ
	private String Zip;
	@NotBlank(message="�ֻ�����Ϊ��")
	private String Mobile;//�ֻ�
	private String QQ;
	private int OrderIndex;//����
	@NotBlank(message="���겻��Ϊ��")
	private String sGPRS;//�ջ�����
	@NotBlank(message="�Ա���Ϊ��")
	private String sex;//������Ůʿ
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
