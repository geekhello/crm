package com.crm.domain;

import java.io.Serializable;
import java.util.Calendar;

import com.crm.constant.LogType;
import com.crm.constant.OperateType;


public class SysLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3263887944371914493L;
	/**
	 * 记录ID
	 */
	private Long id;
	/**
	 * 日志类型
	 */
	private LogType logType;
	/**
	 * 操作类型
	 */
	private OperateType operType;
	/**
	 * 操作描述
	 */
	private String remark;
	/**
	 * 操作地址
	 */
	private String operateMethod;
	/**
	 * 具体参数信息
	 */
	private String args;
	/**
	 * 详细描述，用于记录异常信息等
	 */
	private String detail;
	/**
	 * 操作用户ID
	 */
	private String userId;
	/**
	 * 用户真实姓名
	 */
	private String realName;
	/**
	 * 操作IP
	 */
	private String loginIP;
	/**
	 * 操作时间时间戳
	 */
	private Long operateTime = Calendar.getInstance().getTimeInMillis();
	public Long getId() {
		return id;
	}
	public LogType getLogType() {
		return logType;
	}
	public OperateType getOperType() {
		return operType;
	}
	public String getRemark() {
		return remark;
	}
	public String getOperateMethod() {
		return operateMethod;
	}
	public String getArgs() {
		return args;
	}
	public String getDetail() {
		return detail;
	}
	public String getUserId() {
		return userId;
	}
	public String getRealName() {
		return realName;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public Long getOperateTime() {
		return operateTime;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setLogType(LogType logType) {
		this.logType = logType;
	}
	public void setOperType(OperateType operType) {
		this.operType = operType;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setOperateMethod(String operateMethod) {
		this.operateMethod = operateMethod;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}
	
	
}
