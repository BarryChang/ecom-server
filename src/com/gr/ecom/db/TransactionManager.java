package com.gr.ecom.db;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

	public static Connection connection = null;
	
	public static void beginTransaction(){
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit(){
		try {
			connection.commit();
			ConnectionManager.releaseConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback(){
		try {
			connection.rollback();
			ConnectionManager.releaseConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
