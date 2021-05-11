package com.jonathan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	int sex;
	int patient_type;
	int intubed;
	int pneumonia;
	int age;
	int pregnancy;
	int diabetes;
	int copd;
	int asthma;
	int inmsupr;
	int hypertension;
	int other_disease;
	int cardiovascular;
	int obesity;
	int renal_chronic;
	int tobacco;
	int contact_other_covid;
	int covid_res;
	int icu;
	
	public int getCovid_res() {
		return covid_res;
	}
	public void setCovid_res(int covid_res) {
		this.covid_res = covid_res;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPatient_type() {
		return patient_type;
	}
	public void setPatient_type(int patient_type) {
		this.patient_type = patient_type;
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
	public int getDiabetes() {
		return diabetes;
	}
	public void setDiabetes(int diabetes) {
		this.diabetes = diabetes;
	}
	public int getCopd() {
		return copd;
	}
	public void setCopd(int copd) {
		this.copd = copd;
	}
	public int getAsthma() {
		return asthma;
	}
	public void setAsthma(int asthma) {
		this.asthma = asthma;
	}
	public int getInmsupr() {
		return inmsupr;
	}
	public void setInmsupr(int inmsupr) {
		this.inmsupr = inmsupr;
	}
	public int getHypertension() {
		return hypertension;
	}
	public void setHypertension(int hypertension) {
		this.hypertension = hypertension;
	}
	public int getOther_disease() {
		return other_disease;
	}
	public void setOther_disease(int other_disease) {
		this.other_disease = other_disease;
	}
	public int getCardiovascular() {
		return cardiovascular;
	}
	public void setCardiovascular(int cardiovascular) {
		this.cardiovascular = cardiovascular;
	}
	public int getObesity() {
		return obesity;
	}
	public void setObesity(int obesity) {
		this.obesity = obesity;
	}
	public int getRenal_chronic() {
		return renal_chronic;
	}
	public void setRenal_chronic(int renal_chronic) {
		this.renal_chronic = renal_chronic;
	}
	public int getTobacco() {
		return tobacco;
	}
	public void setTobacco(int tobacco) {
		this.tobacco = tobacco;
	}
	public int getContact_other_covid() {
		return contact_other_covid;
	}
	public void setContact_other_covid(int contact_other_covid) {
		this.contact_other_covid = contact_other_covid;
	}
	public int getIcu() {
		return icu;
	}
	public void setIcu(int icu) {
		this.icu = icu;
	}
	@Override
	public String toString() {
		return "Patient [sex=" + sex + ", patient_type=" + patient_type + ", intubed=" + intubed + ", pneumonia="
				+ pneumonia + ", age=" + age + ", pregnancy=" + pregnancy + ", diabetes=" + diabetes + ", copd=" + copd
				+ ", asthma=" + asthma + ", inmsupr=" + inmsupr + ", hypertension=" + hypertension + ", other_disease="
				+ other_disease + ", cardiovascular=" + cardiovascular + ", obesity=" + obesity + ", renal_chronic="
				+ renal_chronic + ", tobacco=" + tobacco + ", contact_other_covid=" + contact_other_covid
				+ ", covid_res=" + covid_res + ", icu=" + icu + ", getCovid_res()=" + getCovid_res() + ", getSex()="
				+ getSex() + ", getPatient_type()=" + getPatient_type() + ", getIntubed()=" + getIntubed()
				+ ", getPneumonia()=" + getPneumonia() + ", getAge()=" + getAge() + ", getPregnancy()=" + getPregnancy()
				+ ", getDiabetes()=" + getDiabetes() + ", getCopd()=" + getCopd() + ", getAsthma()=" + getAsthma()
				+ ", getInmsupr()=" + getInmsupr() + ", getHypertension()=" + getHypertension()
				+ ", getOther_disease()=" + getOther_disease() + ", getCardiovascular()=" + getCardiovascular()
				+ ", getObesity()=" + getObesity() + ", getRenal_chronic()=" + getRenal_chronic() + ", getTobacco()="
				+ getTobacco() + ", getContact_other_covid()=" + getContact_other_covid() + ", getIcu()=" + getIcu()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
