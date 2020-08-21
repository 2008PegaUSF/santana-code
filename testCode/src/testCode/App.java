package testCode;

public class App {
	public static void main(String[] args) {
		
		Runnable runnable = new MakePrime();
		Thread makePrime = new Thread(runnable);
		Runnable runnable2 = new TakePrime();
		Thread takePrime = new Thread(runnable2);
		
		makePrime.start();
		takePrime.start();
	}
}
