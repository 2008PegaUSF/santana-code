package BankApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class App {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		
		Configurator.initialize(null, "log4j2.xml");
		
		logger.info("The main() method is called");
		
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Joint> joint = new ArrayList<Joint>();
		String fileName = "User.txt";
		String fileName2 = "Joint.txt";
		
		ArrayList<User> users2 = new ArrayList<User>();
		ArrayList<Joint> joint2 = new ArrayList<Joint>();
		String newFileName = "New.txt";
		String newFileName2 = "NewJoint.txt";
		
		users = deserializeFile(users, fileName);
		System.out.println(users);
		joint = deserializeJointFile(joint, fileName2);
		System.out.println(joint);
		logger.info("The single accounts list is populated is called");
		
		users2 = deserializeFile(users2, newFileName);
		System.out.println(users2);
		joint2 = deserializeJointFile(joint2, newFileName2);
		System.out.println(joint2);
		logger.info("The joint accounts list is populated is called");
		
		start(users, joint, fileName, fileName2);
		
		/*User object = new User("luigi", "imma-gonna-win", "Luigi Mario", 
				3000.25, "555-5554", "123 Main st", 2, 'U');
		User object2 = new User("mario", "lets-a-go", "Mario Mario", 
				5000.04, "555-5555", "123 Main st", 1, 'U');
		User object3 = new User("link", "hyaa", "Link Link", 
				13000.99, "555-5553", "135 Main st", 3, 'U');
		User object4 = new User("admin", "password", "Admin", 
				0, null, null, -1, 'A');
		User object5 = new User("emp", "password", "Employee", 
				0, null, null, -2, 'E');
		
		Joint jointObject = new Joint("kc123", "12345678", "Kasey", 
				"javy", "password", "Javy", 45000000, "550-5050", "145 Main st", 7, 'J');
		
		Joint jointObject2 = new Joint("peach", "help", "Princess Peach", 
				"mariotime", "yahoo", "Mario Mario", 500, "551-5661", "450 Castle rd", 56, 'J');
		
		
		
		users.add(object);
		users.add(object2);
		users.add(object3);
		users.add(object4);
		users.add(object5);
		joint.add(jointObject);
		joint.add(jointObject2);
		
		serializeFile(users, fileName);
		serializeJointFile(joint, fileName2);
		System.out.println(users);
		System.out.println(joint);*/
		
		
		//users.removeIf(n -> (n.currentActNum == 2));
		
	}
	
	public static void start(ArrayList<User> users, ArrayList<Joint> joint, String fileName, 
			String fileName2) {
		
		logger.info("The start() method is called");
		
		Scanner input = new Scanner(System.in);
		Scanner longString = new Scanner(System.in).useDelimiter("");
		int newActNum;
		System.out.println("Welcome to Nook's Bank!");
		System.out.println("Please input your username, "
				+ "'new' for a new account, "
				+ "'joint' for a new account,"
				+ " or 'exit' to close");
		String result = (String)input.next().toLowerCase();
		if(result.equals("new")) {
			
			logger.info("New user was selected");
			
			ArrayList<User> newUser = new ArrayList<User>();
			ArrayList<Joint> newJoint = new ArrayList<Joint>();
			String newFileName = "New.txt";
			String newJointFileName = "NewJoint.txt";
			
			logger.info("New accounts variables initialized");
			
			System.out.println("Will this be a joint account? 'Y' - yes, 'N'- No");
			String yesOrNo = (String)input.next().toLowerCase();
			String newUsername, newPassword, newName, newPhone, newAddress, newUsername2 = "";
			switch(yesOrNo) {
				case "y":
					do {
						System.out.println("Please input your desired username: ");
						newUsername = input.next();
					}while(!userValidation(users, joint, newUsername));
					
					logger.info("New joint user being validated");
					
					System.out.println("Please input your desired password: ");
					newPassword = input.next();
					System.out.println("Please input your full name (with a space "
							+ "between first and last): ");
					newName = longString.nextLine();
					
					do {
						System.out.println("Please input second desired username: ");
						newUsername2 = input.next();
					}while(!userValidation(users, joint, newUsername2));
					
					logger.info("New joint user 2 being validated");
					
					System.out.println("Please input second desired password: ");
					String newPassword2 = input.next();
					System.out.println("Please input second full name (with a space "
							+ "between first and last): ");
					String newName2 = longString.nextLine();
					System.out.println("Please input your phone number: ");
					newPhone = input.next();
					System.out.println("Please input your address: ");
					newAddress = longString.nextLine();
					
					newActNum = (int) (Math.random()*((1000 - 6) + 1) + 6);
					for(int i=0; i <users.size(); i++) {
						if(users.get(i).currentActNum == newActNum) {
							newActNum = (int) (Math.random()*((1000 - 6) + 1) + 6);
						}
					}
					
					Joint createJoint = new Joint(newUsername, newPassword, 
							newName, newUsername2, newPassword2, newName2, 
							100, newPhone, newAddress, newActNum, 'U');
					
					logger.info("New joint user created");
					
					newJoint.add(createJoint);
					
					serializeJointFile(newJoint, newJointFileName);
					System.out.println("Account requested sucessfully!");
					start(users, joint, fileName, fileName2);
					
					logger.info("New joint user added to file");
					
					/*Joint jointObject2 = new Joint("peach", "help", "Princess Peach", 
				"mariotime", "yahoo", "Mario Mario", 500, "551-5661", "450 Castle rd", 56, 'J');*/
				
				case "n":
					//Possible do while loop to make sure all values are properly filled
					
					do {
						System.out.println("Please input your desired username: ");
						newUsername = input.next();
					}while(!userValidation(users, joint, newUsername));
					
					logger.info("New user being validated");
					
					System.out.println("Please input your desired password: ");
					newPassword = input.next();
					System.out.println("Please input your full name (with a space between first and last): ");
					newName = longString.nextLine();
					System.out.println("Please input your phone number: ");
					newPhone = input.next();
					System.out.println("Please input your address: ");
					newAddress = longString.nextLine();
					
					
					//run a check so that account numbers don't match
					newActNum = (int) (Math.random()*((1000 - 6) + 1) + 6);
					for(int i=0; i <users.size(); i++) {
						if(users.get(i).currentActNum == newActNum) {
							newActNum = (int) (Math.random()*((1000 - 6) + 1) + 6);
						}
					}
					
					User create = new User(newUsername, newPassword, 
							newName, 100, newPhone, newAddress, newActNum, 'U');
					
					newUser.add(create);
					
					logger.info("New user created");
					
					serializeFile(newUser, newFileName);
					System.out.println("Account requested sucessfully!");
					start(users, joint, fileName, fileName2);
					
					logger.info("New user added to file");
				
				default:
					System.out.println("Invalid entry");
					start(users, joint, fileName, fileName2);
			}
		}
		else if(result.equals("exit")){
			logger.info("Program exited");
			System.exit(0);
		}
		else if(result.equals("joint")) {
			logger.info("joint user logging in");
			System.out.println("Please enter either username associated with the account: ");
			result = (String)input.next();
			for(int i=0; i < joint.size(); i++) {
				if(joint.get(i).username.contentEquals(result) || joint.get(i).username2.contentEquals(result)) {
					for(int j=0; j < 3; j++) {
						System.out.println("Please enter your password: ");
						String password = input.next();
						if(joint.get(i).password.contentEquals(password) || joint.get(i).password2.contentEquals(password)) {
							System.out.println("Login Successful!\n");
							Joint current = joint.get(i);
							System.out.println("Hello, " + current.name 
									+ "\nWhat would you like to do?:");
							menu(users, joint, current, input, fileName, fileName2);
						}
						else {
							System.out.println("Incorrect password, please try again");
						}
					}
					System.out.println("Maximum attempts exceeded!");
					start(users, joint, fileName, fileName2);
				}
			}
			System.out.println("Ussername not found!");
			start(users, joint, fileName, fileName2);
		}
		else {
			logger.info("user logging in");
			for(int i=0; i < users.size(); i++) {
				if(users.get(i).username.contentEquals(result)) {
					for(int j=0; j < 3; j++) {
						System.out.println("Please enter your password: ");
						String password = input.next();
						if(users.get(i).password.contentEquals(password)) {
							System.out.println("Login Successful!\n");
							User current = users.get(i);
							System.out.println("Hello, " + current.name 
									+ "\nWhat would you like to do?:");
							menu(users, joint, current, input, fileName, fileName2);
						}
						else {
							System.out.println("Incorrect password, please try again");
						}
					}
					System.out.println("Maximum attempts exceeded!");
					start(users, joint, fileName, fileName2);
				}
			}
			System.out.println("Username not found!");
			start(users, joint, fileName, fileName2);
		}
	}
	
	private static void menu(ArrayList<User> users, ArrayList<Joint> joint, User current, Scanner input,
			String fileName, String fileName2) {
		
		logger.info("The menu() method is called");
		
		int choice;
		String accountType;
		boolean choiceMade = true;
		do {
			if(current.userType == 'A') {
				int accountNum = 0;
				int accountIndex = 0;
				System.out.println("\nTo check user info choose '1'\n"
						+ "To approve or deny new accounts choose '2'\n"
						+ "To perform functions on accounts choose '3'\n"
						+ "To cancel an account choose '4'\n"
						+ "To exit choose '5'");
				choice = Integer.parseInt(input.next());
				switch(choice) {
				case 1:
					System.out.println("Is this a joint account? 'Y' or 'N'?");
					accountType = input.next().toLowerCase();
					if(accountType.equals("y")) {
						System.out.println("Please enter a user account number");
						accountNum = Integer.parseInt(input.next());
						jointBalance(joint, accountNum);
						logger.info("account balance checked by: " + current.name);
						break;
					}
					System.out.println("Please enter a user account number");
					accountNum = Integer.parseInt(input.next());
					current.loadActInfo(users, accountNum);
					logger.info("account information checked by: " + current.name);
					break;
				case 2:
					editAccount(users, joint, fileName, fileName2, input);
					logger.info("account edited by: " + current.name);
					break;
				case 3:
					System.out.println("Please enter an account number");
					accountNum = Integer.parseInt(input.next());
					for(int i=0; i < users.size(); i++) {
						if(users.get(i).currentActNum == accountNum) {
							current = users.get(i);
						}
					}
					for(int j=0; j < joint.size(); j++) {
						if(joint.get(j).currentActNum == accountNum) {
							current = joint.get(j);
						}
					}
					
					System.out.println("\nTo make a deposit choose '1'\n"
							+ "To make a withdrawal choose '2'\n"
							+ "To make a transfer choose '3'\n"
							+ "To exit choose '4'");
					choice = Integer.parseInt(input.next());
					switch(choice) {
						case 1:
							current.depositFunds(input);
							logger.info("funds deposited by: " + current.name);
							serializeFile(users, fileName);
							serializeJointFile(joint, fileName2);
							break;
						case 2: 
							current.withdrawFunds(input);
							logger.info("funds withdrawn by: " + current.name);
							serializeFile(users, fileName);
							serializeJointFile(joint, fileName2);
							break;
						case 3:
							current.transferFunds(users, joint, input);
							logger.info("funds transfered by: " + current.name);
							serializeFile(users, fileName);
							serializeJointFile(joint, fileName2);
							break;
						case 4:
							break;
					}
					break;
				case 4:
					System.out.println("Enter account number to cancel");
					int currentAccountNum = Integer.parseInt(input.next());
					users.removeIf(n -> (n.currentActNum == currentAccountNum));
					joint.removeIf(n -> (n.currentActNum == currentAccountNum));
					
					serializeFile(users, fileName);
					serializeJointFile(joint, fileName2);
					
					logger.info("account canceled by: " + current.name);
					
					System.out.println("Account canceled successfully!");
					
					break;
				case 5:
					logger.info("return to menu");
					start(users, joint, fileName, fileName2);
				default:
					choiceMade = false;
					break;
				}
			}
			else if(current.userType == 'E') {
				System.out.println("\nTo check user info choose '1'\n"
						+ "To approve or deny new accounts choose '2'\n"
						+ "To exit choose '3'");
				choice = Integer.parseInt(input.next());
				switch(choice) {
				case 1:
					System.out.println("Is this a joint account? 'Y' or 'N'?");
					accountType = input.next().toLowerCase();
					if(accountType.equals("y")) {
						System.out.println("Please enter a user account number");
						int accountNum = Integer.parseInt(input.next());
						jointBalance(joint, accountNum);
						logger.info("account information checked by: " + current.name);
						break;
					}
					System.out.println("Please enter a user account number");
					int accountNum = Integer.parseInt(input.next());
					current.loadActInfo(users, accountNum);
					logger.info("account information checked by: " + current.name);
					break;
				case 2:
					editAccount(users, joint, fileName, fileName2, input);
					logger.info("account edited by: " + current.name);
					break;
				case 3:
					logger.info("return to menu");
					start(users, joint, fileName, fileName2);
				default:
					choiceMade = false;
					break;
				}
			}
			else {
				System.out.println("\nTo check your balance choose '1'\n"
						+ "To make a deposit choose '2'\n"
						+ "To make a withdrawal choose '3'\n"
						+ "To make a transfer choose '4'\n"
						+ "To exit choose '5'");
				
				choice = Integer.parseInt(input.next());
				switch(choice) {
					case 1:
						current.checkBalance(users);
						logger.info("account information checked by: " + current.name);
						break;
					case 2:
						current.depositFunds(input);
						logger.info("deposit made by: " + current.name);
						serializeFile(users, fileName);
						serializeJointFile(joint, fileName2);
						break;
					case 3: 
						current.withdrawFunds(input);
						logger.info("withdrawal made by: " + current.name);
						serializeFile(users, fileName);
						serializeJointFile(joint, fileName2);
						break;
					case 4:
						current.transferFunds(users, joint, input);
						logger.info("transfer made by: " + current.name);
						serializeFile(users, fileName);
						serializeJointFile(joint, fileName2);
						break;
					case 5:
						logger.info("return to menu");
						start(users, joint, fileName, fileName2);
					default:
						choiceMade = false;
						break;
				}
				
			}
			
		}while(choiceMade);
	}
	
	public static void jointBalance(ArrayList<Joint> joint, int accountNum) {
		for(int i=0; i < joint.size(); i++) {
			
			logger.info("The jointBalance() method is called");
			
			if(joint.get(i).currentActNum == accountNum) {
				Joint current = joint.get(i);
				current.loadJointActInfo(joint, accountNum);
			}
			else {
				logger.error("Account doesn't exist");
				System.out.println("No such account!");
			}
		}
	}
	
	public static void editAccount(ArrayList<User> users, ArrayList<Joint> joint, String userFile, 
			String jointFile, Scanner input) {
		
		logger.info("The editAccount() method is called");
		
		ArrayList<User> newUser = new ArrayList<User>();
		ArrayList<Joint> newJoint = new ArrayList<Joint>();
		newUser = deserializeFile(newUser, "New.txt");
		newJoint = deserializeJointFile(newJoint, "NewJoint.txt");
		
		if(newUser.isEmpty() && newJoint.isEmpty()) {
			System.out.println("No new accounts");
		}
		else {
			for(int i=0; i < newUser.size(); i++) {
				System.out.println(newUser.get(i));
			}
			for(int j=0; j < newJoint.size(); j++) {
				System.out.println(newJoint.get(j));
			}
			
			System.out.println("Enter account number to edit");
			int accountNum = Integer.parseInt(input.next());
			System.out.println("Will you aprove or deny this account? \n"
					+ "'1' for approve\n"
					+ "'2' for deny");
			int choice = Integer.parseInt(input.next());
			
			if(choice == 2) {
				newUser.removeIf(n -> (n.currentActNum == accountNum));
				newJoint.removeIf(n -> (n.currentActNum == accountNum));
				logger.info("Account deleted");
			}
			else {
				for(int x=0; x < newUser.size(); x++) {
					if(newUser.get(x).currentActNum == accountNum) {
						users.add(newUser.get(x));
						System.out.println("Account approved!");
						newUser.removeIf(n -> (n.currentActNum == accountNum));
						break;
					}
					else {
						for(int z=0; z < newJoint.size(); z++) {
							if(newJoint.get(z).currentActNum == accountNum) {
								joint.add(newJoint.get(z));
								System.out.println("Account approved!");
								newJoint.removeIf(n -> (n.currentActNum == accountNum));
								break;
							}
						}
					}
				}
			}
			serializeFile(newUser, "New.txt");
			serializeJointFile(newJoint, "NewJoint.txt");
			serializeFile(users, userFile);
			serializeJointFile(joint, jointFile);
			
			logger.info("Account approved");
		}
	}
	
	public static boolean userValidation(ArrayList<User> user, ArrayList<Joint> joint, String username) {
		for(int i=0; i < user.size(); i++) {
			
			logger.info("The userValidation() method is called");
			
			if(user.get(i).username.contentEquals(username)) {
				logger.error("Username already exists");
				System.out.println("Username is currently in use, try another.");
				return false;
			}
			else {
				for(int x=0; x < joint.size(); x++) {
					if(joint.get(x).username.contentEquals(username) || joint.get(x).username2.contentEquals(username)) {
						logger.error("Username already exists");
						System.out.println("Username is currently in use, try another.");
						return false;
					}
				}
			}
		}
		return true;
		
	}
	
	//Serialize the file
	public static void serializeFile(ArrayList<User> users, String fileName) {
		try {
			
			logger.info("The serializeFile() method is called");
			
			// Writing the object to a file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// Method for serialization of object
			out.writeObject(users);
			
			out.close(); 
            file.close(); 
              
		}
		catch(IOException e) {
			System.out.println("IOException" + e.getMessage());
			logger.error("File not accessible");
		}
	}
	
	//Deserialize the file
	public static ArrayList<User> deserializeFile(ArrayList<User> users, String fileName) { 
		
		logger.info("The deserializeFile() method is called");
		
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
			ArrayList<User> readObject = (ArrayList<User>)in.readObject();
			users = readObject; 
              
            in.close(); 
            file.close(); 
                
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException" + ex.getMessage());
            logger.error("File not accessible");
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException" + ex.getMessage());
            logger.error("Class not accessible");
        }
        
        return users;
	}
	
	public static void serializeJointFile(ArrayList<Joint> joint, String fileName) {
		try {
			
			logger.info("The serializeJointFile() method is called");
			
			// Writing the object to a file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// Method for serialization of object
			out.writeObject(joint);
			
			out.close(); 
            file.close(); 
              
		}
		catch(IOException e) {
			System.out.println("IOException" + e.getMessage());
			logger.error("File not accessible");
		}
	}
	
	//Deserialize the file
	public static ArrayList<Joint> deserializeJointFile(ArrayList<Joint> joint, String fileName) { 
		
		logger.info("The deserializeJointFile() method is called");
		
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
			ArrayList<Joint> readObject = (ArrayList<Joint>)in.readObject();
			joint = readObject; 
              
            in.close(); 
            file.close(); 
                
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException" + ex.getMessage());
            logger.error("File not accessible");
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException" + ex.getMessage());
            logger.error("Class not accessible");
        }
        
        return joint;
	}
}
