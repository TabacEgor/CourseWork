package com.example.coursework.presenter;

import android.util.Log;

import com.example.coursework.model.WeatherForecast;
import com.example.coursework.model.network.ApiInterface;
import com.example.coursework.model.network.RetrofitClient;
import com.example.coursework.presenter.contract.IContractForecast;
import com.example.coursework.view.activities.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastPresenter implements IContractForecast.Presenter {

    private IContractForecast.View forecastWeatherView;
    WeatherForecast copyForecast;

    private List<WeatherForecast> forecastList = new ArrayList<>();

    public ForecastPresenter(IContractForecast.View forecastWeatherView) {
        this.forecastWeatherView = forecastWeatherView;
    }

    @Override
    public void getForecastWeather() {
        RetrofitClient.getRetrofitInstance()
                .createJsonApi()
                .getForecast("Chisinau", "metric", MainActivity.apiKey)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("myTag", response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().string());
                            JSONArray listJson = jsonObject.getJSONArray("list");
                            for (int i = 0; i < listJson.length(); i++) {
                                JSONObject oneObject = listJson.getJSONObject(i);
                                WeatherForecast weatherForecast = new WeatherForecast.Builder()
                                        .withTempreture(oneObject.getJSONObject("main").get("temp").toString())
                                        .withDate(oneObject.get("dt_txt").toString())
                                        .withPressure(oneObject.getJSONObject("main").get("pressure").toString())
                                        .withDescription(oneObject.getJSONArray("weather").getJSONObject(0).get("description").toString())
                                        .withWindSpeed(oneObject.getJSONObject("wind").get("speed").toString())
                                        .withWeatherIcon(oneObject.getJSONArray("weather").getJSONObject(0).get("icon").toString())
                                        .build();
                                forecastList.add(weatherForecast);
                                forecastWeatherView.displayForecast(forecastList);
                            }
                        } catch (JSONException | IOException e) {
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
