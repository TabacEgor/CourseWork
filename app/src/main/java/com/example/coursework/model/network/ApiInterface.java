package com.example.coursework.model.network;

import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherByCity(@Query("q") String city, @Query("units") String units, @Query("appid") String appid);

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherById(@Query("id") String id, @Query("units") String units, @Query("appid") String appid);

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherByZip(@Query("lat") String lat, @Query("lon") String lon, @Query("units") String units, @Query("appid") String appid);

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherByCoord(@Query("zip") String zip, @Query("units") String units, @Query("appid") String appid);

    @GET("/data/2.5/forecast")
    Call<ResponseBody> getForecast(@Query("q") String cityName, @Query("units") String units, @Query("appid") String appid);

    @POST("/data/3.0/stations")
    Call<ResponseBody> registrateStation(@Path("external_id") String external_id, @Path("name") String stationName, @Path("latitude") String latitude
            , @Path("longitude") String longitude, @Path("altitude") String altitude);

    @POST("/data/3.0/measurements")
    Call<ResponseBody> sendData(@Path("station_id") String stationId, @Path("dt") String time, @Path("temperature") String tempteture
        , @Path("wind_speed") String windSpeed, @Path("wind_gust") String windGust, @Path("pressure") String pressure
        , @Path("humidity") String humidity, @Path("rain_1h") String rainPerHour, @Path("clouds") String clounds
        , @Path("condition") String condition);
}
