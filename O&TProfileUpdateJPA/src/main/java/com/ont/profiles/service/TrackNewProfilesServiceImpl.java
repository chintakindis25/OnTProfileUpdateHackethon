package com.ont.profiles.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ont.profiles.EmpProfile;
import com.ont.profiles.TrackNewProfiles;
import com.ont.profiles.repository.TrackNewProfilesRepository;

@Service
public class TrackNewProfilesServiceImpl implements TrackNewProfilesService {

	
	@Autowired
	TrackNewProfilesRepository newProfilesRepository;
	
	@Override
	public void saveDetails(List<EmpProfile> empProfileList) {
		// TODO Auto-generated method stub
		
		TrackNewProfiles newProfile;
		List<TrackNewProfiles> list = new ArrayList<>();
		for(EmpProfile empProfile:empProfileList)
		{
			newProfile = new TrackNewProfiles();
			newProfile.setSOEID(empProfile.getSoeid());
			newProfile.setFullName(empProfile.getFullName());
			newProfile.setCreatedDate(LocalDate.now());
			newProfile.setFirstTimeUpdate(false);
			list.add(newProfile);
		}
		if (newProfilesRepository.saveAll(list)!=null)
		{System.out.println("Employee records inserted to database");}
		else
		{System.out.println("Employee record could not be inserted");}

		
	}

	@Override
	public void updateFirstTimeUpdateFlag(TrackNewProfiles newProfile) {
		// TODO Auto-generated method stub
		newProfilesRepository.save(newProfile);
	}



	@Override
	public List<TrackNewProfiles> returnAllNewProfiles() {
		// TODO Auto-generated method stub
		return newProfilesRepository.returnAllNewProfiles();
	}

}
