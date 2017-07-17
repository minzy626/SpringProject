package com.javalec.ex;

import javax.annotation.*;

public class OtherStudent {
	private String name;
	private int age;
	
	public OtherStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@PostConstruct //빈 초기화 과정에서 생성
	public void initMethod() {
		System.out.println("initMethod()");
	}
	
	@PreDestroy //빈 소멸과정에서 생성
	public void destroyMethod() {
		System.out.println("destroyMethod()");
	}
}
