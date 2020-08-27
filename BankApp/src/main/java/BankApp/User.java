package BankApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	//creates username string, and phoneNum and address pulled from current account
	protected String username, password, name, phoneNum, address;
	
	//creates the account number currently being worked on
	protected int currentActNum;
	
	protected char userType;
	
	protected double curActBalance;
	
	public User(String userName, String password, String name, 
			double curActBalance, String phoneNum, String address, 
			int currentActNum, char userType) {
		this.username = userName;
		this.password = password;
		this.name = name;
		this.curActBalance = curActBalance;
		this.phoneNum = phoneNum;
		this.address = address;
		this.currentActNum = currentActNum;
		this.userType = userType;
	}
	
	protected void checkBalance(ArrayList<User> users) {
		System.out.println("Account balance is " + this.curActBalance);
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
	
	protected void transferFunds(ArrayList<User> users, ArrayList<Joint> joint, Scanner input) {
		double transfer;
		boolean good = true;
		int acctFrom = 0;
		int acctTo = 0;
		double balance = 0;
		double balance2 = 0;
		boolean jointAcctFrom = false;
		boolean jointAcctTo = false;
		
		System.out.println("Enter the account number for the account to transfer from: ");
		acctFrom = Integer.parseInt(input.next());
		System.out.println("Enter the account number for the account to transfer to: ");
		acctTo = Integer.parseInt(input.next());
		
		for(int i=0; i < users.size(); i++) {
			if(users.get(i).currentActNum == acctFrom) {
				balance = users.get(i).curActBalance;
				jointAcctFrom = false;
				if(users.get(i).currentActNum == acctTo) {
					jointAcctTo = false;
				}
			}
			else {
				for(int j=0; j < joint.size(); j++) {
					if(joint.get(j).currentActNum == acctFrom) {
						balance = joint.get(j).curActBalance;
						jointAcctFrom = true;
						if(joint.get(j).currentActNum == acctTo) {
							jointAcctTo = true;
						}
					}
				}
			}
		}
		
		do{
			System.out.println("Enter transfer amount: ");
			transfer = Double.parseDouble(input.next());
			if(transfer < 0) {
				System.out.println("Transfer amount cannot be negative");
				good = false;
			}
			else if(transfer > balance) {
				System.out.println("Transer amount cannot be larger than "
						+ "the current balance of " + balance);
				good = false;
			}
			else {
				if(!jointAcctFrom) {
					for(int i=0; i < users.size(); i++) {
						if(users.get(i).currentActNum == acctFrom) {
							users.get(i).curActBalance -= transfer;
							balance = users.get(i).curActBalance;
							if(!jointAcctTo) {
								for(int j=0; j < users.size(); j++) {
									if(users.get(j).currentActNum == acctTo) {
										users.get(i).curActBalance += transfer;
										balance2 = users.get(i).curActBalance;
										System.out.println("Transfered " + transfer + " to account " + 
										acctFrom + "\n"
												+ " Current balance is " + balance
												+ " account balance for account " + acctTo + " is " + balance2);
									}
								}
							}
							else {
								for(int j=0; j < joint.size(); j++) {
									if(joint.get(j).currentActNum == acctTo) {
										joint.get(j).curActBalance += transfer;
										balance2 = joint.get(j).curActBalance;
										System.out.println("Transfered " + transfer + " to account " + 
										acctFrom + "\n"
												+ " Current balance is " + balance
												+ " account balance for account " + acctTo + " is " + balance2);
									}
								}
							}
						}
					}
				}else {
					for(int x=0; x < joint.size(); x++) {
						if(joint.get(x).currentActNum == acctFrom) {
							joint.get(x).curActBalance -= transfer;
							balance = joint.get(x).curActBalance;
							if(!jointAcctTo) {
								for(int z=0; z < users.size(); z++) {
									if(users.get(z).currentActNum == acctTo) {
										users.get(z).curActBalance += transfer;
										balance2 = users.get(z).curActBalance;
										System.out.println("Transfered " + transfer + " to account " + 
										acctFrom + "\n"
												+ " Current balance is " + balance
												+ " account balance for account " + acctTo + " is " + balance2);
									}
								}
							}
						}
						else {
							for(int j=0; j < joint.size(); j++) {
								if(joint.get(j).currentActNum == acctTo) {
									joint.get(j).curActBalance += transfer;
									balance2 = joint.get(j).curActBalance;
									System.out.println("Transfered " + transfer + " to account " + 
									acctFrom + "\n"
											+ " Current balance is " + balance
											+ " account balance for account " + acctTo + " is " + balance2);
								}
							}
						}
					}
				}
				good = true;
			}
		}while(!good);
	}
	
	
	//Loads account info using currentActNum
	protected void loadActInfo(ArrayList<User> users, int accountNum) {	
		for(int i=0; i< users.size(); i++) {
			if(users.get(i).currentActNum == accountNum) {
				System.out.println("Customer Info: ");
				System.out.println("Name: " + users.get(i).name);
				System.out.println("Address: " + users.get(i).address);
				System.out.println("Phone: " + users.get(i).phoneNum);
				System.out.println("Username: " + users.get(i).username);
				System.out.println("Password: " + users.get(i).password);
				System.out.println("Acct #: " + users.get(i).currentActNum);
				System.out.println("Balance: " + users.get(i).curActBalance);
			}
		}		
	}
	
	@Override
	public String toString() {
		return "[" + name + ", " + address + ", " + phoneNum + ", " 
	+ curActBalance + ", " + currentActNum+ "]";
	}
	
} 
