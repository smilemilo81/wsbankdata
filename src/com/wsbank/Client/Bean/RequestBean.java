package com.wsbank.Client.Bean;

public class RequestBean {
	
	private RequestHeadBean head;
	private Object body;
	
	public RequestHeadBean getHead() {
		return head;
	}
	public void setHead(RequestHeadBean head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}

}

