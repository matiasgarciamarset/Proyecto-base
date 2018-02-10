package com.matias.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matias.config.HibernateConfig;
import com.matias.dao.NameDao;
import com.matias.model.Name;

@Component
public class NameDaoImpl implements NameDao{
	
	@Autowired
	private HibernateConfig config;

	@Override
	public Boolean save(Name name) {
		Session session = null;
		try{
			session = config.getCurrentSession();
			session.beginTransaction();
			session.save(name);
			session.getTransaction().commit();
			return true;
		} catch(Exception sqlException) {
			if(null != session.getTransaction()) {
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
			return false;
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}

}
