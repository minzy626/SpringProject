package com.java.ex;

import java.util.ArrayList;

public class MyInfo {
	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobby;
	private BMICalculator bmiCalc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public ArrayList<String> getHobby() {
		return hobby;
	}
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	public BMICalculator getBmiCalc() {
		return bmiCalc;
	}
	public void setBmiCalc(BMICalculator bmiCalc) {
		this.bmiCalc = bmiCalc;
	}
	public void getInfo() {
		System.out.println("이름"+name);
		System.out.println("키"+height);
		System.out.println("몸무게"+weight);
		System.out.println("취미"+hobby);
		bmiCalc.bmiCalculation(weight, height);
	}
}
