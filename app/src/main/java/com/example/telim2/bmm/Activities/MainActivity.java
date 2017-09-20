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
    TextView tw1,tw2,tw3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBarInitialize(R.id.toolbar);
        setTitle("proosos");

        imageView=(ImageView)findViewById(R.id.imageView);
        tw1=(TextView)findViewById(R.id.textView4);
        tw2=(TextView)findViewById(R.id.textView5);
        tw3=(TextView)findViewById(R.id.textView6);

        sharedpreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);

        tw1.setText(sharedpreferences.getString("name", ""));
        tw2.setText(sharedpreferences.getString("surname", ""));
        tw3.setText(sharedpreferences.getString("father", ""));

        Picasso.with(getApplicationContext()).load(sharedpreferences.getString("userImageLink", "")).transform(new CircleTransform()).into(imageView);


    }

}
