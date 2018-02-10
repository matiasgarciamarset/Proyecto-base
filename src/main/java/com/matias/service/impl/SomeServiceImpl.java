package com.matias.service.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matias.config.HibernateConfig;
import com.matias.dao.NameDao;
import com.matias.model.Name;
import com.matias.service.SomeService;

@Component
public class SomeServiceImpl implements SomeService {
	
	@Autowired
	private NameDao nameDao;

	@Override
	public String create() {
		Name obj = new Name();
		obj.setId(0);
		obj.setName("testName");
		Boolean status = nameDao.save(obj);
		return status ? "Correcto" : "Error";
	}

}
