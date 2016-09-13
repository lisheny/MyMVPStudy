package com.lisheny.lenovo.mymvpstudy.login;

/**
 * Created by LENOVO on 2016/9/13.
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswordError();

    void navigateToHome();
}
