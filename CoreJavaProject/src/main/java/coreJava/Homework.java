package coreJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

import NewPackage.FloatingNumbers;

public class Homework {

	//Question 1
	//method for sorting array (bubble sort)
	public void bubbleSort(int[] arr){
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
			System.out.print(x + " "); //print sorted array
		}
	}
	
	//Question 2
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
			System.out.print(x + " ");
		}
	}
	
	//Question 3
	
	public void reverse(String a) {
		for(int i = 0; i < a.length(); i++){
			a = a.substring(1, (a.length() - i))
					+ a.substring(0,1)
					+ a.substring(a.length() - i, a.length());
		}
		System.out.println(a);
	}
	
	//Question 4
	
	public void factorial(int a) {
		int result = a;
		for(int i = a - 1; i >= 1; i--) {
                   			result = result * i;
		}
		System.out.println(result);
	}
	
	//Question 5
	
	public void substring(String a, int b) {
		char[] array = new char[b];
		for(int i=0; i< b; i++) {
			array[i] = a.charAt(i);
		}
		System.out.println(String.copyValueOf(array));
	}
	
	//Question 6
	
	public void checkEven(int a) {
		if((a /2)*2 == a) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}
	
	//Question 7
	
	public void employeeSort() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Javier", "Tech", 31));
		employees.add(new Employee("Ryan", "Music", 25));
		Collections.sort(employees, Employee.AgeComparator);
		System.out.println("By Age:  " + employees);
		Collections.sort(employees, Employee.DepartmentComparator);
		System.out.println("By Department:  " + employees);
		Collections.sort(employees, Employee.NameComparator);
		System.out.println("By Name:  " + employees);
	}
	
	public static class Employee {
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
		
		public String getDepartment() {
			return department;
		}
		
		public int getAge() {
			return age;
		}
		
		
		public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};
		
		public static Comparator<Employee> DepartmentComparator = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getDepartment().compareTo(e2.getDepartment());
			}
		};
		
		public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getAge() - e2.getAge();
			}
		};
		
		@Override
		public String toString() {
			return "Employee name: " + name + " department: " + department
					+ " age: " + age;
		}
		
	}
	
	//Question 8
	
	public void palindromeChecker() {
		ArrayList<String> a = new ArrayList<String>(Arrays.asList("karan", "madam",
				"tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy",
				"did"));
		ArrayList<String> palindrome = new ArrayList<String>();

		for(int i=0; i < a.size(); i++) {
			StringBuilder str = new StringBuilder(a.get(i));
			str.reverse();
			if(a.get(i).contentEquals(str)) {
				palindrome.add(a.get(i));
			}
		}
		System.out.println(palindrome);
	}
	
	//Question 9
	
	public void findPrime() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i=0; i< 100; i++) {
			nums.add(i);
			if(i < 2) {
				continue;
			}
			else if(i == 2) {
				primes.add(i);
				continue;
			}
			else {
				boolean isPrime = true;
				for(int j = 2; j < i; j++) {
					if(i%j==0) {
						isPrime=false;
						break;
					}
				}
				if(isPrime) {
					primes.add(i);
				}
			}
		}
		System.out.println(primes);
	}
	
	//Question 10
	
	public void minOf2(int a, int b) {
		int min;
		 
		min = (a < b) ? a : b;
		System.out.println("Minimum of both number is " + min);
	}
	
	//Question 11
	
	public void accessModifier() {
		float newFloat = FloatingNumbers.number1;
		float newFloat2 = FloatingNumbers.number2;
		System.out.println("First float: " + newFloat + ", Second float: " + newFloat2);
		
	}
	
	//Question 12
	
	public void printEven() {
		int[] numbers = new int[100];
		ArrayList<Integer> evens = new ArrayList<Integer>();
		for(int i=0; i < numbers.length; i++) {
			numbers[i] = (i + 1) * 1;
		}
		for(int x : numbers) {
			if(x % 2 == 0) {
				evens.add(x);
			}
		}
		System.out.println(evens);
	}
	
	//Question 13
	
	public void printPyramid() {
		int rows = 4;
		boolean other = true;
		for(int i=1; i <= rows; i++) {
			for(int j=1; j <= i; j++) {
				if(other) {
					System.out.print(0 + " ");
					other = false;
				}
				else {
					System.out.print(1 + " ");
					other = true;
				}
			}
			System.out.println();
		}
	}
	
	//Question 14
	
	public void switchCase() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What would you like to do? ");
		System.out.println("To get the square root of a number type '1'");
		System.out.println("To see today's date type '2'");
		System.out.println("To split a string type '3'");
		int choice = input.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("Please enter a number");
				int square = input.nextInt();
				square = (int) Math.sqrt(square);
				System.out.println("The result is: " + square);
				break;
			case 2:
				Date now = new Date();
				SimpleDateFormat mdy = new SimpleDateFormat("MM/dd/yyyy");
				String date = mdy.format(now);
				System.out.println("Today's date is " + date);
				break;
			case 3:
				
				String user = ("I am learning Core Java");
				String[] array = user.split(" ", 5);
				for(int i=0; i < array.length; i++) {
					System.out.println(array[i]);
				}
				break;
		}
	}
	
	//Question 15
	
	public static class OperationsTest {
		void main() {
			OperationsWork operations = new OperationsWork();
			operations.addition(5, 10);
			operations.subtraction(6, 3);
			operations.multiplication(3, 4);
			operations.division(64, 8);
		}
	}
	
	interface Operations{
		public void addition(int a, int b);
		public void subtraction(int a, int b);
		public void multiplication(int a, int b);
		public void division(int a, int b);
	}
	
	public static class OperationsWork implements Operations{

		public void addition(int a, int b) {
			System.out.println(a + b);
		}

		public void subtraction(int a, int b) {
			System.out.println(a - b);
		}

		public void multiplication(int a, int b) {
			System.out.println(a * b);
		}

		public void division(int a, int b) {
			System.out.println(a / b);
		}
		
	}
	
	//Question 16
	
	public void countArguments (String[] args) {
		int secondCount = 0;
		for(int i=0; i < args.length; i++) {
			char[] letterArray = args[i].toCharArray();
			int count = 0;
			for(int j=0; j < letterArray.length; j++) {
				if ((letterArray[j] + 'a' - 97 >= 65 && letterArray[j] 
						+ 'a' - 97 <= 90) || (letterArray[j] 
								+ 'a' - 97 >= 97 && letterArray[j] 
		                		+ 'a' - 97 <= 122)) {
					count++;
					secondCount++;
				}
			}
			System.out.println("This string has: " + count + " characters");
		}
		System.out.println("The total character count is: " + secondCount);
	}
	
	//Question 17
	
	public void simpleIntrest(double principal, double percentage, int time) {
		
		//Interest = Principal* Rate* Time
		double interest = (principal * percentage * (double) time)/100;
		System.out.println("Simple interest is: " + interest);
		
	}
	
	//Question 18
	public void inheritAbstractMethods() {
		ConcreteClass concrete = new ConcreteClass();
		System.out.println(concrete.checkUppercase("pilLow"));
		concrete.convertLowercase("Apples");
		concrete.convertIntAdd10("500");
	}
	
	abstract class NewAbstractClass{
		abstract boolean checkUppercase(String str);
		abstract void convertLowercase(String str);
		abstract void convertIntAdd10(String str);
	}
	
	class ConcreteClass extends NewAbstractClass{

		@Override
		boolean checkUppercase(String str) {
			char[] charArray = str.toCharArray();
			
			for(int i=0; i < charArray.length; i++) {
				if(Character.isUpperCase(charArray[i])) {
					return true;
				}
			}
			return false;
			
		}

		@Override
		void convertLowercase(String str) {
			System.out.println(str.toUpperCase());
			
		}

		@Override
		void convertIntAdd10(String str) {
			int i = Integer.parseInt(str) + 10;
			System.out.println(i);
		}
		
	}
	
	//Question 19
	
	public void arrayListFun() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1; i < 11; i++) {
			nums.add(i);
		}
		System.out.println(nums);
		int evens = 0, odds = 0;
		for(int x=0; x < nums.size(); x++) {
			if(nums.get(x) % 2 == 0) {
				evens += nums.get(x);
			}
			else {
				odds += nums.get(x);
			}
		}
		System.out.println("Sum of all evens is: " + evens);
		System.out.println("Sum of all odds is: " + odds);
		
		for(int j = nums.size()-1; j >= 0; j--) {
			if(j < 2) {
				continue;
			}
			else if(j == 2) {
				nums.remove(Integer.valueOf(j));
				continue;
			}
			else {
				boolean isPrime = true;
				for(int k = 2; k < j; k++) {
					if(j%k==0) {
						isPrime=false;
						break;
					}
				}
				if(isPrime) {
					nums.remove(Integer.valueOf(j));
				}
			}
		}
		System.out.println(nums);
	}
	
	//Question 20
	
	public void readFile() {
		File file = new File("C:\\Users\\Javy\\Desktop\\Spring Tool Suite 4\\santana-code\\coreJava\\src\\coreJava\\Data.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str;
			
			while((str = br.readLine()) != null) {
				String[] info = str.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
				System.out.println();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("File read error");
		}
	}
	
	//main with drivers
	
	public static void main(String[] args) {
		//Question 1 driver
		Homework ques1 = new Homework();
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		ques1.bubbleSort(arr);
		System.out.println();
		
		//Question 2 driver
		Homework ques2 = new Homework();
		ques2.fibonacci();
		System.out.println();
		
		//Question 3 driver
		Homework ques3 = new Homework();
		String a = "Homework";
		ques3.reverse(a);
		System.out.println();
		
		//Question 4 driver
		Homework ques4 = new Homework();
		ques4.factorial(10);
		System.out.println();
		
		//Question 5 driver
		Homework ques5 = new Homework();
		ques5.substring("Butterfly", 5);
		System.out.println();
		
		//Question 6 driver
		Homework ques6 = new Homework();
		ques6.checkEven(10);
		System.out.println();
		
		//Question 7 driver
		Homework ques7 = new Homework();
		ques7.employeeSort();
		System.out.println();
		
		//Question 8 driver
		Homework ques8 = new Homework();
		ques8.palindromeChecker();
		System.out.println();
		
		//Question 9 driver
		Homework ques9 = new Homework();
		ques9.findPrime();
		System.out.println();
		
		//Question 10 driver
		Homework ques10 = new Homework();
		ques10.minOf2(3, 18);
		System.out.println();
		
		//Question 11 driver
		Homework ques11 = new Homework();
		ques11.accessModifier();
		System.out.println();
		
		//Question 12 driver
		Homework ques12 = new Homework();
		ques12.printEven();
		System.out.println();
		
		//Question 13 driver
		Homework ques13 = new Homework();
		ques13.printPyramid();
		System.out.println();
		
		//Question 14 driver
		Homework ques14 = new Homework();
		ques14.switchCase();
		System.out.println();
		
		//Question 15 driver
		Homework.OperationsTest ques15 = new Homework.OperationsTest();
		ques15.main();
		System.out.println();
		
		//Question 16 driver
		Homework ques16 = new Homework();
		ques16.countArguments(args);
		System.out.println();
		
		//Question 17 driver
		Homework ques17 = new Homework();
		Scanner input1 = new Scanner(System.in);
		System.out.println("Please enter the principal: ");
		double principal = (double) input1.nextInt();
		System.out.println("Please enter the rate (per year): ");
		double percentage = (double) input1.nextInt();
		System.out.println("Please enter the time (in years): ");
		int time = input1.nextInt();
		ques17.simpleIntrest(principal, percentage, time);
		System.out.println();
		
		//Question 18 driver
		Homework ques18 = new Homework();
		ques18.inheritAbstractMethods();
		System.out.println();
		
		//Question 19 driver
		Homework ques19 = new Homework();
		ques19.arrayListFun();
		System.out.println();
		
		//Question 20 driver
		Homework ques20 = new Homework();
		ques20.readFile();
	}
}
