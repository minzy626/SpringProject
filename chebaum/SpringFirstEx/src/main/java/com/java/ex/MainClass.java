package com.java.ex;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		String configLoc="classpath:applicationCTX.xml";
		AbstractApplicationContext ctx=new GenericXmlApplicationContext(configLoc);
		MyCalculator calc = ctx.getBean("myCalculator",MyCalculator.class);
		
		calc.add();
		calc.sub();
		calc.mul();
		calc.div();
	}

}
