package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.IPrivilegeDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.Privilege;



public class PrivilegeDaoImpl implements IPrivilegeDao {
	private Connection connection;
	private DBUtils dbUtils;

	public PrivilegeDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(Privilege privilege) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String privilegeContent = privilege.getPrivilegeContent();
		String strSQL = "insert into privilege values(null,?)";
		Object[] params = new Object[] { privilegeContent };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(final Privilege privilege) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int privilegeId = privilege.getPrivilegeId();
		String strSQL = "delete from privilege where privilege_Id=?";
		Object[] params = new Object[] { privilegeId };
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
	public List<Privilege> selectByPrivilegeId(final Privilege privilege) {
		// TODO Auto-generated method stub
		List<Privilege> lstPrivilege = new ArrayList<Privilege>();
		connection = ConnectionManager.getConnection();
		int privilegeId = privilege.getPrivilegeId();
		String strSQL = "select distinct * from privilege where privilege_Id = ? order by privilege_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { privilegeId });
		try {
			while (resultSet.next()) {
				Privilege pri = new Privilege();
				pri.setPrivilegeId(resultSet.getInt(1));
				pri.setPrivilegeContent(resultSet.getString(2));

				lstPrivilege.add(pri);
			}
			// ���ؽ��
			return lstPrivilege;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

	@Override
	public int update(Privilege privilege) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update privilege set Privilege_Content=? where Privilege_Id=?";
		Object[] params = new Object[] { privilege.getPrivilegeContent(),
				privilege.getPrivilegeId() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}
}
