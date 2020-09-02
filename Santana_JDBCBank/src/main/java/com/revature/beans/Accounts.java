package com.revature.beans;
/*Java Bean
 * private fields
 * No args and w/fields constructors
 * getters and setters
 * toString method override
 * */
public class Accounts {
	private int accountId;
	private double balance;
	
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounts(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Accounts [accountId=" + accountId + ", balance=" + balance + "]";
	}
	
	
}


