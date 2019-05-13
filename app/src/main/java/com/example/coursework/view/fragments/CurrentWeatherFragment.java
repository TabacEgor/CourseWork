package com.example.coursework.view.fragments;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coursework.BuildConfig;
import com.example.coursework.R;
import com.example.coursework.model.WeatherCurrent;
import com.example.coursework.presenter.CurrentPresenter;
import com.example.coursework.presenter.contract.IContractCurrent;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CurrentWeatherFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CurrentWeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class  CurrentWeatherFragment extends Fragment implements IContractCurrent.View {

    private IContractCurrent.Presenter currentWeatherPresenter;
    private OnFragmentInteractionListener mListener;

    private EditText etCity;
    private Button getButton, btnLastWeather;
    private TextView tvTempreture, tvPressure, tvHumidity, tvDesctiption, tvUpdateTime, tvSunset, tvSunrise;
    private ImageView ivIcon;

    public CurrentWeatherFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentWeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentWeatherFragment newInstance(String param1, String param2) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentWeatherPresenter = new CurrentPresenter(this);
        CurrentPresenter currentPresenter = new CurrentPresenter(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current, container, false);

        etCity = (EditText) view.findViewById(R.id.etCityName);
        getButton = (Button) view.findViewById(R.id.btnGet);
        btnLastWeather = (Button) view.findViewById(R.id.btnLastWeather);
        tvTempreture = (TextView) view.findViewById(R.id.tvTempreture);
        tvPressure = (TextView) view.findViewById(R.id.tvPressure);
        tvHumidity = (TextView) view.findViewById(R.id.tvHumidity);
        tvDesctiption = (TextView) view.findViewById(R.id.tvDescription);
        tvUpdateTime = (TextView) view.findViewById(R.id.tvUpdateTime);
        tvSunset = (TextView) view.findViewById(R.id.tvSunset);
        tvSunrise = (TextView) view.findViewById(R.id.tvSunrise);

        ivIcon = (ImageView) view.findViewById(R.id.ivIcon);

        if (BuildConfig.DEBUG) {
            etCity.setText("Chisinau");
        }

        btnLastWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    currentWeatherPresenter.getLastWeather();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        });

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWeatherPresenter.getCurrentWeather(etCity.getText().toString());
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void displayCurrentWeather(WeatherCurrent weatherCurrent) {
        tvTempreture.setText("Tempreture: " + weatherCurrent.getTempreture() + "°C");
        tvPressure.setText("Pressure: " + weatherCurrent.getPressure() + " hPa");
        tvHumidity.setText("Humidity: " + weatherCurrent.getHumidity() + "%");
        tvDesctiption.setText(weatherCurrent.getDescription());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        tvUpdateTime.setText("Update time: " + simpleDateFormat.format(weatherCurrent.getUpdateTime()*1000));
        tvSunset.setText("Sunset: " + simpleDateFormat.format(weatherCurrent.getSunset()*1000));
        tvSunrise.setText("Sunrise: " + simpleDateFormat.format(weatherCurrent.getSunrise()*1000));

        Picasso.get().load("http://openweathermap.org/img/w/" + weatherCurrent.getWeatherIcon() + ".png").into(ivIcon);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void dipsplayLastWeather(WeatherCurrent copyWeather) {
        tvTempreture.setText("Tempreture: " + copyWeather.getTempreture() + "°C");
        tvPressure.setText("Pressure: " + copyWeather.getPressure() + " hPa");
        tvHumidity.setText("Humidity: " + copyWeather.getHumidity() + "%");
        tvDesctiption.setText(copyWeather.getDescription());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        tvUpdateTime.setText("Update time: " + simpleDateFormat.format(copyWeather.getUpdateTime()*1000));
        tvSunset.setText("Sunset: " + simpleDateFormat.format(copyWeather.getSunset()*1000));
        tvSunrise.setText("Sunrise: " + simpleDateFormat.format(copyWeather.getSunrise()*1000));

        Picasso.get().load("http://openweathermap.org/img/w/" + copyWeather.getWeatherIcon() + ".png").into(ivIcon);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
