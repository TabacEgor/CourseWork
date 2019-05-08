package com.example.coursework.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.coursework.R;
import com.example.coursework.view.activities.ui.main.PageViewModel;

/**
 * A placeholder fragment containing a simple view.*/


public class CreateStationFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "1";

    private PageViewModel pageViewModel;

    EditText etExternalId, etNameStation, etLatitude, etLongitude, etAltitude;
    Button btnRegister;

    public static CreateStationFragment newInstance(int index) {
        CreateStationFragment fragment = new CreateStationFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

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

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.create_station_fragment, container, false);

        etExternalId = container.findViewById(R.id.etExternalId);
        etNameStation = container.findViewById(R.id.etNameStation);
        etLatitude = container.findViewById(R.id.etLatitude);
        etLongitude = container.findViewById(R.id.etLongitude);
        etAltitude = container.findViewById(R.id.etAltitude);

        btnRegister = container.findViewById(R.id.btnRegister);

//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Station restered succesfully!", Toast.LENGTH_LONG).show();
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