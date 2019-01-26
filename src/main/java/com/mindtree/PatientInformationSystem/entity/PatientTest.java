package com.mindtree.PatientInformationSystem.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_test")
public class PatientTest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "patient_test_id")
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "P_ID")
	private Patient patient;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "T_ID")
	private Test test;
	private LocalDate testDate;

	public PatientTest() {
		super();
	}

	public PatientTest(Patient patient, Test test, LocalDate testDate) {
		super();
		this.patient = patient;
		this.test = test;
		this.testDate = testDate;
	}

	public PatientTest(Long id, Patient patient, Test test, LocalDate testDate) {
		super();
		this.id = id;
		this.patient = patient;
		this.test = test;
		this.testDate = testDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}
}
