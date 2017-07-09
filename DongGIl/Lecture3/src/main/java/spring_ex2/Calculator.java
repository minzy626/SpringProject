package spring_ex2;

public class Calculator {

	
	public void add(int f, int s) {
		System.out.println("add()");
		int result = f + s;
		System.out.println(f + " + " + s + " = " + result);
	}
	public void sub(int f, int s) {
		System.out.println("sub()");
		int result = f - s;
		System.out.println(f + " - " + s + " = " + result);
	}
	public void mul(int firstNum, int secondNum) {
		System.out.println("mul()");
		int result = firstNum * secondNum;
		System.out.println(firstNum + " * " + secondNum + " = " + result);
	}
	public void div(int firstNum, int secondNum) {
		System.out.println("div()");
		int result = firstNum / secondNum;
		System.out.println(firstNum + " / " + secondNum + " = " + result);
	}
	
}
