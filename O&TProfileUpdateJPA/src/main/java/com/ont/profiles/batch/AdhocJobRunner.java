package com.ont.profiles.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ont.profiles.EmpProfile;
import com.ont.profiles.OnTTrainingDetails;
import com.ont.profiles.TrackNewProfiles;
import com.ont.profiles.service.ProfileUpdateService;
import com.ont.profiles.service.TrackNewProfilesService;
import com.ont.profiles.service.TrainingDetailsService;

@EnableScheduling
@Component
public class AdhocJobRunner {

	@Autowired
	TrackNewProfilesService newProfilesService;
	
	@Autowired
	ProfileUpdateService profileUpdateService;
	
	@Autowired
	TrainingDetailsService trainingDetailsService;
	
//	static List<TrackNewProfiles> newProfileslist;
	static List<EmpProfile> empProfiles;
	//static List<EmpProfile> empProfileslist; 
	static EmpProfile empProfile;
	static List<OnTTrainingDetails> trainingDetailsList;
	
	
	@Scheduled(cron="*/30 * * * * *")
	public void process()
	{
		System.out.println("Print Adhoc Job Runner---------------------------------------");
		trainingDetailsList = trainingDetailsService.showNewEntries();
		for(OnTTrainingDetails ont: trainingDetailsList)
		{
			empProfile = profileUpdateService.showProfileBySOEID(ont.getRecord().getSoeid());
			if(empProfile!=null && empProfile.isOlderThanOneDay())
			{
			//	System.out.println("Course Contains check result "+empProfile.getOnTAcademyTrainingCertifications().contains(ont.getRecord().getCourseName()));
				if(empProfile.getOnTAcademyTrainingCertifications().contains(ont.getRecord().getCourseName())==false)
				{
					String updatedCourses = empProfile.getOnTAcademyTrainingCertifications()+","+ont.getRecord().getCourseName();
					empProfile.setOnTAcademyTrainingCertifications(updatedCourses);
					profileUpdateService.updateOnTTrainingCertification(empProfile);
					System.out.println("SOEID -"+empProfile.getSoeid()+" Courses after update - "+updatedCourses);
					
				//	System.out.println("Before: "+ont);
					ont.setProfileUpdateStatus(true);
				//	System.out.println("After: "+ont);
				}
				ont.setProfileUpdateStatus(true);
				trainingDetailsService.updateProfileUpdateStatus(ont);
			
			}
		}
	}	
}
