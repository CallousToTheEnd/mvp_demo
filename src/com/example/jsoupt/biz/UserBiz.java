package com.example.jsoupt.biz;

import android.os.Handler;

import com.example.jsoupt.bean.User;

public class UserBiz implements IUserBiz {

	@Override
	public void login(final String username, final String password,
			final OnLoginListener loginListener) {
		// ģ���ʱ����
		// �������ַ�����IUserLoginPresenter��loginSuccess��loginFailed������Ҫ��Handler
		// ����������handler().postDelayed()�ķ�������IUserLoginPresenter��loginSuccess��loginFailed�����в���Ҫ��handler
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
