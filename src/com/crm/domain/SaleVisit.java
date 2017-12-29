package com.crm.domain;

import java.io.Serializable;
import java.util.Date;

public class SaleVisit implements Serializable {
	private String visitId;
	private CstCustomer cstCustomer;
	private SysUser sysUser;
	private String visitInterviewee;
	private Date visitTime;
	private String visitAddr;
	private String visitDetail;
	private Date visitNexttime;
	public String getVisitId() {
		return visitId;
	}
	public CstCustomer getCstCustomer() {
		return cstCustomer;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public String getVisitInterviewee() {
		return visitInterviewee;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public String getVisitAddr() {
		return visitAddr;
	}
	public String getVisitDetail() {
		return visitDetail;
	}
	public Date getVisitNexttime() {
		return visitNexttime;
	}
	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}
	public void setCstCustomer(CstCustomer cstCustomer) {
		this.cstCustomer = cstCustomer;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public void setVisitInterviewee(String visitInterviewee) {
		this.visitInterviewee = visitInterviewee;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public void setVisitAddr(String visitAddr) {
		this.visitAddr = visitAddr;
	}
	public void setVisitDetail(String visitDetail) {
		this.visitDetail = visitDetail;
	}
	public void setVisitNexttime(Date visitNexttime) {
		this.visitNexttime = visitNexttime;
	}

	
}