package com.example.coursework.presenter;

import com.example.coursework.model.network.ApiInterface;
import com.example.coursework.presenter.contract.IContractCurrent;

public class CurrentPresenter implements IContractCurrent.Presenter {

    private ApiInterface api;
    private IContractCurrent.View currentWeatherView;

    public CurrentPresenter(IContractCurrent.View currentWeatherView) {
        this.currentWeatherView = currentWeatherView;
    }

    @Override
    public void getCurrentWeather() {

    }
}
