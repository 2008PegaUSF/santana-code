/*
 * Author: Javier Santana
 * 
 * Date: 8/18/2020
 * 
 * Project: Fibonacci
 * 
 * A method that produces the first
 * 25 numbers of the fibonacci sequence
 * 
 * */
package coreJava;

public class Fibonacci {
	static int initial = 0;
	static int[] fib;
	
	
	static void fibonacci() {
		int temp = 1;
		int result = 0;
		for(int i=1; i < 26; i++) {
			result = initial + temp;
			fib[i] = result;
			initial = temp;
			temp = result;
		}
		
		for(int i=0; i < fib.length; i++) {
			System.out.println(fib[i]);
		}
		
	}
	
	public static void main(String[] args) {
		fibonacci();
	}
}
