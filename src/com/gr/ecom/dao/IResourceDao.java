package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.Resource;


public interface IResourceDao {

	public int insert(final Resource resource);

	public int delete(final Resource resource);

	public List<Resource> selectByResourceIndex(final Resource resource);

	public int update(final Resource resource);
}
