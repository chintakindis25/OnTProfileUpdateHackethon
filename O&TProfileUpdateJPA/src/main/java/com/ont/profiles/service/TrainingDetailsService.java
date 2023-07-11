/**
 * 
 */
package com.ont.profiles.service;

import java.util.List;

import com.ont.profiles.OnTTrainingDetails;
import com.ont.profiles.TrackNewProfiles;

public interface TrainingDetailsService {

	boolean submitTrainingReport(OnTTrainingDetails onTTrainingDetails);
	boolean submitTrainingReportInBulk(List<OnTTrainingDetails> onTTrainingDetailsList);
	List<OnTTrainingDetails> showTrainingReport();
	List<OnTTrainingDetails> showTrainingReportBySOEID(String soeid);
	List<OnTTrainingDetails> showReportByCourse(String course);
	List<OnTTrainingDetails> showTrainingReportBySOEID_NewEntries(String soeid);
	void updateProfileUpdateStatus(OnTTrainingDetails ont);
	List<OnTTrainingDetails> showNewEntries();
}
