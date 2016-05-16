package com.yinbro.tc.pojo;

public class CapsuleBean {
	int id;
	int safeStrategy;
	String key;
	String wxopenid;
	String putTime;
	String preOpenTime;
	String actOpenTime;
	String preShowText;
	String content;
	String subject;
	String qrImgUrl;


	public String getQrImgUrl() {
		return qrImgUrl;
	}

	public void setQrImgUrl(String qrImgUrl) {
		this.qrImgUrl = qrImgUrl;
	}

	// 是否阅后即焚
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

	public String getPutTime() {
		return putTime;
	}

	public void setPutTime(String putTime) {
		this.putTime = putTime;
	}

	public String getPreOpenTime() {
		return preOpenTime;
	}

	public void setPreOpenTime(String preOpenTime) {
		this.preOpenTime = preOpenTime;
	}

	public String getActOpenTime() {
		return actOpenTime;
	}

	public void setActOpenTime(String actOpenTime) {
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


	
	
}
