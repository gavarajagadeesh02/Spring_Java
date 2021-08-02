package com.example.project.model;

public class Teacher extends Employee {
	
	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	private String specialization;

}
