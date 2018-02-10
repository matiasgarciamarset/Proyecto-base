package com.matias.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
