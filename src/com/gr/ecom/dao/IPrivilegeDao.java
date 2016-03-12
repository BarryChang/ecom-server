package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.Privilege;


public interface IPrivilegeDao {

	public int insert(final Privilege privilege);

	public int delete(final Privilege privilege);

	public List<Privilege> selectByPrivilegeId(final Privilege privilege);

	public int update(final Privilege privilege);
}
