package com.ont.profiles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingDetailsServiceImpl implements TrainingDetailsService {

	
	@Autowired
	TrainingReportUpdateRepository trainingReportUpdateRepository;
		
	@Override
	public boolean submitTrainingReport(OnTTrainingDetails onTTrainingDetails) {
		// TODO Auto-generated method stub
	
		OnTTrainingDetails p = trainingReportUpdateRepository.save(onTTrainingDetails);
		System.out.println("saved 1"+p.toString());
		if(p!=null)
		{
			return true;
		}
			
		return false;
	}

	@Override
	public boolean submitTrainingReportInBulk(List<OnTTrainingDetails> onTTrainingDetailsList) {
		
		List<OnTTrainingDetails> list = new ArrayList();
		list = trainingReportUpdateRepository.saveAll(onTTrainingDetailsList);
		if(list!=null)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public List<OnTTrainingDetails> showTrainingReport() {
		// TODO Auto-generated method stub
		List<OnTTrainingDetails> onTTrainingDetails;
		onTTrainingDetails = trainingReportUpdateRepository.findAll();
		return onTTrainingDetails;
	}


	@Override
	public List<OnTTrainingDetails> showTrainingReportBySOEID(String soeid) {
		// TODO Auto-generated method stub
		List<OnTTrainingDetails> list = trainingReportUpdateRepository.showBySOEID(soeid);
		return list;
	}

	@Override
	public List<OnTTrainingDetails> showReportByCourse(String course) {
		
		List<OnTTrainingDetails> list = trainingReportUpdateRepository.showByTraining(course);
		// TODO Auto-generated method stub
		return list;
	}
	
}
