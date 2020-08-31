package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao{
	public static ConnFactory cf = ConnFactory.getInstance();

	public User getUser(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from \"User\" where \"UserId\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return u;
	}

	public List<User> getAllUsers() throws SQLException {
		List<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from \"User\"");
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			userList.add(u);
		}
		return userList;
	}

	public void addNewUser(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into \"User\" (\"UserId\", \"Username\", \"Password\", \"UserType\") "
				+ "values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setString(2, username);
		ps.setString(3, password);
		ps.setString(4, "New");
		ps.executeUpdate();
		
	}
	
	public void addNewJointUser(String username, String password, 
			String username2, String password2) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "insert into \"User\" (\"UserId\", \"Username\", \"Password\", \"UserType\") "
				+ "values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		PreparedStatement ps2 = conn.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setString(2, username);
		ps.setString(3, password);
		ps.setString(4, "New Joint");
		ps.executeUpdate();
		
		ps2.setInt(1, 1);
		ps2.setString(2, username2);
		ps2.setString(3, password2);
		ps2.setString(4, "New Joint");
		ps2.executeUpdate();
		
	}

	public int getUserIdFromUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select \"UserId\" from \"User\" where \"Username\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		int a = 0;
		while(rs.next()) {
			a = rs.getInt(1);
		}
		return a;
	}

	public ArrayList<User> getNewUsers() throws SQLException {
		ArrayList<User> userList = new ArrayList<User>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from \"User\" where \"UserType\" = 'New' or \"UserType\" = 'New Joint'");
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			userList.add(u);
		}
		return userList;
	}

	public void deny(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from \"User\" where \"UserId\"= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
	}
	
}
