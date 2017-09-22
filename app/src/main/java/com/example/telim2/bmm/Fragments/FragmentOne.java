package com.example.telim2.bmm.Fragments;

/**
 * Created by telim2 on 20.09.2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.telim2.bmm.R;


public class FragmentOne extends Fragment {

    Spinner spinner;
    Button ok,monday,tuesday,wednesday,thursday,friday;
    RecyclerView recyclerView;
    int k=1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment1,container,false);

        spinner = (Spinner) view.findViewById(R.id.spinner1);
        monday=(Button)view.findViewById(R.id.buttonMonday);
        tuesday=(Button)view.findViewById(R.id.buttonTuesday);
        wednesday=(Button)view.findViewById(R.id.buttonWednesday);
        thursday=(Button)view.findViewById(R.id.buttonThursday);
        friday=(Button)view.findViewById(R.id.buttonFriday);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycleview);


        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getActivity(), String.valueOf(spinner.getSelectedItem()), Toast.LENGTH_SHORT).show();
                if(k==1){
                    tuesday.setVisibility(View.GONE);
                    wednesday.setVisibility(View.GONE);
                    thursday.setVisibility(View.GONE);
                    friday.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                    k++;
                }
                else{
                    tuesday.setVisibility(View.VISIBLE);
                    wednesday.setVisibility(View.VISIBLE);
                    thursday.setVisibility(View.VISIBLE);
                    friday.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                    k--;
                }
            }
        });


        return view;

    }
}