package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;

public interface UserDao {
	
	public User getUser(int id) throws SQLException;
	
	public int getUserIdFromUsername(String username) throws SQLException;
	
	public List<User> getAllUsers() throws SQLException;

	public void addNewUser(String username, String password) throws SQLException;
	
	public void addNewJointUser(String username, String password, 
			String username2, String password2) throws SQLException;
	
	public ArrayList<User> getNewUsers() throws SQLException;
	
	public void deny(int id) throws SQLException;
	
	public void userIsCustomer(int id) throws SQLException;
	
}
