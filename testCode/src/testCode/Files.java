package testCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.lang.ClassNotFoundException;

public class Files implements Serializable {
	
	public String name;
	public int age;
	public double height;
	
	public Files(String a, int b, double c) {
		
		this.name = a;
		this.age = b;
		this.height = c;
	}
	
	
	public static void main(String[] args) {
		String filename = "file.txt";
		File f = new File(filename);
		Files answers = null;
		if(f.exists()) {
			try {
				FileInputStream file = new FileInputStream(filename);
				ObjectInputStream in = new ObjectInputStream(file);
				
				answers = (Files) in.readObject();
				in.close();
				file.close();
				
				System.out.println("Your name is " + answers.name + " you are " + answers.age 
						+ " year(s) old, and you are " + answers.height + " tall.");
			}
			catch(IOException e){
				
			
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		}
		else {
			Scanner input = new Scanner(System.in);
			
			System.out.println("What is your name? ");
			String name = input.nextLine();
			
			System.out.println("What is your age? ");
			int age = input.nextInt();
			
			System.out.println("How tall are you? ");
			double height = input.nextDouble();
			
			input.close();
			
			answers = new Files(name, age, height);
			
			try {
				FileOutputStream file = new FileOutputStream(filename);
				ObjectOutputStream out = new ObjectOutputStream(file);
				
				out.writeObject(answers);
				
				out.close();
				file.close();
				
				System.out.println("Object Serialized!");
			}
			catch(IOException ex) {
				
			}
		}	
	}
}
