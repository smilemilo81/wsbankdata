package cn.bannuo.ws.cxf.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cn.bannuo.ws.cxf.model.BankCard;
import cn.bannuo.ws.cxf.model.ThirdCardCollect;
import cn.bannuo.ws.cxf.model.TransQry;

@Repository("bankApplicationManagerImpl")
public class BankApplicationManagerImpl implements BankApplicationManager {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void setBankCard(BankCard bankCard) {
		System.out.println("########## Service setBankCard(���հ󶨿���Ϣ) ##########");
		System.out.println("MemberNo()|��Ա�� : " + bankCard.getMemberNo());
		System.out.println("BankCard()|���п��� : " + bankCard.getBankCard());
		System.out.println("BankCode()|���д��� : " + bankCard.getBankCode());
		System.out.println("CardType()|�������� : " + bankCard.getCardType());
		System.out.println("IdNo()|֤���� : " + bankCard.getIdNo());
		System.out.println("IdType()|֤�������� : " + bankCard.getIdType());
		System.out.println("Name()|�û����� : " + bankCard.getName());
		System.out.println("PhoneNo()|�ֻ��� : " + bankCard.getPhoneNo());
		
		getSession().save(bankCard);
	}

	@Override
	public void setCardCollect(ThirdCardCollect thirdCardCollect) {
		System.out.println("########## Service setCardCollect(����֧��������Ϣ) ##########");
		System.out.println("MemberNo()|��Ա�� : " + thirdCardCollect.getMemberNo());
		System.out.println("BankCard()|���� : " + thirdCardCollect.getBankCard());
		System.out.println("OutTradeNo()|������ : " + thirdCardCollect.getOutTradeNo());
		System.out.println("Amt()|���׽�� : " + thirdCardCollect.getAmt());
		
		getSession().save(thirdCardCollect);
	}

	@Override
	public void setTransQry(TransQry transQry) {
		System.out.println("########## Service setTransQry(���ս�����ˮ��Ϣ) ##########");
		System.out.println("MemberNo()|��Ա�� : " + transQry.getMemberNo());
		System.out.println("OutTradeNo()|������ : " + transQry.getOutTradeNo());
		System.out.println("TradeType()|�������� : " + transQry.getTradeType());
		System.out.println("BeginTime()| : " + transQry.getBeginTime());
		System.out.println("EndTime()| : " + transQry.getEndTime());
		System.out.println("Pageindex()| : " + transQry.getPageindex());
		System.out.println("Pagesize()| : " + transQry.getPagesize());
		
		getSession().save(transQry);
	}

}

