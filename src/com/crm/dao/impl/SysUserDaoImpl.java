package com.crm.dao.impl;

import com.crm.dao.SysUserDao;
import com.crm.domain.SysUser;
import com.crm.pojo.SysModel;
import java.util.List;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {
	public SysUser findUserByNameAndPwd(String username, String password) {
		String sql = "from SysUser where userCode=? and userPassword=?";
		List list = getHibernateTemplate().find(sql,
				new Object[] { username, password });
		if ((list == null) || (list.size() < 1)) {
			return null;
		}
		return (SysUser) list.get(0);
	}

	public List<SysUser> findAllSysUser(SysModel sysModel) {
		StringBuffer queryString = new StringBuffer("from SysUser where 1=1");
		if ((sysModel != null) && (sysModel.getUser() != null)) {
			queryString.append("and userName="
					+ sysModel.getUser().getUserName());
		}

		List list = getHibernateTemplate().find(queryString.toString(),
				new Object[0]);
		if ((list == null) || (list.size() < 1)) {
			return null;
		}
		return list;
	}
}
