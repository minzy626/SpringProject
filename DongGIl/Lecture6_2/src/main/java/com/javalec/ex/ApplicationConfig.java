package com.javalec.ex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("잠");
		hobbys.add("게임");
		
		Student student = new Student("노동길", 25, hobbys);
		student.setHeight(180);
		student.setWeight(90);
		
		return student;
	}
	@Bean
public Student student2() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("운동");
		
		Student student = new Student("김길길", 22, hobbys);
		student.setHeight(160);
		student.setWeight(50);
		
		return student;
	}
}
