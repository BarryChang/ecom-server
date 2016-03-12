package com.gr.ecom.biz.impl;

import java.util.List;

import com.gr.ecom.biz.ILoginBiz;
import com.gr.ecom.dao.IUserDao;
import com.gr.ecom.dao.impl.UserDaoImpl;
import com.gr.ecom.po.User;

public class LoginBizImpl implements ILoginBiz {

	private IUserDao userDao;

	public LoginBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.userDao = new UserDaoImpl();
	}

	@Override
	public boolean isValidate(final User user) {
		// TODO Auto-generated method stub
		List<User> usr = userDao.selectByUserName(user);
		if (usr.get(0).getUserName() == null) {
			return false;
		} else {
			return true;
		}
	}

}
