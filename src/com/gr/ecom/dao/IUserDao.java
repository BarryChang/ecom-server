package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.User;


public interface IUserDao {
	public int insert(final User user);

	public int delete(final User user);

	public List<User> selectByUserId(final User user);

	public int update(final User user);
	
	public List<User> selectByUserName(final User user);
}
