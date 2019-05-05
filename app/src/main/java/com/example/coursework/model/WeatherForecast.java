package com.example.coursework.model;

import com.google.gson.annotations.SerializedName;

public class WeatherForecast {

    @SerializedName("dt_txt")
    private String date;

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


    public void setDate(String date) {
        this.date = date;
    }

    public void setTempreture(String tempreture) {
        this.tempreture = tempreture;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public WeatherForecast(String date, String tempreture, String pressure, String description, String wind, String icon) {
        this.date = date;
        this.tempreture = tempreture;
        this.pressure = pressure;
        this.description = description;
        this.wind = wind;
        this.icon = icon;
    }

    public String getDate() {
        return date;
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
