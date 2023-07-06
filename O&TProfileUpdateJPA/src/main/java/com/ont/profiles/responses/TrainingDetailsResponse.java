package com.ont.profiles.responses;

import java.util.List;

import com.ont.profiles.OnTTrainingDetails;

public class TrainingDetailsResponse {

	List<OnTTrainingDetails> trainingDetailslist;
	String responseMessage;
	public TrainingDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainingDetailsResponse(List<OnTTrainingDetails> trainingDetailslist, String responseMessage) {
		super();
		this.trainingDetailslist = trainingDetailslist;
		this.responseMessage = responseMessage;
	}
	public List<OnTTrainingDetails> getTrainingDetailslist() {
		return trainingDetailslist;
	}
	public void setTrainingDetailslist(List<OnTTrainingDetails> trainingDetailslist) {
		this.trainingDetailslist = trainingDetailslist;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	
}
