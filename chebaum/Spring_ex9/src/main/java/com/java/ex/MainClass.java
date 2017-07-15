package com.java.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Student student=ctx.getBean("student", Student.class);
		student.getStudentInfo();
		student.printMeaningless();
		
		Worker worker=ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
		
		ctx.close();
				
	}

}