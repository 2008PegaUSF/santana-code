package testCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Threads extends Thread{
	
	public void run() {
		for(int i = 0; i < 1; i++) {
			addNumber();
		}
		
	}
	
	public static synchronized void addNumber() {
		Random rand = new Random();
		for(int i=0; i < 5; i++) {
			int randint = rand.nextInt(10000);
				
			Deque<Integer> deque = new ArrayDeque<Integer>(5);
				
			deque.add(randint);
			System.out.println(deque);
		}
	}
}
