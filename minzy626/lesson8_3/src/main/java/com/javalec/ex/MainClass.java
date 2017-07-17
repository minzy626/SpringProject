package com.javalec.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
//xml이용하지 않고 자바파일 이용하기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AdminConnection connection = ctx.getBean("adminConfig", AdminConnection.class);
		
		System.out.println("adminID : " + connection.getAdminId());
		System.out.println("adminPW : " + connection.getAdminPw());
		System.out.println("sub_adminID : " + connection.getSub_adminId());
		System.out.println("sub_adminPW : " + connection.getSub_adminPw());
		
		ctx.close();

	}

}
