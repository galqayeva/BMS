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
import com.example.telim2.bmm.R;

/**
 * Created by galqayeva on 21.08.2017.
 */

public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view1=inflater.inflate(R.layout.fragment2,container,false);
        return view1;

    }
}