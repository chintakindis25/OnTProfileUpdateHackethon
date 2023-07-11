package com.ont.profiles.batch;

import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@SpringBootApplication
//@EnableScheduling
public class BatchProcessingApplication {

	public static void main(String[] args) throws Exception {
		System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessingApplication.class, args)));
	}

//	@Component
//	class DailyJobRunner implements CommandLineRunner {
//
//		@Override
//		public void run(String... args) throws Exception {
//			// TODO Auto-generated method stub
//			
//			
//		}
//		
//		@Scheduled(cron="*/10 * * * * *")
//		void print()
//		{
//			System.out.println("Hello");
//		}
//		
//		
//		
//	}
}
