package com.example.telim2.bmm;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
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

        Picasso.with(getApplicationContext()).load(sharedpreferences.getString("image", "")).transform(new CircleTransform()).into(imageView);

        Toast.makeText(getApplicationContext(),sharedpreferences.getString("userImageLink", ""),Toast.LENGTH_LONG).show();


    }

}
