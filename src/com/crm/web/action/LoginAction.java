package com.crm.web.action;

import com.crm.domain.SysRole;
import com.crm.domain.SysUser;
import com.crm.service.SystemService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport
{
  private SystemService systemService;
  private String username;
  private String password;

  public SystemService getSystemService()
  {
    return this.systemService;
  }
  public void setSystemService(SystemService systemService) {
    this.systemService = systemService;
  }
  public String getUsername() {
    return this.username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return this.password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String login()
  {
    SysUser sysUser = this.systemService.findUserByNameAndPwd(this.username, this.password);

    if (sysUser == null) {
      addFieldError("msg", "用户名或密码输入有误");
      return "input";
    }

    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();
    session.setAttribute("loginedUser", sysUser);

    Set<SysRole> sysRoles = sysUser.getSysRoles();
    for (SysRole sysRole : sysRoles)
    {
      if (sysRole.getRoleId().longValue() == 2L) {
        session.setAttribute("authority", Integer.valueOf(2));
        break;
      }

      if (sysRole.getRoleId().longValue() == 3L) {
        session.setAttribute("authority", Integer.valueOf(3));
        break;
      }
    }
    return "login";
  }

  public String logout()
  {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpSession session = request.getSession();
    session.invalidate();
    return "logout";
  }
}