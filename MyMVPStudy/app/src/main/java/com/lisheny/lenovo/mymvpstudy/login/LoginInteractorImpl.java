package com.lisheny.lenovo.mymvpstudy.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by LENOVO on 2016/9/13.
 */
public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListerner listerner) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listerner.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listerner.onPasswordError();
                    error = true;
                }
                if (!error){
                    listerner.onSuccess();
                }
            }
        },2000);

    }
}
