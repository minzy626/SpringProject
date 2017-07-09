package spring_ex1;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate calcul = new Calculate();
		calcul.setFirstNum(10);
		calcul.setSecondNum(5);
		
		calcul.add();
		calcul.sub();
		calcul.mul();
		calcul.div();
	}
}
