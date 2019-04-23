package com.example.coursework.presenter;

import com.example.coursework.model.network.ApiInterface;
import com.example.coursework.presenter.contract.IContractForecast;

public class ForecastPresenter implements IContractForecast.Presenter {

    private ApiInterface api;
    private IContractForecast.View forecastWeatherView;

    public ForecastPresenter(IContractForecast.View forecastWeatherView) {
        this.forecastWeatherView = forecastWeatherView;
    }

    @Override
    public void getForecastWeather() {

    }
}
