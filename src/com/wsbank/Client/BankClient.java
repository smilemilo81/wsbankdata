package com.wsbank.Client;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.uxun.net.webservice.CommonClient;
import com.wsbank.Client.Bean.*;

public class BankClient {

	@SuppressWarnings("unused")
	private ConfigBean _config;
	private CommonClient _client;

	public BankClient() {
		Util util = new Util();
		_config = util.LoadConfig();
		_client = CommonClient.getInstance();
	}

	public Object SendRequest(int ServiceSign, Object body, Object repsonse) {
		String ServiceName = "";
		switch (ServiceSign) {
		case 1:
			// 卡号绑定
			ServiceName = "bankCardBind";
			break;
		case 2:
			// 他行卡代收
			ServiceName = "thirdCardCollect";
			break;
		case 3:
			// 交易流水查询
			ServiceName = "transQry";
			break;
		default:
			return null;
		}
		XStream xstream = new XStream();
		xstream.alias("body", body.getClass());
		String bodydata = xstream.toXML(body);
		String sign = Util.signEncode(bodydata,
				_config.getClientPrivateKeyFile(), _config.getEncodKey());

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		RequestHeadBean head = new RequestHeadBean();
		// 版本号
		head.setVersion("1.0");
		// 渠道类型(默认005互联网)
		head.setTranchannel("005");
		// 时间
		head.setTrandatetime(df.format(date));
		// 认证码
		head.setAuthcode("0112");
		// 请求流水号
		head.setReqsn("CP" + df.format(date));
		// 后台服务方法
		head.setServicename(ServiceName);
		// 设备号(非空值即可)
		head.setDevno("123");
		// 签名
		head.setSignData(sign);
		// 接入方商户号(默认)
		head.setCustNo("101142000218162");

		RequestBean req = new RequestBean();
		req.setHead(head);
		req.setBody(body);

		try {
			_client.init(_config.getNamespace(), _config.getPath(),
					_config.getAesKey(), _config.getAesIv(),
					_config.getSource());
			return _client.common(1, "request", req,
					BankCardBindRepsonseBean.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {

		BankCardBindBean body = new BankCardBindBean();
		BankCardBindRepsonseBean reponse = new BankCardBindRepsonseBean();
		// 会员号
		body.setMemberNo("znwowy");
		// 银行卡号
		body.setBankCard("6214968210500285982");
		// 银行代码(默认447)
		body.setBankCode("447");
		// 卡号类型
		body.setCardType("0");
		// 证件号
		body.setIdNo("62010219790609081x");
		// 证件号类型
		body.setIdType("01");
		// 用户姓名
		body.setName("张三");
		// 手机号
		body.setPhoneNo("13809310304");
		

		BankClient bc = new BankClient();
		// 1
		reponse = (BankCardBindRepsonseBean) bc.SendRequest(1, body, reponse);
	}

}
