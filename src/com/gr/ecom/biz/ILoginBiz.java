package com.gr.ecom.biz;

import com.gr.ecom.po.User;

public interface ILoginBiz {

	public abstract boolean isValidate(final User user);
}
