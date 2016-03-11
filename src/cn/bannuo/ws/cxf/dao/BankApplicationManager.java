package cn.bannuo.ws.cxf.dao;

import javax.jws.WebService;

import cn.bannuo.ws.cxf.model.BankCard;
import cn.bannuo.ws.cxf.model.ThirdCardCollect;
import cn.bannuo.ws.cxf.model.TransQry;

@WebService
public interface BankApplicationManager {

	/**
	 * 接收绑定卡信息
	 */
	public void setBankCard(BankCard bankCard);
	
	/**
	 * 接收支付订单信息
	 */
	public void setCardCollect(ThirdCardCollect thirdCardCollect);
	
	/**
	 * 接收交易流水信息
	 */
	public void setTransQry(TransQry transQry);
		
}
