package com.crm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SysRole implements Serializable {
	private Long roleId;
	private String roleName;
	private String roleMemo;
	private Set<SysUser> sysUsers = new HashSet(0);
	public Long getRoleId() {
		return roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getRoleMemo() {
		return roleMemo;
	}
	public Set<SysUser> getSysUsers() {
		return sysUsers;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setRoleMemo(String roleMemo) {
		this.roleMemo = roleMemo;
	}
	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	@Override
	public String toString() {
		return "SysRole [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleMemo=" + roleMemo + "]";
	}

	
}