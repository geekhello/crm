package com.crm.dao.impl;

import com.crm.dao.SaleVisitDao;
import com.crm.domain.SaleVisit;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class SaleVisitDaoImpl extends BaseDaoImpl<SaleVisit> implements
		SaleVisitDao {
	public List<SaleVisit> findAllSaleVisit() {
		return (List<SaleVisit>) getHibernateTemplate().find("from SaleVisit", new Object[0]);
	}
}
