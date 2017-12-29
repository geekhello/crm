package com.crm.dao.impl;

import com.crm.dao.CstCustomerDao;

import com.crm.domain.CstCustomer;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class CstCustomerDaoImpl extends BaseDaoImpl<CstCustomer> implements
		CstCustomerDao {
	public List<CstCustomer> findAllCustomer() {
		return (List<CstCustomer>) getHibernateTemplate().find("from CstCustomer", new Object[0]);
	}

	public List<CstCustomer> findCustomerByName(String custName) {
		String sql = "from CstCustomer where custName like ?";

		return (List<CstCustomer>) getHibernateTemplate().find(sql,
				new Object[] { "%" + custName + "%" });
	}

}
