package com.gr.ecom.biz;

import com.gr.ecom.po.User;

public interface IValidationBiz {
	public abstract int checkUserStatus(final User user);
}
