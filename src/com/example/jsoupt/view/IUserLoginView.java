package com.example.jsoupt.view;

import com.example.jsoupt.bean.User;

public interface IUserLoginView {

	String getUserName();

	String getPassword();

	void clearUserName();

	void clearPassword();

	void showLoading();

	void hideLoading();

	void toMainActivity(User user);

	void showFailedError();

}
