package com.example.jsoupt.biz;

import com.example.jsoupt.bean.User;

public interface OnLoginListener {
	
	public void loginSuccess(User user);

	public void loginFailed();
	
}
