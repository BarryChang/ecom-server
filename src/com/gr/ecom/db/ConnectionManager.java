package com.gr.ecom.db;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

	private static ConnectionPool connectionpool;
	static{
		try {
			connectionpool=new ConnectionPool();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			return connectionpool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void releaseConnection(Connection c){
		connectionpool.releaseConnection(c);
	}
	
	
}
