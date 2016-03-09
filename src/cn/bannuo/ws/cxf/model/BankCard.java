package cn.bannuo.ws.cxf.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_bankcard")
public class BankCard {

	// ��Ա��
	private String memberNo;
	// ���п���
	private String bankCard;
	// ���д���
	private String bankCode;
	// ��������
	private String cardType;
	// ���ÿ���Ч��
	private String validDate;
	// ���ÿ�����λ
	private String cvn;
	// ֤����
	private String idNo;
	// ֤��������
	private String idType;
	// �û�����
	private String name;
	// �ֻ���
	private String phoneNo;
	
	@Id
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
	
}

