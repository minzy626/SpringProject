package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLoc="classpath:applicationCTX.xml";
		AbstractApplicationContext ctx=new GenericXmlApplicationContext(configLoc);
		MyCalculator calc = ctx.getBean("myCalculator",MyCalculator.class);
		
		calc.add();
		calc.sub();
		calc.mul();
		calc.div();
	}

}


