package com.jonathan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	private String id;
	private String name;
	private int sex;
	private int patient_Type;
	private String date_Of_Entry;
	private String date_Of_First_Symptoms;
	private String date_Of_Death;
	private int intubed;
	private int pneumonia;
	private int age;
	private int pregnancy;
	
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPatient_Type() {
		return patient_Type;
	}
	public void setPatient_Type(int patientType) {
		this.patient_Type = patientType;
	}
	public String getDate_Of_Entry() {
		return date_Of_Entry;
	}
	public void setDate_Of_Entry(String dateOfEntry) {
		this.date_Of_Entry = dateOfEntry;
	}
	public String getDate_Of_First_Symptoms() {
		return date_Of_First_Symptoms;
	}
	public void setDate_Of_First_Symptoms(String dateOfFirstSymptoms) {
		this.date_Of_First_Symptoms = dateOfFirstSymptoms;
	}
	public String getDate_Of_Death() {
		return date_Of_Death;
	}
	public void setDate_Of_Death(String dateOfDeath) {
		this.date_Of_Death = dateOfDeath;
	}
	public int getIntubed() {
		return intubed;
	}
	public void setIntubed(int intubed) {
		this.intubed = intubed;
	}
	public int getPneumonia() {
		return pneumonia;
	}
	public void setPneumonia(int pneumonia) {
		this.pneumonia = pneumonia;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPregnancy() {
		return pregnancy;
	}
	public void setPregnancy(int pregnancy) {
		this.pregnancy = pregnancy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", sex=" + sex + ", patient_Type=" + patient_Type
				+ ", date_Of_Entry=" + date_Of_Entry + ", date_Of_First_Symptoms=" + date_Of_First_Symptoms
				+ ", date_Of_Death=" + date_Of_Death + ", intubed=" + intubed + ", pneumonia=" + pneumonia + ", age="
				+ age + ", pregnancy=" + pregnancy + "]";
	}

}
