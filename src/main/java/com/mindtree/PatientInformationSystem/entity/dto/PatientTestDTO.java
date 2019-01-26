package com.mindtree.PatientInformationSystem.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PatientTestDTO {
	@NotNull
	private Long patientId;
	@NotNull
	private Long testId;
	@NotNull
	private Integer value;
	@NotBlank
	private String comment;

	public PatientTestDTO() {
		super();
	}

	public PatientTestDTO(Long patientId, Long testId, Integer value, String comment) {
		super();
		this.patientId = patientId;
		this.testId = testId;
		this.value = value;
		this.comment = comment;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "PatientTestDTO [patientId=" + patientId + ", testId=" + testId + ", value=" + value + ", comment="
				+ comment + "]";
	}
}
