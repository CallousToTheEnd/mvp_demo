package com.example.jsoupt.biz;

public interface IUserBiz {

	public void login(String username, String password, OnLoginListener loginListener);
	
}
