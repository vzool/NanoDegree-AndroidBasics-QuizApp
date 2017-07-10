package me.vzool.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question5Activity extends AppCompatActivity {

    private final String TAG = "Question5Activity";

    private RadioGroup mPeaceDecisionRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        mPeaceDecisionRadioGroup = (RadioGroup) findViewById(R.id.peace_decision_radioGroup);

        // set question number in title
        setTitle(getTitle() + " - " + getString(R.string.question) + " 5 / 5");
    }

    public void ShowTheResult(View view) {

        // move to next question if user make a choice
        if(mPeaceDecisionRadioGroup.getCheckedRadioButtonId() > -1){

            // give third option more points & others options normal point
            if(mPeaceDecisionRadioGroup.getCheckedRadioButtonId() == R.id.two_side_radioButton){

                SimpleDB.peaceDecisionQuestionPoints = 2;

            }else{

                SimpleDB.peaceDecisionQuestionPoints = 1;
            }

            Log.d(TAG, "Select number Saved: " + SimpleDB.peaceDecisionQuestionPoints);

            // move to next question
            startActivity(new Intent(this, ResultActivity.class));

        }else{

            // show error message if user push button with empty choices
            Toast.makeText(this, R.string.make_choice_to_show_final_result, Toast.LENGTH_SHORT).show();
        }
    }
}
