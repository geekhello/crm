package com.crm.dao.impl;

import com.crm.dao.BaseDictDao;
import com.crm.domain.BaseDict;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements
		BaseDictDao {
	public List<BaseDict> findAllBaseDict(String dictTypeCode) {
		String sql = "from BaseDict where dictTypeCode=?";
		return (List<BaseDict>)this.getHibernateTemplate().find(sql, new Object[]{dictTypeCode});
	}
}
