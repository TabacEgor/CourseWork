package com.example.coursework.presenter;

import com.example.coursework.presenter.contract.ILoginContract;

public class LoginPresenter implements ILoginContract.Presenter {

    private ILoginContract.View loginView;

    public LoginPresenter(ILoginContract.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void doLogin(String login, String password) {
        if (login.equals("admin") && password.equals("adminadmin")) {
            loginView.onLoginSuccess();
        } else
            loginView.onLoginFailed();
    }
}
