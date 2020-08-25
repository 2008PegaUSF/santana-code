package coreJava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import coreJava.Homework.Employee;



public class TestHomework {

	Homework test = new Homework();
	@Test
	public void shouldDoNothingWithEmptyArray() {
        int[] values = {};
 
        test.bubbleSort(values);
    }
	
	@Test
    public void shouldDoNothingWithOneElementArray() {
        int[] values = {42};
 
        test.bubbleSort(values);
 
        Assertions.assertArrayEquals(new int[] {42}, values);
    }
	
	@Test
    public void shouldSortValues() {
        int[] values = { 9, -3, 5, 0, 1};
        int[] expectedOrder = { -3, 0, 1, 5, 9};
 
        test.bubbleSort(values);
 
        Assertions.assertArrayEquals(expectedOrder, values);
    }
	
	@Test
	public void shouldDisplayFirst25Numbers() {
		String expectedValues = "0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 " 
				+ "1597 2584 4181 6765 10946 17711 28657 46368 ";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.fibonacci();
		
		Assertions.assertEquals(expectedValues, out.toString());
		
	}
	
	@Test
	public void shouldReverseString() {
		String expectedValue = "krowemoH";
		String testValue = "Homework";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.reverse(testValue);
		
		Assertions.assertTrue(out.toString().contains(expectedValue));
	}
	
	@Test
	public void shouldPrintFactorial() {
		String result = "120";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.factorial(5);		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldReturnReducedString() {
		String result = "Butter";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.substring("Butterfly", 6);
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldConfirmEven() {
		String result = "Even";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.checkEven(6);
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldConfirmOdd() {
		String result = "Odd";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.checkEven(3);
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldSortEmployeesByAge() {
		String result = "By Age:  [Employee name: Ryan department: Music age: 25, "
				+ "Employee name: Javier department: Tech age: 31]";
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Javier", "Tech", 31));
		employees.add(new Employee("Ryan", "Music", 25));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		Collections.sort(employees, Employee.AgeComparator);
		System.out.println("By Age:  " + employees);
		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldSortEmployeesByDepartment() {
		String result = "By Department:  [Employee name: Ryan department: "
				+ "Music age: 25, Employee name: Javier department: Tech age: 31]";
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Javier", "Tech", 31));
		employees.add(new Employee("Ryan", "Music", 25));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		Collections.sort(employees, Employee.DepartmentComparator);
		System.out.println("By Department:  " + employees);
		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldSortEmployeesByName() {
		String result = "By Name:  [Employee name: Javier department: "
				+ "Tech age: 31, Employee name: Ryan department: Music age: 25]";
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Javier", "Tech", 31));
		employees.add(new Employee("Ryan", "Music", 25));
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		Collections.sort(employees, Employee.NameComparator);
		System.out.println("By Name:  " + employees);
		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldPrintAllPalindromes() {
		String result = "[madam, civic, radar, kayak, refer, did]";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.palindromeChecker();
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldFindThePrimeNumbers() {
		String result = "[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, "
				+ "41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.findPrime();
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldFindTheMinimumOf2Numbers() {
		String result = "8";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.minOf2(35, 8);
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldAccessFloatInAnotherClassFile() {
		String result = "First float: 34.006, Second float: 88.04234";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.accessModifier();
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldPrintAllEvenNumbersTo100() {
		String result = "[2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, "
				+ "26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, "
				+ "52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, "
				+ "78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100]";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.printEven();
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldPrintPyramidOf0And1() {
		String result = "0 \r\n" + 
				"1 0 \r\n" + 
				"1 0 1 \r\n" + 
				"0 1 0 1";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.printPyramid();
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldSplitStringInSwitchCase() {
		String result = "I\r\n" + 
				"am\r\n" + 
				"learning\r\n" + 
				"Core\r\n" + 
				"Java";
		
		ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.switchCase();
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldAddBothNumbers() {
		String result = "15\r\n" + 
				"3\r\n" + 
				"12\r\n" + 
				"8";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		Homework.OperationsTest testing = new Homework.OperationsTest();
		
		testing.main();
		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldReturnStringCount() {
		String result = "This string has: 1 characters\r\n" + 
				"This string has: 4 characters\r\n" + 
				"This string has: 5 characters\r\n" + 
				"The total character count is: 10";
		
		String[] tester = new String[3];
		tester[0] = "I";
		tester[1] = "Love";
		tester[2] = "Pizza";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.countArguments(tester);
		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldCalculateSimpleInterest() {
		String result = "100";
		
		
		double principal = (double) 5000;
		double percentage = (double) 1;
		int time = 2;
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.simpleIntrest(principal, percentage, time);
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldInheretAbstractMethods() {
		String result = "true";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.inheritAbstractMethods();
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldDisplayNonPrimes() {
		String result = "[1, 4, 6, 8, 9, 10]";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.arrayListFun();
		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
	@Test
	public void shouldDisplayInformation() {
		String result = "Name: Mickey Mouse\r\n" + 
				"Age: 35 years\r\n" + 
				"State: Arizona State";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		test.readFile();
		
		Assertions.assertTrue(out.toString().contains(result));
	}
}


