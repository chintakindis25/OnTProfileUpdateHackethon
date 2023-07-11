package com.ont.profiles;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table
public class OnTTrainingDetails {

	
	@EmbeddedId
	TrainingRecordId record;
	
	@Column
	String durationInWeeks;
	
	@Column
	boolean profileUpdateStatus;
	
	public OnTTrainingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OnTTrainingDetails(TrainingRecordId key, String courseName, String durationInWeeks, boolean profileUpdateStatus) {
		super();
		this.record = key;
		this.durationInWeeks = durationInWeeks;
		this.profileUpdateStatus = profileUpdateStatus;
	}
	
	
	public TrainingRecordId getRecord() {
		return record;
	}
	public void setRecord(TrainingRecordId record) {
		this.record = record;
	}
	public String getDurationInWeeks() {
		return durationInWeeks;
	}
	public void setDurationInWeeks(String durationInWeeks) {
		this.durationInWeeks = durationInWeeks;
	}
	public boolean isProfileUpdateStatus() {
		return profileUpdateStatus;
	}
	public void setProfileUpdateStatus(boolean profileUpdateStatus) {
		this.profileUpdateStatus = profileUpdateStatus;
	}
	@Override
	public String toString() {
		return "OnTTrainingDetails [record=" + record + ", durationInWeeks=" + durationInWeeks
				+ ", profileUpdateStatus=" + profileUpdateStatus + "]";
	}
	
	
}
