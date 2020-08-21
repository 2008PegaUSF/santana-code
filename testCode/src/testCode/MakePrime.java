package testCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class MakePrime implements Runnable{
	public static Deque<Integer> deque = new ArrayDeque<Integer>();
	
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			if(deque.size() < 5) {
				addNumber();
			}
		}
	}
	
	
	public static synchronized void addNumber() {
		Random rand = new Random();
		int randint = rand.nextInt(10000);
		deque.addFirst(randint);
		
	}
}
