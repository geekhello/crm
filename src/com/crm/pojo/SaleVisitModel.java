package com.crm.pojo;

import com.crm.domain.CstCustomer;
import com.crm.domain.SaleVisit;
import com.crm.domain.SysUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SaleVisitModel implements Serializable {
	private List<SaleVisit> saleVisits = new ArrayList(0);
	private List<CstCustomer> cstCustomers = new ArrayList(0);
	private List<SysUser> sysUsers;
	private SaleVisit saleVisit;
	public List<SaleVisit> getSaleVisits() {
		return saleVisits;
	}
	public List<CstCustomer> getCstCustomers() {
		return cstCustomers;
	}
	public List<SysUser> getSysUsers() {
		return sysUsers;
	}
	public SaleVisit getSaleVisit() {
		return saleVisit;
	}
	public void setSaleVisits(List<SaleVisit> saleVisits) {
		this.saleVisits = saleVisits;
	}
	public void setCstCustomers(List<CstCustomer> cstCustomers) {
		this.cstCustomers = cstCustomers;
	}
	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	public void setSaleVisit(SaleVisit saleVisit) {
		this.saleVisit = saleVisit;
	}

	
}