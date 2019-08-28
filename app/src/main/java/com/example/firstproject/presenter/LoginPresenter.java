package com.example.firstproject.presenter;

import com.example.firstproject.ui.ILogin;

public class LoginPresenter implements ILoginPresenter {
    private ILogin iLogin;

    public LoginPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
    }
    @Override
    public void onLogin(String email, String password) {
        if (email.equals("") && password.equals("")) {
            iLogin.LoginFail();
        } else if (email.equals("nghiemminh0906@gmail.com") && password.equals("123456")) {
            iLogin.LoginSucess();
        }
    }
}
