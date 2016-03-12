package com.wsbank.Client.Bean.BankCardBind;

import com.wsbank.Client.Bean.CommonRepsonseBean;

public class BankCardBindResponse extends CommonRepsonseBean {
	public BankCardBindRepsonseBodyBean getBody() {
		return body;
	}
	public void setBody(BankCardBindRepsonseBodyBean body) {
		this.body = body;
	}
	private BankCardBindRepsonseBodyBean body;

}
