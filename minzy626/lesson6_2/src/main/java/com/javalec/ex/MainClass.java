package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {
//java파일을 이용해서 DI하는 방법 XML파일대신 Config자바파일 만들어서 사용하는것.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());
		System.out.println(student1.getAge());
		System.out.println(student1.getHobbys());
		
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		System.out.println(student2.getHobbys());
	
		ctx.close();
	}

}


