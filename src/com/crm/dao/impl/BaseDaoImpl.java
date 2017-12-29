package com.crm.dao.impl;

import com.crm.dao.IBaseDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	public Class clazz;

	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();

		if ((type instanceof ParameterizedType)) {
			ParameterizedType ptype = (ParameterizedType) type;

			Type[] types = ptype.getActualTypeArguments();

			this.clazz = ((Class) types[0]);
		}
	}

	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	public void delete(Serializable id) {
		Object entity = getHibernateTemplate().get(this.clazz, id);
		getHibernateTemplate().delete(entity);
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public T findById(Serializable id) {
		return (T)getHibernateTemplate().load(this.clazz, id);
	}
}
