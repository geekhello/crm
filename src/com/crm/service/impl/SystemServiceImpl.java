package com.crm.service.impl;

import com.crm.constant.LogType;
import com.crm.constant.OperateType;
import com.crm.dao.SysRoleDao;
import com.crm.dao.SysUserDao;
import com.crm.domain.SysRole;
import com.crm.domain.SysUser;
import com.crm.pojo.SysModel;
import com.crm.service.SystemService;
import com.crm.utils.SystemLogMark;

import java.util.List;

public class SystemServiceImpl implements SystemService {
	private SysUserDao sysUserDao;
	private SysRoleDao sysRoleDao;

	public SysRoleDao getSysRoleDao() {
		return sysRoleDao;
	}

	public void setSysRoleDao(SysRoleDao sysRoleDao) {
		this.sysRoleDao = sysRoleDao;
	}

	public SysUserDao getSysUserDao() {
		return this.sysUserDao;
	}

	public void setSysUserDao(SysUserDao sysUserDao) {
		this.sysUserDao = sysUserDao;
	}

	//@SystemLogMark(operType=OperateType.LOGIN,logType=LogType.LOGIN,remark="用户登陆")
	public SysUser findUserByNameAndPwd(String username, String password) {
		return this.sysUserDao.findUserByNameAndPwd(username, password);
	}

	public List<SysUser> findAllSysUser(SysModel sysModel) {
		return this.sysUserDao.findAllSysUser(sysModel);
	}

	public void deleteSysUser(Long userId) {
		this.sysUserDao.delete(userId);
	}

	@Override
	public List<SysRole> findAllSysRoles() {
		return sysRoleDao.findAllSysRoles();
	}
}