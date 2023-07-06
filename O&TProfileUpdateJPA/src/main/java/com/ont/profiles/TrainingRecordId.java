package com.ont.profiles;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class TrainingRecordId implements Serializable {
	
	String soeid;
	String name;
	String courseName;
	public TrainingRecordId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainingRecordId(String soeid, String name, String courseName) {
		super();
		this.soeid = soeid;
		this.name = name;
		this.courseName = courseName;
	}
	public String getSoeid() {
		return soeid;
	}
	public void setSoeid(String soeid) {
		this.soeid = soeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
}
