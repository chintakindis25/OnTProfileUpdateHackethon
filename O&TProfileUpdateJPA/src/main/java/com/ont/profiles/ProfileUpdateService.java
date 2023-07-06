package com.ont.profiles;

import java.util.List;

public interface ProfileUpdateService {

	boolean addProfile(EmpProfile empProfile);
	boolean addProfileList(List<EmpProfile> empProfileList);
	List<EmpProfile> showAllProfiles();
	EmpProfile showProfileBySOEID(String soeid);

}
