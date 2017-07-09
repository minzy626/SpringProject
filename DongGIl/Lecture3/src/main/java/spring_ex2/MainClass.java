package spring_ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyCalculator calcul = ctx.getBean("myCalculator",MyCalculator.class);
		
		calcul.add();
		calcul.sub();
		calcul.mul();
		calcul.div();
		
	//	ctx.close();
	}
}
