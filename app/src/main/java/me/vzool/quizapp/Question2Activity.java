package me.vzool.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question2Activity extends AppCompatActivity {

    private final String TAG = "Question2Activity";

    private RadioGroup mNumber6Or9RadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        mNumber6Or9RadioGroup = (RadioGroup) findViewById(R.id.number_6_or_9_radioGroup);

        // set question number in title
        setTitle(getTitle() + " - " + getString(R.string.question) + " 2 / 5");
    }

    public void moveToNextQuestion(View view) {

        Log.d(TAG, "Select number: " + mNumber6Or9RadioGroup.getCheckedRadioButtonId());

        // move to next question if user make a choice
        if(mNumber6Or9RadioGroup.getCheckedRadioButtonId() > -1){

            // give third option more points & others options normal point
            if(mNumber6Or9RadioGroup.getCheckedRadioButtonId() == R.id.number_9_only){

                SimpleDB.numbersQuestionPoints = 1;

            }else{

                SimpleDB.numbersQuestionPoints = 0;
            }

            Log.d(TAG, "Select number Saved: " + SimpleDB.numbersQuestionPoints);

            // move to next question
            startActivity(new Intent(this, Question3Activity.class));

        }else{

            // show error message if user push button with empty choices
            Toast.makeText(this, R.string.make_choice_to_move_to_next_question, Toast.LENGTH_SHORT).show();
        }
    }
}
