package com.example.telim2.bmm.Activities;

/**
 * Created by telim2 on 20.09.2017.
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.telim2.bmm.Constants;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import com.example.telim2.bmm.R;


public class BaseActivity extends ActionBarActivity {


    private TextView textViewUserName;
    private ImageView imageViewUserPhoto;
    private Intent intent;
    private SharedPreferences prospectPreferences;
    private SharedPreferences.Editor editorPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void toolBarInitialize(int toolBarId) {
        Toolbar toolbar = (Toolbar) findViewById(toolBarId);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setSubtitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);

        PrimaryDrawerItem item0 = new PrimaryDrawerItem().withIdentifier(1).withName(Constants.DRAWER_MENU_HOME);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(2).withName(Constants.DRAWER_MENU_GUNLUK);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(3).withName(Constants.DRAWER_MENU_CHAT);
        PrimaryDrawerItem item3=  new PrimaryDrawerItem().withIdentifier(4).withName(Constants.DRAWER_MENU_LOGOUT);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.logo)
                .build();
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item0,item1,item2,
                        new DividerDrawerItem(),item3
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        switch (position){
                            case 1:
                                Intent intent0=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent0);
                                break;
                            case 2:
                                Intent intent=new Intent(getApplicationContext(),DailyActivity.class);
                                startActivity(intent);
                                break;
                            case 3:
                                Intent intent2=new Intent(getApplicationContext(),ChatActivity.class);
                                startActivity(intent2);
                                break;
                            case 5:
                                getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE).edit().clear().commit();
                                Intent intent3=new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent3);
                                break;
                        }

                        return true;
                    }
                })
                .build();

    }



}