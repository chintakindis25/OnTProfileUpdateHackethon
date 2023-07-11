package com.ont.profiles.service;

import java.util.List;

import com.ont.profiles.EmpProfile;
import com.ont.profiles.TrackNewProfiles;

public interface TrackNewProfilesService {

	//void saveDetails(EmpProfile empProfile);

	void saveDetails(List<EmpProfile> empProfileList);

	//List<TrackNewProfiles> returnAll();

	void updateFirstTimeUpdateFlag(TrackNewProfiles newProfile);

	List<TrackNewProfiles> returnAllNewProfiles();

//	void writeToCSVWriter(List<EmpProfile> list);
//
//	void writeToCSVWriter(EmpProfile empProfile);

}
