package me.vzool.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox mDevilCheckBox;
    private CheckBox mAngelCheckBox;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDevilCheckBox = (CheckBox) findViewById(R.id.devil_checkbox);
        mAngelCheckBox = (CheckBox) findViewById(R.id.angel_checkbox);

        // set question number in title
        setTitle(getTitle() + " - " + getString(R.string.question) + " 1 / 5");
    }

    public void moveToNextQuestion(View view) {

        // reset points
        SimpleDB.devilAngelQuestionPoints = 0;

        // move to next activity only if one of checkbox are checked
        if(mDevilCheckBox.isChecked() || mAngelCheckBox.isChecked()){

            // Add point
            if(mDevilCheckBox.isChecked()){

                SimpleDB.devilAngelQuestionPoints += 1;
            }

            // Add point
            if(mAngelCheckBox.isChecked()){

                SimpleDB.devilAngelQuestionPoints += 1;
            }

            // move to next question
            Log.d(TAG, "Points: " + SimpleDB.devilAngelQuestionPoints);

            startActivity(new Intent(this, Question2Activity.class));

        }else{

            // show error message if user push button with empty choices
            Toast.makeText(this, R.string.make_choice_to_move_to_next_question, Toast.LENGTH_SHORT).show();
        }
    }
}
