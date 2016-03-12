package com.gr.ecom.biz.impl;

import java.util.List;

import com.gr.ecom.biz.IRelationshipBiz;
import com.gr.ecom.dao.IRelationshipDao;
import com.gr.ecom.dao.impl.RelationshipDaoImpl;
import com.gr.ecom.po.Relationship;

public class RelationshipBizImpl implements IRelationshipBiz {

	private IRelationshipDao relationshipDao = null;

	public RelationshipBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		relationshipDao = new RelationshipDaoImpl();
	}

	@Override
	public boolean removeFriend(Relationship relationship) {
		// TODO Auto-generated method stub
		if (relationshipDao.delete(relationship) > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean applyForFriend(Relationship relationship) {
		// TODO Auto-generated method stub
		if (relationshipDao.insert(relationship) > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean blacklistedFriend(Relationship relationship) {
		// TODO Auto-generated method stub
		relationship.setTypeId(10);
		if (relationshipDao.update(relationship) > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<Relationship> viewFriendList(Relationship relationship) {
		// TODO Auto-generated method stub
		List<Relationship> lrelationship = relationshipDao
				.selectByUserId(relationship);
		if (lrelationship.isEmpty()) {
			System.out.println("lRelationship is Empty!");
		} else {
			for (Relationship usr : lrelationship) {
				System.out.println(usr.toString());
			}
		}
		return lrelationship;
	}

}
