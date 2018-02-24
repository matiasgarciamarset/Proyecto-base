package com.matias.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.matias.dao.NameDao;
import com.matias.model.Name;

@Component
public class NameDaoImpl implements NameDao{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Boolean save(Name name) {
		entityManager.persist(name);
		return true;
	}
}
