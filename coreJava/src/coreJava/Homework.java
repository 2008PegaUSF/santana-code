package coreJava;

public class Homework {

	//method for sorting array (bubble sort)
	public void BubbleSort(int[] arr){
		int temp = 0;
		
		for(int i=0; i < arr.length; i++) {
			for(int j = 1; j < (arr.length-i); j++) {
				if(arr[j-1] > arr[j]) { //compare both values and swap if needed
					temp = arr[j-1]; //left value becomes temporary
					arr[j-1] = arr[j]; // right value swaps with left
					arr[j] = temp; // right value swaps with temporary (old left)
				}
			}
		}
		for(int x : arr) {
			System.out.print(x + ", "); //print sorted array
		}
	}
	
	//method for first 25 numbers of fibonacci sequence without recursion
	public void fibonacci() {
		int num1  =  0;
		int num2 = 1;
		int num3 = 0;
		int[] arr = new int[25]; //initialize array and set size
		arr[0] = num1; //assigning value for first digit
		arr[1] = num2; // assigning value for second digit
		
		for(int i = 2; i < arr.length; i++) {
			num3 = num1 + num2; //third number is the sum of first and second
			arr[i] = num3; //add to array
			num1 = num2; // used to move to next number
			num2 = num3; // used to move to next number
		}
		
		for(int x : arr) {
			System.out.print(x + ", ");
		}
	}
	
	public void reverse(String a) {
		for(int i = 0; i < a.length(); i++){
			a = a.substring(1, (a.length() - i))
					+ a.substring(0,1)
					+ a.substring(a.length() - i, a.length());
		}
		System.out.println(a);
	}
	
	public void factorial(int a) {
		int result = a;
		for(int i = a - 1; i >= 1; i--) {
			result = result * i;
		}
		System.out.println(result);
	}
	
	public void SubStringMethod(String a, int b) {
		for(int i = 0; i < b; i++) {
			
		}
	}
	
	public static void main(String[] args) {
		Homework ques1 = new Homework();
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		ques1.BubbleSort(arr);
		System.out.println();
		
		Homework ques2 = new Homework();
		ques2.fibonacci();
		System.out.println();
		
		Homework ques3 = new Homework();
		String a = "Homework";
		ques3.reverse(a);
		
		Homework ques4 = new Homework();
		ques4.factorial(10);
		
		Homework ques5 = new Homework();
		ques5.SubStringMethod("Butterfly", 5);
		
	}
}
