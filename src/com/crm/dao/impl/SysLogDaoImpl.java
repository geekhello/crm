package com.crm.dao.impl;

import java.io.Serializable;

import com.crm.dao.SysLogDao;
import com.crm.domain.SysLog;

public class SysLogDaoImpl extends BaseDaoImpl<SysLog> implements SysLogDao {

	@Override
	public void save(SysLog sysLog) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(sysLog);
	}

	@Override
	public void delete(Serializable paramSerializable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(SysLog sysLog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SysLog findById(Serializable paramSerializable) {
		// TODO Auto-generated method stub
		return null;
	}


}
