package com.mindtree.PatientInformationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.PatientInformationSystem.entity.PatientTest;

@Repository
public interface PatientTestRepository extends JpaRepository<PatientTest, Long> {

}
