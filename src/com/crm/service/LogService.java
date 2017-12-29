package com.crm.service;

import java.util.List;

import com.crm.domain.SysLog;

public interface LogService {

	/**
	 * 添加日志
	 */
	public void addLog(SysLog sysLog) throws Exception;
	/**
	 * 查询日志
	 */
	public List<SysLog> findAllLog() throws Exception;
}
