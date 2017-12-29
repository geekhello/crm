package com.crm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SysUser implements Serializable {
	private Long userId;
	private String userCode;
	private String userName;
	private String userPassword;
	private String userState;
	private Set<SysRole> sysRoles = new HashSet(0);

	private Set<SaleVisit> saleVisits = new HashSet(0);

	private Set cstCustomersForCustUserId = new HashSet(0);

	private Set cstCustomersForCustCreateId = new HashSet(0);

	public SysUser() {
	}

	public SysUser(String userCode, String userName, String userPassword,
			String userState) {
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userState = userState;
	}

	public Set<SysRole> getSysRoles() {
		return sysRoles;
	}

	public Set<SaleVisit> getSaleVisits() {
		return saleVisits;
	}

	public Set getCstCustomersForCustUserId() {
		return cstCustomersForCustUserId;
	}

	public Set getCstCustomersForCustCreateId() {
		return cstCustomersForCustCreateId;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	public void setSaleVisits(Set<SaleVisit> saleVisits) {
		this.saleVisits = saleVisits;
	}

	public void setCstCustomersForCustUserId(Set cstCustomersForCustUserId) {
		this.cstCustomersForCustUserId = cstCustomersForCustUserId;
	}

	public void setCstCustomersForCustCreateId(Set cstCustomersForCustCreateId) {
		this.cstCustomersForCustCreateId = cstCustomersForCustCreateId;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	@Override
	public String toString() {
		return "SysUser [userId=" + userId + ", userCode=" + userCode
				+ ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userState=" + userState + "]";
	}
	

}