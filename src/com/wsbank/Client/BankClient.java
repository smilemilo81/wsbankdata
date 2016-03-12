package com.wsbank.Client;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.XStream;
import com.uxun.net.webservice.CommonClient;
import com.wsbank.Client.Bean.*;
import com.wsbank.Client.Bean.BankCardBind.BankCardBindBean;
import com.wsbank.Client.Bean.BankCardBind.BankCardBindResponse;
import com.wsbank.Client.Bean.thirdCardCollect.thirdCardCollectBean;
import com.wsbank.Client.Bean.thirdCardCollect.thirdCardCollectResponse;
import com.wsbank.Client.Bean.transQry.transQryBean;
import com.wsbank.Client.Bean.transQry.transQryResponse;

public class BankClient {

	private ConfigBean _config;
	private CommonClient _client;

	public BankClient() {
		Util util = new Util();
		_config = util.LoadConfig();
		_client = CommonClient.getInstance();
	}

	public Object SendRequest(int ServiceSign, Object body, Class<?> repsonse) {
		String ServiceName = "";
		Object ret=null;
		
		switch (ServiceSign) {
		case 1:
			// 卡号绑定
			ServiceName = "bankCardBind";
			break;
		case 2:
			// 他行卡代收
			ServiceName = "thirdCardCollect";
			break;
		case 4:
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
		CommonRequestHeadBean head = new CommonRequestHeadBean();
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

		CommonRequestBean req = new CommonRequestBean();
		req.setHead(head);
		req.setBody(body);
		
		_client.init(_config.getNamespace(), _config.getPath(),
				_config.getAesKey(), _config.getAesIv(),
				_config.getSource());
		try {
			ret=_client.common(ServiceSign, "uxunmsg", req,repsonse);
			
			CommonRepsonseBean c= (CommonRepsonseBean)ret;
			if (Util.signDecode(c.getHead().getSignData(), xstream.toXML(c.getBody()),_config.getServerPublicKeyFile() ))
			{
				System.out.println("true");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void main(String[] args) {

		BankClient bc = new BankClient();
		
		
		//卡号绑定
		BankCardBindBean body = new BankCardBindBean();
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
		
		System.out.println("开始请求BankCardBind");
		BankCardBindResponse reponse= (BankCardBindResponse) bc.SendRequest(1, body, BankCardBindResponse.class);
		System.out.println("BankCardBind返回:"+reponse.getBody().getRetcode()+","+reponse.getBody().getRetshow());
		
		
		
		//他行卡代收
		thirdCardCollectBean tccBody=new thirdCardCollectBean();
		tccBody.setMemberNo("znwowy");
		tccBody.setBankCard("6214968210500285982");
		tccBody.setOutTradeNo("12456789");
		tccBody.setAmt("100.00");
		tccBody.setCurrencyType("1");
		System.out.println("开始请求thirdCardCollect");
		thirdCardCollectResponse tccResponse=(thirdCardCollectResponse)bc.SendRequest(2, tccBody, thirdCardCollectResponse.class);
		System.out.println("thirdCardCollect返回:"+tccResponse.getBody().getRetcode()+","+tccResponse.getBody().getRetshow());
		
		
		//交易查询
		transQryBean tqBody=new transQryBean();
		tqBody.setBeginTime("20160301");
		tqBody.setEndTime("20160401");
		System.out.println("开始请求transQry");
		transQryResponse tqResponse=(transQryResponse)bc.SendRequest(4, tqBody, transQryResponse.class);
		System.out.println("transQry返回:"+tqResponse.getBody().getRetcode()+","+tqResponse.getBody().getRetshow());
		
		
	}

}
