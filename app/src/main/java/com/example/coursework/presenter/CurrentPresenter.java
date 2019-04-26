package com.example.coursework.presenter;

import android.util.Log;

import com.example.coursework.model.network.ApiInterface;
import com.example.coursework.model.network.RetrofitClient;
import com.example.coursework.presenter.contract.IContractCurrent;
import com.example.coursework.view.activities.MainActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentPresenter implements IContractCurrent.Presenter {

    private IContractCurrent.View currentWeatherView;

    public CurrentPresenter(IContractCurrent.View currentWeatherView) {
        this.currentWeatherView = currentWeatherView;
    }

    @Override
    public void getCurrentWeather() {
        RetrofitClient.getRetrofitInstance()
                .createJsonApi()
                .getWeatherByCity("London", MainActivity.apiKey)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            Log.d("myTag", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("myTag", t.getMessage());
                    }
                });
    }
}
