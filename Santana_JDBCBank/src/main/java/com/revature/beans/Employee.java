package com.revature.beans;
/*Java Bean
 * private fields
 * No args and w/fields constructors
 * getters and setters
 * toString method override
 * */
public class Employee {
	private int employeeId;
	private int userId;
	private String employeeType;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, int userId, String employeeType) {
		super();
		this.employeeId = employeeId;
		this.userId = userId;
		this.employeeType = employeeType;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", userId=" + userId + ", employeeType=" + employeeType + "]";
	}
	
	
}
