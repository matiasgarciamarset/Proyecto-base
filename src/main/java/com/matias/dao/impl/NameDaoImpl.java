package com.matias.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matias.dao.NameDao;
import com.matias.dao.cache.NameInternalCache;
import com.matias.dao.cache.exception.CacheException;
import com.matias.model.Name;

@Component
public class NameDaoImpl implements NameDao{
	
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	private NameInternalCache nameInternalCache;

	@Override
	public Boolean save(Name name) {
		nameInternalCache.isExpired();
		entityManager.persist(name);
		return true;
	}
	
	@Override
	public Long count() {
		try {
			return nameInternalCache.getRowCount();
		} catch (CacheException e) {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Long> query = builder.createQuery(Long.class);
			query.select(builder.count(query.from(Name.class)));
			Long rowCount = entityManager.createQuery(query)
					.getSingleResult();
			nameInternalCache.updateRowCount(rowCount);
			return rowCount;
		}
		
	}
}
