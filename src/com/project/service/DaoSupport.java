package com.project.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.project.dao.UserDaoImpl;

public class DaoSupport extends HibernateDaoSupport {
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@SuppressWarnings("rawtypes")
	public List find(String HQLQuery, String[] nameOfTheParam, Object[] valueOfTheParam) throws Exception {

		logger.info("here the process starts12121!");
		if (nameOfTheParam != null && valueOfTheParam != null && (nameOfTheParam.length == valueOfTheParam.length)) {
			return getHibernateTemplate().findByNamedParam(HQLQuery, nameOfTheParam, valueOfTheParam);
		} else {
			throw new Exception("");
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByNamedQuery(String queryName, String nameOfTheParam, Object valueOfTheParam) {
		return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, nameOfTheParam, valueOfTheParam);
	}

	@SuppressWarnings("rawtypes")
	public List find(String HQLQuery) {
		return getHibernateTemplate().find(HQLQuery);
	}

}
