package com.crm.domain;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class BaseDict implements Serializable {
	private String dictId;
	private String dictTypeCode;
	private String dictTypeName;
	private String dictItemName;
	private String dictItemCode;
	private Integer dictSort;
	private String dictEnable;
	private String dictMemo;
	private Set<CstCustomer> customers = new HashSet(0);

	public String getDictId() {
		return dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getDictTypeCode() {
		return dictTypeCode;
	}

	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}

	public String getDictTypeName() {
		return dictTypeName;
	}

	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}

	public String getDictItemName() {
		return dictItemName;
	}

	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}

	public String getDictItemCode() {
		return dictItemCode;
	}

	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}

	public Integer getDictSort() {
		return dictSort;
	}

	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}

	public String getDictEnable() {
		return dictEnable;
	}

	public void setDictEnable(String dictEnable) {
		this.dictEnable = dictEnable;
	}

	public String getDictMemo() {
		return dictMemo;
	}

	public void setDictMemo(String dictMemo) {
		this.dictMemo = dictMemo;
	}

	public Set<CstCustomer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<CstCustomer> customers) {
		this.customers = customers;
	}

	public String toString() {
		return "BaseDict [dictId=" + this.dictId + ", dictTypeCode="
				+ this.dictTypeCode + ", dictTypeName=" + this.dictTypeName
				+ ", dictItemName=" + this.dictItemName + ", dictItemCode="
				+ this.dictItemCode + ", dictSort=" + this.dictSort
				+ ", dictEnable=" + this.dictEnable + ", dictMemo="
				+ this.dictMemo + "]";
	}
}
