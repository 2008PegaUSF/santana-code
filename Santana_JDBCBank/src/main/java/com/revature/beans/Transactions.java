package com.revature.beans;
/*Java Bean
 * private fields
 * No args and w/fields constructors
 * getters and setters
 * toString method override
 * */
public class Transactions {
	private int transactionId;
	private int userId;
	private String transactionType;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transactions(int transactionId, int userId, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.transactionType = transactionType;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", userId=" + userId + ", transactionType="
				+ transactionType + "]";
	}
	
	
}
