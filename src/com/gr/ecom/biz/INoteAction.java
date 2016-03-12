package com.gr.ecom.biz;

import java.util.List;

import com.gr.ecom.po.Note;

public interface INoteAction {

	public abstract int releaseNote(Note note);
	
	public abstract int deleteNote(Note note);
	
	public abstract List<Note> returnNotes(int currentPage, int nextPage, int pageNumber);
	
}
