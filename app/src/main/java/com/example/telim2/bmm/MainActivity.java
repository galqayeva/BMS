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

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imageView;
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    TextView tw1,tw2,tw3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        imageView=(ImageView)findViewById(R.id.imageView);
        tw1=(TextView)findViewById(R.id.textView4);
        tw2=(TextView)findViewById(R.id.textView5);
        tw3=(TextView)findViewById(R.id.textView6);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        tw1.setText(sharedpreferences.getString("name", ""));
        tw2.setText(sharedpreferences.getString("surname", ""));
        tw3.setText(sharedpreferences.getString("father", ""));

        Picasso.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png").transform(new CircleTransform()).into(imageView);

        drawMenu(toolbar);




    }

    public void drawMenu(Toolbar toolbar){

        PrimaryDrawerItem item0 = new PrimaryDrawerItem().withIdentifier(1).withName(Constants.DRAWER_MENU_HOME);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(Constants.DRAWER_MENU_GUNLUK);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(1).withName(Constants.DRAWER_MENU_CHAT);


        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.logo)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz")
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item0,item1,item2,
                        new DividerDrawerItem()
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
                        }

                        return true;
                    }
                })
                .build();

    }
}
