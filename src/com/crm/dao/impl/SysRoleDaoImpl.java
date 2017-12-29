package com.crm.dao.impl;

import java.util.List;

import com.crm.dao.SysRoleDao;
import com.crm.domain.SysRole;

public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements SysRoleDao {

	@Override
	public List<SysRole> findAllSysRoles() {
		String sql = "from SysRole";
		return (List<SysRole>) this.getHibernateTemplate().find(sql);
	}

}
