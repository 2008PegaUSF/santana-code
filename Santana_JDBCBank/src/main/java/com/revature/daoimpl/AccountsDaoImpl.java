package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Accounts;
import com.revature.beans.User;
import com.revature.dao.AccountsDao;
import com.revature.util.ConnFactory;

public class AccountsDaoImpl implements AccountsDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public double getAccountBalance(int id) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "select * from \"Accounts\" where \"AccountId\"= ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		double a = 0;
		while(rs.next()) {
			a = rs.getDouble(2);
		}
		return a;
	}

	public void deposit(int id, double deposit) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "update \"Accounts\" set balance = balance + ? where \"AccountId\"= ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDouble(1, deposit);
		ps.setInt(2, id);
		ps.executeUpdate();
		
	}
	
	public void withdraw(int id, double withdraw) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "update \"Accounts\" set balance = balance - ? where \"AccountId\"= ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDouble(1, withdraw);
		ps.setInt(2, id);
		ps.executeUpdate();
	
	}

	public void transfer(int id, int id2, double transfer) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "update \"Accounts\" set balance = balance - ? where \"AccountId\"= ?";
		String sql2 = "update \"Accounts\" set balance = balance + ? where \"AccountId\"= ?";		
		
		PreparedStatement ps = conn.prepareStatement(sql);
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		
		ps.setDouble(1, transfer);
		ps.setInt(2, id);
		
		ps2.setDouble(1, transfer);
		ps2.setInt(2, id2);
		
		ps.executeUpdate();
		
		ps2.executeUpdate();
	
	}

	public void addNewAccount(int id) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "insert into \"Accounts\" (\"AccountId\", balance) values(?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		ps.setDouble(2, 0);
		ps.execute();
		
	}

	public void deleteAccount(int id) throws SQLException {
		
		Connection conn = cf.getConnection();
		
		String sql = "delete from \"Accounts\" where \"AccountId\" = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, id);
		ps.execute();
		
	}

}
