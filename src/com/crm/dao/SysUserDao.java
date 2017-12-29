package com.crm.dao;

import com.crm.domain.SysUser;
import com.crm.pojo.SysModel;
import java.util.List;

public abstract interface SysUserDao extends IBaseDao<SysUser>
{
  public abstract SysUser findUserByNameAndPwd(String paramString1, String paramString2);

  public abstract List<SysUser> findAllSysUser(SysModel paramSysModel);
}
