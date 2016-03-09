package cn.bannuo.ws.cxf.dao;

import javax.jws.WebService;

import cn.bannuo.ws.cxf.model.BankCard;
import cn.bannuo.ws.cxf.model.ThirdCardCollect;
import cn.bannuo.ws.cxf.model.TransQry;

@WebService
public interface BankApplicationManager {

	/**
	 * ���հ󶨿���Ϣ
	 */
	public void setBankCard(BankCard bankCard);
	
	/**
	 * ����֧��������Ϣ
	 */
	public void setCardCollect(ThirdCardCollect thirdCardCollect);
	
	/**
	 * ���ս�����ˮ��Ϣ
	 */
	public void setTransQry(TransQry transQry);
		
}
