package cn.bannuo.ws.cxf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="fanwe_transqry")
public class TransQry {

	// 编号
	private String id;
	
	// 会员号
	private String memberNo;
	
	// 订单号
	private String outTradeNo;
	
	// 交易类型
	private String tradeType;
	
	// 起始时间
	private String beginTime;
	
	// 结束时间
	private String endTime;
	
	// 页码
	private String pageindex;
	
	// 页面大小
	private String pagesize;
	
	// 新增时间
	private String addtime;

	
	@Id
	@GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPageindex() {
		return pageindex;
	}

	public void setPageindex(String pageindex) {
		this.pageindex = pageindex;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
}
