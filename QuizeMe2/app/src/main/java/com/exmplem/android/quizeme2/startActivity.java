package com.exmplem.android.quizeme2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class startActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }


    public void goTopic(View view)
    {
        Intent moveToTopic = new Intent(startActivity.this, HomeActivity.class);
        startActivity(moveToTopic);

    }
}
