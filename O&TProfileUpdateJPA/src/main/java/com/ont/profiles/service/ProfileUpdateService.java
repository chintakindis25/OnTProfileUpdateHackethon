package com.ont.profiles.service;

import java.util.List;

import com.ont.profiles.EmpProfile;

public interface ProfileUpdateService {

	boolean addProfile(EmpProfile empProfile);
	boolean addProfileList(List<EmpProfile> empProfileList);
	List<EmpProfile> showAllProfiles();
	EmpProfile showProfileBySOEID(String soeid);
	void updateOnTTrainingCertification(EmpProfile empProfile);
	List<EmpProfile> returnAllOldProfiles();

}
