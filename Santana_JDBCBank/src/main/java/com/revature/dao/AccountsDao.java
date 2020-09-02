package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Accounts;

public interface AccountsDao {
	
	public double getAccountBalance(int id) throws SQLException;
	
	public void deposit(int id, double deposit) throws SQLException;
	
	public void withdraw(int id, double withdraw) throws SQLException;
	
	public void transfer(int id, int id2, double transfer) throws SQLException;
	
	public void addNewAccount(int id) throws SQLException;
	
	public void deleteAccount(int id) throws SQLException;
}
