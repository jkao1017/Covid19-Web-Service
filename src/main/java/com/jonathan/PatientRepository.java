package com.jonathan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.jonathan.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	
}
