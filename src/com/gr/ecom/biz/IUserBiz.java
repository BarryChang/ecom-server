package com.gr.ecom.biz;

import java.util.List;

import com.gr.ecom.po.User;

public interface IUserBiz {
	List<User> viewPersonalInformation(final User user);
	boolean modifyPersonalInformation(final User user);
}
