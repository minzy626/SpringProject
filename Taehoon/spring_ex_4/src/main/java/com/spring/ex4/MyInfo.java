package com.spring.ex4;

import java.util.ArrayList;

public class MyInfo {

	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobby;
	private BMICalculator bmiCalculator;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
	public void bmiCalculation() {
		bmiCalculator.bmiCalculation(weight, height);
	}
	
	public void getInfo() {
		System.out.println("이름 : " + name);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("취미 : " + hobby);
		bmiCalculation();
	}
}
