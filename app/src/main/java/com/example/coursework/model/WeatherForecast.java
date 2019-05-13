package com.example.coursework.model;

import com.google.gson.annotations.SerializedName;

public class WeatherForecast implements Cloneable {

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

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("dt")
    private long updateTime;

    @SerializedName("sunset")
    private long sunset;

    @SerializedName("sunrise")
    private long sunrise;

    @SerializedName("temp_min")
    private String temp_min;

    @SerializedName("temp_max")
    private String temp_max;

    @SerializedName("visibility")
    private String visibility;

    @SerializedName("country")
    private String country;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
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

    @Override
    public WeatherForecast clone() throws CloneNotSupportedException {
        WeatherForecast copyForecast = (WeatherForecast) super.clone();
        return copyForecast;
    }

    public static class Builder {

        private WeatherForecast weatherForecast;

        public Builder() {
            weatherForecast = new WeatherForecast();
        }

        public Builder withDate(String date) {
            weatherForecast.date = date;
            return  this;
        }

        public Builder withTempreture(String tempreture) {
            weatherForecast.tempreture = tempreture;
            return  this;
        }

        public Builder withPressure(String pressure) {
            weatherForecast.pressure = pressure;
            return  this;
        }

        public Builder withHumidity(String humidity) {
            weatherForecast.humidity = humidity;
            return  this;
        }

        public Builder withDescription(String description) {
            weatherForecast.description = description;
            return  this;
        }

        public Builder withUpdateTime(Long updateTime) {
            weatherForecast.updateTime = updateTime;
            return  this;
        }

        public Builder withWeatherIcon(String icon) {
            weatherForecast.icon = icon;
            return  this;
        }

        public Builder withSunset(Long sunset) {
            weatherForecast.sunset = sunset;
            return  this;
        }

        public Builder withSunrise(Long sunrise) {
            weatherForecast.sunrise = sunrise;
            return  this;
        }

        public Builder withTempMax(String tempMax) {
            weatherForecast.temp_max = tempMax;
            return  this;
        }

        public Builder withTempMin(String tempMin) {
            weatherForecast.temp_min = tempMin;
            return  this;
        }

        public Builder withVisibility(String visibility) {
            weatherForecast.visibility = visibility;
            return  this;
        }

        public Builder withWindSpeed(String wind) {
            weatherForecast.wind = wind;
            return  this;
        }

        public Builder withCountry(String country) {
            weatherForecast.country = country;
            return  this;
        }

        public WeatherForecast build() {
            return weatherForecast;
        }
    }
}
