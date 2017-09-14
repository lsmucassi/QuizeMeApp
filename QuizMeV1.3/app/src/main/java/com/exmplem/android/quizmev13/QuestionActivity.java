package com.exmplem.android.quizmev13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static android.R.attr.description;
import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.attr.value;
import static android.R.attr.x;
import static com.exmplem.android.quizmev13.R.id.submit_button;
import static com.exmplem.android.quizmev13.R.string.korean;

public class QuestionActivity extends AppCompatActivity
{

    TextView question;
    TextView questionHeader;
    TextView display;

    Button nextBtn;
    Button submitBtn;
    Button goBtn;
    Button startBtn;

    Spinner answers;

    int index = 0;
    int points = 0;

    String currentQuestion = " ";

    ArrayList<String> histQuestions;
    ArrayList<String> econoQuestions;
    ArrayList<String> sciQuestions;

    ArrayList<String> headerMessage;

    ArrayList<String> histAns;
    ArrayList<String> econAns;
    ArrayList<String> sciAns;

    int id;




    private ArrayAdapter<String> adapterAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        id = intent.getIntExtra("Topic", 0);

        nextBtn = (Button) findViewById(R.id.next_button);
        submitBtn = (Button) findViewById(R.id.submit_button);
        goBtn = (Button) findViewById(R.id.go_button);
        startBtn = (Button) findViewById(R.id.start);


        histQuestions = new ArrayList<String>();
        econoQuestions = new ArrayList<String>();
        sciQuestions = new ArrayList<String>();

        histAns = new ArrayList<String>();
        econAns = new ArrayList<String>();
        sciAns = new ArrayList<String>();

        headerMessage = new ArrayList<String>();
        histQuestions = new ArrayList<String>();
        econoQuestions = new ArrayList<String>();
        sciQuestions = new ArrayList<String>();

        headerMessage = new ArrayList<String>();

        question = (TextView) findViewById(R.id.question_one);
        questionHeader = (TextView) findViewById(R.id.question_header);
        display = (TextView) findViewById(R.id.display_mes);

        answers = (Spinner) findViewById(R.id.spinner2);

        //        histAns = new String[10];
//        econAns = new String[10];
//        sciAns = new String[10];

        //topic headers
        headerMessage.add(getResources().getString(R.string.hist_trivia));
        headerMessage.add(getResources().getString(R.string.econo_trivia));
        headerMessage.add(getResources().getString(R.string.sci_trivia));

        //history answers
        histAns.add(getResources().getString(R.string.select));
        histAns.add(getResources().getString(R.string.zep));
        histAns.add(getResources().getString(R.string.george));
        histAns.add(getResources().getString(R.string.adams));
        histAns.add(getResources().getString(R.string.josephine));
        histAns.add(getResources().getString(R.string.belfast));
        histAns.add(getResources().getString(R.string.bonn));
        histAns.add(getResources().getString(R.string.six_wom));
        histAns.add(getResources().getString(R.string.nine));
        histAns.add(getResources().getString(R.string.corsica));
        histAns.add(getResources().getString(korean));

        //economic answers
        econAns.add(getResources().getString(R.string.select));
        econAns.add(getResources().getString(R.string.lirian));
        econAns.add(getResources().getString(R.string.spain_curr));
        econAns.add(getResources().getString(R.string.spain_prod));
        econAns.add(getResources().getString(R.string.pentagon));
        econAns.add(getResources().getString(R.string.rand));
        econAns.add(getResources().getString(R.string.sand));
        econAns.add(getResources().getString(R.string.south_korea));
        econAns.add(getResources().getString(R.string.switz));
        econAns.add(getResources().getString(R.string.alb));
        econAns.add(getResources().getString(R.string.qantas));

        //science answers
        sciAns.add(getResources().getString(R.string.select));
        sciAns.add(getResources().getString(R.string.gagarin));
        sciAns.add(getResources().getString(R.string.hemisphere));
        sciAns.add(getResources().getString(R.string.blue));
        sciAns.add(getResources().getString(R.string.goodyear));
        sciAns.add(getResources().getString(R.string.liver));
        sciAns.add(getResources().getString(R.string.telescope));
        sciAns.add(getResources().getString(R.string.candelas));
        sciAns.add(getResources().getString(R.string.robert));
        sciAns.add(getResources().getString(R.string.torri));
        sciAns.add(getResources().getString(R.string.alan));

