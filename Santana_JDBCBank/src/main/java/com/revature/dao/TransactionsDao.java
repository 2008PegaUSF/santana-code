package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Transactions;

public interface TransactionsDao {
	public List<Transactions> getAllTransactions() throws SQLException;
	public List<Transactions> getAllUserTransactions(int id) throws SQLException;
}
