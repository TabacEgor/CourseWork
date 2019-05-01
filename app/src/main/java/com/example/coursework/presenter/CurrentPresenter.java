package com.example.coursework.presenter;

import android.util.Log;

import com.example.coursework.model.WeatherCurrent;
import com.example.coursework.model.network.ApiInterface;
import com.example.coursework.model.network.RetrofitClient;
import com.example.coursework.presenter.contract.IContractCurrent;
import com.example.coursework.view.activities.MainActivity;
import com.example.coursework.view.fragments.CurrentWeatherFragment;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentPresenter implements IContractCurrent.Presenter {

    private IContractCurrent.View currentWeatherView;
    private WeatherCurrent weatherCurrent;
    private JSONObject jsonWeather;

    public CurrentPresenter(IContractCurrent.View currentWeatherView) {
        this.currentWeatherView = currentWeatherView;
    }

    @Override
    public void getCurrentWeather(String cityName) {
        RetrofitClient.getRetrofitInstance()
                .createJsonApi()
                .getWeatherByCity(cityName,"metric", MainActivity.apiKey)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().string());
                            JSONArray jsonArray = jsonObject.getJSONArray("weather");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                jsonWeather = jsonArray.getJSONObject(i);
                            }
                            weatherCurrent = new WeatherCurrent();
                            weatherCurrent.setTempreture((jsonObject.getJSONObject("main").get("temp").toString()));
                            weatherCurrent.setPressure(jsonObject.getJSONObject("main").get("pressure").toString());
                            weatherCurrent.setHumidity(jsonObject.getJSONObject("main").get("humidity").toString());
                            weatherCurrent.setDescription(jsonWeather.getString("description"));
                            weatherCurrent.setUpdateTime(jsonObject.getLong("dt"));
                            weatherCurrent.setWeatherIcon(jsonWeather.getString("icon"));
                            weatherCurrent.setSunset(jsonObject.getJSONObject("sys").getLong("sunset"));
                            weatherCurrent.setSunrise(jsonObject.getJSONObject("sys").getLong("sunrise"));
                            currentWeatherView.displayCurrentWeather(weatherCurrent);
                        } catch (IOException | JSONException e) {
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
