package com.exmplem.android.quizeme2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn = (Button) findViewById(R.id.history_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToQuest = new Intent(HomeActivity.this, QuestionActivity.class);
                moveToQuest.putExtra("Topic", 1);
                startActivity(moveToQuest);

            }
        });

    }

    public void goQuestHist(View view)
    {
        Intent moveToQuest = new Intent(HomeActivity.this, QuestionActivity.class);
        moveToQuest.putExtra("Topic", 1);
        startActivity(moveToQuest);
    }

    public void goQuestEcono(View view)
    {
        Intent moveToQuest = new Intent(HomeActivity.this, QuestionActivity.class);
        moveToQuest.putExtra("Topic", 2);
        startActivity(moveToQuest);

    }

    public void goQuestSci(View view)
    {
        Intent moveToQuest = new Intent(HomeActivity.this, QuestionActivity.class);
        moveToQuest.putExtra("Topic", 3);
        startActivity(moveToQuest);

    }
}
