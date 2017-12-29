package com.crm.web.action;

import com.crm.domain.CstCustomer;
import java.io.PrintStream;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAction
{
  public static void main(String[] args)
  {
    try
    {
      ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
      Object bean = ac.getBean("customerDao");

      System.out.println(bean);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test() {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    Object bean = ac.getBean("customerService");

    System.out.println(bean);
  }

  @Test
  public void test2() {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring/bean1.xml");
    CstCustomer customer = (CstCustomer)ac.getBean("customer");
    System.out.println(customer);
  }
}