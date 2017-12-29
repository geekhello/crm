package com.crm.web.action.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.io.PrintStream;

public class customerInterceptor1 extends AbstractInterceptor
{
  public String intercept(ActionInvocation arg0)
    throws Exception
  {
    System.out.println("customerInterceptor1...1");

    String result = arg0.invoke();
    System.out.println("customerInterceptor1...2");
    return result;
  }
}