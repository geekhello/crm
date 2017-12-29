package com.crm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CstCustomer implements Serializable {
	private Long custId;
	private String custName;
	private String custIndustry;
	private String custLevel;
	private String custAddress;
	private String custZip;
	private String custPhone;
	private String custFax;
	private String custWebsite;
	private String custCorporation;
	private String custMemo;
	private SysUser sysUserByCustUserId;
	private SysUser sysUserByCustCreateId;
	private Set<CstLinkMan> linkMans = new HashSet(0);

	private Set<SaleVisit> saleVisits = new HashSet(0);
	private BaseDict baseDict;

	public CstCustomer() {
	}

	public CstCustomer(Long custId, String custName) {
		this.custId = custId;
		this.custName = custName;
	}

	public Long getCustId() {
		return custId;
	}

	public String getCustName() {
		return custName;
	}

	public String getCustIndustry() {
		return custIndustry;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public String getCustZip() {
		return custZip;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public String getCustFax() {
		return custFax;
	}

	public String getCustWebsite() {
		return custWebsite;
	}

	public String getCustCorporation() {
		return custCorporation;
	}

	public String getCustMemo() {
		return custMemo;
	}

	public SysUser getSysUserByCustUserId() {
		return sysUserByCustUserId;
	}

	public SysUser getSysUserByCustCreateId() {
		return sysUserByCustCreateId;
	}

	public Set<CstLinkMan> getLinkMans() {
		return linkMans;
	}

	public Set<SaleVisit> getSaleVisits() {
		return saleVisits;
	}

	public BaseDict getBaseDict() {
		return baseDict;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public void setCustZip(String custZip) {
		this.custZip = custZip;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}

	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}

	public void setCustCorporation(String custCorporation) {
		this.custCorporation = custCorporation;
	}

	public void setCustMemo(String custMemo) {
		this.custMemo = custMemo;
	}

	public void setSysUserByCustUserId(SysUser sysUserByCustUserId) {
		this.sysUserByCustUserId = sysUserByCustUserId;
	}

	public void setSysUserByCustCreateId(SysUser sysUserByCustCreateId) {
		this.sysUserByCustCreateId = sysUserByCustCreateId;
	}

	public void setLinkMans(Set<CstLinkMan> linkMans) {
		this.linkMans = linkMans;
	}

	public void setSaleVisits(Set<SaleVisit> saleVisits) {
		this.saleVisits = saleVisits;
	}

	public void setBaseDict(BaseDict baseDict) {
		this.baseDict = baseDict;
	}

	public String toString() {
		return "CstCustomer [custId=" + this.custId + ", custName="
				+ this.custName + ", custSource=" + ", custIndustry="
				+ this.custIndustry + ", custLevel=" + this.custLevel
				+ ", custAddress=" + this.custAddress + ", custZip="
				+ this.custZip + ", custPhone=" + this.custPhone + ", custFax="
				+ this.custFax + ", custWebsite=" + this.custWebsite
				+ ", custCorporation=" + this.custCorporation + ", custMemo="
				+ this.custMemo + "]";
	}
}
