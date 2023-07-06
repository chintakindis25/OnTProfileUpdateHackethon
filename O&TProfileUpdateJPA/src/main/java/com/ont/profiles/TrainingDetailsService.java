/**
 * 
 */
package com.ont.profiles;

import java.util.List;

public interface TrainingDetailsService {

	boolean submitTrainingReport(OnTTrainingDetails onTTrainingDetails);
	boolean submitTrainingReportInBulk(List<OnTTrainingDetails> onTTrainingDetailsList);
	List<OnTTrainingDetails> showTrainingReport();
	List<OnTTrainingDetails> showTrainingReportBySOEID(String soeid);
	List<OnTTrainingDetails> showReportByCourse(String course);
}
