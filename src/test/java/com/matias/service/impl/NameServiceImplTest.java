package com.matias.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

import com.matias.dao.NameDao;
import com.matias.service.SomeService;

public class NameServiceImplTest {

	@Mock
	private NameDao nameDao;

	@InjectMocks
	private SomeService someService = new SomeServiceImpl();
	
	@BeforeMethod
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreate_callSave() {
		when(nameDao.save(any())).thenReturn(true);
		someService.create();
		verify(nameDao, times(1)).save(any());
	}

}
