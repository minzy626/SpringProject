package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass {
	//리소스 파일만 바꿔주면 된당.자바파일 변경 없이 유지보수 가능!!

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		//경로는 복사 붙여넣기 습관들이기 오타로 오류나면 화가나~~
		Pencil pencil = ctx.getBean("pencil", Pencil.class);
		pencil.use();
		
		ctx.close();//자원 닫아주는 습관 들이기~~

	}

}
