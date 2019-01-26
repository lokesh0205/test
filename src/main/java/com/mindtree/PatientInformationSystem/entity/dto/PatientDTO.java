package com.mindtree.PatientInformationSystem.entity.dto;

import java.util.List;

import com.mindtree.PatientInformationSystem.entity.Name;
import com.mindtree.PatientInformationSystem.entity.Test;

public class PatientDTO {

	private Name patientName;
	private Integer age;
	private String testDate;
	private List<Test> tests;
	private Integer totalCost;

	public PatientDTO() {
		super();
	}

	public Name getPatientName() {
		return patientName;
	}

	public void setPatientName(Name patientName) {
		this.patientName = patientName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
}
