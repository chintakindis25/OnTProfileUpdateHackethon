package com.ont.profiles.batch;

import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DailyJobRunner {

	
	@Autowired
	TrackNewProfilesService newProfilesService;
	
	@Autowired
	ProfileUpdateService profileUpdateService;
	
	@Autowired
	TrainingDetailsService trainingDetailsService;
	
	static List<TrackNewProfiles> newProfileslist;
	//static List<EmpProfile> empProfileslist; 
	//static EmpProfile empProfile;
	static List<OnTTrainingDetails> trainingDetailsList;
	
	
	@Scheduled(cron="0 */1 * * * *")
	public void print()
	{
		System.out.println("Print Daily Job Runner---------------------------------------");
		newProfileslist = newProfilesService.returnAllNewProfiles();
	    for(TrackNewProfiles newProfile:newProfileslist)
	    {
	    	EmpProfile empProfile = profileUpdateService.showProfileBySOEID(newProfile.getSOEID());
	    	if (empProfile!=null)
	    	{
	    		List<OnTTrainingDetails> ontList = trainingDetailsService.showTrainingReportBySOEID(newProfile.getSOEID());
	    		boolean firstCourse=true;
	    		String updatedCourses="";
	    		for(OnTTrainingDetails ont:ontList)
	    		{   updatedCourses = empProfile.getOnTAcademyTrainingCertifications();
	    			if(firstCourse==true)
	    			{
	    				updatedCourses = ont.getRecord().getCourseName();
	    				firstCourse=false;
	    			}else
	    			{
	    				updatedCourses = updatedCourses+","+(ont.getRecord().getCourseName());
	    			}
    				
    				ont.setProfileUpdateStatus(true);
    				trainingDetailsService.updateProfileUpdateStatus(ont);
    				
    				newProfile.setFirstTimeUpdate(true);

    				System.out.println("SOEID -"+empProfile.getSoeid()+" Courses after update - "+updatedCourses);

    				empProfile.setOnTAcademyTrainingCertifications(updatedCourses);
    				empProfile.setOlderThanOneDay(true);
	    		}
			   	newProfilesService.updateFirstTimeUpdateFlag(newProfile);
				profileUpdateService.updateOnTTrainingCertification(empProfile);
//	   	     newProfile.setFirstTimeUpdate(true);
//	   	     newProfilesService.updateFirstTimeUpdateFlag(newProfile);
	    	}
		

	    }

	}
}
