package cn.bannuo.ws.cxf.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import cn.bannuo.ws.cxf.dao.BankApplicationManager;
import cn.bannuo.ws.cxf.model.BankCard;
import cn.bannuo.ws.cxf.model.ThirdCardCollect;

public class ApplicationClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/wsbankpayment/ws/bankApplicationManager");
		/*factory.setAddress("http://118.180.9.78:8080/wsbankpayment/ws/bankApplicationManager");*/
		factory.setServiceClass(BankApplicationManager.class);
		factory.getInInterceptors().add(new LoggingInInterceptor());
		BankApplicationManager service = (BankApplicationManager) factory.create();  
		
		// 模拟客户端向服务端发请求，测试【卡号绑定】。
        BankCard bc = new BankCard();  
        bc.setMemberNo("bc003");
        bc.setBankCard("6201041975");
        bc.setName("李四2");
        Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		bc.setAddtime(sdf.format(date));
		System.out.println("date.format = " + sdf.format(date));
        service.setBankCard(bc);
        
        
        // 模拟客户端向服务端发请求，测试【银行代收】。
        ThirdCardCollect tcc = new ThirdCardCollect();
        tcc.setMemberNo("bn001");
        tcc.setBankCard("620104");
        tcc.setOutTradeNo("JY201603101716");
        tcc.setAmt("100");
        //service.setCardCollect(tcc);
        
        
        
        
	}
	
}
