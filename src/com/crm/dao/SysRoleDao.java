package com.crm.dao;

import java.util.List;

import com.crm.domain.SysRole;
import com.crm.pojo.SysModel;

public interface SysRoleDao extends IBaseDao<SysRole> {

	public abstract List<SysRole> findAllSysRoles();
}
