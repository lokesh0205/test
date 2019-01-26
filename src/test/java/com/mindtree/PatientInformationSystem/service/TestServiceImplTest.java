package com.mindtree.PatientInformationSystem.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtree.PatientInformationSystem.repository.TestRepository;
import com.mindtree.PatientInformationSystem.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest extends TestUtil {

	@Autowired
	private TestService testService;

	@MockBean
	private TestRepository testRepository;

	@Test
	public void getAllTestsTest() {
		when(testRepository.findAll()).thenReturn(getTestsList());
		assertNotNull(testService.getAllTests());
	}
}
