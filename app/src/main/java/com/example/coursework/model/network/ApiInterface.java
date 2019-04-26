package com.example.coursework.model.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherByCity(@Query("q") String city, @Query("appid") String appid);

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherById(@Query("id") String id,@Query("appid") String appid);

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherByZip(@Query("lat") String lat, @Query("lon") String lon, @Query("appid") String appid);

    @GET("/data/2.5/weather")
    Call<ResponseBody> getWeatherByCoord(@Query("zip") String zip, @Query("appid") String appid);
}
