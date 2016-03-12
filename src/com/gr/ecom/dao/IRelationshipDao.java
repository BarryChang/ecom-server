package com.gr.ecom.dao;

import java.util.List;

import com.gr.ecom.po.Relationship;



public interface IRelationshipDao {

	public int insert(final Relationship relationship);

	public int delete(final Relationship relationship);

	public List<Relationship> selectByRelationshipId(final Relationship relationship);

	public int update(final Relationship relationship);
	
	public List<Relationship> selectByUserId(final Relationship relationship);
}
