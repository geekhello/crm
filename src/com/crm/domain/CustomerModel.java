package com.crm.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
	private CstCustomer customer = new CstCustomer();
	private String dictId;
	private Long custId;
	private String custName;
	private List<CstCustomer> customers = new ArrayList();

	public CstCustomer getCustomer() {
		return customer;
	}

	public String getDictId() {
		return dictId;
	}

	public Long getCustId() {
		return custId;
	}

	public String getCustName() {
		return custName;
	}

	public List<CstCustomer> getCustomers() {
		return customers;
	}

	public void setCustomer(CstCustomer customer) {
		this.customer = customer;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setCustomers(List<CstCustomer> customers) {
		this.customers = customers;
	}

}