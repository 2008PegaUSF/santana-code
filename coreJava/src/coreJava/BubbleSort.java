/*
 * Author: Javier Santana
 * 
 * Date: 8/18/2020
 * 
 * Project: Bubble sort
 * 
 * A method that runs a bubble sort
 * to order an array
 * 
 * */
package coreJava;

public class BubbleSort {
	//method for sorting array
	static void bubbleSort(int[] arr) {
		
		int n = arr.length; //get array length 
		
		int temp = 0; // temporary integer as a placeholder for values
		
		//for loop to iterate through values in array 
		for(int i=0; i < n; i++) {
			for(int j=1; j< (n-1); j++) {
				if(arr[j-1] > arr[j]) { //compare values next to each other and switch if less
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] array = {1,0,5,6,3,2,3,7,9,8,4}; //test array
		
		bubbleSort(array); //method call to sort
		
		for(int i : array) {
			System.out.println(array[i]); //print sorted array
		}
	}
}
