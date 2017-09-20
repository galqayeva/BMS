package com.example.telim2.bmm.Activities;

import android.os.Bundle;

import com.example.telim2.bmm.R;

public class ChatActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        toolBarInitialize(R.id.toolbar);
        setTitle("proosos");


    }
}
