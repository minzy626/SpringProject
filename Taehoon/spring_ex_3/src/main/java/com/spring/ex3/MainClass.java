package com.spring.ex3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String configLoc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyCalculator myCalcultor = ctx.getBean("myCalculator", MyCalculator.class);
		
		myCalcultor.add();
		myCalcultor.sub();
		myCalcultor.mult();
		myCalcultor.div();
	}

}
