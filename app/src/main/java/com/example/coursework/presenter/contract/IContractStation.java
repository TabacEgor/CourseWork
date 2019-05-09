package com.example.coursework.presenter.contract;

public interface IContractStation {

    interface Presenter {

        void registerStation(String external_id, String stationName, String latitude, String longitude, String altitude);

        void sendMeasurements(String stationId, String time, String tempreture, String windSpeed, String windGust, String pressure, String humidity, String rainPerHour, String clouds, String condition);

        void getMeasurements();

        void deleteStation();
    }

    interface View {

        void displayStationData();

        void displayMeasurements();
    }
}
