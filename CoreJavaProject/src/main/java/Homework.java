
public class Homework {

	//Q1: method for sorting array (bubble sort)
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
		
	//Q2: method for first 25 numbers of fibonacci sequence without recursion
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
	
	//Q3: reverse a string method
	public void reverse(String a) {
		for(int i = 0; i < a.length(); i++){
			a = a.substring(1, (a.length() - i))
					+ a.substring(0,1)
					+ a.substring(a.length() - i, a.length());
		}
		System.out.println(a);
	}
	
	//Q4: calculating factorial
	public void factorial(int a) {
		int result = a;
		for(int i = a - 1; i >= 1; i--) {
                   			result = result * i;
		}
		System.out.println(result);
	}
	
	
	
}
