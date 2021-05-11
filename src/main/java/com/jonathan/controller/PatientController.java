package com.jonathan.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.google.gson.Gson;
import com.jonathan.PatientRepository;
import com.jonathan.PatientServices;
import com.jonathan.model.Patient;

@RestController
@CrossOrigin
public class PatientController {

	@Autowired
	private PatientServices service;

	Patient patient;
	@Autowired
	PatientRepository repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	//saves patient into database
	@PostMapping(path="/patient", consumes= {"application/json"})
	public String addPatient(@RequestBody Patient patient_) throws IOException {
		repo.save(patient_);
		patient = patient_;
		
		
		String url = "http://python1-env.eba-pxsmpsb5.us-east-2.elasticbeanstalk.com/results";
		//String url = "http://127.0.0.1:8000/results";
		Gson gson = new Gson();
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		StringEntity postingString = new StringEntity(gson.toJson(patient));
		post.setEntity(postingString);
		post.setHeader("Content-type", "application/json");
		HttpResponse response = httpClient.execute(post);
		Scanner sc = new Scanner(response.getEntity().getContent());
		System.out.println(response.getStatusLine());
		String probability = sc.nextLine();
		sc.close();
		return probability;
		
		
	}
	//returns all patients in database
	@GetMapping("/patients")
	public Patient getPatients(){
		return patient;
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
		String[] csvHead = {"Sex", "Patient Type", "Intubed", "Pneumonia", "Age", "Pregnancy", 
							"Diabetes", "Copd", "Asthma", "Immnuosuppressed", "Hypertension", "Other Disease",
							"Cardiovascular", "Obesity", "Renal Chronic", "Tobacco", "Contact Other Covid","Covid Res","ICU"};
		String[] mapping = {"sex", "patient_type", "intubed", "pneumonia", "age", "pregnancy", 
							"diabetes", "copd", "asthma", "inmsupr", "hypertension", "other_disease",
							"cardiovascular", "obesity", "renal_chronic", "tobacco", "contact_other_covid","covid_res", "icu"};
		writer.writeHeader(csvHead);

		for (Patient patient : listPatients) {
			writer.write(patient, mapping);
		}

		writer.close();

	}
}
