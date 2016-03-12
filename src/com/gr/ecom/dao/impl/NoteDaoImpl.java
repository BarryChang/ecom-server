package com.gr.ecom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gr.ecom.dao.INoteDao;
import com.gr.ecom.db.ConnectionManager;
import com.gr.ecom.db.DBUtils;
import com.gr.ecom.db.TransactionManager;
import com.gr.ecom.po.Note;



public class NoteDaoImpl implements INoteDao {

	private Connection connection;
	private DBUtils dbUtils;

	public NoteDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.dbUtils = new DBUtils();
		connection = null;
	}

	@Override
	public int insert(final Note note) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int communityId = note.getCommunityId();
		int noteReplyTo = note.getNoteReplyTo();
		String noteContent = note.getNoteContent();
		int userId = note.getUserId();
		int noteView = note.getNoteView();
		String resourceIndex = note.getResourceIndex();
		String strSQL = "insert into note values(null,?,?,?,now(),?,?,?)";
		Object[] params = new Object[] { communityId, noteReplyTo, noteContent,
				userId, noteView, resourceIndex };
		int affectedRows = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRows > 0) {
			TransactionManager.commit();
		} else {
			TransactionManager.rollback();
		}
		return affectedRows;
	}

	@Override
	public int delete(final Note note) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		int noteId = note.getNoteId();
		String strSQL = "delete from note where note_Id=?";
		Object[] params = new Object[] { noteId };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		// ����6������Ӱ������
		return affectedRwos;
	}

	public List<Note> selectByNoteId(final Note note) {
		// TODO Auto-generated method stub
		List<Note> lstNote = new ArrayList<Note>();
		connection = ConnectionManager.getConnection();
		int noteId = note.getNoteId();
		String strSQL = "select distinct * from note where note_Id = ? order by note_Id desc ";
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { noteId });
		try {
			while (resultSet.next()) {
				Note res = new Note();
				res.setNoteId(resultSet.getInt(1));
				res.setCommunityId(resultSet.getInt(2));
				res.setNoteReplyTo(resultSet.getInt(3));
				res.setNoteContent(resultSet.getString(4));
				res.setNoteDate(resultSet.getString(5));
				res.setUserId(resultSet.getInt(6));
				res.setNoteView(resultSet.getInt(7));
				res.setResourceIndex(resultSet.getString(8));

				lstNote.add(res);
			}
			// ���ؽ��
			return lstNote;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}

	}

	@Override
	public int update(Note note) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update note set Community_Id=?, Note_ReplyTo=?, Note_Content=?, Note_Date=?, User_Id=?, Note_View=?, Resource_Index=? where Note_Id=?";
		Object[] params = new Object[] { note.getCommunityId(),
				note.getNoteReplyTo(), note.getNoteContent(),
				note.getNoteDate(), note.getUserId(), note.getNoteView(),
				note.getResourceIndex(), note.getNoteId() };
		int affectedRwos = this.dbUtils.execOthers(connection, strSQL, params);
		if (affectedRwos > 0) {
			TransactionManager.commit(); // �����ύ
		} else {
			TransactionManager.rollback(); // ����Ļع�
		}
		return affectedRwos;
	}

	public List<Note> selectByUserId(final Note note) {
		// TODO Auto-generated method stub
		List<Note> lstNote = new ArrayList<Note>();
		connection = ConnectionManager.getConnection();
		int userId = note.getUserId();
		String strSQL = "SELECT * FROM note where user_Id= ? and note_ReplyTo is not null order by note_Id desc ";
		if (1 == note.getNoteReplyTo()) {
			strSQL = "SELECT * FROM note where user_Id= ? and note_ReplyTo is not null order by note_Id desc ";
		} else {
			strSQL = "SELECT * FROM note where user_Id= ? and note_ReplyTo is null order by note_Id desc ";
		}

		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { userId });
		try {
			while (resultSet.next()) {
				Note res = new Note();
				res.setNoteId(resultSet.getInt(1));
				res.setCommunityId(resultSet.getInt(2));
				res.setNoteReplyTo(resultSet.getInt(3));
				res.setNoteContent(resultSet.getString(4));
				res.setNoteDate(resultSet.getString(5));
				res.setUserId(resultSet.getInt(6));
				res.setNoteView(resultSet.getInt(7));
				res.setResourceIndex(resultSet.getString(8));

				lstNote.add(res);
			}
			// ���ؽ��
			return lstNote;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			ConnectionManager.releaseConnection(connection);
		}
	}

	@Override
	public List<Note> selectByPage(int currentPage, int nextPage, int pageNumber) {
		// TODO Auto-generated method stub
		List<Note> lstNote = new ArrayList<Note>();
		connection = ConnectionManager.getConnection();
		String strSQL="select * from note_topic limit "+Integer.toString(pageNumber * (currentPage-1))+", "+Integer.toString(pageNumber*(nextPage-1));
		ResultSet resultSet = this.dbUtils.execQuery(connection, strSQL,
				new Object[] { });
		try {
			while(resultSet.next()){
				Note res = new Note();
				res.setNoteId(resultSet.getInt(1));
				res.setCommunityId(resultSet.getInt(2));
				res.setNoteReplyTo(resultSet.getInt(3));
				res.setNoteContent(resultSet.getString(4));
				res.setNoteDate(resultSet.getString(5));
				res.setUserId(resultSet.getInt(6));
				res.setNoteView(resultSet.getInt(7));
				res.setResourceIndex(resultSet.getString(8));
				lstNote.add(res);
			}
			return lstNote;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			ConnectionManager.releaseConnection(connection);
		}
	}

	@Override
	public int updateById(int noteId) {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		TransactionManager.connection = this.connection;
		TransactionManager.beginTransaction();
		String strSQL = "update note set Note_IsDelete=1 where Note_ID=?";
		Object[] params=new Object[]{ noteId };
		int affectRows=dbUtils.execOthers(connection, strSQL, params);
		return affectRows;
		
	}

	

}
