package com.example.coursework.model.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    private static RetrofitClient retrofitInstance;
    private Retrofit retrofit;

    private static final String BASE_URL = "https://samples.openweathermap.org";

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    public static RetrofitClient getRetrofitInstance() {
        if (retrofitInstance == null){
            retrofitInstance = new RetrofitClient();
        }
        return retrofitInstance;
    }

    public ApiInterface createJsonApi() {
        return retrofit.create(ApiInterface.class);
    }
}
