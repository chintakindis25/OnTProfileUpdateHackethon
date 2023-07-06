package com.ont.profiles;

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

@RestController
@RequestMapping("/v1")
public class OnTTrainingDetailsController {

	@Autowired
	TrainingDetailsService trainingDetailsService;
	
	//Add Training report (single employee)
	@RequestMapping(value="/submitTrainingReport", method=RequestMethod.POST)
	public ResponseEntity<OnTTrainingDetails> submitTrainingReport(@RequestBody OnTTrainingDetails onTTrainingDetails) {
		
		if(trainingDetailsService.submitTrainingReport(onTTrainingDetails))
		{	System.out.println("Training report submitted for 1" + onTTrainingDetails);
			return new ResponseEntity(onTTrainingDetails,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(onTTrainingDetails,HttpStatus.BAD_REQUEST);
		}
	}
	
	//Add Training report (bulk)
	@RequestMapping(value="/submitTrainingReportBulk", method=RequestMethod.POST)
		public ResponseEntity<OnTTrainingDetails> submitTrainingReportInBulk(@RequestBody List<OnTTrainingDetails> onTTrainingDetailsList) {
			
			if(trainingDetailsService.submitTrainingReportInBulk(onTTrainingDetailsList))
			{	System.out.println("Training report submitted for multiple" + onTTrainingDetailsList);
				return new ResponseEntity(onTTrainingDetailsList,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity(onTTrainingDetailsList,HttpStatus.BAD_REQUEST);
			}
		}
	
	
	//Profile View all
	@RequestMapping(value="/show/AllTrainingReports", method=RequestMethod.GET)
	public ResponseEntity<EmpProfile> showAllProfiles(){
		
		List<OnTTrainingDetails> onTTrainingDetails = new ArrayList();
		onTTrainingDetails = trainingDetailsService.showTrainingReport();
		return new ResponseEntity(onTTrainingDetails,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/show/TrainingDetailsBySOEID/{soeid}", method=RequestMethod.POST)
	public ResponseEntity<OnTTrainingDetails> showTrainingDetailsBySOEID(@PathVariable String soeid)
	{
		List<OnTTrainingDetails> onTTrainingDetailsList;
		onTTrainingDetailsList = trainingDetailsService.showTrainingReportBySOEID(soeid);
		return new ResponseEntity(onTTrainingDetailsList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/show/TrainingDetailsByCourse/{course}", method=RequestMethod.POST)
	public ResponseEntity<OnTTrainingDetails> showReportByTraining(@PathVariable String course)
	{
		List<OnTTrainingDetails> onTTrainingDetailsList;
		onTTrainingDetailsList = trainingDetailsService.showReportByCourse(course);
		return new ResponseEntity(onTTrainingDetailsList,HttpStatus.OK);
		
	}
	
	
}
