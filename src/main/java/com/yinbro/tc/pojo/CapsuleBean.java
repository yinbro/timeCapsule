package com.yinbro.tc.pojo;

import java.sql.Timestamp;

public class CapsuleBean {
	int id;
	String key;
	int userid;
	Timestamp putTime;
	Timestamp preOpenTime;
	Timestamp actOpenTime;
	String preShowText;
	String content;
	//是否阅后即焚
	boolean isSnap;

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public Timestamp getPutTime() {
		return putTime;
	}



	public void setPutTime(Timestamp putTime) {
		this.putTime = putTime;
	}



	public Timestamp getPreOpenTime() {
		return preOpenTime;
	}



	public void setPreOpenTime(Timestamp preOpenTime) {
		this.preOpenTime = preOpenTime;
	}



	public Timestamp getActOpenTime() {
		return actOpenTime;
	}



	public void setActOpenTime(Timestamp actOpenTime) {
		this.actOpenTime = actOpenTime;
	}



	public String getPreShowText() {
		return preShowText;
	}



	public void setPreShowText(String preShowText) {
		this.preShowText = preShowText;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public boolean isSnap() {
		return isSnap;
	}



	public void setSnap(boolean isSnap) {
		this.isSnap = isSnap;
	}



	@Override
	public String toString() {
		return "CapsuleBean [id=" + id + ", key=" + key + ", userid=" + userid + ", putTime=" + putTime
				+ ", preOpenTime=" + preOpenTime + ", actOpenTime=" + actOpenTime + ", preShowText=" + preShowText
				+ ", content=" + content + ", isSnap=" + isSnap + "]";
	}

	
	
}
