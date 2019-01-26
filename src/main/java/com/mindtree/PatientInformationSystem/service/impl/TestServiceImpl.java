package com.mindtree.PatientInformationSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.PatientInformationSystem.entity.Test;
import com.mindtree.PatientInformationSystem.repository.TestRepository;
import com.mindtree.PatientInformationSystem.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired	private TestRepository testRepository;

	@Override
	public List<Test> getAllTests() {
		return testRepository.findAll();
	}
}
