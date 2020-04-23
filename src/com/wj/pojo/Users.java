package com.wj.pojo;

import java.util.Date;

public class Users {
     private String cardid;//���֤
     private String name;//����
     private int gender;//�Ա�
     private Date createtime;//����ʱ��
     private String password;//����
     private int status;//״̬��Ϣ
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Users(String cardid, String name, int gender, Date createtime, String password, int status) {
		super();
		this.cardid = cardid;
		this.name = name;
		this.gender = gender;
		this.createtime = createtime;
		this.password = password;
		this.status = status;
	}
	
	public Users(String cardid, String name, int gender, Date createtime, String password) {
		super();
		this.cardid = cardid;
		this.name = name;
		this.gender = gender;
		this.createtime = createtime;
		this.password = password;
	}
	public Users() {
		super();
	}
     
}
