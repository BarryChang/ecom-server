package com.gr.ecom.biz.impl;

import java.util.List;

import com.gr.ecom.biz.INoteAction;
import com.gr.ecom.dao.INoteDao;
import com.gr.ecom.dao.IUserDao;
import com.gr.ecom.dao.impl.NoteDaoImpl;
import com.gr.ecom.dao.impl.UserDaoImpl;
import com.gr.ecom.po.Note;
import com.gr.ecom.po.User;

public class NoteAction implements INoteAction {

	INoteDao noteDao;
	IUserDao userDao;
	public NoteAction() {
		// TODO Auto-generated constructor stub
		noteDao=new NoteDaoImpl();
		userDao=new UserDaoImpl();
	}

	@Override
	public int releaseNote(Note note) {
		// TODO Auto-generated method stub
		User u=new User();
		if(note==null)
			return 0;
		u.setUserId(note.getUserId());
		User tempUser=userDao.selectByUserId(u).get(0);
		if(tempUser==null)
			return 1;
		else{
			noteDao.insert(note);
			return 2;
		}
	}

	@Override
	public int deleteNote(Note note) {
		// TODO Auto-generated method stub
		if(note==null)
			return 0;
		else{
			int affectRows=noteDao.updateById(note.getNoteId());
			if(affectRows==0)
				return 0;
			else
				return 1;
		}
	}

	@Override
	public List<Note> returnNotes(int currentPage, int nextPage, int pageNumber) {
		// TODO Auto-generated method stub
		return noteDao.selectByPage(currentPage, nextPage, pageNumber);
	}

}
