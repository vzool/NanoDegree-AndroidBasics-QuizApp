package me.vzool.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question4Activity extends AppCompatActivity {

    private final String TAG = "Question4Activity";

    private RadioGroup mColorHumansRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        mColorHumansRadioGroup = (RadioGroup) findViewById(R.id.color_humans_radioGroup);

        // set question number in title
        setTitle(getTitle() + " - " + getString(R.string.question) + " 4 / 5");
    }

    public void moveToNextQuestion(View view) {

        // move to next question if user make a choice
        if(mColorHumansRadioGroup.getCheckedRadioButtonId() > -1){

            // give third option more points & others options normal point
            if(mColorHumansRadioGroup.getCheckedRadioButtonId() == R.id.color_humans_no_one){

                SimpleDB.humanColorsQuestionPoints = 3;

            }else{

                SimpleDB.humanColorsQuestionPoints = 0;
            }

            Log.d(TAG, "Select number Saved: " + SimpleDB.humanColorsQuestionPoints);

            // move to next question
            startActivity(new Intent(this, Question5Activity.class));

        }else{

            // show error message if user push button with empty choices
            Toast.makeText(this, R.string.make_choice_to_move_to_next_question, Toast.LENGTH_SHORT).show();
        }
    }
}
