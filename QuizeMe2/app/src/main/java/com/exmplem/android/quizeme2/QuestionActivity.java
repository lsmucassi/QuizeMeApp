package com.exmplem.android.quizeme2;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.view.View.VISIBLE;
import static com.exmplem.android.quizeme2.R.string.korean;

public class QuestionActivity extends AppCompatActivity {
    TextView question;
    TextView questionHeader;
    TextView display;
    TextView selectCmd;

    Button nextBtn;
    Button submitBtn;
    Button goBtn;
    Button startBtn;

    RadioGroup rad_grp;
    RadioButton rad_one;
    RadioButton rad_two;
    RadioButton rad_thr;
    RadioButton rad_fr;

    String selectAnswer = "";
    String correctAnswer = "";

    ImageView startPic;
    ImageView goodPic;
    ImageView badPic;

    int index = 0;
    int points = 0;

//    String currentQuestion = " ";
//    String currentAnswer = " ";


    ArrayList<String> headerMessage;

    ArrayList<String> histAns;
    ArrayList<String> econAns;
    ArrayList<String> sciAns;

    QuizObject object;
    ArrayList<QuizObject> histQuestions = new ArrayList<>();
    ArrayList<QuizObject> econoQuestions = new ArrayList<>();
    ArrayList<QuizObject> sciQuestions = new ArrayList<>();

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        points = 0;
        selectAnswer = "";

         correctAnswer = "";
        Intent intent = getIntent();
        id = intent.getIntExtra("Topic", 0);

        nextBtn = (Button) findViewById(R.id.next_button);
        submitBtn = (Button) findViewById(R.id.submit_button);
        goBtn = (Button) findViewById(R.id.go_button);
        startBtn = (Button) findViewById(R.id.start);

        rad_grp = (RadioGroup) findViewById(R.id.rad_group);
        rad_one = (RadioButton) findViewById(R.id.rad_BtnOne);
        rad_two = (RadioButton) findViewById(R.id.rad_BtnTwo);
        rad_thr = (RadioButton) findViewById(R.id.rad_BtnThr);
        rad_fr = (RadioButton) findViewById(R.id.rad_BtnFr);
        startPic = (ImageView) findViewById(R.id.start_pic);
        goodPic = (ImageView) findViewById(R.id.good_scor);
        badPic = (ImageView) findViewById(R.id.bad_scor);

        selectCmd = (TextView) findViewById(R.id.select_cmd);
        question = (TextView) findViewById(R.id.question_one);
        questionHeader = (TextView) findViewById(R.id.question_header);
        display = (TextView) findViewById(R.id.display_mes);

        histAns = new ArrayList<String>();
        econAns = new ArrayList<String>();
        sciAns = new ArrayList<String>();

        headerMessage = new ArrayList<String>();

        //topic headers
        headerMessage.add(getResources().getString(R.string.hist_trivia));
        headerMessage.add(getResources().getString(R.string.econo_trivia));
        headerMessage.add(getResources().getString(R.string.sci_trivia));

