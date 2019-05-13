package com.example.coursework.presenter.contract;

import com.example.coursework.model.WeatherCurrent;

import org.json.JSONObject;

public interface IContractCurrent {

    interface Presenter {

        void getCurrentWeather(String cityName);

        void getLastWeather() throws CloneNotSupportedException;
    }

    interface View {

        void displayCurrentWeather(WeatherCurrent weatherCurrent);

        void dipsplayLastWeather(WeatherCurrent copyWeather);
    }
}
