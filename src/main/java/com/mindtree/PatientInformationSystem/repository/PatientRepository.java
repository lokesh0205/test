package com.mindtree.PatientInformationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.PatientInformationSystem.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
