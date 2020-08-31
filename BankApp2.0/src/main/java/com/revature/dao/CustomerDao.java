package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {
	public List<Customer> getCustomerInfo(int id) throws SQLException;
	public int getAccountId(int id) throws SQLException;
	public void approve(int id, String lastName, String firstName, String address, String type, 
			String city, String state, String zipcode, String phone) throws SQLException;
}
