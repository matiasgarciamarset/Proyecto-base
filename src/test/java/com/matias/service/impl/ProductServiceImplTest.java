package com.matias.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

import com.matias.dao.ProductDao;
import com.matias.service.ProductService;

public class ProductServiceImplTest {

	@Mock
	private ProductDao productDao;

	@InjectMocks
	private ProductService productService = new ProductServiceImpl();
	
	@BeforeMethod
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate_callSave() {
		when(productDao.save(any())).thenReturn(true);
		productService.create("test");
		verify(productDao, times(1)).save(any());
	}

}
