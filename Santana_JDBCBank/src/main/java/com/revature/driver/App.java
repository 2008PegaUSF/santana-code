package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import com.revature.beans.User;
import com.revature.daoimpl.AccountsDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.daoimpl.UserDaoImpl;


public class App {
	
	private static final Logger logger = LogManager.getLogger(App.class);
	
	public static void main (String[] args) {
		
		Configurator.initialize(null, "log4j2.xml");
		
		logger.info("The main() method is called");
		
		UserDaoImpl users = new UserDaoImpl();
		
		try {
			
			users.getAllUsers();
			start(users);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	public static void start(UserDaoImpl users) {
		
		logger.info("The start() method is called");
		
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
			
			logger.info("New account creation");
			
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
					
					try {
						
						allUsers = (ArrayList<User>) users.getAllUsers();
					
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					
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
					logger.info("New user added to User table");
					start(users);
					
				default:
					System.out.println("Invalid entry");
					start(users);
			}
			
		} 
		else if(result.equals("exit")){
			logger.info("Application closed by user");
			System.exit(0);
		} 
		else {
			
			String type = null;
			
			for(int i=0; i < allUsers.size(); i++) {
				
				if(allUsers.get(i).getUsername().contentEquals(result)) {
					
					for(int j=0; j < 3; j++) {
						
						System.out.println("Please enter your password: ");
						
						String password = input.next();
						
						if(allUsers.get(i).getPassword().contentEquals(password)) {
						
							System.out.println("Login Successful!\n");
							logger.info("User " +allUsers.get(i).getUserId() +  " logged in");
							
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
		logger.info("User doesn't exist");
		start(users);
		
	}
	
	public static void menu(String type, Scanner input, UserDaoImpl users, String username) {
		logger.info("The menu() function is called");
		int choice;
		boolean choiceMade = true;
		int accountNum = 0;
		
		AccountsDaoImpl accounts = new AccountsDaoImpl();
		CustomerDaoImpl customers = new CustomerDaoImpl();
		UserDaoImpl singleUser = new UserDaoImpl();
		
		do {
			if(type == "Admin") {
				logger.info("User is admin");
				//ADMIN MENU
				System.out.println("\nTo check customer info choose '1'\n"
						+ "To approve or deny new accounts choose '2'\n"
						+ "To perform functions on accounts choose '3'\n"
						+ "To cancel an account choose '4'\n"
						+ "To exit choose '5'");
				choice = Integer.parseInt(input.next());
			
				switch(choice) {
				case 1:
					//ADMIN CHECK USER INFO
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
					//ADMIN APPROVE/DENY
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
						//INITIALIZE VARIABLES
						String newLastName = null;
						String newFirstName = null;
						String newAddress = null;
						String newCity = null;
						String newState = null;
						String newZipCode = null;
						String newPhone = null;
						Scanner longString = new Scanner(System.in).useDelimiter("");
						
						//DISPLAY ALL NEW USERS
						System.out.println(newUsers);
						
						System.out.println("Enter userId number to edit");
						int userId = Integer.parseInt(input.next());
						
						for(int i=0; i < newUsers.size(); i++) {
							
							if(newUsers.get(i).getUserId() == userId && newUsers.get(i).getJointId() > 0) {
								int jointId = newUsers.get(i).getJointId();
								for (int j=0; j < newUsers.size(); j++) {
									if(newUsers.get(j).getJointId() == jointId && newUsers.get(j).getUserId() != userId) {
										
										int userId2 = newUsers.get(j).getUserId();
										
										System.out.println("Will you aprove or deny these accounts? \n"
												+ "'1' for approve\n"
												+ "'2' for deny");
										int choice1 = Integer.parseInt(input.next());
										if(choice1 == 1) {
											//ADMIN APPROVE JOINT ACCOUNT
											System.out.println("Please input the last name: ");
											newLastName = input.next();
											System.out.println("Please input the first name: ");
											newFirstName = input.next();
											System.out.println("Please input the street address: ");
											newAddress = longString.nextLine();
											System.out.println("Please input the city: ");
											newCity = input.next();
											System.out.println("Please input the state: ");
											newState = input.next();
											System.out.println("Please input the zipcode: ");
											newZipCode = input.next();
											System.out.println("Please input the phone number (including any dashes): ");
											newPhone = input.next();
											
											System.out.println("Is the address the same? \n"
													+ "'1' for yes\n"
													+ "'2' for no");
											int sameChoice = input.nextInt();
											
											String newLastName2 = null;
											String newFirstName2 = null;
											String newAddress2 = null;
											String newCity2 = null;
											String newState2 = null;
											String newZipCode2 = null;
											String newPhone2 = null;
											
											if(sameChoice == 1) {
												//ADMIN SAME ADDRESS
												System.out.println("Please input the other last name: ");
												newLastName2 = input.next();
												System.out.println("Please input the other first name: ");
												newFirstName2 = input.next();
												System.out.println("Please input the other phone number (including any dashes): ");
												newPhone2 = input.next();
												newAddress2 = newAddress;
												newCity2 = newCity;
												newState2 = newState;
												newZipCode2 = newZipCode;
											}
											else {
												//ADMIN DIFFERENT ADDRESS
												System.out.println("Please input the other last name: ");
												newLastName2 = input.next();
												System.out.println("Please input the other first name: ");
												newFirstName2 = input.next();
												System.out.println("Please input the other street address: ");
												newAddress2 = longString.nextLine();
												System.out.println("Please input the other city: ");
												newCity2 = input.next();
												System.out.println("Please input the other state: ");
												newState2 = input.next();
												System.out.println("Please input the other zipcode: ");
												newZipCode2 = input.next();
												System.out.println("Please input the other phone number (including any dashes): ");
												newPhone2 = input.next();
											}
											
											try {
												//ADMIN ADD JOINT CUSTOMER AND JOINT ACCOUNT METHODS
												customers.approveJoint(userId, newLastName, newFirstName, newAddress, 
														"Joint", newCity, newState, newZipCode, newPhone, userId2, newLastName2, newFirstName2, newAddress2, 
														"Joint", newCity2, newState2, newZipCode2, newPhone2);
												
												users.userIsCustomer(userId);
												users.userIsCustomer(userId2);
												
												accounts.addNewAccount(customers.getAccountId(userId));
												
												System.out.println("Users added successfully!");
											
											} catch (SQLException e) {
												
												e.printStackTrace();
											}
										}
										else {
											//ADMIN DENY JOINT USERS
											try {
												
												users.deny(userId);
												users.deny(userId2);
												
												System.out.println("Users denied...");
											
											} catch (SQLException e) {
												
												e.printStackTrace();
											}
											
										}
										
									}
								}
							} //END OF JOINT ADDS
						}
						//SINGLE USER ACCOUNT CREATE
						System.out.println("Will you aprove or deny this account? \n"
								+ "'1' for approve\n"
								+ "'2' for deny");
						int choice1 = Integer.parseInt(input.next());
						if(choice1 == 1) {
							//ADMIN SINGLE USER APPROVED
							System.out.println("Please input the last name: ");
							newLastName = input.next();
							System.out.println("Please input the first name: ");
							newFirstName = input.next();
							System.out.println("Please input the street address: ");
							newAddress = longString.nextLine();
							System.out.println("Please input the city: ");
							newCity = input.next();
							System.out.println("Please input the state: ");
							newState = input.next();
							System.out.println("Please input the zipcode: ");
							newZipCode = input.next();
							System.out.println("Please input the phone number (including any dashes): ");
							newPhone = input.next();
						
							try {
								//ADMIN ADD CUSTOMER AND ACCOUNT METHODS 
								customers.approve(userId, newLastName, newFirstName, newAddress, 
										"Single", newCity, newState, newZipCode, newPhone);
								
								users.userIsCustomer(userId);
							
								accounts.addNewAccount(customers.getAccountId(userId));
								
								System.out.println("Account added successfully!");
							
							} catch (SQLException e) {
								
								e.printStackTrace();
							}
					
						}
						else {
							//ADMIN DENY USER
							logger.warn("User is removed");
							try {
								
								users.deny(userId);
								
							} catch(SQLException e) {
								
								e.printStackTrace();
							}
						}
					}
					break;
				case 3:
					//ADMIN TRANSACTIONS
					System.out.println("Enter the accuont number: ");
					int userAccountNum = input.nextInt();
					
					System.out.println("\nTo check the balance choose '1'\n"
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
									customers.getAccountId(userAccountNum)));
						} catch (SQLException e) {
							e.printStackTrace();
						}
							break;
						case 2:
						try {
							double deposit;
							boolean good = true;
							double currentBalance = accounts.getAccountBalance(
									customers.getAccountId(userAccountNum));
							do{
								System.out.println("Enter deposit amount: ");
								deposit = Double.parseDouble(input.next());
								if(deposit < 0) {
									System.out.println("Deposit amount cannot be negative");
									good = false;
								}
								else {
									accounts.deposit(customers.getAccountId(
											userAccountNum), deposit);
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
								currentBalance = accounts.getAccountBalance(
										customers.getAccountId(userAccountNum));
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
												userAccountNum), withdraw);
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
								currentBalance1 = accounts.getAccountBalance(customers.getAccountId(userAccountNum));
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
									accounts.transfer(customers.getAccountId(userAccountNum), acctTo, transfer);
									currentBalance1 -= transfer;
								} catch (SQLException e) {
									e.printStackTrace();
								}
							
								System.out.println("Transfer completed successfully, current balance is: " + currentBalance1);
							break;
						case 5:
							start(users);
					}
					break;
				case 4:
					//ADMIN CANCEL ACCOUNT
					System.out.println("Enter the accuont number: ");
					int cancelAccountNum = input.nextInt();
					System.out.println("You are about to cancel an account. \n"
							+ "You will NOT be able to get it back, is that ok?\n"
							+ "'1' for yes\n"
							+ "'2' for no");
					int choice2 = input.nextInt();
					if(choice2 == 1) {
						try {
							
							accounts.deleteAccount(customers.getAccountId(cancelAccountNum));
							customers.deleteCustomer(cancelAccountNum);
							users.deny(cancelAccountNum);
							
							System.out.println("Account successfully canceled");
							logger.info("User account removed");
						
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}
					else {
						System.out.println("Transaction canceled!");
						break;
					}
				case 5:
					//ADMIN EXIT
					break;
				default:
					choiceMade = false;
					break;
				}
			} 
			else if(type == "Employee") {
				logger.info("User is employee");
				//EMPLOYEE MENU
				System.out.println("\nTo check customer info choose '1'\n"
						+ "To approve or deny new accounts choose '2'\n"
						+ "To exit choose '3'");
				choice = Integer.parseInt(input.next());
			
				switch(choice) {
				case 1:
					//EMPLOYEE CHECK INFO
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
					//EMPLOYEE APPROVE/DENY
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
						//INITIALIZE VARIABLES
						String newLastName = null;
						String newFirstName = null;
						String newAddress = null;
						String newCity = null;
						String newState = null;
						String newZipCode = null;
						String newPhone = null;
						Scanner longString = new Scanner(System.in).useDelimiter("");
						
						//DISPLAY ALL NEW USERS
						System.out.println(newUsers);
						
						System.out.println("Enter userId number to edit");
						int userId = Integer.parseInt(input.next());
						
						for(int i=0; i < newUsers.size(); i++) {
							
							if(newUsers.get(i).getUserId() == userId && newUsers.get(i).getJointId() > 0) {
								int jointId = newUsers.get(i).getJointId();
								for (int j=0; j < newUsers.size(); j++) {
									if(newUsers.get(j).getJointId() == jointId && newUsers.get(j).getUserId() != userId) {
										
										int userId2 = newUsers.get(j).getUserId();
										
										System.out.println("Will you aprove or deny these accounts? \n"
												+ "'1' for approve\n"
												+ "'2' for deny");
										int choice1 = Integer.parseInt(input.next());
										if(choice1 == 1) {
											//EMPLOYEE APPROVE JOINT ACCOUNT
											System.out.println("Please input the last name: ");
											newLastName = input.next();
											System.out.println("Please input the first name: ");
											newFirstName = input.next();
											System.out.println("Please input the street address: ");
											newAddress = longString.nextLine();
											System.out.println("Please input the city: ");
											newCity = input.next();
											System.out.println("Please input the state: ");
											newState = input.next();
											System.out.println("Please input the zipcode: ");
											newZipCode = input.next();
											System.out.println("Please input the phone number (including any dashes): ");
											newPhone = input.next();
											
											System.out.println("Is the address the same? \n"
													+ "'1' for yes\n"
													+ "'2' for no");
											int sameChoice = input.nextInt();
											
											String newLastName2 = null;
											String newFirstName2 = null;
											String newAddress2 = null;
											String newCity2 = null;
											String newState2 = null;
											String newZipCode2 = null;
											String newPhone2 = null;
											
											if(sameChoice == 1) {
												//EMPLOYEE SAME ADDRESS
												System.out.println("Please input the other last name: ");
												newLastName2 = input.next();
												System.out.println("Please input the other first name: ");
												newFirstName2 = input.next();
												System.out.println("Please input the other phone number (including any dashes): ");
												newPhone2 = input.next();
												newAddress2 = newAddress;
												newCity2 = newCity;
												newState2 = newState;
												newZipCode2 = newZipCode;
											}
											else {
												//EMPLOYEE DIFFERENT ADDRESS
												System.out.println("Please input the other last name: ");
												newLastName2 = input.next();
												System.out.println("Please input the other first name: ");
												newFirstName2 = input.next();
												System.out.println("Please input the other street address: ");
												newAddress2 = longString.nextLine();
												System.out.println("Please input the other city: ");
												newCity2 = input.next();
												System.out.println("Please input the other state: ");
												newState2 = input.next();
												System.out.println("Please input the other zipcode: ");
												newZipCode2 = input.next();
												System.out.println("Please input the other phone number (including any dashes): ");
												newPhone2 = input.next();
											}
											
											try {
												//EMPLOYEE ADD JOINT CUSTOMER AND JOINT ACCOUNT METHODS
												customers.approveJoint(userId, newLastName, newFirstName, newAddress, 
														"Joint", newCity, newState, newZipCode, newPhone, userId2, newLastName2, newFirstName2, newAddress2, 
														"Joint", newCity2, newState2, newZipCode2, newPhone2);
												
												users.userIsCustomer(userId);
												users.userIsCustomer(userId2);
												
												accounts.addNewAccount(customers.getAccountId(userId));
												
												System.out.println("Users added successfully!");
												logger.info("User account created");
											
											} catch (SQLException e) {
												
												e.printStackTrace();
											}
										}
										else {
											//EMPLOYEE DENY JOINT USERS
											try {
												
												users.deny(userId);
												users.deny(userId2);
												
												System.out.println("Users denied...");
											
											} catch (SQLException e) {
												
												e.printStackTrace();
											}
											
										}
										
									}
								}
							} //END OF JOINT ADDS
						}
						//SINGLE USER ACCOUNT CREATE
						System.out.println("Will you aprove or deny this account? \n"
								+ "'1' for approve\n"
								+ "'2' for deny");
						int choice1 = Integer.parseInt(input.next());
						if(choice1 == 1) {
							//EMPLOYEE SINGLE USER APPROVED
							System.out.println("Please input the last name: ");
							newLastName = input.next();
							System.out.println("Please input the first name: ");
							newFirstName = input.next();
							System.out.println("Please input the street address: ");
							newAddress = longString.nextLine();
							System.out.println("Please input the city: ");
							newCity = input.next();
							System.out.println("Please input the state: ");
							newState = input.next();
							System.out.println("Please input the zipcode: ");
							newZipCode = input.next();
							System.out.println("Please input the phone number (including any dashes): ");
							newPhone = input.next();
						
							try {
								//EMPLOYEE ADD CUSTOMER AND ACCOUNT METHODS 
								customers.approve(userId, newLastName, newFirstName, newAddress, 
										"Single", newCity, newState, newZipCode, newPhone);
								
								users.userIsCustomer(userId);
							
								accounts.addNewAccount(customers.getAccountId(userId));
								
								System.out.println("Account added successfully!");
								logger.info("User account created");
							
							} catch (SQLException e) {
								
								e.printStackTrace();
							}
					
						}
						else {
							//EMPLOYEE DENY USER
							try {
								
								users.deny(userId);
								
							} catch(SQLException e) {
								
								e.printStackTrace();
							}
						}
					}
					break;

				case 3:
					//EMPLOYEE EXIT
					start(users);
				default:
					choiceMade = false;
					break;
				}
			} else {
				logger.info("User is logged in");
				//USER MENU
				System.out.println("\nTo check your balance choose '1'\n"
						+ "To make a deposit choose '2'\n"
						+ "To make a withdrawal choose '3'\n"
						+ "To make a transfer choose '4'\n"
						+ "To make a an account choose '5'\n"
						+ "To exit choose '6'");
				
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
								logger.info("Deposit made");
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
								logger.info("Withdrawal made");
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
							logger.info("Transfer made");
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						System.out.println("Transfer completed successfully, current balance is: " + currentBalance1);
						break;
					case 5:
						
						int trys = 0;
						boolean idCheck = false;
						
						UserDaoImpl newUsersPull = new UserDaoImpl();
						
						ArrayList<User> newUsers = new ArrayList<User>();
						
						try {
							newUsers = newUsersPull.getNewUsers();
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						do {
							if(trys == 3) {
								System.out.println("Maximum Attemps exceeded!\n"
										+ "Please check your number and try again");
								start(users);
							}
							else {
								System.out.println("Please enter your UserId");
								int userId = Integer.parseInt(input.next());
								for(int i=0; i < newUsers.size(); i++) {
									if(newUsers.get(i).getUserId() == userId) {
										
										//INITIALIZE VARIABLES
										String newLastName = null;
										String newFirstName = null;
										String newAddress = null;
										String newCity = null;
										String newState = null;
										String newZipCode = null;
										String newPhone = null;
										Scanner longString = new Scanner(System.in).useDelimiter("");
										
										//SINGLE USER CREATION
										System.out.println("Please input the last name: ");
										newLastName = input.next();
										System.out.println("Please input the first name: ");
										newFirstName = input.next();
										System.out.println("Please input the street address: ");
										newAddress = longString.nextLine();
										System.out.println("Please input the city: ");
										newCity = input.next();
										System.out.println("Please input the state: ");
										newState = input.next();
										System.out.println("Please input the zipcode: ");
										newZipCode = input.next();
										System.out.println("Please input the phone number (including any dashes): ");
										newPhone = input.next();
										
										try {
											//ADD CUSTOMER AND ACCOUNT METHODS 
											customers.approve(userId, newLastName, newFirstName, newAddress, 
													"Single", newCity, newState, newZipCode, newPhone);
											
											users.userIsCustomer(userId);
										
											accounts.addNewAccount(customers.getAccountId(userId));
											
											System.out.println("Account added successfully!");
										
										} catch (SQLException e) {
											
											e.printStackTrace();
										}
										
										idCheck = true;
									}
									else {
										System.out.println("Invalid entry, try again");
									}
									
									trys ++;
								}
								
							}
						}while(!idCheck);
						
						break;
					
					case 6:
						start(users);
					default:
						choiceMade = false;
						break;
				}
			}
		}while(choiceMade);
	}
	
}
