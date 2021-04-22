package com.jonathan.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.jonathan.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.jonathan.PatientRepository;
import com.jonathan.model.Patient;

@RestController
public class PatientController {

	@Autowired
	private PatientServices service;

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

	// localhost:8080/exports downloads a csv file with user info from database
	// NO specific webpage yet lol
	@GetMapping("/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");

		// date in file name
		String pattern = "MM/dd/yyyy_HH:mm:ss";
		DateFormat df = new SimpleDateFormat(pattern);
		String date = df.format(Calendar.getInstance().getTime());

		String headerKey = "Content-Disposition";
		String headerVal = "attachment; filename=patients_" +  date + ".csv";
		response.setHeader(headerKey, headerVal);

		List<Patient> listPatients = service.retrieveAll();

		ICsvBeanWriter writer = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		// update csvHead columns in accordance to Patient class
		String[] csvHead = {"ID", "Name"};
		String[] mapping = {"id", "name"};
		writer.writeHeader(csvHead);

		for (Patient patient : listPatients) {
			writer.write(patient, mapping);
		}

		writer.close();

	}
}
