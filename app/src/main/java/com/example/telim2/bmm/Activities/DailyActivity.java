package com.example.telim2.bmm.Activities;

import android.os.Bundle;

import com.example.telim2.bmm.R;

public class DailyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        toolBarInitialize(R.id.toolbar);

    }

}
