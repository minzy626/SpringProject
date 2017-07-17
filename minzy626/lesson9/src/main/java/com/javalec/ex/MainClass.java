package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
//AOP는 핵심기능과 공통기능을 분리시키고 공통기능을 필요로하는 핵심기능들에서 사용하는 방식
//스프링에서는 메소드에만 AOP적용 가능
//공통기능을 proxy에 넣어놓고 호출
//1.의존설정(pom.xml)2.공통기능 클래스제작(Advice역할클래스)3.xml파일에 aspect설정
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo();
		
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
		
		ctx.close();
		
	}
	
}
