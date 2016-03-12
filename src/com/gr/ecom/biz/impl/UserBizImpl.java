package com.gr.ecom.biz.impl;

import java.util.List;

import com.gr.ecom.biz.IUserBiz;
import com.gr.ecom.dao.IUserDao;
import com.gr.ecom.dao.impl.UserDaoImpl;
import com.gr.ecom.po.User;
import com.gr.ecom.po.User;

public class UserBizImpl implements IUserBiz {

	private IUserDao userDao = null;

	public UserBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		userDao=new UserDaoImpl();
	}
	@Override
	public List<User> viewPersonalInformation(User user) {
		// TODO Auto-generated method stub
		List<User> luser = userDao
				.selectByUserId(user);
		if (luser.isEmpty()) {
			System.out.println("lUser is Empty!");
		} else {
			for (User usr : luser) {
				System.out.println(usr.toString());
			}
		}
		return luser;
	}
	@Override
	public boolean modifyPersonalInformation(User user) {
		// TODO Auto-generated method stub
		if(userDao.update(user)>0)
			return true;
		else
			return false;
	}

}
