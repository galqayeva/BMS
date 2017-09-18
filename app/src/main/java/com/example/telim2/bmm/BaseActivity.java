//package com.example.telim2.bmm;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.widget.Toolbar;
//
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ImageView;
//import android.widget.TextView;
//import com.mikepenz.materialdrawer.Drawer;
//import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
//import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
//import com.prospect.app.Constants;
//import com.prospect.app.R;
//import com.squareup.picasso.Picasso;
//
///**
// * Created by telim2 on 18.09.2017.
// */
//
//public class BaseActivity extends ActionBarActivity {
//
//    private Drawer.Result drawerResult = null;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    public void toolBarInitialize(int toolBarId) {
//        Toolbar toolbar = (Toolbar) findViewById(toolBarId);
//        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
//        toolbar.setSubtitleTextColor(getResources().getColor(android.R.color.white));
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        drawerResult = new Drawer()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withActionBarDrawerToggle(true)
//                .withHeader(R.layout.drawer_header)
//                .addDrawerItems(
//                        new SecondaryDrawerItem().withName(getString(R.string.control_panel_title)).withIcon(getResources().getDrawable(R.drawable.ic_home_black_24dp)),
//                        new SecondaryDrawerItem().withName(getString(R.string.main_screen_name)).withIcon(getResources().getDrawable(R.drawable.ic_assigment)),
//                        new SecondaryDrawerItem().withName(getString(R.string.mettings_title)).withIcon(getResources().getDrawable(R.drawable.ic_supervisor_account_black_24dp)),
//                        new SecondaryDrawerItem().withName(getString(R.string.tasks_activity_title)).withIcon(getResources().getDrawable(R.drawable.ic_task)),
//                        new SecondaryDrawerItem().withName(getString(R.string.job_activity_title)).withIcon(getResources().getDrawable(R.drawable.ic_current_job)),
//                        new SecondaryDrawerItem().withName("Gunluk").withIcon(getResources().getDrawable(R.drawable.ic_android_demo_24dp)),
//                        new SecondaryDrawerItem().withName(getString(R.string.menu_exit_title)).withIcon(getResources().getDrawable(R.drawable.ic_exit))
//                )
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
//                        switch (position) {
//
//                            case 0:
//                                intent = new Intent(getApplication(), ControlPanelActivity.class);
//                                startActivity(intent);
//                                break;
//
//                            case 1:
//                                intent = new Intent(getApplication(), BegOffListActivity.class);
//                                startActivity(intent);
//                                break;
//
//
//
//                        }
//                    }
//                })
//                .build();
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (drawerResult.isDrawerOpen()) {
//            drawerResult.closeDrawer();
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//
//
//
//}
