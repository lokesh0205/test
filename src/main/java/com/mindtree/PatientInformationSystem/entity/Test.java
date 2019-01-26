package com.mindtree.PatientInformationSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tests")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "T_ID")
	private Long testId;
	@Column(name = "Name")
	private String name;
	@Column(name = "Cost")
	private Integer cost;
	@OneToMany(mappedBy = "test")
	private List<PatientTest> patientTests;

	public Test() {
		super();
	}

	public Test(String name, Integer cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public Test(Long testId, String name, Integer cost) {
		super();
		this.testId = testId;
		this.name = name;
		this.cost = cost;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public void setPatientTests(List<PatientTest> patientTests) {
		this.patientTests = patientTests;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", name=" + name + ", cost=" + cost + ", patientTests=" + patientTests + "]";
	}

}
