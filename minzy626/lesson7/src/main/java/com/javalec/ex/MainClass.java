package com.javalec.ex;

import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {
	//스프링 컨테이너 생명주기
	//스프링컨테이너 생성-설정(.load를 이용하면 .refresh반드시 해줘야함)-사용-종료(.close)
public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();// 생성

		ctx.load("classpath:applicationCTX.xml");// 설정
		
		ctx.refresh();//호출
		
		Student student = ctx.getBean("student", Student.class);// 사용
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		
		ctx.close();// 종료
		
	}
		

}
