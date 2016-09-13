package com.lisheny.lenovo.mymvpstudy.login;

/**
 * Created by LENOVO on 2016/9/13.
 */
public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.OnLoginFinishedListerner {

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.mLoginView = loginView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String passwrod) {
        if (mLoginView != null){
            mLoginView.showProgress();
        }
        mLoginInteractor.login(username,passwrod,this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }

    @Override
    public void onUsernameError() {
        if (mLoginView != null){
            mLoginView.setUserNameError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (mLoginView != null){
            mLoginView.setPasswordError();
            mLoginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        mLoginView.navigateToHome();
    }
}
