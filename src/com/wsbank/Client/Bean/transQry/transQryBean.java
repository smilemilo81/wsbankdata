package com.wsbank.Client.Bean.transQry;

public class transQryBean {

	private String memberNo;
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPageindex() {
		return pageindex;
	}
	public void setPageindex(String pageindex) {
		this.pageindex = pageindex;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	private String outTradeNo;
	private String tradeType;
	private String beginTime;
	private String endTime;
	private String pageindex;
	private String pagesize;
	
	public transQryBean()
	{
		memberNo="";
		outTradeNo="";
		tradeType="";
		beginTime="";
		endTime="";
		pageindex="";
		pagesize="";

	}

}
