package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.Note;


public interface INoteDao {

	public int insert(final Note note);

	public int delete(final Note note);

	public List<Note> selectByNoteId(final Note note);

	public int update(final Note note);

	public List<Note> selectByUserId(final Note note);
	
	public List<Note> selectByPage(int currentPage, int nextPage, int pageNumber);
	
	public int updateById(final int noteId);
	
}
