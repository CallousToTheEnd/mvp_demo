package com.example.jsoupt.view;

import com.example.jsoupt.R;
import com.example.jsoupt.bean.User;
import com.example.jsoupt.presenter.IUserLoginPresenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UserLoginActivity extends Activity implements IUserLoginView,
		OnClickListener {

	EditText etUserName, etPassword;
	Button btnLogin, btnClear;
	ProgressBar progressBar;

	IUserLoginPresenter loginPresenter = new IUserLoginPresenter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etUserName = (EditText) findViewById(R.id.etUserName);
		etPassword = (EditText) findViewById(R.id.etPassword);
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnClear = (Button) findViewById(R.id.btnClear);
		progressBar = (ProgressBar) findViewById(R.id.progressBar);

		btnLogin.setOnClickListener(this);
		btnClear.setOnClickListener(this);
	}

	@Override
	public String getUserName() {
		return etUserName.getText().toString();
	}

	@Override
	public String getPassword() {
		return etPassword.getText().toString();
	}

	@Override
	public void clearUserName() {
		etUserName.setText("");
	}

	@Override
	public void clearPassword() {
		etPassword.setText("");
	}

	@Override
	public void showLoading() {
		progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoading() {
		progressBar.setVisibility(View.GONE);
	}

	@Override
	public void toMainActivity(User user) {
		Toast.makeText(
				this,
				"username:" + user.getName() + "\n passward:"
						+ user.getPassword(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showFailedError() {
		Toast.makeText(this, "UserName or password error", Toast.LENGTH_SHORT)
				.show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin:
			loginPresenter.login();
			break;
		case R.id.btnClear:
			loginPresenter.clear();
			break;
		}
	}

}
