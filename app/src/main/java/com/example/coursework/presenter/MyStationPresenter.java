package com.example.coursework.presenter;

import com.example.coursework.model.network.ApiInterface;
import com.example.coursework.presenter.contract.IContractStation;

public class MyStationPresenter implements IContractStation.Presenter {

    private ApiInterface api;
    private IContractStation.View myStationView;

    public MyStationPresenter(IContractStation.View myStationView) {
        this.myStationView = myStationView;
    }

    @Override
    public void registerStation() {

    }

    @Override
    public void sendMeasurements() {

    }

    @Override
    public void getMeasurements() {

    }

    @Override
    public void deleteStation() {

    }
}
