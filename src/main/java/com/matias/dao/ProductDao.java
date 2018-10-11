package com.matias.dao;

import com.matias.model.Product;

import java.util.List;

public interface ProductDao {

	Boolean save(Product product);

	Product read(Integer id);

	List<Product> read();
}
