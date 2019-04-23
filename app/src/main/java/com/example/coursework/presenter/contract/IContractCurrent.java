package com.example.coursework.presenter.contract;

public interface IContractCurrent {

    interface Presenter {

        void getCurrentWeather();
    }

    interface View {

        void displayCurrentWeather();
    }
}
