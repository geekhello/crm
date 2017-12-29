package com.crm.domain;

import java.util.ArrayList;
import java.util.List;

public class LinkManModel {
	private CstLinkMan linkMan = new CstLinkMan();
	private Long custId;
	private Long lkmId;
	private String lkmName;
	private List<CstLinkMan> linkmans = new ArrayList();
	private List<CstCustomer> customers = new ArrayList();
	public CstLinkMan getLinkMan() {
		return linkMan;
	}
	public Long getCustId() {
		return custId;
	}
	public Long getLkmId() {
		return lkmId;
	}
	public String getLkmName() {
		return lkmName;
	}
	public List<CstLinkMan> getLinkmans() {
		return linkmans;
	}
	public List<CstCustomer> getCustomers() {
		return customers;
	}
	public void setLinkMan(CstLinkMan linkMan) {
		this.linkMan = linkMan;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}
	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}
	public void setLinkmans(List<CstLinkMan> linkmans) {
		this.linkmans = linkmans;
	}
	public void setCustomers(List<CstCustomer> customers) {
		this.customers = customers;
	}

	
}