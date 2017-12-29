package com.crm.web.action.interceptor;

import com.crm.domain.SysUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class LoginInterceptor extends AbstractInterceptor
{
  public String intercept(ActionInvocation actionInvocation)
    throws Exception
  {
    HttpServletRequest request = ServletActionContext.getRequest();
    String url = request.getRequestURI();
    System.out.println(url);
    if (url.indexOf("login.action") >= 0)
    {
      return actionInvocation.invoke();
    }

    HttpSession session = request.getSession();
    SysUser loginedUser = (SysUser)session.getAttribute("loginedUser");
    if (loginedUser != null) {
      return actionInvocation.invoke();
    }
    return "loginUI";
  }
}