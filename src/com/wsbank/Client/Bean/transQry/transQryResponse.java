package com.wsbank.Client.Bean.transQry;

import com.wsbank.Client.Bean.CommonRepsonseBean;

public class transQryResponse extends CommonRepsonseBean{
	private transQryRepsonseBodyBean body;

	public transQryRepsonseBodyBean getBody() {
		return body;
	}

	public void setBody(transQryRepsonseBodyBean body) {
		this.body = body;
	}

}
