package com.crm.dao.impl;

import com.crm.dao.CstLinkManDao;
import com.crm.domain.CstLinkMan;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class CstLinkManDaoImpl extends BaseDaoImpl<CstLinkMan> implements
		CstLinkManDao {
	public List<CstLinkMan> findAllLinkMan() {
		return (List<CstLinkMan>) getHibernateTemplate().find("from CstLinkMan", new Object[0]);
	}

	public List<CstLinkMan> findLinkManByName(String lkmName) {
		String sql = "from CstLinkMan where lkmName like ?";
		return (List<CstLinkMan>) getHibernateTemplate().find(sql,
				new Object[] { "%" + lkmName + "%" });
	}
}
