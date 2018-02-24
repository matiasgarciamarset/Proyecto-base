package com.matias.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.matias.dao.NameDao;
import com.matias.model.Name;
import com.matias.service.SomeService;

@Component
public class SomeServiceImpl implements SomeService {
	
	@Autowired
	private NameDao nameDao;

	@Override
	@Transactional
	public String create() {
		Name obj = new Name();
		obj.setName("testName");
		Boolean status = nameDao.save(obj);
		return status ? "Correcto" : "Error";
	}
	
	@Override
	@Transactional
	public Long count() {
		return nameDao.count();
	}

}
