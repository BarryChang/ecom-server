package com.gr.ecom.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;



public class ConnectionPool {
	
	private Vector<PooledConnection> connections=null;
	private int initSize=10;
	private int currentSize;
	private int maxSize=100;
	private int addSize=5;
	public ConnectionPool() throws SQLException {
		// TODO Auto-generated constructor stub
		connections=new Vector<>();
		for(int i=0;i<initSize;i++){
			PooledConnection pc=new PooledConnection();
			connections.add(pc);
		}
		currentSize=initSize;
	}
	public synchronized Connection getConnection() throws SQLException{
		Enumeration<PooledConnection> enumer=connections.elements();
		PooledConnection pc=null;
		while(enumer.hasMoreElements()){
			pc=(PooledConnection) enumer.nextElement();
			if(pc.isBusy()){
				pc.setFree(false);
				return pc.getConnection();
			}
		}
		Connection c=addConnection();
		if(c!=null)
			return c;
		else
			return null;
	}
	private Connection addConnection() throws SQLException{
		PooledConnection pc=null;
		if(currentSize<maxSize)
		{
			for(int i=0;i<addSize;i++){
				pc=new PooledConnection();
				connections.add(pc);
			}
			currentSize+=addSize;
			pc.setFree(false);
			return pc.getConnection();
		}
		else
			return null;
	}
	public void releaseConnection(Connection c){
		Enumeration<PooledConnection> enumer=connections.elements();
		PooledConnection pc;
		while(enumer.hasMoreElements()){
			pc=(PooledConnection) enumer.nextElement();
			if(pc.getConnection()==c){
				pc.setFree(true);
				return;
			}
		}
	}
	public int getCurrentSize() {
		return currentSize;
	}
	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}
	
}
