package com.qa.opencart.InterviewQuestions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ThreadTask implements Runnable {

	@Override
	public void run() {
		
		for(int i=0;i<5;i++) {
			System.out.println("Thread " + Thread.currentThread().getName() + " " + LocalDateTime.now());
		}
		
	}

}
