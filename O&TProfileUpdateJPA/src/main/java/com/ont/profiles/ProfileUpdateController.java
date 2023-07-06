package com.ont.profiles;

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

@RestController
@RequestMapping("/v1")
public class ProfileUpdateController {

	@Autowired
	ProfileUpdateService profileUpdateService;
	
	//Profile Update (Add)
	@RequestMapping(value="/addProfile", method=RequestMethod.POST)
	public ResponseEntity<EmpProfile> addProfile(@RequestBody EmpProfile empProfile) {
		
		if(profileUpdateService.addProfile(empProfile))
		{	System.out.println("Emp Profile Created" + empProfile);
			return new ResponseEntity(empProfile,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(empProfile,HttpStatus.BAD_REQUEST);
		}
	}
	

	//Profile Update (Add bulk)
	@RequestMapping(value="/addProfileList", method=RequestMethod.POST)
	public ResponseEntity<EmpProfile> addProfileList(@RequestBody List<EmpProfile> empProfileList) {
		
		if(profileUpdateService.addProfileList(empProfileList))
		{	System.out.println("Emp Profile Created" + empProfileList);
			return new ResponseEntity(empProfileList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity(empProfileList,HttpStatus.BAD_REQUEST);
		}
	}
	
	//Profile View all
	@RequestMapping(value="/show/AllProfiles", method=RequestMethod.GET)
	public ResponseEntity<EmpProfile> showAllProfiles(){
		
		List<EmpProfile> empProfiles = new ArrayList();
		empProfiles = profileUpdateService.showAllProfiles();
		return new ResponseEntity(empProfiles,HttpStatus.OK);
		
	}
	
	//Profile ViewBySOEID
	@RequestMapping(value="/show/{soeid}", method=RequestMethod.GET)
	public ResponseEntity<EmpProfile> showProfileBySOEID(@PathVariable String soeid){
		
		EmpProfile empProfile = new EmpProfile();
		System.out.println("\n ShowProfileBySOEID "+soeid);
		empProfile = profileUpdateService.showProfileBySOEID(soeid);
		System.out.println("Results "+empProfile);
		if(empProfile!=null)
		{
			return new ResponseEntity(empProfile,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}



	