package com.example.coursework.model;

import android.app.Person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherCurrent implements Cloneable{

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

    @SerializedName("temp_min")
    private String temp_min;

    @SerializedName("temp_max")
    private String temp_max;

    @SerializedName("speed")
    private String windSpeed;

    @SerializedName("visibility")
    private String visibility;

    @SerializedName("country")
    private String country;

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

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public WeatherCurrent clone() throws CloneNotSupportedException {
        WeatherCurrent copyCurrent = (WeatherCurrent) super.clone();
        return copyCurrent;
    }


    public static class Builder implements Cloneable {
        private WeatherCurrent weatherCurrent;

        public Builder() {
            weatherCurrent = new WeatherCurrent();
        }

        @Override
        protected WeatherCurrent clone() throws CloneNotSupportedException {
            WeatherCurrent copy = (WeatherCurrent) super.clone();
            return copy;
        }

        public Builder withTempreture(String tempreture) {
            weatherCurrent.tempreture = tempreture;
            return  this;
        }

        public Builder withPressure(String pressure) {
            weatherCurrent.pressure = pressure;
            return  this;
        }

        public Builder withHumidity(String humidity) {
            weatherCurrent.humidity = humidity;
            return  this;
        }

        public Builder withDescription(String description) {
            weatherCurrent.description = description;
            return  this;
        }

        public Builder withUpdateTime(Long updateTime) {
            weatherCurrent.updateTime = updateTime;
            return  this;
        }

        public Builder withWeatherIcon(String weatherIcon) {
            weatherCurrent.weatherIcon = weatherIcon;
            return  this;
        }

        public Builder withSunset(Long sunset) {
            weatherCurrent.sunset = sunset;
            return  this;
        }

        public Builder withSunrise(Long sunrise) {
            weatherCurrent.sunrise = sunrise;
            return  this;
        }

        public Builder withTempMax(String tempMax) {
            weatherCurrent.temp_max = tempMax;
            return  this;
        }

        public Builder withTempMin(String tempMin) {
            weatherCurrent.temp_min = tempMin;
            return  this;
        }

        public Builder withVisibility(String visibility) {
            weatherCurrent.visibility = visibility;
            return  this;
        }

        public Builder withWindSpeed(String windSpeed) {
            weatherCurrent.windSpeed = windSpeed;
            return  this;
        }

        public Builder withCountry(String country) {
            weatherCurrent.country = country;
            return  this;
        }

        public WeatherCurrent build() {
            return weatherCurrent;
        }
    }
}
