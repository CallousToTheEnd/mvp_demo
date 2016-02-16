package com.example.jsoupt.biz;

import android.os.Handler;

import com.example.jsoupt.bean.User;

public class UserBiz implements IUserBiz {

	@Override
	public void login(final String username, final String password,
			final OnLoginListener loginListener) {
		// 模拟耗时操作
		// ，用这种方法在IUserLoginPresenter的loginSuccess和loginFailed方法中要用Handler
		// 用下面那种handler().postDelayed()的方法在在IUserLoginPresenter的loginSuccess和loginFailed方法中不需要用handler
		new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if ("lk".equals(username) && "123".equals(password)) {
					User user = new User(username, password);
					loginListener.loginSuccess(user);
				} else {
					loginListener.loginFailed();
				}
			};
		}.start();
		// new Handler().postDelayed(new Runnable() {
		//
		// @Override
		// public void run() {
		// if("lk".equals(username) && "123".equals(password)) {
		// User user = new User(username, password);
		// loginListener.loginSuccess(user);
		// } else {
		// loginListener.loginFailed();
		// }
		// }
		// }, 2000);
	}

}
