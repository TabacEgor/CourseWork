package com.example.coursework.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coursework.R;
import com.example.coursework.model.Weather;
import com.example.coursework.presenter.ForecastPresenter;
import com.example.coursework.presenter.contract.IContractForecast;
import com.example.coursework.view.adapters.ForecastAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ForecastWeatherFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ForecastWeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastWeatherFragment extends Fragment implements IContractForecast.View {

    private IContractForecast.Presenter forecastWeatherPresenter;
    private RecyclerView recyclerView;
    private ForecastAdapter forecastAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ForecastWeatherFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastWeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastWeatherFragment newInstance(String param1, String param2) {
        ForecastWeatherFragment fragment = new ForecastWeatherFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        forecastWeatherPresenter = new ForecastPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) container.findViewById(R.id.rvForecast);

//        forecastAdapter = new ForecastAdapter(weatherList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(forecastAdapter);

        return inflater.inflate(R.layout.fragment_forecast, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void displayForecast() {

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
