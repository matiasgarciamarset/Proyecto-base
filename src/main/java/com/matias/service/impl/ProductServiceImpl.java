package com.matias.service.impl;

import com.matias.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.matias.dao.ProductDao;
import com.matias.service.ProductService;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public String create(String name) {
		Product obj = new Product();
		obj.setName(name);
		Boolean status = productDao.save(obj);
		return status ? "Correcto" : "Error";
	}

	@Override
	@Transactional
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	@Transactional
	public List<Product> read() {
		return productDao.read();
	}
}
