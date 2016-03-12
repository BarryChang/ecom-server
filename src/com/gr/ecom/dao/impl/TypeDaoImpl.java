package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.ITypeDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.Type;



public class TypeDaoImpl implements ITypeDao {

	private Connection connection;
	private DBUtils dbUtils;

	public TypeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(Type type) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String typeName = type.getType();
		String strSQL = "insert into type values(null,?)";
		Object[] params = new Object[] { typeName };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(final Type type) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int typeId = type.getTypeId();
		String strSQL = "delete from type where type_Id=?";
		Object[] params = new Object[] { typeId };
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
	public List<Type> selectByTypeId(final Type type) {
		// TODO Auto-generated method stub
		List<Type> lstType = new ArrayList<Type>();
		connection = ConnectionManager.getConnection();
		int typeId = type.getTypeId();
		String strSQL = "select distinct * from type where type_Id = ? order by type_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { typeId });
		try {
			while (resultSet.next()) {
				Type typ = new Type();
				typ.setTypeId(resultSet.getInt(1));
				typ.setType(resultSet.getString(2));

				lstType.add(typ);
			}
			// ���ؽ��
			return lstType;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

	@Override
	public int update(Type type) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update type set type=? where type_Id=?";
		Object[] params = new Object[] { type.getType(), type.getTypeId() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}

}
