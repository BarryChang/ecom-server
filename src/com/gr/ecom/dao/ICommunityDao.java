package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.Community;

public interface ICommunityDao {


	public int insert(final Community community);

	public int delete(final Community community);

	public List<Community> selectByCommunityId(final Community community);

	public int update(final Community community);
}
