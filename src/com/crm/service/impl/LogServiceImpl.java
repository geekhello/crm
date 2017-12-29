package com.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.SysLogDao;
import com.crm.domain.SysLog;
import com.crm.service.LogService;

public class LogServiceImpl implements LogService {
	
	@Autowired
	private SysLogDao sysLogDao;

	@Override
	public void addLog(SysLog sysLog) throws Exception {
		sysLogDao.save(sysLog);
	}

	@Override
	public List<SysLog> findAllLog() throws Exception {
		return null;
	}

}
