package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.Password;

public interface IPasswordDao {

	public int insert(final Password password);

	public int delete(final Password password);

	public List<Password> selectByPasswordId(final Password password);

	public int updateByPasswordId(final Password password);

	public int updateByUserName(final Password password);
}
