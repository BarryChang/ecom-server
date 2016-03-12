package com.gr.ecom.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c=ConnectionManager.getConnection();
		try {
			ResultSet r=c.prepareStatement("select * from user").executeQuery();
			r.next();
			System.out.println(r.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
