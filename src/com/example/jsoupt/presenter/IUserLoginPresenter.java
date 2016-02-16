package com.example.jsoupt.presenter;

import android.os.Handler;

import com.example.jsoupt.bean.User;
import com.example.jsoupt.biz.IUserBiz;
import com.example.jsoupt.biz.OnLoginListener;
import com.example.jsoupt.biz.UserBiz;
import com.example.jsoupt.view.IUserLoginView;

public class IUserLoginPresenter implements OnLoginListener {

	private IUserBiz userBiz;
	private IUserLoginView userLoginView;
	private Handler mHandler = new Handler();
	
	public IUserLoginPresenter(IUserLoginView userLoginView) {
		this.userLoginView = userLoginView;
		userBiz = new UserBiz();
	}
	
	public void login() {
		userLoginView.showLoading();
		userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), this);
	}

	@Override
	public void loginSuccess(final User user) {
		//需要在UI线程执行
        mHandler.post(new Runnable()
        {
            @Override
            public void run()
            {
                userLoginView.toMainActivity(user);
                userLoginView.hideLoading();
            }
        });
	}

	@Override
	public void loginFailed() {
		//需要在UI线程执行
        mHandler.post(new Runnable()
        {
            @Override
            public void run()
            {
                userLoginView.showFailedError();
                userLoginView.hideLoading();
            }
        });
	}
	
	public void clear() {
		userLoginView.clearUserName();
		userLoginView.clearPassword();
	}
	
}
