package BankApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable{

	//creates username string, and phoneNum and address pulled from current account
	protected String username, password, name, phoneNum, address;
	
	//creates the account number currently being worked on
	protected int currentActNum, joint;
	
	protected char userType;
	
	protected double curActBalance;
	
	public User(String userName, String password, String name, 
			double curActBalance, String phoneNum, String address, 
			int currentActNum, char userType, int joint) {
		this.username = userName;
		this.password = password;
		this.name = name;
		this.curActBalance = curActBalance;
		this.phoneNum = phoneNum;
		this.address = address;
		this.currentActNum = currentActNum;
		this.userType = userType;
		this.joint = joint;
	}
	
	protected void checkBalance(ArrayList<User> users) {
		if(this.joint > 0) {
			for(int i=0; i < users.size(); i++) {
				if(users.get(i).currentActNum == this.joint) {
					System.out.println("Joint account balance is " + users.get(i).curActBalance);
				}
			}
		}
		System.out.println("Main account balance is " + this.curActBalance);
	}
	
	protected void depositFunds(Scanner input) {
		double deposit;
		boolean good = true;
		do{
			System.out.println("Enter deposit amount: ");
			deposit = Double.parseDouble(input.next());
			if(deposit < 0) {
				System.out.println("Deposit amount cannot be negative");
				good = false;
			}
			else {
				this.curActBalance += deposit;
				good = true;
			}
		}while(!good);
		
		System.out.println("Deposit successful, current balance is: "+ this.curActBalance);
	}
	
	protected void withdrawFunds(Scanner input) {
		double withdraw;
		boolean good = true;
		do{
			System.out.println("Enter withdrawal amount: ");
			withdraw = Double.parseDouble(input.next());
			if(withdraw < 0) {
				System.out.println("Withdraw amount cannot be negative");
				good = false;
			}
			else if(withdraw > curActBalance) {
				System.out.println("Withdrawal amount cannot be larger than "
						+ "the current balance of " + this.curActBalance);
				good = false;
			}
			else {
				this.curActBalance -= withdraw;
				good = true;
			}
		}while(!good);
		
		System.out.println("Withdrawal successful, current balance is: "+ this.curActBalance);
		
	}
	
	protected void transferFunds(ArrayList<User> users, Scanner input) {
		double transfer;
		boolean good = true;
		
		do{
			System.out.println("Enter transfer amount: ");
			transfer = Double.parseDouble(input.next());
			if(transfer < 0) {
				System.out.println("Transfer amount cannot be negative");
				good = false;
			}
			else if(transfer > curActBalance) {
				System.out.println("Transer amount cannot be larger than "
						+ "the current balance of " + this.curActBalance);
				good = false;
			}
			else {
				
				for(int i=0; i < users.size(); i++) {
					if(users.get(i).currentActNum == this.joint) {
						this.curActBalance -= transfer;
						users.get(i).curActBalance += transfer;
						System.out.println("Transfered " + transfer + " to joint account\n"
								+ " Current balance is " + this.curActBalance
								+ "  Joint account balance is " + users.get(i).curActBalance);
					}
				}
				good = true;
			}
		}while(!good);
	}
	
	
	//Loads account info using currentActNum
	protected void loadActInfo(int currentActNum) {
		System.out.println("Customer Info: ");
		System.out.println("Name: " + this.name);
		System.out.println("Address: " + this.address);
		System.out.println("Phone: " + this.phoneNum);
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + address + ", " + phoneNum + ", " + curActBalance +"]";
	}
	
} 
