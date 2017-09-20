package com.example.telim2.bmm.Activities;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telim2.bmm.Others.CircleTransform;
import com.example.telim2.bmm.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends BaseActivity{

    Toolbar toolbar;
    ImageView imageView;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    TextView twInf,twClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBarInitialize(R.id.toolbar);

        imageView=(ImageView)findViewById(R.id.imageView);
        twInf=(TextView)findViewById(R.id.textViewInf);
        twClass=(TextView)findViewById(R.id.textViewClass);

        sharedpreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);

        twInf.setText(sharedpreferences.getString("name", "")+" "+sharedpreferences.getString("surname", "")+" "+sharedpreferences.getString("father", ""));
        twClass.setText(sharedpreferences.getString("classNumber", "")+sharedpreferences.getString("classLetter", ""));

        Picasso.with(getApplicationContext()).load(sharedpreferences.getString("userImageLink", "")).transform(new CircleTransform()).into(imageView);


    }

}
