package com.spring.ex5;

public class StudentInfo {

	private Student student;
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void getStudentInfo() {
		if(student != null) {
			System.out.println("�̸� : " + student.getName());
			System.out.println("���� : " + student.getAge());
			System.out.println("�г� : " + student.getGradeNum());
			System.out.println("�� : " + student.getClassNum());
			System.out.println("================================");
		}
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
