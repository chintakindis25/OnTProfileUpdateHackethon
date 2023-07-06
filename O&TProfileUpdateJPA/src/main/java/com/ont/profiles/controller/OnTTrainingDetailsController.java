package com.ont.profiles.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ont.profiles.EmpProfile;
import com.ont.profiles.OnTTrainingDetails;
import com.ont.profiles.responses.TrainingDetailsResponse;
import com.ont.profiles.service.TrainingDetailsService;

@RestController
@RequestMapping("/v1")
public class OnTTrainingDetailsController {

	@Autowired
	TrainingDetailsService trainingDetailsService;
	
	//Add Training report (single employee)
	@RequestMapping(value="/submitTrainingReport", method=RequestMethod.POST)
	public ResponseEntity<TrainingDetailsResponse> submitTrainingReport(@RequestBody OnTTrainingDetails onTTrainingDetails) {
		
		TrainingDetailsResponse response = new TrainingDetailsResponse();
		response.setTrainingDetailslist(new ArrayList<>());
		response.setResponseMessage("");
		
		if(trainingDetailsService.submitTrainingReport(onTTrainingDetails))
		{	//System.out.println("Training report submitted for 1" + onTTrainingDetails);
			response.getTrainingDetailslist().add(onTTrainingDetails);
			response.setResponseMessage("Training details report saved in database.");
			return new ResponseEntity(response,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	//Add Training report (bulk)	
	@RequestMapping(value="/submitTrainingReportBulk", method=RequestMethod.POST)
		public ResponseEntity<TrainingDetailsResponse> submitTrainingReportInBulk(@RequestBody List<OnTTrainingDetails> onTTrainingDetailsList) {
			
		
			TrainingDetailsResponse response = new TrainingDetailsResponse();
			response.setTrainingDetailslist(new ArrayList<>());
			response.setResponseMessage("");
		
			if(trainingDetailsService.submitTrainingReportInBulk(onTTrainingDetailsList))
			{	//System.out.println("Training report submitted for multiple" + onTTrainingDetailsList);
				response.setTrainingDetailslist(onTTrainingDetailsList);
				response.setResponseMessage("Training details report saved in database.");
				return new ResponseEntity(response,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
			}
		}
	
	
	//Profile View all
	@RequestMapping(value="/show/AllTrainingReports", method=RequestMethod.GET)
	public ResponseEntity<EmpProfile> showAllProfiles(){
		

		TrainingDetailsResponse response = new TrainingDetailsResponse();
		response.setTrainingDetailslist(new ArrayList<>());
		response.setResponseMessage("");
		
		List<OnTTrainingDetails> onTTrainingDetails = new ArrayList();
		onTTrainingDetails = trainingDetailsService.showTrainingReport();
		
		if(onTTrainingDetails != null)
		{
			response.setTrainingDetailslist(onTTrainingDetails);
			response.setResponseMessage("Training details returned.");
		}
		else
		{
			response.setResponseMessage("No records in database.");
		}
		
		return new ResponseEntity(response,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/show/TrainingDetailsBySOEID/{soeid}", method=RequestMethod.POST)
	public ResponseEntity<TrainingDetailsResponse> showTrainingDetailsBySOEID(@PathVariable String soeid)
	{

		TrainingDetailsResponse response = new TrainingDetailsResponse();
		response.setTrainingDetailslist(new ArrayList<>());
		response.setResponseMessage("");
		List<OnTTrainingDetails> onTTrainingDetailsList;
		onTTrainingDetailsList = trainingDetailsService.showTrainingReportBySOEID(soeid);
		
		if(onTTrainingDetailsList != null)
		{
			response.setTrainingDetailslist(onTTrainingDetailsList);
			response.setResponseMessage("Training details returned.");
		}
		else
		{
			response.setResponseMessage("No records in database.");
		}
		return new ResponseEntity(response,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/show/TrainingDetailsByCourse/{course}", method=RequestMethod.POST)
	public ResponseEntity<TrainingDetailsResponse> showReportByTraining(@PathVariable String course)
	{

		TrainingDetailsResponse response = new TrainingDetailsResponse();
		response.setTrainingDetailslist(new ArrayList<>());
		response.setResponseMessage("");
		
		List<OnTTrainingDetails> onTTrainingDetailsList;
		onTTrainingDetailsList = trainingDetailsService.showReportByCourse(course);
		if(onTTrainingDetailsList != null)
		{
			response.setTrainingDetailslist(onTTrainingDetailsList);
			response.setResponseMessage("Training details returned.");
		}
		else
		{
			response.setResponseMessage("No records in database.");
		}
		return new ResponseEntity(response,HttpStatus.OK);
	}
	
	
}
