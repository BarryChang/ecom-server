package com.gr.ecom.biz.impl;

import com.gr.ecom.biz.IPasswordBiz;
import com.gr.ecom.dao.IPasswordDao;
import com.gr.ecom.dao.impl.PasswordDaoImpl;
import com.gr.ecom.po.Password;

public class PasswordBizImpl implements IPasswordBiz {

	private IPasswordDao passwordDao = new PasswordDaoImpl();
	@Override
	public boolean modifyPasswordInformation(Password password) {
		// TODO Auto-generated method stub
		if(passwordDao.updateByUserName(password)>0)
			return true;
		else
			return false;
	}

	
}
