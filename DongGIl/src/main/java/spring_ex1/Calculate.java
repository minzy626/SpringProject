package spring_ex1;

public class Calculate {
	private int firstNum;
	private int secondNum;
	
	public void add() {
		System.out.println("add()");
		int result = firstNum + secondNum;
		System.out.println(firstNum + " + " + secondNum + " = " + result);
	}
	public void sub() {
		System.out.println("sub()");
		int result = firstNum - secondNum;
		System.out.println(firstNum + " - " + secondNum + " = " + result);
	}
	public void mul() {
		System.out.println("mul()");
		int result = firstNum * secondNum;
		System.out.println(firstNum + " * " + secondNum + " = " + result);
	}
	public void div() {
		System.out.println("div()");
		int result = firstNum / secondNum;
		System.out.println(firstNum + " / " + secondNum + " = " + result);
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
}
