package com.wsbank.Client.Bean;

public class CommonRequestBean {
	
	private CommonRequestHeadBean head;
	private Object body;
	
	public CommonRequestHeadBean getHead() {
		return head;
	}
	public void setHead(CommonRequestHeadBean head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}

}

