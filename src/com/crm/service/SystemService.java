package com.crm.service;

import com.crm.domain.SysRole;
import com.crm.domain.SysUser;
import com.crm.pojo.SysModel;

import java.util.List;

public abstract interface SystemService
{
  public abstract SysUser findUserByNameAndPwd(String paramString1, String paramString2);

  public abstract List<SysUser> findAllSysUser(SysModel paramSysModel);

  public abstract void deleteSysUser(Long paramLong);
  
  public abstract List<SysRole> findAllSysRoles();
}