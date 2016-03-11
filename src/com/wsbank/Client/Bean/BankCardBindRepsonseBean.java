package com.wsbank.Client.Bean;

public class BankCardBindRepsonseBean {
	
	// 返回码
	private String retcode;
	// 异常提示
	private String retshow;
	// 会员号
	private String memberNo;
	// 绑定卡号
	private String bankCard;
	
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	public String getRetshow() {
		return retshow;
	}
	public void setRetshow(String retshow) {
		this.retshow = retshow;
	}
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

}
