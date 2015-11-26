package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Dx_Clerks {
//�����ȸ��
	private int CL_ID;
	@NotEmpty(message="��ʵ��������Ϊ��")
	private String CL_Name;//����
	@NotEmpty(message="�绰����Ϊ��")
	private String CL_Tell;//�绰
	@Email(message="�����ʽ����")
	private String CL_Email;//����
	@NotEmpty(message="������벻��Ϊ��")
	private String CL_Address;//���ڵ�������
	private double CL_Mony;
	private String CL_HanYe;//��ҵ
	private Date CL_AddTime;//ע��ʱ��
	private String CL_AreaID;//���ȹ�˾���б���
	@NotEmpty(message="���֤�Ų���Ϊ��")
	private String CL_Number;//���֤����
	private String CL_HZPhoto;//�ֳ����֤
	private String CL_ZMPhoto;//���֤����
	private String CL_FMPhoto;//���֤����
	private String CL_WorkPhoto;//����֤��Ƭ
	@NotNull(message="ע�����Ͳ���Ϊ��")
	private int CL_Type;//����  0����Ա 1����ʦ��
	@NotNull(message="��ͨ���߲���Ϊ��")
	private String CL_ISJiaoTong;//��ͨ����
	@NotNull(message="������ϵ�˲���Ϊ��")
	private String CL_LianName;//������ϵ��
	@NotNull(message="������ϵ�˵绰����Ϊ��")
	private String CL_LianMobil;//������ϵ�˵绰
	private String CL_LoginName;//
	private String CL_LoginPassword;//��¼����
	private String CL_NumId;//����
	private int userid;//�������ȹ�˾
	@NotNull(message="״̬����Ϊ��")
	private int CL_State;//״̬ ����1/����0
	@NotNull(message="��ѡ��ȫְ���ְ")
	private int CL_Zhiwei;//ְλ ȫְ1/��ְ0
	private String token;//��½��Ĳ������� ���˳��� ��������Ϊ��,�����ݿ��ֶΣ�
	private String pushTag;//�������ͱ�ʶ
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getCL_ID() {
		return CL_ID;
	}
	public void setCL_ID(int cL_ID) {
		CL_ID = cL_ID;
	}
	
	public String getCL_Name() {
		return CL_Name;
	}
	public void setCL_Name(String cL_Name) {
		CL_Name = cL_Name;
	}
	
	public String getCL_Tell() {
		return CL_Tell;
	}
	public void setCL_Tell(String cL_Tell) {
		CL_Tell = cL_Tell;
	}
	
	public String getCL_Email() {
		return CL_Email;
	}
	public void setCL_Email(String cL_Email) {
		CL_Email = cL_Email;
	}
	
	public String getCL_Address() {
		return CL_Address;
	}
	public void setCL_Address(String cL_Address) {
		CL_Address = cL_Address;
	}
	public double getCL_Mony() {
		return CL_Mony;
	}
	public void setCL_Mony(double cL_Mony) {
		CL_Mony = cL_Mony;
	}
	public String getCL_HanYe() {
		return CL_HanYe;
	}
	public void setCL_HanYe(String cL_HanYe) {
		CL_HanYe = cL_HanYe;
	}
	public Date getCL_AddTime() {
		return CL_AddTime;
	}
	public void setCL_AddTime(Date cL_AddTime) {
		CL_AddTime = cL_AddTime;
	}
	public String getCL_AreaID() {
		return CL_AreaID;
	}
	public void setCL_AreaID(String cL_AreaID) {
		CL_AreaID = cL_AreaID;
	}
	
	public String getCL_Number() {
		return CL_Number;
	}
	public void setCL_Number(String cL_Number) {
		CL_Number = cL_Number;
	}
	public String getCL_HZPhoto() {
		return CL_HZPhoto;
	}
	public void setCL_HZPhoto(String cL_HZPhoto) {
		CL_HZPhoto = cL_HZPhoto;
	}
	public String getCL_ZMPhoto() {
		return CL_ZMPhoto;
	}
	public void setCL_ZMPhoto(String cL_ZMPhoto) {
		CL_ZMPhoto = cL_ZMPhoto;
	}
	public String getCL_FMPhoto() {
		return CL_FMPhoto;
	}
	public void setCL_FMPhoto(String cL_FMPhoto) {
		CL_FMPhoto = cL_FMPhoto;
	}
	public String getCL_WorkPhoto() {
		return CL_WorkPhoto;
	}
	public void setCL_WorkPhoto(String cL_WorkPhoto) {
		CL_WorkPhoto = cL_WorkPhoto;
	}
	public int getCL_Type() {
		return CL_Type;
	}
	public void setCL_Type(int cL_Type) {
		CL_Type = cL_Type;
	}
	
	public String getCL_ISJiaoTong() {
		return CL_ISJiaoTong;
	}
	public void setCL_ISJiaoTong(String cL_ISJiaoTong) {
		CL_ISJiaoTong = cL_ISJiaoTong;
	}
	
	public String getCL_LianName() {
		return CL_LianName;
	}
	public void setCL_LianName(String cL_LianName) {
		CL_LianName = cL_LianName;
	}
	
	public String getCL_LianMobil() {
		return CL_LianMobil;
	}
	public void setCL_LianMobil(String cL_LianMobil) {
		CL_LianMobil = cL_LianMobil;
	}
	public String getCL_LoginName() {
		return CL_LoginName;
	}
	public void setCL_LoginName(String cL_LoginName) {
		CL_LoginName = cL_LoginName;
	}
	public String getCL_LoginPassword() {
		return CL_LoginPassword;
	}
	public void setCL_LoginPassword(String cL_LoginPassword) {
		CL_LoginPassword = cL_LoginPassword;
	}
	public String getCL_NumId() {
		return CL_NumId;
	}
	public void setCL_NumId(String cL_NumId) {
		CL_NumId = cL_NumId;
	}
	public int getCL_State() {
		return CL_State;
	}
	public void setCL_State(int cL_State) {
		CL_State = cL_State;
	}
	
	public int getCL_Zhiwei() {
		return CL_Zhiwei;
	}
	public void setCL_Zhiwei(int cL_Zhiwei) {
		CL_Zhiwei = cL_Zhiwei;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
