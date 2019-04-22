package com.example.coursework.presenter.contract;

public interface ILoginContract {

    interface Presenter {

        void doLogin(String login, String password);
    }

    interface View {

        void onLoginSuccess();

        void onLoginFailed();
    }
}
