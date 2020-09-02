package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDao {
	
	public List<Customer> getCustomerInfo(int id) throws SQLException;
	
	public int getAccountId(int id) throws SQLException;
	
	public void deleteCustomer(int id) throws SQLException;
	
	public void approve(int id, String lastName, String firstName, String address, String type, 
			String city, String state, String zipcode, String phone) throws SQLException;
	
	public void approveJoint(int id, String lastName, String firstName, String address, String type, 
			String city, String state, String zipcode, String phone, int id2, String lastName2, 
			String firstName2, String address2, String type2, String city2, String state2, 
			String zipcode2, String phone2) throws SQLException;
}
