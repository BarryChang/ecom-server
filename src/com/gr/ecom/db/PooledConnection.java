package com.gr.ecom.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gr.ecom.db.DBConfig;

class PooledConnection {

	Connection conn=null;
	private boolean isFree=true;
	public boolean isBusy(){
		return isFree;
	}
	public PooledConnection() throws SQLException{
		conn=DriverManager.getConnection("jdbc:mysql://" + DBConfig.IP
					+ ":" + DBConfig.PORT + "/" + DBConfig.DBNAME,
					DBConfig.ACCOUNT, DBConfig.PASSWORD);
	}
	public Connection getConnection(){
		return conn;
	}
	public void setFree(boolean b){
		isFree=b;
	}
}
