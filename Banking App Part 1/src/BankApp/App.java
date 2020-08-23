package BankApp;

import java.io.*;

public class App {

	public static void main(String[] args) {	
		User object = new User("mario", "lets-a-go", "Peter Brooks", 
				5000.04, "555-5555", "123 Main st", 'U',
				485);
		String fileName = "Data.txt";
		
		//Serialize
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(object);
			
			out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized");
		}
		catch(IOException e) {
			System.out.println("IOException caught");
		}
		
		User object1 = null; 
		  
        // Deserialization 
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            object1 = (User)in.readObject(); 
              
            in.close(); 
            file.close(); 
              
            System.out.println("Object has been deserialized "); 
            System.out.println("Name: " + object1.name); 
            System.out.println("Phone = " + object1.phoneNum); 
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        }
	}

}
