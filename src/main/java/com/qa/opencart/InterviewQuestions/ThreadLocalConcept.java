package com.qa.opencart.InterviewQuestions;

public class ThreadLocalConcept {

	public static void main(String[] args) {
		
		ThreadLocal<String> tl = new ThreadLocal<String>();
		
		Thread thread1 = new Thread(() ->{
			tl.set("Thread-1");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String value1 = tl.get();
			System.out.println(value1);
		});
		
		
		
		Thread thread2 = new Thread(() ->{
			tl.set("Thread-2");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String value2 = tl.get();
			System.out.println(value2);
		});
		
		
		
		thread1.start();
		thread2.start();
		

	}

}
