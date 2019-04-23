package com.example.coursework.presenter.contract;

public interface IContractStation {

    interface Presenter {

        void registerStation();

        void sendMeasurements();

        void getMeasurements();

        void deleteStation();
    }

    interface View {

        void displayStationData();

        void displayMeasurements();
    }
}
