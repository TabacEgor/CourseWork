package com.example.coursework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherCurrent {

    @SerializedName("temp")
    private String tempreture;

    @SerializedName("pressure")
    private String pressure;

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("description")
    private String description;

    @SerializedName("dt")
    private long updateTime;

    @SerializedName("icon")
    private String weatherIcon;

    @SerializedName("sunset")
    private long sunset;

    @SerializedName("sunrise")
    private long sunrise;

    public void setTempreture(String tempreture) {
        this.tempreture = tempreture;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("temp")
    public String getTempreture() {
        return tempreture;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public long getSunset() {
        return sunset;
    }

    public long getSunrise() {
        return sunrise;
    }
}
