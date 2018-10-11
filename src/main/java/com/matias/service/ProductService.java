package com.matias.service;

import com.matias.model.Product;

import java.util.List;

public interface ProductService {

	String create(String name);

	Product read(Integer id);

	List<Product> read();
}
