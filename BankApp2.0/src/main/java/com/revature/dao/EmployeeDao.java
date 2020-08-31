package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees() throws SQLException;
	public List<Employee> getEmployee(int id) throws SQLException;
}
