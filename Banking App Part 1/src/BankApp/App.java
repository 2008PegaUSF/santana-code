package BankApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {	
		ArrayList<User> users = new ArrayList<User>();
		String fileName = "Data.txt";
		
		users = deserializeFile(users, fileName);
		System.out.println(users);
		
		start(users, fileName);
		
		/*User object = new User("luigi", "imma-gonna-win", "Luigi Mario", 
				3000.25, "555-5554", "123 Main st", 2, 'U', 1);
		User object2 = new User("mario", "lets-a-go", "Mario Mario", 
				5000.04, "555-5555", "123 Main st", 1, 'U', 0);
		User object3 = new User("link", "hyaa", "Link Link", 
				13000.99, "555-5553", "135 Main st", 3, 'U', 0);
		User object4 = new User("admin", "password", "Admin", 
				0, null, null, 100, 'A', -1);
		User object5 = new User("emp", "password", "Employee", 
				0, null, null, 101, 'E', -2);
		
		users.add(object);
		users.add(object2);
		users.add(object3);
		users.add(object4);
		users.add(object5);*/
		
		//serializeFile(users, fileName);
		//System.out.println(users);
		
		
		//users.removeIf(n -> (n.currentActNum == 2));
		
	}
	
	public static void start(ArrayList<User> users, String fileName) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Nook's Bank!");
		System.out.println("Please input your username, "
				+ "or input 'new' for a new account"
				+ " or 'exit' to close");
		String result = input.next().toLowerCase();
		if(result == "new") {
			String newFileName = "New.txt";
			System.out.println("Will this be a joint account? 'Y' - yes, 'N'- No");
			String yesOrNo = input.next();
			String newUsername, newPassword = "";
			switch(yesOrNo) {
				case "Y":
					System.out.println("Please input your desired username: ");
					newUsername = input.next();
					System.out.println("Please input your desired password: ");
					newPassword = input.next();
					System.out.println("Please input the next desired username: ");
					String newUsername2 = input.next();
					System.out.println("Please input the next desired password: ");
					String newPassword2 = input.next();
				
				case "N":
					System.out.println("Please input your desired username: ");
					newUsername = input.next();
					System.out.println("Please input your desired password: ");
					newPassword = input.next();
			}
		}
		else if(result == "exit"){
			System.exit(0);
		}
		else {
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
							menu(users,current, input, fileName);
						}
						else {
							System.out.println("Incorrect password, please try again");
						}
					}
					System.out.println("Maximum attempts exceeded!");
					start(users, fileName);
				}
			}
			System.out.println("Ussername not found!");
			start(users, fileName);
		}
	}
	
	private static void menu(ArrayList<User> users, User current, Scanner input, String fileName) {
		int choice;
		boolean choiceMade = true;
		do {
			if(current.userType == 'A') {
				
			}
			else if(current.userType == 'E') {
				
			}
			else {
				System.out.println("\nTo check you balance choose '1'\n"
						+ "To make a deposit choose '2'\n"
						+ "To make a withdrawal choose '3'\n"
						+ "To make a transfer choose '4'\n"
						+ "To exit choose 5");
				
				choice =Integer.parseInt(input.next());
				switch(choice) {
					case 1:
						current.checkBalance(users);
						break;
					case 2:
						current.depositFunds(input);
						serializeFile(users, fileName);
						break;
					case 3: 
						current.withdrawFunds(input);
						serializeFile(users, fileName);
						break;
					case 4:
						current.transferFunds(users, input);
						serializeFile(users, fileName);
						break;
					case 5:
						start(users, fileName);
					default:
						choiceMade = false;
						break;
				}
			}
		}while(choiceMade);
	}
	
	private void checkRequests() {
		// BE ABLE TO CHECK NEW ACCOUNT REQUESTS
	}
	
	private void cancelAcount() {
		// CANCEL ANY ACCOUNT
	}
	
	public static void serializeFile(ArrayList<User> users, String fileName) {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(users);
			
			out.close(); 
            file.close(); 
              
		}
		catch(IOException e) {
			System.out.println("IOException caught");
		}
	}
	
	public static ArrayList<User> deserializeFile(ArrayList<User> users, String fileName) { 
		
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            users = (ArrayList<User>)in.readObject(); 
              
            in.close(); 
            file.close(); 
                
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        }
        
        return users;
	}
	
}
