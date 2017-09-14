package com.exmplem.android.quizmev13;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goTopic(View view)
    {
        Intent moveToTopic = new Intent(HomeActivity.this, TopicActivity.class);
        startActivity(moveToTopic);

    }

}
