package me.vzool.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private int totalPoints;

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResultTextView = (TextView) findViewById(R.id.the_result_textView);

        // set question number in title
        setTitle(getTitle() + " - " + getString(R.string.the_result));

        // Calculate The Result
        totalPoints = SimpleDB.Calculate();

        mResultTextView.setText(String.valueOf(totalPoints) + "/9");

        Toast.makeText(this, getString(R.string.the_result) + " " + String.valueOf(totalPoints) + "/9", Toast.LENGTH_LONG).show();
    }
}
