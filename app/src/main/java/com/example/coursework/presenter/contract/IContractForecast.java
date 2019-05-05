package com.example.coursework.presenter.contract;

import com.example.coursework.model.WeatherForecast;

import java.util.List;

public interface IContractForecast {

    interface Presenter {

        void getForecastWeather();
    }

    interface View {

        void displayForecast(List<WeatherForecast> forecastList);
    }
}
