package BankApp;

import java.io.Serializable;

public class User implements Serializable{

	//creates username string, and phoneNum and address pulled from current account
	protected String username, password, name, phoneNum, address;
	
	//creates the account number currently being worked on
	protected int currentActNum;
	
	protected char userType;
	
	protected double curActBalance;
	
	public User(String userName, String password, String name, 
			double curActBalance, String phoneNum, String address, char userType,
			int currentActNum) {
		this.username = userName;
		this.password = password;
		this.name = name;
		this.curActBalance = curActBalance;
		this.phoneNum = phoneNum;
		this.address = address;
		this.userType = userType;
		this.currentActNum = currentActNum;
	}
	
	protected double checkBalance() {
		return curActBalance;
	}
	
	protected void depositFunds(double curActBalance, double deposit) {
		this.curActBalance += deposit;
	}
	
	protected void withdrawFunds(double curActBalance, double withdraw) {
		this.curActBalance -= withdraw;
	}
	
	
	//Loads account info using currentActNum
	protected void loadActInfo(int currentActNum) {
		System.out.println("Customer Info: ");
		System.out.println("Name: " + this.name);
		System.out.println("Address: " + this.address);
		System.out.println("Phone: " + this.phoneNum);
	}
	
	public static char menu(char userType){
		if(userType == 'A') {
			//call admin menu
			return 'A';
		}
		else if(userType == 'E') {
			//call employee menu
			return 'E';
		}
		else {
			//call user menu
			return 'U';
		}
	}
	
} 
