package me.vzool.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {

    private final String TAG = "Question3Activity";

    private EditText mPinkColorAnswerEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        mPinkColorAnswerEditText = (EditText) findViewById(R.id.person_name_editText);

        // set question number in title
        setTitle(getTitle() + " - " + getString(R.string.question) + " 3 / 5");
    }

    public void moveToNextQuestion(View view) {

        // Set current text to cache variable & move to next activity if there is some text
        String personName = mPinkColorAnswerEditText.getText().toString();

        if(personName.length() > 0){

            Log.d(TAG, "Person Name: " + personName);

            if(personName.trim().equalsIgnoreCase("yes")){

                SimpleDB.pinkColorQuestionPoints = 1;

            }else{

                SimpleDB.pinkColorQuestionPoints = 0;
            }

            startActivity(new Intent(this, Question4Activity.class));

        }else{

            // show error message if user push button with empty choices
            Toast.makeText(this, R.string.make_choice_to_move_to_next_question, Toast.LENGTH_SHORT).show();
        }
    }
}
