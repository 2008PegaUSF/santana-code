package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;
import com.revature.beans.User;
import com.revature.dao.CustomerDao;
import com.revature.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public List<Customer> getCustomerInfo(int id) throws SQLException {
		List<Customer> customers = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		String sql = "select * from \"Customer\" where \"AccountId\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), 
					rs.getString(9), rs.getString(10), rs.getInt(11));
			customers.add(c);
		}
		return customers;
	}


	public int getAccountId(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select \"AccountId\" from \"Customer\" where \"UserId\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		int a = 0;
		while(rs.next()) {
			a = rs.getInt(1);
		}
		return a;
	}
	
	public void approve(int id, String lastName, String firstName, String address, String type, 
			String city, String state, String zipcode, String phone) throws SQLException {
		
		Connection conn = cf.getConnection();
		if(type == "Single") {
			String sql = "insert into \"Customer\"  (\"CustomerId\", \"UserId\", \"LastName\", "
					+ "\"FirstName\", \"Address\", \"CustomerType\", \"City\", \"State\", "
					+ "\"ZipCode\", \"Phone\", \"AccountId\")"
								+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, id);
			ps.setString(3, lastName);
			ps.setString(4, firstName);
			ps.setString(5, address);
			ps.setString(6, type);
			ps.setString(7, city);
			ps.setString(8, state);
			ps.setString(9, zipcode);
			ps.setString(10, phone);
			ps.setInt(11, 10);
			ps.executeUpdate();
		}
		else {
			/*
			 * pass values from the previously created customer querying the accountId
			 * that was generated and pass that value into the next customer on the joint
			 * account. access the accountId via the userId. Possibly create two functions
			 * to better control this.*/
		}
	}

}
