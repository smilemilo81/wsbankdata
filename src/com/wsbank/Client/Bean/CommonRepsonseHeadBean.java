package com.wsbank.Client.Bean;

public class CommonRepsonseHeadBean {
	private String version;
	private String tranchannel;
	private String trandatetime;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getTranchannel() {
		return tranchannel;
	}
	public void setTranchannel(String tranchannel) {
		this.tranchannel = tranchannel;
	}
	public String getTrandatetime() {
		return trandatetime;
	}
	public void setTrandatetime(String trandatetime) {
		this.trandatetime = trandatetime;
	}
	public String getAuthcode() {
		return authcode;
	}
	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}
	public String getReqsn() {
		return reqsn;
	}
	public void setReqsn(String reqsn) {
		this.reqsn = reqsn;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getDevno() {
		return devno;
	}
	public void setDevno(String devno) {
		this.devno = devno;
	}
	public String getSignData() {
		return signData;
	}
	public void setSignData(String signData) {
		this.signData = signData;
	}
	public String getCustNo() {
		return custNo;
	}
	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}
	private String authcode;
	private String reqsn;
	private String servicename;
	private String devno;
	private String signData;
	private String custNo;

}
