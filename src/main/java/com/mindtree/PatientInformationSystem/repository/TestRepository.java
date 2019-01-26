package com.mindtree.PatientInformationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.PatientInformationSystem.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
