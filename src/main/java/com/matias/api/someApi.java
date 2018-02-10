package com.matias.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matias.config.HibernateConfig;
import com.matias.model.Name;
import com.matias.service.SomeService;

@RestController
@RequestMapping("/test")
public class someApi {
	
	@Autowired
	private SomeService someService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "Hola mundo";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return someService.create();
	}
	
}
