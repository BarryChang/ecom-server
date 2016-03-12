package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.IRelationshipDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.Relationship;



public class RelationshipDaoImpl implements IRelationshipDao {

	private Connection connection;
	private DBUtils dbUtils;

	public RelationshipDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		connection = ConnectionManager.getConnection();
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(Relationship relationship) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int userId = relationship.getUserId();
		int targetId = relationship.getTargetId();
		int typeId = relationship.getTypeId();

		String strSQL = "insert into Relationship values(null,?,?,?)";
		Object[] params = new Object[] { userId, targetId, typeId };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(Relationship relationship) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int RelationshipId = relationship.getRelationshipId();
		String strSQL = "delete from Relationship where Relationship_Id=?";
		Object[] params = new Object[] { RelationshipId };
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
	public int update(Relationship relationship) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update Relationship set User_Id=?, Target_Id=?, Type_Id=? where Relationship_Id=?";
		Object[] params = new Object[] { relationship.getUserId(),
				relationship.getTargetId(), relationship.getTypeId(),
				relationship.getRelationshipId() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}

	@Override
	public List<Relationship> selectByRelationshipId(final Relationship relationship) {
		// TODO Auto-generated method stub
		List<Relationship> lstRelationship = new ArrayList<Relationship>();
		connection = ConnectionManager.getConnection();
		int RelationshipId = relationship.getRelationshipId();
		String strSQL = "select distinct * from Relationship where Relationship_Id = ? order by Relationship_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { RelationshipId });
		try {
			while (resultSet.next()) {
				Relationship r = new Relationship();
				r.setRelationshipId(resultSet.getInt(1));
				r.setUserId(resultSet.getInt(2));
				r.setTargetId(resultSet.getInt(3));
				r.setTypeId(resultSet.getInt(4));
				lstRelationship.add(r);
			}
			// ���ؽ��
			return lstRelationship;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}
	}

	@Override
	public List<Relationship> selectByUserId(Relationship relationship) {
		// TODO Auto-generated method stub
		List<Relationship> lstRelationship = new ArrayList<Relationship>();
		connection = ConnectionManager.getConnection();
		int userId = relationship.getUserId();
		int typeId=relationship.getTypeId();
		String strSQL = "select distinct * from Relationship where User_Id = ? and Type_Id = ? order by Relationship_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { userId,typeId });
		try {
			while (resultSet.next()) {
				Relationship r = new Relationship();
				r.setRelationshipId(resultSet.getInt(1));
				r.setUserId(resultSet.getInt(2));
				r.setTargetId(resultSet.getInt(3));
				r.setTypeId(resultSet.getInt(4));
				lstRelationship.add(r);
			}
			// ���ؽ��
			return lstRelationship;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}
	}
}
