package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.IResourceDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.Resource;



public class ResourceDaoImpl implements IResourceDao {

	private Connection connection;
	private DBUtils dbUtils;

	public ResourceDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(final Resource resource) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int typeId = resource.getTypeId();
		String resourcePath = resource.getResourcePath();
		String resourceIndex = resource.getResourceIndex();
		String strSQL = "insert into resource values(null,?,?,?)";
		Object[] params = new Object[] { typeId, resourcePath, resourceIndex };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(final Resource resource) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String resourceIndex = resource.getResourceIndex();
		String strSQL = "delete from resource where resource_Index=?";
		Object[] params = new Object[] { resourceIndex };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		// ����6������Ӱ������
		return affectedRwos;
	}

	public List<Resource> selectByResourceIndex(final Resource resource) {
		// TODO Auto-generated method stub
		List<Resource> lstResource = new ArrayList<Resource>();
		connection = ConnectionManager.getConnection();
		String resourceIndex = resource.getResourceIndex();
		String strSQL = "select distinct * from resource where resource_Index = ? order by resource_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { resourceIndex });
		try {
			while (resultSet.next()) {
				Resource res = new Resource();
				res.setResourceId(resultSet.getInt(1));
				res.setTypeId(resultSet.getInt(2));
				res.setResourcePath(resultSet.getString(3));
				res.setResourceIndex(resultSet.getString(4));
				lstResource.add(res);
			}
			// ���ؽ��
			return lstResource;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

	@Override
	public int update(Resource resource) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update resource set Type_Id=?, Resource_Path=? where Resource_Index=?";
		Object[] params = new Object[] { resource.getTypeId(),
				resource.getResourcePath(), resource.getResourceIndex() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}
}
