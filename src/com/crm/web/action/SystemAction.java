package com.crm.web.action;

import com.crm.domain.SysUser;
import com.crm.pojo.SysModel;
import com.crm.service.SystemService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SystemAction extends ActionSupport
  implements ModelDriven<SysModel>
{
  private SysModel sysModel = new SysModel();
  private SystemService systemService;

  public SysModel getModel()
  {
    return this.sysModel;
  }
  public SystemService getSystemService() {
    return this.systemService;
  }
  public void setSystemService(SystemService systemService) {
    this.systemService = systemService;
  }

  public String listSysUser()
  {
    this.sysModel.setSysUsers(this.systemService.findAllSysUser(this.sysModel));
    return "listSysUser";
  }

  public String deleteSysUser()
  {
    this.systemService.deleteSysUser(this.sysModel.getUser().getUserId());
    return "deleteSysUser";
  }

  public String listSysUserByCondition()
  {
    return "listSysUserCondition";
  }
  
  public String listSysRole(){
	  this.sysModel.setSysRoles(systemService.findAllSysRoles());
	  return "listSysRole";
  }
}