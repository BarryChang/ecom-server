package com.gr.ecom.biz.impl;

import java.util.List;

import com.gr.ecom.biz.ICommunityBiz;
import com.gr.ecom.dao.ICommunityDao;
import com.gr.ecom.dao.impl.CommunityDaoImpl;
import com.gr.ecom.po.Community;

public class CommunityBizImpl implements ICommunityBiz {

	ICommunityDao communityDao = null;

	public CommunityBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		communityDao = new CommunityDaoImpl();
	}

	@Override
	public List<Community> viewCommunityInformation(Community community) {
		// TODO Auto-generated method stub
		List<Community> lCommunity = communityDao
				.selectByCommunityId(community);
		if (lCommunity.isEmpty()) {
			System.out.println("lCommunity is Empty!");
		} else {
			for (Community usr : lCommunity) {
				System.out.println(usr.toString());
			}
		}
		return lCommunity;
	}

}
