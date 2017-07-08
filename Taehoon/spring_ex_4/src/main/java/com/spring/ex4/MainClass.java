package com.spring.ex4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String configLoc = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		
		myInfo.getInfo();
		ctx.close();
	}

}
