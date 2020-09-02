package com.revature.driver;

import com.revature.daoimpl.AccountsDaoImpl;
import com.revature.daoimpl.CustomerDaoImpl;
import com.revature.daoimpl.UserDaoImpl;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBankApp {

	UserDaoImpl tu = new UserDaoImpl();
	CustomerDaoImpl tc = new CustomerDaoImpl();
	AccountsDaoImpl ta = new AccountsDaoImpl();
	
	@Test
	public void shouldDeposit() {
		try {
			
			double currentBalance = ta.getAccountBalance(tc.getAccountId(5));
			
			ta.deposit(3, 20);
			
			Assertions.assertTrue(ta.getAccountBalance(tc.getAccountId(5)) > currentBalance);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldWithdraw() {
		try {
			
			double currentBalance = ta.getAccountBalance(tc.getAccountId(5));
			
			ta.withdraw(3, 20);
			
			Assertions.assertTrue(ta.getAccountBalance(tc.getAccountId(5)) < currentBalance);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldTransfer() {
		try {
			
			double from = ta.getAccountBalance(tc.getAccountId(5));
			double to = ta.getAccountBalance(tc.getAccountId(4));
			
			ta.transfer(3, 2, 20);
			
			Assertions.assertTrue(ta.getAccountBalance(tc.getAccountId(5)) < from);
			Assertions.assertTrue(ta.getAccountBalance(tc.getAccountId(4)) > to);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
