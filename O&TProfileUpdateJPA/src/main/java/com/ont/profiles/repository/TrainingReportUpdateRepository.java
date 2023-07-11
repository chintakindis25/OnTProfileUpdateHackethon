package com.ont.profiles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ont.profiles.OnTTrainingDetails;
import com.ont.profiles.TrainingRecordId;

@Repository
public interface TrainingReportUpdateRepository extends JpaRepository<OnTTrainingDetails, TrainingRecordId>{

	
	@Query("SELECT ot FROM OnTTrainingDetails ot WHERE ot.record.soeid = ?1")
	List<OnTTrainingDetails> showBySOEID(String soeid);

	@Query("SELECT ot FROM OnTTrainingDetails ot WHERE ot.record.courseName = ?1")
	List<OnTTrainingDetails> showByTraining(String course);

	@Query("SELECT ot FROM OnTTrainingDetails ot WHERE ot.record.soeid = ?1 and ot.profileUpdateStatus = ?2")
	List<OnTTrainingDetails> showBySOEID_NewEntries(String soeid,boolean profileUpdateStatus);

	@Query("SELECT ot FROM OnTTrainingDetails ot WHERE ot.profileUpdateStatus = false")
	List<OnTTrainingDetails> showNewEntries();

//	@Modifying
//	@Query("UPDATE OnTTrainingDetails ot SET ot.profileUpdateStatus = true where ot.record.soeid = ?1 ")
//	void updateProfileUpdateStatus(String soeid);
}
