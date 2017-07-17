package com.javalec.ex;

public class MyCalculator {
	private Calculator calc;
	private int firstNum;
	private int secondNum;
	public Calculator getCalc() {
		return calc;
	}
	public void setCalc(Calculator calc) {
		this.calc = calc;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void add() {
		calc.addition(firstNum, secondNum);
	}
	public void sub() {
		calc.subtraction(firstNum, secondNum);
	}
	public void mul() {
		calc.multiplication(firstNum, secondNum);
	}
	public void div() {
		calc.division(firstNum, secondNum);
	}

}