        //History Topic
        object = new QuizObject(getResources().getString(R.string.german), getResources().getString(R.string.zep), "Germany", "Spain", "Italy");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.city), getResources().getString(R.string.bonn), "Zeppelin", "Iris", "Paris");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.titanic), getResources().getString(R.string.belfast), "CApe Town", "Paris", "New York City");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.island), getResources().getString(R.string.corsica), "Tropical", "Antarctica", "Indiana");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.napoleon), getResources().getString(R.string.josephine), "Elizabeth", "Martha", "Marry Joselene");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.sec_pres), getResources().getString(R.string.adams), "George W Bush", "Clinton Williams", "John Williams");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.usa_pres), getResources().getString(R.string.george), "Barak Obama", "Nelson Mandela", "W. George Bush");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.viii), getResources().getString(R.string.six_wom), "Two", "Four", "One");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.war), getResources().getString(korean), "World War Two", "Nuclear War", "American War");
        histQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.children), getResources().getString(R.string.nine), "Nineteen", "Five", "Three");
        histQuestions.add(object);

        //Economic Topic
        object = new QuizObject(getResources().getString(R.string.italy), getResources().getString(R.string.lirian), "Dollar", "Pound", "Euro");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.pesetas), getResources().getString(R.string.spain_curr), "Italy", "Paris", "New York");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.oil), getResources().getString(R.string.spain_prod), "Paris", "China", "Portugal");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.office), getResources().getString(R.string.pentagon), "South African Reserve Bank", "New York City", "London Tower");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.jse), getResources().getString(R.string.rand), "Dollar", "Euro", "Penny");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.component), getResources().getString(R.string.sand), "Crystals", "Fibre", "Water");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.origin), getResources().getString(R.string.south_korea), "South-East Korea", "North Korea", "West Korea");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.ch), getResources().getString(R.string.switz), "Netherlands", "Germany", "England");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.lek), getResources().getString(R.string.alb), "Dollar", "Pound", "Euro");
        econoQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.australia), getString(R.string.qantas), "South African airways", "TransNet", "AeroWays");
        econoQuestions.add(object);

        //science questions
        object = new QuizObject(getResources().getString(R.string.spaceship), getString(R.string.gagarin), "Neil Amstrong", "Robert Oppenheimer", "Alexandra Fleming");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.dinosaur), getString(R.string.hemisphere), "The South Hemisphere", "Equator hemisphere", "North hemisphere");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.color), getString(R.string.blue), "Green", "Yellow", "White");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.invented), getString(R.string.goodyear), "James Watt", "Alexandra Fleming", "Gagarin");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.affected), getString(R.string.liver), "Heart", "Lung", "Esophagus");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.device), getString(R.string.telescope), "Microscope", "Binoculars", "Magnifying glass");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.intensity), getString(R.string.candelas), "Farad", "Hertz", "Wat");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.atomic), getString(R.string.robert), "Alan Shepard", "gagarin", "Torricelli");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.barometer), getString(R.string.torri), "James Watt", "Notari John", "William Jordan");
        sciQuestions.add(object);
        object = new QuizObject(getResources().getString(R.string.american), getString(R.string.alan), "Sam Smith", "James Washington", "David Johnson");
        sciQuestions.add(object);

        Collections.shuffle(histQuestions);
        Collections.shuffle(econoQuestions);
        Collections.shuffle(sciQuestions);


        questionHeader.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        display.setVisibility(View.GONE);
        submitBtn.setVisibility(View.GONE);
        goBtn.setVisibility(View.GONE);
        nextBtn.setVisibility(View.GONE);
        rad_grp.setVisibility(View.GONE);
        selectCmd.setVisibility(View.GONE);
        goodPic.setVisibility(View.GONE);
        badPic.setVisibility(View.GONE);

    }

    public void startButton(View view) {
        points = 0;
        displayNow();
    }

    public void displayNow() {

        rad_grp.clearCheck();
        questionHeader.setVisibility(VISIBLE);
        question.setVisibility(VISIBLE);
        startBtn.setVisibility(View.GONE);
        startPic.setVisibility(View.GONE);
        nextBtn.setVisibility(VISIBLE);
        rad_grp.setVisibility(VISIBLE);
        selectCmd.setVisibility(VISIBLE);

        //this is what happens when the button associated with the first ID is pressed
        //this happens in the topic choosing screen
        if (id == 1) {

            //setting the header according to the relevant ID/topic
            questionHeader.setText(headerMessage.get(0));

            //display:
            //a singular question at a time while the index is less thn five(5)
            if (index < 5) {

                QuizObject currentObject = histQuestions.get(index);

                String questi = currentObject.getQuestion();

                String ans = currentObject.getCorrectAnswer();

                correctAnswer = "";
                correctAnswer = ans;

                String dum1 = currentObject.getDummy1();
                String dum2 = currentObject.getGetDummy2();
                String dum3 = currentObject.getGetDummy3();

                question.setText(questi);

                ArrayList<AnswersToShuffle>shufflesAnswer = new ArrayList<>();
                AnswersToShuffle answersToShuffle = new AnswersToShuffle(ans);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum1);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum2);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum3);
                shufflesAnswer.add(answersToShuffle);

                Collections.shuffle(shufflesAnswer);

                rad_one.setText(shufflesAnswer.get(0).getAnswer());
                rad_two.setText(shufflesAnswer.get(1).getAnswer());
                rad_thr.setText(shufflesAnswer.get(2).getAnswer());
                rad_fr.setText(shufflesAnswer.get(3).getAnswer());

                histQuestions.remove(currentObject);

            }
            index++;

            if (index == 5) {

                submitBtn.setVisibility(VISIBLE);
                nextBtn.setVisibility(View.GONE);

            }

        } else if (id == 2) {

            questionHeader.setText(headerMessage.get(1));

            if (index < 5) {

                QuizObject currentObject = econoQuestions.get(index);

                String questi = currentObject.getQuestion();
                String ans = currentObject.getCorrectAnswer();

                correctAnswer = "";
                correctAnswer = ans;

                String dum1 = currentObject.getDummy1();
                String dum2 = currentObject.getGetDummy2();
                String dum3 = currentObject.getGetDummy3();

                question.setText(questi);

                ArrayList<AnswersToShuffle>shufflesAnswer = new ArrayList<>();
                AnswersToShuffle answersToShuffle = new AnswersToShuffle(ans);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum1);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum2);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum3);
                shufflesAnswer.add(answersToShuffle);

                Collections.shuffle(shufflesAnswer);

                rad_one.setText(shufflesAnswer.get(0).getAnswer());
                rad_two.setText(shufflesAnswer.get(1).getAnswer());
                rad_thr.setText(shufflesAnswer.get(2).getAnswer());
                rad_fr.setText(shufflesAnswer.get(3).getAnswer());
                econoQuestions.remove(currentObject);

            }
            index++;

            if (index == 5) {

                submitBtn.setVisibility(VISIBLE);
                nextBtn.setVisibility(View.GONE);

            }

        } else if (id == 3) {

            questionHeader.setText(headerMessage.get(2));

            if (index < 5) {

                correctAnswer = "";

                QuizObject currentObject = sciQuestions.get(index);

                String questi = currentObject.getQuestion();
                String ans = currentObject.getCorrectAnswer();

                correctAnswer = "";
                correctAnswer = ans;
                String correctAnswer = "";

                String dum1 = currentObject.getDummy1();
                String dum2 = currentObject.getGetDummy2();
                String dum3 = currentObject.getGetDummy3();

                question.setText(questi);
                ArrayList<AnswersToShuffle>shufflesAnswer = new ArrayList<>();
                AnswersToShuffle answersToShuffle = new AnswersToShuffle(ans);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum1);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum2);
                shufflesAnswer.add(answersToShuffle);
                answersToShuffle = new AnswersToShuffle(dum3);
                shufflesAnswer.add(answersToShuffle);

                Collections.shuffle(shufflesAnswer);

                rad_one.setText(shufflesAnswer.get(0).getAnswer());
                rad_two.setText(shufflesAnswer.get(1).getAnswer());
                rad_thr.setText(shufflesAnswer.get(2).getAnswer());
                rad_fr.setText(shufflesAnswer.get(3).getAnswer());

                sciQuestions.remove(currentObject);

            }
            index++;


            if (index == 5) {
                submitBtn.setVisibility(VISIBLE);
                nextBtn.setVisibility(View.GONE);
            }
        }
    }

    public void submitButton(View view) {
       String results = " ";

//        Toast.makeText(getBaseContext(), "Points :" + points, Toast.LENGTH_LONG).show();
        display.setVisibility(VISIBLE);
        submitBtn.setVisibility(View.GONE);
        goBtn.setVisibility(VISIBLE);
        rad_grp.setVisibility(View.GONE);
        selectCmd.setVisibility(View.GONE);
        question.setVisibility(View.GONE);
        questionHeader.setText("SCORE");

        if (selectAnswer.equalsIgnoreCase(correctAnswer)) {
            points++;
//            Toast.makeText(getBaseContext(), "Correct  :  " + points, Toast.LENGTH_LONG).show();
        } else {
            points = points;
//
//          Toast.makeText(getBaseContext(), "Wrong answer :  " , Toast.LENGTH_LONG).show();
        }

        if (points < 3) {
            badPic.setVisibility(View.VISIBLE);
        } else {
            goodPic.setVisibility(View.VISIBLE);
        }

        display.setText(scoreResults(points));
    }

    public void playAgain(View view) {

        Intent moveToHome = new Intent(QuestionActivity.this, HomeActivity.class);
        moveToHome.putExtra("Topic", 1);
        startActivity(moveToHome);
    }

    public void nextButton(View view) {

        // everything that wil happen when the "next" button is pressed,
        //re-showing items that where invisible
        if(selectAnswer.equalsIgnoreCase(correctAnswer))
        {
            points ++;
//            Toast.makeText(getBaseContext(), "Correct  :  " + points, Toast.LENGTH_LONG).show();
        }
        else
        {
            points = points;
//
//          Toast.makeText(getBaseContext(), "Wrong answer :  " , Toast.LENGTH_LONG).show();
        }
        displayNow();
    }

    public  String scoreResults(int scr)
    {
        String mes;
        mes = "------You Score Results is-----";

        if (scr <= 2){
            mes += "\n ";
            mes += "\n " + scr + " ";
            mes += "\n You got: " + scr + " answers correct";
            mes += "\n You were BAD in answering this Questions";
            mes += "\n !! PLAY AGAIN !! --- Maybe you will do better this time ";
        }else {
            mes += "\n ";
            mes += "\n SCORE: " + scr + " ";
            mes += "\n You got: " + scr + " answers correct";
            mes += "\n You were Good in answering this Questions";
            mes += "\n !! PLAY AGAIN !! ";
        }
        return mes;
    }

    public  void rbnOneClicked(View view)
    {
        selectAnswer = rad_one.getText().toString();
    }
    public  void rbnTwoClicked(View view)
    {
        selectAnswer = rad_two.getText().toString();
    }
    public  void rbnThreeClicked(View view)
    {
        selectAnswer = rad_thr.getText().toString();
    }
    public  void rbnFourClicked(View view)
    {
        selectAnswer = rad_fr.getText().toString();
    }


}
