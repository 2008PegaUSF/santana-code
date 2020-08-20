package MyPackage;

public class Exceptions extends Exception{
	
	//no parameter constructor (if it has, then parameter constructor)
	public Exceptions() {
		super();
	}
	
	
	public static int quotient(int number1, int number2) throws ArithmeticException {
		if(number2 == 0) {
			throw new ArithmeticException("Denominator cannot be zero");
		}
		return number1 / number2;
	}
	
	public static void main(String[] args){
		int number1 = 5;
		int number2 = 0;
		
		try {
			int result = quotient(number1, number2);
			System.out.println(number1 + " / " + number2 + " is " + number1/number2);
		}
		catch (ArithmeticException ex){
			System.out.println("Exception: Cannot divide any number by 0");
		}
		
		
	}
}