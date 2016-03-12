package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.ICommunityDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.Community;


public class CommunityDaoImpl implements ICommunityDao {

	private Connection connection;
	private DBUtils dbUtils;

	public CommunityDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(Community community) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String communityName = community.getCommunityName();
		int communityLevel = community.getCommunityLevel();
		int communityCapacity = community.getCommunityCapacity();
		String communityBackground = community.getCommunityBackground();
		String communitySignature = community.getCommunitySignature();
		int communityNoteNumber = community.getCommunityNoteNumber();
		int communityThemeNumber = community.getCommunityThemeNumber();
		String strSQL = "insert into community values(null,?,?,?,?,?,?,?)";
		Object[] params = new Object[] { communityName, communityLevel,
				communityCapacity, communityBackground, communitySignature,
				communityNoteNumber, communityThemeNumber };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(final Community community) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int communityId = community.getCommunityId();
		String strSQL = "delete from community where Community_Id=?";
		Object[] params = new Object[] { communityId };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); 
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

	@Override
	public List<Community> selectByCommunityId(final Community community) {
		// TODO Auto-generated method stub
		List<Community> lstCommunity = new ArrayList<Community>();
		connection = ConnectionManager.getConnection();
		int communityId = community.getCommunityId();
		String strSQL = "select distinct * from community where community_Id = ? order by community_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { communityId });
		try {
			while (resultSet.next()) {
				Community com = new Community();
				com.setCommunityId(resultSet.getInt(1));
				com.setCommunityName(resultSet.getString(2));
				com.setCommunityLevel(resultSet.getInt(3));
				com.setCommunityCapacity(resultSet.getInt(4));
				com.setCommunityBackground(resultSet.getString(5));
				com.setCommunitySignature(resultSet.getString(6));
				com.setCommunityNoteNumber(resultSet.getInt(7));
				com.setCommunityThemeNumber(resultSet.getInt(8));

				lstCommunity.add(com);
			}
			return lstCommunity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

	@Override
	public int update(Community community) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update community set community_Name=?, community_Level=?, community_Capacity=?, community_Background=?, community_Signature=?, community_NoteNumber=?, community_ThemeNumber=? where community_Id=?";
		Object[] params = new Object[] { community.getCommunityName(),
				community.getCommunityLevel(),
				community.getCommunityCapacity(),
				community.getCommunityBackground(),
				community.getCommunitySignature(),
				community.getCommunityNoteNumber(),
				community.getCommunityThemeNumber(), community.getCommunityId() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback(); 
		}
		return affectedRwos;
	}

}
