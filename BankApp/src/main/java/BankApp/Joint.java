package BankApp;

import java.util.ArrayList;

public class Joint extends User{

	private static final long serialVersionUID = 1L;
	
	protected String username2, password2, name2;
	
	public Joint(String userName, String password, String name, String username2, String password2, String name2, double curActBalance, String phoneNum, String address,
			int currentActNum, char userType) {
		super(userName, password, name, curActBalance, phoneNum, address, currentActNum, userType);
		this.name2 = name2;
		this.username2 = username2;
		this.password2 = password2;
	}

	protected void loadJointActInfo(ArrayList<Joint> joint, int accountNum) {	
		for(int i=0; i< joint.size(); i++) {
			if(joint.get(i).currentActNum == accountNum) {
				System.out.println("Customer Info: ");
				System.out.println("Names: " + joint.get(i).name + ", " + joint.get(i).name2);
				System.out.println("Address: " + joint.get(i).address);
				System.out.println("Phone: " + joint.get(i).phoneNum);
				System.out.println("Username: " + joint.get(i).username + ", " + joint.get(i).username2);
				System.out.println("Password: " + joint.get(i).password + ", " + joint.get(i).password2);
				System.out.println("Acct #: " + joint.get(i).currentActNum);
				System.out.println("Balance: " + joint.get(i).curActBalance);
			}
		}		
	}
	
}
