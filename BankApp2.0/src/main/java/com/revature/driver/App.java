package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daoimpl.AccountsDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.daoimpl.UserDaoImpl;

public class App {
	
	public static void main (String[] args) {
		UserDaoImpl users = new UserDaoImpl();
		
		try {
			users.getAllUsers();
			start(users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void start(UserDaoImpl users) {
		ArrayList<User> allUsers = new ArrayList<User>();
		try {
			allUsers = (ArrayList<User>) users.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Scanner input = new Scanner(System.in);
		boolean validUsername = false;
		
		System.out.println("Welcome to Nook's Bank!");
		System.out.println("Please input your username, "
				+ "'new' for a new account, "
				+ " or 'exit' to close");
		String result = (String)input.next().toLowerCase();
		
		if(result.equals("new")) {
			
			System.out.println("Will this be a joint account? 'Y' - yes, 'N'- No");
			String yesOrNo = (String)input.next().toLowerCase();
			String newUsername, newPassword, newUsername2, newPassword2 = "";
			switch(yesOrNo) {
				case "y":
					do {
						System.out.println("Please input your desired username: ");
						newUsername = input.next();
						for(int i=0; i < allUsers.size(); i++) {
							if(allUsers.get(i).getUsername().equals(newUsername)) {
								validUsername = false;
								System.out.println("This username is being used by someone else");
								break;
							}
							else {
								validUsername = true;
							}
						}
					}while(!validUsername);
					
					System.out.println("Please input your desired password: ");
					newPassword = input.next();
					
					do {
						System.out.println("Please input your second desired username: ");
						newUsername2 = input.next();
						for(int i=0; i < allUsers.size(); i++) {
							if(allUsers.get(i).getUsername().equals(newUsername2)) {
								validUsername = false;
								System.out.println("This username is being used by someone else");
								break;
							}
							else {
								validUsername = true;
							}
						}
					}while(!validUsername);
					
					System.out.println("Please input your desired password: ");
					newPassword = input.next();
					
					try {
						users.addNewUser(newUsername, newPassword);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					try {
						users.addNewJointUser(newUsername, newPassword, newUsername2, newPassword2);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				case "n":
					do {
						System.out.println("Please input your desired username: ");
						newUsername = input.next();
						for(int i=0; i < allUsers.size(); i++) {
							if(allUsers.get(i).getUsername().equals(newUsername)) {
								validUsername = false;
								System.out.println("This username is being used by someone else");
								break;
							}
							else {
								validUsername = true;
							}
						}
					}while(!validUsername);
					
					System.out.println("Please input your desired password: ");
					newPassword = input.next();
					
					try {
						users.addNewUser(newUsername, newPassword);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("New user added successfully!");
					start(users);
					
				default:
					System.out.println("Invalid entry");
					start(users);
			}
			
		} else if(result.equals("exit")){
			System.exit(0);
		} else {
			String type = null;
			for(int i=0; i < allUsers.size(); i++) {
				if(allUsers.get(i).getUsername().contentEquals(result)) {
					for(int j=0; j < 3; j++) {
						System.out.println("Please enter your password: ");
						String password = input.next();
						if(allUsers.get(i).getPassword().contentEquals(password)) {
							System.out.println("Login Successful!\n");
							if(allUsers.get(i).getUserType().contentEquals("Admin")) {
								type = "Admin";
								menu(type, input, users, result);
							}
							else if(allUsers.get(i).getUserType().contentEquals("Employee")) {
								type = "Employee";
								menu(type, input, users, result);
							}
							else {
								type = "User";
								menu(type, input, users, result);
							}
						}
						else {
							System.out.println("Incorrect password, please try again");
						}
					}
					System.out.println("Maximum attempts exceeded!");
					start(users);
				}
			}
		}
		System.out.println("Username not found!");
		start(users);
	}
	
	public static void menu(String type, Scanner input, UserDaoImpl users, String username) {
		int choice;
		boolean choiceMade = true;
		int accountNum = 0;
		AccountsDaoImpl accounts = new AccountsDaoImpl();
		CustomerDaoImpl customers = new CustomerDaoImpl();
		UserDaoImpl singleUser = new UserDaoImpl();
		do {
			if(type == "Admin") {
				System.out.println("\nTo check customer info choose '1'\n"
						+ "To approve or deny new accounts choose '2'\n"
						+ "To perform functions on accounts choose '3'\n"
						+ "To cancel an account choose '4'\n"
						+ "To exit choose '5'");
				choice = Integer.parseInt(input.next());
				switch(choice) {
				case 1:
					System.out.println("Please enter a user account number");
					accountNum = Integer.parseInt(input.next());
					try {
						System.out.print("Customer Info: \n");
						System.out.println(customers.getCustomerInfo(accountNum));
						System.out.print(" Customer Balance: ");
						System.out.println(accounts.getAccountBalance(accountNum));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					
				case 3:
					
				case 4:
					
				case 5:
					start(users);
				default:
					choiceMade = false;
					break;
				}
			} else if(type == "Employee") {
				System.out.println("\nTo check customer info choose '1'\n"
						+ "To approve or deny new accounts choose '2'\n"
						+ "To exit choose '3'");
				choice = Integer.parseInt(input.next());
				switch(choice) {
				case 1:
					System.out.println("Please enter a user account number");
					accountNum = Integer.parseInt(input.next());
					try {
						System.out.print("Customer Info: \n");
						System.out.println(customers.getCustomerInfo(accountNum));
						System.out.print(" Customer Balance: ");
						System.out.println(accounts.getAccountBalance(accountNum));
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					UserDaoImpl newUsersPull = new UserDaoImpl();
					
					ArrayList<User> newUsers = new ArrayList<User>();
					
					try {
						newUsers = newUsersPull.getNewUsers();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					boolean empty = newUsers.isEmpty();
					
					if(empty) {
						System.out.println("There are no new applications at the moment...");
					}
					else {
						Scanner longString = new Scanner(System.in).useDelimiter("");
						System.out.println(newUsers);
						System.out.println("Will this be a joint account? \n"
								+ "'1' for yes\n"
								+ "'2' for no");
						int joint = Integer.parseInt(input.next());
						if(joint == 1) {
							
						} else {
							String newLastName = null;
							String newFirstName = null;
							String newAddress = null;
							String newCity = null;
							String newState = null;
							String newZipCode = null;
							String newPhone = null;
							System.out.println("Enter userId number to edit");
							int userId = Integer.parseInt(input.next());
							System.out.println("Will you aprove or deny this account? \n"
									+ "'1' for approve\n"
									+ "'2' for deny");
							int choice1 = Integer.parseInt(input.next());
							
							if(choice1 == 2) {
								try {
									users.deny(userId);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
							else {
								System.out.println("Please input your last name: ");
								newLastName = input.next();
								System.out.println("Please input your first name: ");
								newFirstName = input.next();
								System.out.println("Please input your street address: ");
								newAddress = longString.nextLine();
								System.out.println("Please input your city: ");
								newCity = input.next();
								System.out.println("Please input your state: ");
								newState = input.next();
								System.out.println("Please input your zipcode: ");
								newZipCode = input.next();
								System.out.println("Please input your phone number (including any dashes): ");
								newPhone = input.next();
								try {
									customers.approve(userId, newLastName, newFirstName, newAddress, 
											"Single", newCity, newState, newZipCode, newPhone);
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
					}
					
					break;
				case 3:
					start(users);
				default:
					choiceMade = false;
					break;
				}
			} else {
				System.out.println("\nTo check your balance choose '1'\n"
						+ "To make a deposit choose '2'\n"
						+ "To make a withdrawal choose '3'\n"
						+ "To make a transfer choose '4'\n"
						+ "To exit choose '5'");
				
				choice = Integer.parseInt(input.next());
				switch(choice) {
					case 1:
						System.out.print("Customer Balance: ");
					try {
						System.out.println(accounts.getAccountBalance(
								customers.getAccountId(
										singleUser.getUserIdFromUsername(username))));
					} catch (SQLException e) {
						e.printStackTrace();
					}
						break;
					case 2:
					try {
						double deposit;
						boolean good = true;
						double currentBalance = accounts.getAccountBalance(
								customers.getAccountId(
										singleUser.getUserIdFromUsername(username)));
						do{
							System.out.println("Enter deposit amount: ");
							deposit = Double.parseDouble(input.next());
							if(deposit < 0) {
								System.out.println("Deposit amount cannot be negative");
								good = false;
							}
							else {
								accounts.deposit(customers.getAccountId(
										singleUser.getUserIdFromUsername(username)), deposit);
								currentBalance += deposit;
								good = true;
							}
						}while(!good);
						System.out.println("Deposit successful, current balance is: "+ currentBalance);
					} catch (SQLException e) {
						e.printStackTrace();
					}
						break;
					case 3: 
						double withdraw;
						boolean good = true;
						double currentBalance = 0;
						try {
							currentBalance = accounts.getAccountBalance(customers.getAccountId(singleUser.getUserIdFromUsername(username)));
						} catch (SQLException e) {
							e.printStackTrace();
						}
						do{
							System.out.println("Enter withdrawal amount: ");
							withdraw = Double.parseDouble(input.next());
							if(withdraw < 0) {
								System.out.println("Withdraw amount cannot be negative");
								good = false;
							}
							else if(withdraw > currentBalance) {
								System.out.println("Withdrawal amount cannot be larger than "
										+ "the current balance of " + currentBalance);
								good = false;
							}
							else {
								try {
									accounts.withdraw(customers.getAccountId(
											singleUser.getUserIdFromUsername(username)), withdraw);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								currentBalance -= withdraw;
								good = true;
							}
						}while(!good);
						System.out.println("Withdrawal successful, current balance is: "+ currentBalance);
						break;
					case 4:
						double transfer;
						boolean good1 = true;
						int acctTo = 0;
						double currentBalance1 = 0;
					try {
						currentBalance1 = accounts.getAccountBalance(customers.getAccountId(singleUser.getUserIdFromUsername(username)));
					} catch (SQLException e) {
						e.printStackTrace();
					}
						
						System.out.println("Enter the account number for the account to transfer to: ");
						acctTo = Integer.parseInt(input.next());
						
						do{
							System.out.println("Enter transfer amount: ");
							transfer = Double.parseDouble(input.next());
							if(transfer < 0) {
								System.out.println("Transfer amount cannot be negative");
								good = false;
							}
							else if(transfer > currentBalance1) {
								System.out.println("Transer amount cannot be larger than "
										+ "the current balance of " + currentBalance1);
								good = false;
							}
						}while(!good1);
						
						try {
							accounts.transfer(customers.getAccountId(singleUser.getUserIdFromUsername(username)), acctTo, transfer);
							currentBalance1 -= transfer;
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						System.out.println("Transfer completed successfully, current balance is: " + currentBalance1);
						break;
					case 5:
						start(users);
					default:
						choiceMade = false;
						break;
				}
			}
		}while(choiceMade);
	}
	
}
