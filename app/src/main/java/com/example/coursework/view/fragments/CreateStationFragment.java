package com.example.coursework.view.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.coursework.R;
import com.example.coursework.presenter.MyStationPresenter;
import com.example.coursework.presenter.contract.IContractStation;
import com.example.coursework.view.activities.ui.main.PageViewModel;

import java.util.Objects;

/**
 * A placeholder fragment containing a simple view.*/


public class CreateStationFragment extends Fragment implements IContractStation.View {

    private static final String ARG_SECTION_NUMBER = "1";

    private PageViewModel pageViewModel;

    private IContractStation.Presenter stationPresenter;

    EditText etExternalId, etNameStation, etLatitude, etLongitude, etAltitude;
    Button btnRegister;

    public static CreateStationFragment newInstance(int index) {
        CreateStationFragment fragment = new CreateStationFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.create_station_fragment, container, false);

        etExternalId = root.findViewById(R.id.etExternalId);
        etNameStation = root.findViewById(R.id.etNameStation);
        etLatitude = root.findViewById(R.id.etLatitude);
        etLongitude = root.findViewById(R.id.etLongitude);
        etAltitude = root.findViewById(R.id.etAltitude);

        btnRegister = (Button) root.findViewById(R.id.btnRegister);


        stationPresenter = new MyStationPresenter(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Station restered succesfully!", Toast.LENGTH_LONG).show();
//                stationPresenter.registerStation(etExternalId.getText().toString(), etNameStation.getText().toString()
//                    ,etLatitude.getText().toString(), etLongitude.getText().toString()
//                    ,etAltitude.getText().toString());
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