package com.ont.profiles.responses;

import java.util.List;

import com.ont.profiles.EmpProfile;


public class ProfileUpdateResponse {

	List<EmpProfile> empProfileList;
	String responseMessage;
	public List<EmpProfile> getEmpProfileList() {
		return empProfileList;
	}
	public void setEmpProfileList(List<EmpProfile> empProfileList) {
		this.empProfileList = empProfileList;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public ProfileUpdateResponse(List<EmpProfile> empProfileList, String responseMessage) {
		super();
		this.empProfileList = empProfileList;
		this.responseMessage = responseMessage;
	}
	public ProfileUpdateResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
