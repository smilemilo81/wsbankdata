package cn.bannuo.ws.cxf.client;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import cn.bannuo.ws.cxf.dao.BankApplicationManager;
import cn.bannuo.ws.cxf.model.BankCard;

public class ApplicationClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/wsbankpayment/ws/bankApplicationManager");
		factory.setServiceClass(BankApplicationManager.class);
		factory.getInInterceptors().add(new LoggingInInterceptor());
		BankApplicationManager service = (BankApplicationManager) factory.create();  
		
		// ģ��ͻ��������˷����󣬲��ԡ����Ű󶨡���
        BankCard bc = new BankCard();  
        bc.setMemberNo("bn001");
        bc.setBankCard("620104");
        bc.setName("����");
        service.setBankCard(bc);
        
        
        
	}
	
}
