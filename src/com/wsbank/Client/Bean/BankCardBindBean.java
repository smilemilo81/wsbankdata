package com.wsbank.Client.Bean;

public class BankCardBindBean {

	// 会员号
	private String memberNo;
	// 银行卡号
	private String bankCard;
	// 银行代码
	private String bankCode;
	// 卡号类型
	private String cardType;
	// 信用卡有效期
	public String validDate;
	// 信用卡后三位
	public String cvn;
	// 证件号
	private String idNo;
	// 证件号类型
	private String idType;
	// 用户姓名
	private String name;
	// 手机号
	private String phoneNo;

	
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

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getCvn() {
		return cvn;
	}

	public void setCvn(String cvn) {
		this.cvn = cvn;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public BankCardBindBean() {
		memberNo = "";
		bankCard = "";
		bankCode = "";
		cardType = "";
		validDate = "";
		cvn = "";
		idNo = "";
		idType = "";
		name = "";
		phoneNo = "";
	}

}
