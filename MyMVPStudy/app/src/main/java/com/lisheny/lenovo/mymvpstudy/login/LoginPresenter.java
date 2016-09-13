package com.lisheny.lenovo.mymvpstudy.login;

/**
 * 注释：嘻嘻嘻
 * Created by LENOVO on 2016/9/13.
 */
public interface LoginPresenter {
    void validateCredentials(String username, String passwrod);

    void onDestroy();

}
