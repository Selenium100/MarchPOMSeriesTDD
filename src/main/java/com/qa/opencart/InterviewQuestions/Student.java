package com.qa.opencart.InterviewQuestions;

public class Student {
	
	String sname;
	int rollno;
	String subject;
	
	
	public Student(String sname,int rollno,String subject) {
		this.sname=sname;
		this.rollno=rollno;
		this.subject=subject;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getRollno() {
		return rollno;
	}


	public void setRollno(int rollno) {
		this.rollno = rollno;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	@Override
	public String toString() {
		return "Student [sname=" + sname + ", rollno=" + rollno + ", subject=" + subject + "]";
	}
	
	

}
