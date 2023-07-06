package com.ont.profiles;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingReportUpdateRepository extends JpaRepository<OnTTrainingDetails, TrainingRecordId>{

	
	@Query("SELECT ot FROM OnTTrainingDetails ot WHERE ot.record.courseName = ?1")
	List<OnTTrainingDetails> showBySOEID(String soeid);

	@Query("SELECT ot FROM OnTTrainingDetails ot WHERE ot.record.courseName = ?1")
	List<OnTTrainingDetails> showByTraining(String course);

}
