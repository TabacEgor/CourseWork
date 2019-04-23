package com.example.coursework.presenter.contract;

public interface IContractForecast {

    interface Presenter {

        void getForecastWeather();
    }

    interface View {

        void displayForecast();
    }
}
