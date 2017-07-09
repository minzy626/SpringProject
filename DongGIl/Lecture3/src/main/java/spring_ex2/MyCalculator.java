package spring_ex2;

public class MyCalculator {
	
	public Calculator calculator;
	private int firstNum;
	private int secondNum;
	
	public void add() {
		calculator.add(firstNum,secondNum);
	}
	public void sub() {

		calculator.sub(firstNum,secondNum);
	}
	public void mul() {

		calculator.mul(firstNum,secondNum);
	}
	public void div() {

		calculator.div(firstNum,secondNum);
	}

	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public Calculator getMycalculator() {
		return calculator;
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
	
	
	
	
}
