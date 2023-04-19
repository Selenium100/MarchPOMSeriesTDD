package com.qa.opencart.InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDatabase {

	public static void main(String[] args) {
		
		Student s1 = new Student("kutu", 140, "science");
		Student s2 = new Student("viswa", 120, "history");
		Student s3 = new Student("abhay", 130, "geography");
		Student s4 = new Student("dibya", 150, "math");
		Student s5 = new Student("nitya", 100, "computer");
		
		ArrayList<Student> studentList = new ArrayList<Student>(Arrays.asList(s1,s2,s3,s4,s5));
		List<Student> sortedByNameList =  studentList.stream().sorted((a,b) -> a.getSname().compareTo(b.getSname())).collect(Collectors.toList());
		
		sortedByNameList.stream().map(e -> e.getSname()).forEach(System.out::println);
		
	}

}
