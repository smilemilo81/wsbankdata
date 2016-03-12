package com.wsbank.Client.Bean.transQry;

import java.util.List;

public class transQryRepsonseBodyBean {
	private String retcode;
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
	public String getTotalrecs() {
		return totalrecs;
	}
	public void setTotalrecs(String totalrecs) {
		this.totalrecs = totalrecs;
	}
	public String getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(String totalpage) {
		this.totalpage = totalpage;
	}
	public List<transBean> getTransList() {
		return transList;
	}
	public void setTransList(List<transBean> transList) {
		this.transList = transList;
	}
	private String retshow;
	private String totalrecs;
	private String totalpage;
	private List<transBean> transList;

}
