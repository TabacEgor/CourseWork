package com.example.coursework.model;

import com.google.gson.annotations.SerializedName;

public class WeatherForecast {

    @SerializedName("temp")
    private String tempreture;

    @SerializedName("pressure")
    private String pressure;

    @SerializedName("description")
    private String description;

    @SerializedName("wind")
    private String wind;

    @SerializedName("icon")
    private String icon;

    public WeatherForecast(String tempreture, String pressure, String description, String wind, String icon) {
        this.tempreture = tempreture;
        this.pressure = pressure;
        this.description = description;
        this.wind = wind;
        this.icon = icon;
    }

    public String getTempreture() {
        return tempreture;
    }

    public String getPressure() {
        return pressure;
    }

    public String getDescription() {
        return description;
    }

    public String getWind() {
        return wind;
    }

    public String getIcon() {
        return icon;
    }
}
