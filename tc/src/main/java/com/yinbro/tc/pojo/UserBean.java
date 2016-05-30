package com.yinbro.tc.pojo;

public class UserBean {
	int id;   //用户id
	int gender;  //用户性别
	String name;  //用户名
	String password; //用户密码
	String showMsg;  //展示信息
	String tele;     	//
	String wxopenid;  //微信openid
	String email;   //邮箱
	String wxname;  //微信名称
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShowMsg() {
		return showMsg;
	}
	public void setShowMsg(String showMsg) {
		this.showMsg = showMsg;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getWxopenid() {
		return wxopenid;
	}
	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWxname() {
		return wxname;
	}
	public void setWxname(String wxname) {
		this.wxname = wxname;
	}
	@Override
	public String toString() {
		return "UserBean [name=" + name + ", id=" + id + ", gender=" + gender + ", password=" + password + ", showMsg="
				+ showMsg + ", tele=" + tele + ", wxopenid=" + wxopenid + ", email=" + email + ", wxname=" + wxname
				+ "]";
	}
	
	
}
