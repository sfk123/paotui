package com.shengping.paotui.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Dx_pl {
//���۱�
	private int id;
	private int Pl_type;//1�̼�  2��Ʒ 3����Ա 4�������
	private int Pl_id;//��Ӧid
	private String Pl_content;//��������
	private Date Pl_addtime;//����ʱ��
	private String Areaid;//���ȹ�˾���б���
	private int userid;//�û�id
	private int Target_id;//����Ŀ��id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "persistenceGenerator", strategy = "increment") 
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPl_type() {
		return Pl_type;
	}
	public void setPl_type(int pl_type) {
		Pl_type = pl_type;
	}
	public int getPl_id() {
		return Pl_id;
	}
	public void setPl_id(int pl_id) {
		Pl_id = pl_id;
	}
	public String getPl_content() {
		return Pl_content;
	}
	public void setPl_content(String pl_content) {
		Pl_content = pl_content;
	}
	public Date getPl_addtime() {
		return Pl_addtime;
	}
	public void setPl_addtime(Date pl_addtime) {
		Pl_addtime = pl_addtime;
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
	public int getTarget_id() {
		return Target_id;
	}
	public void setTarget_id(int target_id) {
		Target_id = target_id;
	}
	
}
