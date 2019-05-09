package com.example.coursework.view.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.coursework.R;
import com.example.coursework.presenter.MyStationPresenter;
import com.example.coursework.presenter.contract.IContractStation;
import com.example.coursework.view.activities.ui.main.PageViewModel;

import java.util.Calendar;
import java.util.Objects;

public class SendDataFragment extends Fragment implements IContractStation.View {

    private static final String ARG_SECTION_NUMBER = "2";

    private PageViewModel pageViewModel;

    private IContractStation.Presenter stationPresenter;

    EditText etStationId, etTemperature, etWind_speed, etWind_gust, etPressure, etHumidity, etRain_1h, etClouds, etCondition;
    Button btnSendData;

    public static SendDataFragment newInstance(int index) {
        SendDataFragment fragment = new SendDataFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.send_data_fragment, container, false);

        etStationId = root.findViewById(R.id.etStationId);
        etTemperature = root.findViewById(R.id.etTemperature);
        etWind_speed = root.findViewById(R.id.etWind_speed);
        etWind_gust = root.findViewById(R.id.etWind_gust);
        etPressure = root.findViewById(R.id.etPressure);
        etHumidity = root.findViewById(R.id.etHumidity);
        etRain_1h = root.findViewById(R.id.etRain_1h);
        etClouds = root.findViewById(R.id.etClouds);
        etCondition = root.findViewById(R.id.etCondition);

        btnSendData = root.findViewById(R.id.btnSendData);

        stationPresenter = new MyStationPresenter(this);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Data send succesfully!", Toast.LENGTH_LONG).show();
//                stationPresenter.sendMeasurements(etStationId.getText().toString(), Calendar.getInstance().toString()
//                    ,etTemperature.getText().toString(), etWind_speed.getText().toString()
//                    ,etWind_gust.getText().toString(), etPressure.getText().toString()
//                    ,etHumidity.getText().toString(), etRain_1h.getText().toString()
//                    ,etClouds.getText().toString(), etCondition.getText().toString());
            }
        });

        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void displayStationData() {

    }

    @Override
    public void displayMeasurements() {

    }
}
