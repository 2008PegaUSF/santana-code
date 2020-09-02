package com.revature.beans;
/*Java Bean
 * private fields
 * No args and w/fields constructors
 * getters and setters
 * toString method override
 * */
public class User {
	private int userId;
	private String username;
	private String password;
	private String userType;
	private int jointId;
	
	public User() {
		super();
	}
	
	public User(int userId, String username, String password, String userType, int jointId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.jointId = jointId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getJointId() {
		return jointId;
	}

	public void setJointId(int jointId) {
		this.jointId = jointId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userType=" + userType
				+ "]\n";
	}
	
}


