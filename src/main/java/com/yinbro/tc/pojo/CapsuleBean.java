package com.yinbro.tc.pojo;

import java.sql.Timestamp;

public class CapsuleBean {
	int id;
	int safeStrategy;
	String key;
	String wxopenid;
	Timestamp putTime;
	Timestamp preOpenTime;
	Timestamp actOpenTime;
	
	String preShowText;
	String content;
	String subject;
	//是否阅后即焚
	boolean isSnap;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSafeStrategy() {
		return safeStrategy;
	}
	public void setSafeStrategy(int safeStrategy) {
		this.safeStrategy = safeStrategy;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getWxopenid() {
		return wxopenid;
	}
	public void setWxopenid(String wxopenid) {
		this.wxopenid = wxopenid;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public boolean isSnap() {
		return isSnap;
	}
	public void setSnap(boolean isSnap) {
		this.isSnap = isSnap;
	}
	@Override
	public String toString() {
		return "CapsuleBean [id=" + id + ", safeStrategy=" + safeStrategy + ", key=" + key + ", wxopenid=" + wxopenid
				+ ", putTime=" + putTime + ", preOpenTime=" + preOpenTime + ", actOpenTime=" + actOpenTime
				+ ", preShowText=" + preShowText + ", content=" + content + ", subject=" + subject + ", isSnap="
				+ isSnap + "]";
	}

	
	
}
