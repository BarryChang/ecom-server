package com.gr.ecom.biz.impl;

import com.gr.ecom.biz.IValidationBiz;
import com.gr.ecom.dao.IUserDao;
import com.gr.ecom.dao.impl.UserDaoImpl;
import com.gr.ecom.po.User;

public class ValidationBizImpl implements IValidationBiz {

	private IUserDao userDao;

	public ValidationBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.userDao = new UserDaoImpl();
	}

	@Override
	public int checkUserStatus(final User user) {
		// TODO Auto-generated method stub
		User resUser = userDao.selectByUserId(user).get(0);
		int userLevel = resUser.getUserLevel();
		return userLevel;

	}

}
