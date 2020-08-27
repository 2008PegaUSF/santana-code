package BankApp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestApp {
	
	ArrayList<User> testUsers = new ArrayList<User>();
	ArrayList<Joint> testJoints = new ArrayList<Joint>();
	
	Scanner testScanner = new Scanner(System.in);

	User testUser = new User("test", "test", "Test Test", 
			1000, "777-7777", "7865 Test st", 
			987, 'U');
	
	User testUser2 = new User("test", "test", "Test Test", 
			1001, "777-7777", "7865 Test st", 
			765, 'U');
	
	User testAdmin = new User("admin", "test", "Admin Test", 
			1000, "777-7777", "7865 Test st", 
			-10, 'A');
	
	User testEmployee = new User("emp", "test", "Employee Test", 
			1000, "777-7777", "7865 Test st", 
			-5, 'E');
	
	Joint testJoint = new Joint("joint", "test", "Joint Test", 
			"joint2", "test", "Joint Test 2", 1000, 
			"123-4567", "888 Test st", -100, 'U');
	
	Joint testJoint2 = new Joint("joint", "test", "Joint Test", 
			"joint2", "test", "Joint Test 2", 1000, 
			"123-4567", "888 Test st", -101, 'U');
	
	
	@Test
	public void shouldWithdrawFromUserAccount() {
		double balance = testUser.curActBalance;
		testUser.withdrawFunds(testScanner);
		Assertions.assertTrue(testUser.curActBalance < balance);
	}
	
	@Test
	public void shouldDepositUserAccount() {
		double balance = testUser.curActBalance;
		testUser.depositFunds(testScanner);
		Assertions.assertTrue(testUser.curActBalance > balance);
	}
	
	@Test
	public void shouldTransferToAnotherAccount() {
		
		//USE ACCOUNT NUMBERS '987' and '765'
		
		testUsers.add(testUser);
		testUsers.add(testUser2);
		
		testUser.transferFunds(testUsers, testJoints, testScanner);
		
		Assertions.assertFalse(testUsers.equals(testUser2));
	}
	
	@Test
	public void shouldvalidateUsername() {
		String test = "test";
		boolean result = true;
		
		testJoints.add(testJoint);
		testJoints.add(testJoint2);
		
		result = App.userValidation(testUsers, testJoints, test);
		
		Assertions.assertTrue(result);
	}
	
	
	@Test
	public void shouldLoadJointBalance() {
		testJoints.add(testJoint);
		testJoints.add(testJoint2);
		
		String result = "Balance: 1000.0";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		App.jointBalance(testJoints, -100);
		
		
		
		Assertions.assertTrue(out.toString().contains(result));
	}
	
}
