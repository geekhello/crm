package com.crm.web.action;

import org.hibernate.Query;
import org.hibernate.Session;

import com.crm.utils.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from SysUser");
	}
}
