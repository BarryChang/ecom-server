package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.IUserDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.User;



public class UserDaoImpl implements IUserDao {

	private Connection connection;
	private DBUtils dbUtils;

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(final User user) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String userName = user.getUserName();
		int userAge = user.getUserAge();
		int userGender = user.getUserGender();
		String userEmail = user.getUserEmail();
		String userPhone = user.getUserPhone();
		int communityId = user.getCommunityId();
		int userScore = user.getUserScore();
		int userLevel = user.getUserLevel();
		int PrivilegeId = user.getPrivilegeId();
		String strSQL = "insert into user values(null,?,?,?,?,?,?,now(),?,?,?)";
		Object[] params = new Object[] { userName, userAge, userGender,
				userEmail, userPhone, communityId, userScore, userLevel,
				PrivilegeId };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(final User user) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int userId = user.getUserId();
		String strSQL = "delete from user where user_Id=?";
		Object[] params = new Object[] { userId };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		// ����6������Ӱ������
		return affectedRwos;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update user set User_Name=?, User_Age=?, User_Gender=?, User_Email=?, User_Phone=?, Community_ID=?, User_RegisterDate=?, User_Score=?, User_Level=?, Privilege_ID=? where user_Id=?";
		Object[] params = new Object[] { user.getUserName(), user.getUserAge(),
				user.getUserGender(), user.getUserEmail(), user.getUserPhone(),
				user.getCommunityId(), user.getUserRegisterDate(),
				user.getUserScore(), user.getUserLevel(),
				user.getPrivilegeId(), user.getUserId() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}

	public List<User> selectByUserId(final User user) {
		// TODO Auto-generated method stub
		List<User> lstUser = new ArrayList<User>();
		connection = ConnectionManager.getConnection();
		int userId = user.getUserId();
		String strSQL = "select distinct * from user where user_Id = ? order by user_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { userId });
		try {
			while (resultSet.next()) {
				User usr = new User();
				usr.setUserId(resultSet.getInt(1));
				usr.setUserName(resultSet.getString(2));
				usr.setUserAge(resultSet.getInt(3));
				usr.setUserGender(resultSet.getInt(4));
				usr.setUserEmail(resultSet.getString(5));
				usr.setUserPhone(resultSet.getString(6));
				usr.setCommunityId(resultSet.getInt(7));
				usr.setUserRegisterDate(resultSet.getDate(8));
				usr.setUserScore(resultSet.getInt(9));
				usr.setUserLevel(resultSet.getInt(10));
				usr.setPrivilegeId(resultSet.getInt(11));
				lstUser.add(usr);
			}
			// ���ؽ��
			return lstUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

	@Override
	public List<User> selectByUserName(final User user) {
		// TODO Auto-generated method stub
		List<User> lstUser = new ArrayList<User>();
		connection = ConnectionManager.getConnection();
		String userName = user.getUserName();
		String strSQL = "select distinct * from user where User_Name = ? order by User_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { userName });
		try {
			while (resultSet.next()) {
				User usr = new User();
				usr.setUserId(resultSet.getInt(1));
				usr.setUserName(resultSet.getString(2));
				usr.setUserAge(resultSet.getInt(3));
				usr.setUserGender(resultSet.getInt(4));
				usr.setUserEmail(resultSet.getString(5));
				usr.setUserPhone(resultSet.getString(6));
				usr.setCommunityId(resultSet.getInt(7));
				usr.setUserRegisterDate(resultSet.getDate(8));
				usr.setUserScore(resultSet.getInt(9));
				usr.setUserLevel(resultSet.getInt(10));
				usr.setPrivilegeId(resultSet.getInt(11));
				lstUser.add(usr);
			}
			// ���ؽ��
			return lstUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

}
