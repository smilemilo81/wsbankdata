package cn.bannuo.ws.cxf.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.bannuo.ws.cxf.model.BankCard;
import cn.bannuo.ws.cxf.model.ThirdCardCollect;
import cn.bannuo.ws.cxf.model.TransQry;

@Repository("bankApplicationManagerImpl")
public class BankApplicationManagerImpl extends HibernateDaoSupport implements BankApplicationManager {
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public void setBankCard(BankCard bankCard) {
		System.out.println("########## Service setBankCard(接收绑定卡信息) ##########");
		System.out.println("MemberNo()|会员号 : " + bankCard.getMemberNo());
		System.out.println("BankCard()|银行卡号 : " + bankCard.getBankCard());
		System.out.println("BankCode()|银行代码 : " + bankCard.getBankCode());
		System.out.println("CardType()|卡号类型 : " + bankCard.getCardType());
		System.out.println("IdNo()|证件号 : " + bankCard.getIdNo());
		System.out.println("IdType()|证件号类型 : " + bankCard.getIdType());
		System.out.println("Name()|用户姓名 : " + bankCard.getName());
		System.out.println("PhoneNo()|手机号 : " + bankCard.getPhoneNo());
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 记录保存到数据库的时间
		bankCard.setAddtime(sdf.format(date));
		
		getHibernateTemplate().save(bankCard);
	}

	@Override
	public void setCardCollect(ThirdCardCollect thirdCardCollect) {
		System.out.println("########## Service setCardCollect(接收支付订单信息) ##########");
		System.out.println("MemberNo()|会员号 : " + thirdCardCollect.getMemberNo());
		System.out.println("BankCard()|卡号 : " + thirdCardCollect.getBankCard());
		System.out.println("OutTradeNo()|订单号 : " + thirdCardCollect.getOutTradeNo());
		System.out.println("Amt()|交易金额 : " + thirdCardCollect.getAmt());
		
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 记录保存到数据库的时间
		thirdCardCollect.setAddtime(sdf.format(date));
		getHibernateTemplate().save(thirdCardCollect);
	}

	@Override
	public void setTransQry(TransQry transQry) {
		System.out.println("########## Service setTransQry(接收交易流水信息) ##########");
		System.out.println("MemberNo()|会员号 : " + transQry.getMemberNo());
		System.out.println("OutTradeNo()|订单号 : " + transQry.getOutTradeNo());
		System.out.println("TradeType()|交易类型 : " + transQry.getTradeType());
		System.out.println("BeginTime()| : " + transQry.getBeginTime());
		System.out.println("EndTime()| : " + transQry.getEndTime());
		System.out.println("Pageindex()| : " + transQry.getPageindex());
		System.out.println("Pagesize()| : " + transQry.getPagesize());
		
		getHibernateTemplate().save(transQry);
	}

}