        //history questions
        histQuestions.add(getResources().getString(R.string.german));         //Zeppelin
        histQuestions.add(getResources().getString(R.string.city));           //George Washington
        histQuestions.add(getResources().getString(R.string.titanic));        //John Adams
        histQuestions.add(getResources().getString(R.string.island));         //Six women
        histQuestions.add(getResources().getString(R.string.napoleon));       //Belfast
        histQuestions.add(getResources().getString(R.string.sec_pres));       //Josephine
        histQuestions.add(getResources().getString(R.string.usa_pres));       //Bonn
        histQuestions.add(getResources().getString(R.string.viii));           //Corsica
        histQuestions.add(getResources().getString(R.string.war));       //The Korean War
        histQuestions.add(getResources().getString(R.string.children));       //Nine children

        //economic questions
        econoQuestions.add(getResources().getString(R.string.italy));        //Lirain
        econoQuestions.add(getResources().getString(R.string.pesetas));      //Spain
        econoQuestions.add(getResources().getString(R.string.oil));          //Spain
        econoQuestions.add(getResources().getString(R.string.office));       //Pentagon
        econoQuestions.add(getResources().getString(R.string.jse));          //South African rand
        econoQuestions.add(getResources().getString(R.string.component));    //Sand
        econoQuestions.add(getResources().getString(R.string.origin));       //South Korea
        econoQuestions.add(getResources().getString(R.string.ch));           //Switzerland
        econoQuestions.add(getResources().getString(R.string.lek));          //Albanese lek
        econoQuestions.add(getResources().getString(R.string.australia));    //Qantas

        //science questions
        sciQuestions.add(getResources().getString(R.string.spaceship));        //Gagarin
        sciQuestions.add(getResources().getString(R.string.dinosaur));         //The northern hemisphere
        sciQuestions.add(getResources().getString(R.string.color));            //Blue
        sciQuestions.add(getResources().getString(R.string.invented));         //Goodyear
        sciQuestions.add(getResources().getString(R.string.affected));         //Liver
        sciQuestions.add(getResources().getString(R.string.device));           //Telescope
        sciQuestions.add(getResources().getString(R.string.intensity));        //Candelas
        sciQuestions.add(getResources().getString(R.string.atomic));           //Robert Oppenheimer
        sciQuestions.add(getResources().getString(R.string.barometer));        //Torricelli
        sciQuestions.add(getResources().getString(R.string.american));         //Alan Shepard


        Collections.shuffle(histQuestions);
        Collections.shuffle(econoQuestions);
        Collections.shuffle(sciQuestions);

//        currentQuestion = histQuestions.get(index);
//        question.setText(currentQuestion);
//        index++;

