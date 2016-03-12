package com.wsbank.Client.Bean.thirdCardCollect;

public class thirdCardCollectBean {
	private String memberNo;
	private String bankCard;
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public String getOutTradeNo() {
		return outTradeNo;
	}
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	private String outTradeNo;
	private String amt;
	private String currencyType;
	private String remark;
	
	public thirdCardCollectBean()
	{
		memberNo="";
		bankCard="";
		outTradeNo="";
		amt="";
		currencyType="";
		remark="";

	}

}
