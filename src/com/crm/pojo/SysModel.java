package com.crm.pojo;

import com.crm.domain.SysRole;
import com.crm.domain.SysUser;

import java.util.ArrayList;
import java.util.List;

public class SysModel {
	private SysUser user;
	private List<SysUser> sysUsers = new ArrayList(0);
	private List<SysRole> sysRoles = new ArrayList(0);
	public SysUser getUser() {
		return user;
	}
	public List<SysUser> getSysUsers() {
		return sysUsers;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	public List<SysRole> getSysRoles() {
		return sysRoles;
	}
	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
	
}