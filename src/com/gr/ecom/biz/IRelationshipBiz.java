package com.gr.ecom.biz;

import java.util.List;

import com.gr.ecom.po.Relationship;

public interface IRelationshipBiz {
	boolean applyForFriend(final Relationship relationship);
	boolean removeFriend(final Relationship relationship);
	boolean blacklistedFriend(final Relationship relationship);
	List<Relationship> viewFriendList(final Relationship relationship);
}
