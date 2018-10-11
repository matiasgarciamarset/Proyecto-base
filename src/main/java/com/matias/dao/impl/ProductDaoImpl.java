package com.matias.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.matias.dao.ProductDao;
import com.matias.model.Product;

import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Boolean save(Product product) {
		entityManager.persist(product);
		return true;
	}

	@Override
	public Product read(Integer id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> read() {
		return entityManager.createQuery("Select a from Product a", Product.class)
				.getResultList();
	}
}
