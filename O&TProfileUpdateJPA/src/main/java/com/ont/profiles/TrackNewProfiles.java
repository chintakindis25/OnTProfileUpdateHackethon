package com.ont.profiles;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class TrackNewProfiles {

	@Id
	String SOEID;
	@Column
	String fullName;
	@Column
	LocalDate createdDate;
	@Column
	boolean firstTimeUpdate;
	
	public boolean isFirstTimeUpdate() {
		return firstTimeUpdate;
	}
	public void setFirstTimeUpdate(boolean firstTimeUpdate) {
		this.firstTimeUpdate = firstTimeUpdate;
	}
	public TrackNewProfiles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrackNewProfiles(String sOEID, String fullName, LocalDate createdDate, boolean firstTimeUpdate) {
		super();
		SOEID = sOEID;
		this.fullName = fullName;
		this.createdDate = createdDate;
		this.firstTimeUpdate = firstTimeUpdate;
	}
	public String getSOEID() {
		return SOEID;
	}
	public void setSOEID(String sOEID) {
		SOEID = sOEID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	
}
