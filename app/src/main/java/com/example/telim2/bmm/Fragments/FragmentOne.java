package com.example.telim2.bmm.Fragments;

/**
 * Created by telim2 on 20.09.2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.telim2.bmm.R;


public class FragmentOne extends Fragment {

    Spinner spinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment1,container,false);

        spinner = (Spinner) view.findViewById(R.id.spinner1);


        Toast.makeText(getActivity(), String.valueOf(spinner.getSelectedItem()), Toast.LENGTH_SHORT).show();


        return view;

    }
}