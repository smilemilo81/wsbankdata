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
			// ���Ű�
			ServiceName = "bankCardBind";
			break;
		case 2:
			// ���п�����
			ServiceName = "thirdCardCollect";
			break;
		case 3:
			// ������ˮ��ѯ
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
		// �汾��
		head.setVersion("1.0");
		// ��������(Ĭ��005������)
		head.setTranchannel("005");
		// ʱ��
		head.setTrandatetime(df.format(date));
		// ��֤��
		head.setAuthcode("0112");
		// ������ˮ��
		head.setReqsn("CP" + df.format(date));
		// ��̨���񷽷�
		head.setServicename(ServiceName);
		// �豸��(�ǿ�ֵ����)
		head.setDevno("123");
		// ǩ��
		head.setSignData(sign);
		// ���뷽�̻���(Ĭ��)
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
		// ��Ա��
		body.setMemberNo("znwowy");
		// ���п���
		body.setBankCard("6214968210500285982");
		// ���д���(Ĭ��447)
		body.setBankCode("447");
		// ��������
		body.setCardType("0");
		// ֤����
		body.setIdNo("62010219790609081x");
		// ֤��������
		body.setIdType("01");
		// �û�����
		body.setName("����");
		// �ֻ���
		body.setPhoneNo("13809310304");
		

		BankClient bc = new BankClient();
		// 1
		reponse = (BankCardBindRepsonseBean) bc.SendRequest(1, body, reponse);
	}

}
