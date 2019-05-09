package com.example.coursework.presenter;

import android.util.Log;

import com.example.coursework.model.network.ApiInterface;
import com.example.coursework.model.network.RetrofitClient;
import com.example.coursework.presenter.contract.IContractStation;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Path;

public class MyStationPresenter implements IContractStation.Presenter {

    private IContractStation.View myStationView;

    public MyStationPresenter(IContractStation.View myStationView) {
        this.myStationView = myStationView;
    }

    @Override
    public void registerStation(String external_id, String stationName, String latitude
            , String longitude, String altitude) {
        RetrofitClient.getRetrofitInstance()
                .createJsonApi()
                .registrateStation(external_id, stationName, latitude, longitude, altitude)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("myTag", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        myStationView.displayStationData();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("myTag", t.getMessage());
                    }
                });
    }

    @Override
    public void sendMeasurements(String stationId, String time, String tempreture, String windSpeed
            , String windGust, String pressure, String humidity, String rainPerHour
            , String clouds, String condition) {
        RetrofitClient.getRetrofitInstance()
                .createJsonApi()
                .sendData(stationId, time, tempreture, windSpeed, windGust, pressure, humidity, rainPerHour, clouds, condition)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("myTag", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        myStationView.displayMeasurements();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("myTag", t.getMessage());
                    }
                });
    }

    @Override
    public void getMeasurements() {

    }

    @Override
    public void deleteStation() {

    }
}
