package com.lisheny.lenovo.mymvpstudy.login;

/**
 * Created by LENOVO on 2016/9/13.
 */
public interface LoginInteractor {

    interface OnLoginFinishedListerner{

        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username,String password, OnLoginFinishedListerner listerner);
}
