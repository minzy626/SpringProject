package com.spring.ex6_4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.ex6_4.Student;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Student student1 = ctx.getBean("student1", Student.class);
		
		System.out.println("�̸� : " + student1.getName());
		System.out.println("���� : " + student1.getAge());
		System.out.println("��� : " + student1.getHobbys());
		System.out.println("Ű : " + student1.getHeight());
		System.out.println("������ : " + student1.getWeight());
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("�̸� : " + student2.getName());
		System.out.println("���� : " + student2.getAge());
		System.out.println("��� : " + student2.getHobbys());
		System.out.println("Ű : " + student2.getHeight());
		System.out.println("������ : " + student2.getWeight());
	}

}