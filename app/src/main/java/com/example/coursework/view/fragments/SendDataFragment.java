package com.example.coursework.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.coursework.R;
import com.example.coursework.view.activities.ui.main.PageViewModel;

public class SendDataFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "2";

    private PageViewModel pageViewModel;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.send_data_fragment, container, false);

        etStationId = container.findViewById(R.id.etStationId);
        etTemperature = container.findViewById(R.id.etTemperature);
        etWind_speed = container.findViewById(R.id.etWind_speed);
        etWind_gust = container.findViewById(R.id.etWind_gust);
        etPressure = container.findViewById(R.id.etPressure);
        etHumidity = container.findViewById(R.id.etHumidity);
        etRain_1h = container.findViewById(R.id.etRain_1h);
        etClouds = container.findViewById(R.id.etClouds);
        etCondition = container.findViewById(R.id.etCondition);

        btnSendData = container.findViewById(R.id.btnSendData);

//        btnSendData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Data send succesfully!", Toast.LENGTH_LONG).show();
//            }
//        });

        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }
}
