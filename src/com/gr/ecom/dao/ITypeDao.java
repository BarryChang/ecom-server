package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.Type;


public interface ITypeDao {

	public int insert(final Type type);

	public int delete(final Type type);

	public List<Type> selectByTypeId(final Type type);

	public int update(final Type type);
}
