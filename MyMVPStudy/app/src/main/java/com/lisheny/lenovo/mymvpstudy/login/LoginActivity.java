package com.lisheny.lenovo.mymvpstudy.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.lisheny.lenovo.mymvpstudy.R;
import com.lisheny.lenovo.mymvpstudy.main.MainActivity;

/**
 * Created by LENOVO on 2016/9/13.
 */
public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    private EditText usernaem;
    private EditText password;
    private ProgressBar mProgressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernaem = (EditText)findViewById(R.id.username);
        password  = (EditText)findViewById(R.id.password);
        mProgressBar = (ProgressBar)findViewById(R.id.progress);
        findViewById(R.id.button).setOnClickListener(this);

        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                mLoginPresenter.validateCredentials(usernaem.getText().toString().trim(),
                        password.getText().toString().trim());
                break;
            default:
        }
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        usernaem.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
