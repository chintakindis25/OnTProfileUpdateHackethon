package com.ont.profiles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProfileUpdateServiceImpl implements ProfileUpdateService{


	@Autowired
	ProfileUpdateRepository profileUpdateRepository;
	
	@Override
	public boolean addProfile(EmpProfile empProfile) {
		EmpProfile p = profileUpdateRepository.save(empProfile);
		System.out.println("saved 1"+p.toString());
		if(p!=null)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addProfileList(List<EmpProfile> empProfileList) {
		List<EmpProfile> p = profileUpdateRepository.saveAll(empProfileList);
		System.out.println("Saved All"+p.toString());
		if(p!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<EmpProfile> showAllProfiles() {
		List<EmpProfile> empProfiles = new ArrayList();
		empProfiles = profileUpdateRepository.findAll();
		return empProfiles;
	}

	@Override
	public EmpProfile showProfileBySOEID(String soeid) {
		EmpProfile empProfile;
		empProfile=profileUpdateRepository.findBySOEID(soeid);
		System.out.println(empProfile);
		return empProfile;
	}
}
