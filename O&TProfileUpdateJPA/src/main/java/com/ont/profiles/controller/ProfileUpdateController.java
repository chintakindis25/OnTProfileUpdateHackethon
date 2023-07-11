package com.ont.profiles.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.ont.profiles.EmpProfile;
import com.ont.profiles.responses.ProfileUpdateResponse;
import com.ont.profiles.service.ProfileUpdateService;
import com.ont.profiles.service.TrackNewProfilesService;

@RestController
@RequestMapping("/v1")
public class ProfileUpdateController {

	@Autowired
	ProfileUpdateService profileUpdateService;
	
	@Autowired
	TrackNewProfilesService trackNewProfilesService;

	//Profile Update (Add)
	@RequestMapping(value="/addProfile", method=RequestMethod.POST)
	public ResponseEntity<ProfileUpdateResponse> addProfile(@RequestBody EmpProfile empProfile) {
		
		ProfileUpdateResponse response = new ProfileUpdateResponse();
		response.setEmpProfileList(new ArrayList<>());
		response.setResponseMessage("");
		empProfile.setOlderThanOneDay(false);
		if(profileUpdateService.addProfile(empProfile))
		{	//System.out.println("Emp Profile Created" + empProfile);
			
			//Add SOEID to temporary table for daily batch
		//	trackNewProfilesService.writeToCSVWriter(empProfile);
			List<EmpProfile> list = new ArrayList<>();
			list.add(empProfile);
			trackNewProfilesService.saveDetails(list);
			
			//trackNewProfilesService.saveDetails((empProfile));
			response.getEmpProfileList().add(empProfile);
			response.setResponseMessage("Employee Profile created.");
			return new ResponseEntity(response,HttpStatus.OK);
		}
		else
		{	response.setResponseMessage("Error creating Employee Profile.");
			return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
		}
	}
	

	//Profile Update (Add bulk)
	@RequestMapping(value="/addProfileList", method=RequestMethod.POST)
	public ResponseEntity<ProfileUpdateResponse> addProfileList(@RequestBody List<EmpProfile> empProfileList) {
		

		ProfileUpdateResponse response = new ProfileUpdateResponse();
		response.setEmpProfileList(new ArrayList<>());
		response.setResponseMessage("");
		for(EmpProfile empProfile:empProfileList)
		{
			empProfile.setOlderThanOneDay(false);
		}
		if(profileUpdateService.addProfileList(empProfileList))
		{	
			trackNewProfilesService.saveDetails(empProfileList);
			response.setEmpProfileList(empProfileList);
			response.setResponseMessage("Employee Profiles created.");
			//System.out.println("Emp Profile Created" + empProfileList);
			return new ResponseEntity(response,HttpStatus.OK);
		}
		else
		{
			response.setResponseMessage("Error creating Employee Profile.");
			return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	//Profile View all
	@RequestMapping(value="/show/AllProfiles", method=RequestMethod.GET)
	public ResponseEntity<ProfileUpdateResponse> showAllProfiles(){
		

		ProfileUpdateResponse response = new ProfileUpdateResponse();
		response.setEmpProfileList(new ArrayList<>());
		response.setResponseMessage("");
		List<EmpProfile> empProfiles = new ArrayList();
		empProfiles = profileUpdateService.showAllProfiles();
		
		if(empProfiles != null)
		{
			response.setEmpProfileList(empProfiles);
			response.setResponseMessage("Employee Profiles details returned.");
		}
		else
		{
			response.setResponseMessage("No records in database.");
		}
		
		return new ResponseEntity(response,HttpStatus.OK);
		
	}
	
	//Profile ViewBySOEID
	@RequestMapping(value="/show/{soeid}", method=RequestMethod.GET)
	public ResponseEntity<ProfileUpdateResponse> showProfileBySOEID(@PathVariable String soeid){
		
		ProfileUpdateResponse response = new ProfileUpdateResponse();
		response.setEmpProfileList(new ArrayList<>());
		response.setResponseMessage("");

		EmpProfile empProfile = new EmpProfile();
		//System.out.println("\n ShowProfileBySOEID "+soeid);
		empProfile = profileUpdateService.showProfileBySOEID(soeid);
		//System.out.println("Results "+empProfile);
		if(empProfile!=null)
		{
			response.getEmpProfileList().add(empProfile);
			response.setResponseMessage("Employee Profile details returned for "+soeid+".");
			return new ResponseEntity(response,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(response,HttpStatus.NOT_FOUND);
		}
		
	}
}



	