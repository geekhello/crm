package com.crm.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil
{
  private static SessionFactory factory;

  static
  {
    try
    {
      factory = new Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      throw new ExceptionInInitializerError("初始化Session失败");
    }
  }

  public static SessionFactory getSessionFactory() {
    return factory;
  }

  public static Session getSession()
  {
    return factory.getCurrentSession();
  }

  public static void main(String[] args) {
    Session s = getSession();
    s.close();
  }
}