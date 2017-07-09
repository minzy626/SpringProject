package com.javalec.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); 
		ctx.load("classpath:applicationCTX.xml");
		
		ctx.refresh();
		ctx.close();
	}

}
