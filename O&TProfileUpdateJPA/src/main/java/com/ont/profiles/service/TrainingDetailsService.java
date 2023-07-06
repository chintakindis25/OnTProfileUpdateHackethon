/**
 * 
 */
package com.ont.profiles.service;

import java.util.List;

import com.ont.profiles.OnTTrainingDetails;

public interface TrainingDetailsService {

	boolean submitTrainingReport(OnTTrainingDetails onTTrainingDetails);
	boolean submitTrainingReportInBulk(List<OnTTrainingDetails> onTTrainingDetailsList);
	List<OnTTrainingDetails> showTrainingReport();
	List<OnTTrainingDetails> showTrainingReportBySOEID(String soeid);
	List<OnTTrainingDetails> showReportByCourse(String course);
}
