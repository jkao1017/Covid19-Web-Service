package com.jonathan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jonathan.PatientRepository;
import com.jonathan.model.Patient;

@RestController
public class PatientController {
	
	@Autowired
	PatientRepository repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping(path="/patient", consumes= {"application/json"})
	public Patient addPatient(@RequestBody Patient patient) {
		repo.save(patient);
		return patient;
	}
	
	@GetMapping("/patients")
	public List<Patient> getPatients(){
		return repo.findAll();
	}
}
