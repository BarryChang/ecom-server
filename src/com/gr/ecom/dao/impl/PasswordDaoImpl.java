package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.IPasswordDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.Password;


public class PasswordDaoImpl implements IPasswordDao {

	private Connection connection;
	private DBUtils dbUtils;

	public PasswordDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(final Password password) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String userName = password.getUserName();
		String psd = password.getPassword();
		int typeId = password.getTypeId();
		String strSQL = "insert into password values(null,?,?,?)";
		Object[] params = new Object[] { userName, psd, typeId };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(final Password password) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int passwordId = password.getPasswordId();
		String strSQL = "delete from password where password_Id=?";
		Object[] params = new Object[] { passwordId };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		// ����6������Ӱ������
		return affectedRwos;
	}

	public List<Password> selectByPasswordId(final Password password) {
		// TODO Auto-generated method stub
		List<Password> lstPassword = new ArrayList<Password>();
		connection = ConnectionManager.getConnection();
		int passwordId = password.getPasswordId();
		String strSQL = "select distinct * from password where password_Id = ? order by password_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { passwordId });
		try {
			while (resultSet.next()) {
				Password psd = new Password();
				psd.setPasswordId(resultSet.getInt(1));
				psd.setUserName(resultSet.getString(2));
				psd.setPassword(resultSet.getString(3));
				psd.setTypeId(resultSet.getInt(4));
				lstPassword.add(psd);
			}
			// ���ؽ��
			return lstPassword;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

	@Override
	public int updateByPasswordId(Password password) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update password set User_Name=?, Password=?, Type_Id=? where Password_Id=?";
		Object[] params = new Object[] { password.getUserName(),
				password.getPassword(), password.getTypeId(),
				password.getPasswordId() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}

	@Override
	public int updateByUserName(Password password) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update password set User_Name=?, Password=?, Type_Id=? where User_Name = ?";
		Object[] params = new Object[] { password.getUserName(),
				password.getPassword(), password.getTypeId(),
				password.getUserName() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}

}
