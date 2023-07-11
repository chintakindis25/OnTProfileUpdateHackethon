package com.ont.profiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ont.profiles.EmpProfile;

@Repository
public interface ProfileUpdateRepository extends JpaRepository<EmpProfile, String>{

	@Query("SELECT ep FROM EmpProfile ep WHERE ep.soeid = ?1")
	EmpProfile findBySOEID(String inputSOEID);

	@Query("SELECT ep FROM EmpProfile ep WHERE ep.olderThanOneDay = true")
	List<EmpProfile> findAllOldProfiles();
	
//	@Modifying
//	@Query("UPDATE EmpProfile ep SET ep.onTAcademyTrainingCertifications = ?2 WHERE ep.soeid=?1")
//	void updateCourses(String soeid,String courses);

}
