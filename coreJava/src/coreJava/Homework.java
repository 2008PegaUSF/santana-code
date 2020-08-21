package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
	
	public void Substring(String a, int b) {
		char[] array = new char[b];
		for(int i=0; i< b; i++) {
			array[i] = a.charAt(i);
		}
		System.out.println(String.copyValueOf(array));
	}
	
	public void checkEven(int a) {
		if((a /2)*2 == a) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}
	
	public class Employee implements Comparable<Employee>{
		private String name;
		private String department;
		private int age;
		
		public Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getDepartment() {
			return department;
		}
		
		public void setDepartment() {
			this.department = department;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge() {
			this.age = age;
		}
		
		@Override
		public int compareTo(Employee anotherEmployee) {
			return this.getAge() - anotherEmployee.getAge();
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;
			Employee employee = (Employee) o;
			return age == employee.age;
		}
		
		@Override
		public String toString() {
			return "Employee name: " + name + " Employee department: " + department
					+ " Employee age: " + age;
		}
		
	}
	public void palindromeChecker(ArrayList<String> a) {
		ArrayList<String> palindrome = new ArrayList<String>();
		
		public void isPalindrome(String x) {
			if(x == null || x.isEmpty())
				
			
			//StringBuilder(x).reverse().toString().equals(x);
		}
		
		for(int i = 0; i < a.size(); i++) {
			
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
		ques5.Substring("Butterfly", 5);
		
		Homework ques6 = new Homework();
		ques6.checkEven(10);
		
		//Homework ques7 = new Homework();
		List<Employee> employees = new ArrayList<>();
		Homework ques7.new Homework(employees.add(new Employee("Javier", "Tech", 31)));
		
		Homework ques8 = new Homework();
		ArrayList<String> arrList = new ArrayList<>(Arrays.asList("karan", "madam",
				"tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy",
				"did"));
		ques8.palindromeChecker(arrList);
	}
}