        questionHeader.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        answers.setVisibility(View.GONE);
        display.setVisibility(View.GONE);
        submitBtn.setVisibility(View.GONE);
        goBtn.setVisibility(View.GONE);
        nextBtn.setVisibility(View.GONE);
    }

    public int goButton()
    {





        return points;
    }

    public void startButton(View view)
    {

      nextButton(view);

    }

    public void nextButton(View view)
    {

        // everything that wil happen when the "next" button is pressed,
        // this function is also interacted with the " start button

        //setting the next button's text to show start
        //nextBtn.setText("Next");

        //re-showing items that where invisible
        questionHeader.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        answers.setVisibility(View.VISIBLE);
        goBtn.setVisibility(View.VISIBLE);
        startBtn.setVisibility(View.GONE);
        nextBtn.setVisibility(View.VISIBLE);

       // display.setVisibility(View.VISIBLE);
        String head;


        //this is what happens when the button associated with the first ID is pressed
        //this happens in the topic choosing window
        if (id == 1)
        {
            //displaying the history answers in the spinner
            adapterAnswers = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_dropdown_item_1line, histAns);
            answers.setAdapter(adapterAnswers);

            //setting the header according to the relevant ID/topic
            questionHeader.setText(headerMessage.get(0));

            //display:
                //a singular question at a time while the index is less thn five(5)
            if (index < 5)
            {
                currentQuestion = histQuestions.get(index);
                question.setText(currentQuestion);

                String selectedAnswer = answers.getSelectedItem().toString();

                if (currentQuestion.equalsIgnoreCase(getResources().getString(R.string.german)) && selectedAnswer.equalsIgnoreCase(getResources().getString(R.string.zep)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuestionActivity.this, "Problem with answer",Toast.LENGTH_LONG).show();
                }


                if (currentQuestion.equals(getResources().getString(R.string.usa_pres)) && selectedAnswer.equals(getResources().getString(R.string.george)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.sec_pres)) && selectedAnswer.equals(getResources().getString(R.string.adams)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.viii)) && selectedAnswer.equals(getResources().getString(R.string.josephine)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.napoleon)) && selectedAnswer.equals(getResources().getString(R.string.belfast)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.city)) && selectedAnswer.equals(getResources().getString(R.string.bonn)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.island)) && selectedAnswer.equals(getResources().getString(R.string.six_wom)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.children)) && selectedAnswer.equals(getResources().getString(R.string.nine)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.war)) && selectedAnswer.equals(getResources().getString(R.string.korean)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.titanic)) && selectedAnswer.equals(getResources().getString(R.string.corsica)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

            }
            index++;

            if (index == 5){

                submitBtn.setVisibility(View.VISIBLE);
                nextBtn.setVisibility(View.GONE);
                display.setVisibility(View.VISIBLE);
                goBtn.setVisibility(View.GONE);
                Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_LONG).show();
                submitRes(points);
            }

        } else if (id == 2) {

            adapterAnswers = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_dropdown_item_1line, econAns);
            answers.setAdapter(adapterAnswers);

            questionHeader.setText(headerMessage.get(1));

            if (index < 5)
            {
                currentQuestion = econoQuestions.get(index);
                question.setText(currentQuestion);

                String selectedAnswer = answers.getSelectedItem().toString();

                if (currentQuestion.equals(getResources().getString(R.string.italy)) && selectedAnswer.equals(getResources().getString(R.string.lirian)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.pesetas)) && selectedAnswer.equals(getResources().getString(R.string.spain_prod)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.oil)) && selectedAnswer.equals(getResources().getString(R.string.spain_curr)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.office)) && selectedAnswer.equals(getResources().getString(R.string.pentagon)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.jse)) && selectedAnswer.equals(getResources().getString(R.string.rand)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.component)) && selectedAnswer.equals(getResources().getString(R.string.south_korea)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.origin)) && selectedAnswer.equals(getResources().getString(R.string.switz)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.ch)) && selectedAnswer.equals(getResources().getString(R.string.alb)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.lek)) && selectedAnswer.equals(getResources().getString(R.string.qantas)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.australia)) && selectedAnswer.equals(getResources().getString(R.string.sand))) {

                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

            }
            index++;

            if (index == 5){

                submitBtn.setVisibility(View.VISIBLE);
                nextBtn.setVisibility(View.GONE);
                display.setVisibility(View.VISIBLE);
                goBtn.setVisibility(View.GONE);
                Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_LONG).show();
                submitRes(points);

            }

        } else if (id == 3) {

            adapterAnswers = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_dropdown_item_1line, sciAns);
            answers.setAdapter(adapterAnswers);

            questionHeader.setText(headerMessage.get(2));

            if (index < 5)
            {
                currentQuestion = sciQuestions.get(index);
                question.setText(currentQuestion);

                String selectedAnswer = answers.getSelectedItem().toString();

                if (currentQuestion.equals(getResources().getString(R.string.spaceship)) && selectedAnswer.equals(getResources().getString(R.string.gagarin)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.dinosaur)) && selectedAnswer.equals(getResources().getString(R.string.hemisphere)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.color)) && selectedAnswer.equals(getResources().getString(R.string.blue)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.invented)) && selectedAnswer.equals(getResources().getString(R.string.goodyear)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.affected)) && selectedAnswer.equals(getResources().getString(R.string.liver)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.device)) && selectedAnswer.equals(getResources().getString(R.string.telescope)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.intensity)) && selectedAnswer.equals(getResources().getString(R.string.candelas)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.atomic)) && selectedAnswer.equals(getResources().getString(R.string.robert)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.barometer)) && selectedAnswer.equals(getResources().getString(R.string.torri)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

                if (currentQuestion.equals(getResources().getString(R.string.american)) && selectedAnswer.equals(getResources().getString(R.string.alan)))
                {
                    points += 1;
                    Log.d("Points", " " + points);

                    Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_SHORT).show();
                }

            }
            index++;

            if (index == 5)
            {

                submitBtn.setVisibility(View.VISIBLE);
                nextBtn.setVisibility(View.GONE);
                display.setVisibility(View.VISIBLE);
                goBtn.setVisibility(View.GONE);
                Toast.makeText(QuestionActivity.this, "Points: " + points, Toast.LENGTH_LONG).show();
                 submitRes(points);

            }

        }

        submitRes(points);
    }

    private String createScore(int score)
    {
        score = goButton();
        String priceMessage = "You get: " + score;
        priceMessage += "\nThank you";

        return priceMessage;
    }
    /**
     * displays the quantity to the screen
     **/
    public void submitRes(int score) {




        display.setText(" " + score);
    }

}
