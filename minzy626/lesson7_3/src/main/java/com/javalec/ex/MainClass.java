package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
//스프링 빈 범위(scope)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		System.out.println(student1.getName());//xml값 가져옴
		System.out.println(student1.getAge());//xml값 가져옴
		
		
		Student student2 = ctx.getBean("student", Student.class);
		student2.setName("홀길자");//속성값 새로설정
		student2.setAge(20);//값 새로설정
		
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		

		if(student1.equals(student2)) {
			System.out.println("student1 == student2"); //찍어내는 값만 student2에서 새로 설정 했을 뿐 1과 2는 같은객체이다.~~~~~~~
		} else {
			System.out.println("student1 != student2");
		}
		
		ctx.close();
		

	}

}
