package com.qa.opencart.InterviewQuestions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;



public class Test4 {

	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();

		Runnable r1 = () -> {
			for (int i = 1; i <=10000; i++) {

				c.increment();
			}
		};

		Runnable r2 = () -> {
			for (int i = 1; i <= 10000; i++) {
				c.increment();
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

		System.out.println(c.count);

	}

}
