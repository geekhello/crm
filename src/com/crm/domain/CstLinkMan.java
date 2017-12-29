package com.crm.domain;

import java.io.Serializable;

public class CstLinkMan implements Serializable {
	private Long lkmId;
	private String lkmName;
	private String lkmGender;
	private String lkmPhone;
	private String lkmMobile;
	private String lkmEmail;
	private String lkmPosition;
	private String lkmMemo;
	private CstCustomer customer;

	public Long getLkmId() {
		return lkmId;
	}

	public String getLkmName() {
		return lkmName;
	}

	public String getLkmGender() {
		return lkmGender;
	}

	public String getLkmPhone() {
		return lkmPhone;
	}

	public String getLkmMobile() {
		return lkmMobile;
	}

	public String getLkmEmail() {
		return lkmEmail;
	}

	public String getLkmPosition() {
		return lkmPosition;
	}

	public String getLkmMemo() {
		return lkmMemo;
	}

	public CstCustomer getCustomer() {
		return customer;
	}

	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}

	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}

	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public void setLkmEmail(String lkmEmail) {
		this.lkmEmail = lkmEmail;
	}

	public void setLkmPosition(String lkmPosition) {
		this.lkmPosition = lkmPosition;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	public void setCustomer(CstCustomer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CstLinkMan [lkmId=" + lkmId + ", lkmName=" + lkmName
				+ ", lkmGender=" + lkmGender + ", lkmPhone=" + lkmPhone
				+ ", lkmMobile=" + lkmMobile + ", lkmEmail=" + lkmEmail
				+ ", lkmPosition=" + lkmPosition + ", lkmMemo=" + lkmMemo + "]";
	}

}