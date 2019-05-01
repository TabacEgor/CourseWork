package com.example.coursework.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coursework.R;
import com.example.coursework.model.WeatherForecast;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private List<WeatherForecast> weatherForecastList;

    public ForecastAdapter(List<WeatherForecast> weatherForecastList) {
        this.weatherForecastList = weatherForecastList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherForecast weatherForecast = weatherForecastList.get(position);

        holder.tvTempreture.setText(weatherForecast.getTempreture());
        holder.tvPressure.setText(weatherForecast.getPressure());
        holder.tvDescription.setText(weatherForecast.getDescription());
        holder.tvWind.setText(weatherForecast.getWind());

        Picasso.get().load("http://openweathermap.org/img/w/" + weatherForecast.getIcon() + ".png")
                .into(holder.circleImageView);
    }

    @Override
    public int getItemCount() {
        return weatherForecastList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTempreture, tvPressure, tvDescription, tvWind;
        CircleImageView circleImageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.circleImageView);
            tvTempreture = (TextView) itemView.findViewById(R.id.tvTempreture);
            tvPressure = (TextView) itemView.findViewById(R.id.tvPressure);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            tvWind = (TextView) itemView.findViewById(R.id.tvWind);
        }
    }
}
