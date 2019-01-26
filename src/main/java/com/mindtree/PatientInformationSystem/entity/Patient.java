package com.mindtree.PatientInformationSystem.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "P_ID")
	private Long patientId;
	@Embedded
	private Name patientName;
	@Column(name = "DOB")
	private LocalDate dob;
	@OneToMany(mappedBy = "patient")
	private List<PatientTest> patientTests;

	public Patient() {
		super();
	}

	public Patient(Name patientName, LocalDate dob) {
		super();
		this.patientName = patientName;
		this.dob = dob;
	}

	public Patient(Long patientId, Name patientName, LocalDate dob) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.dob = dob;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Name getPatientName() {
		return patientName;
	}

	public void setPatientName(Name patientName) {
		this.patientName = patientName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public List<PatientTest> getPatientTests() {
		return patientTests;
	}

	public void setPatientTests(List<PatientTest> patientTests) {
		this.patientTests = patientTests;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", dob=" + dob + ", patientTests="
				+ patientTests + "]";
	}

}
