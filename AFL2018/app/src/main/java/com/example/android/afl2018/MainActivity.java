package com.example.android.afl2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreTeam1 = 0;
    int scoreTeam2 = 0;

    Boolean lastTouchdownForTeam1 = false;
    Boolean lastTouchdownForTeam2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Should add 6 points to the score
    //After adding 6 points to the score, should display it
    public void team1Touchdown(View view) {
        scoreTeam1 = scoreTeam1 + 6;
        lastTouchdownForTeam1 = true;
        displayTeam1Score(scoreTeam1);
    }

    public void team2Touchdown(View view) {
        scoreTeam2 = scoreTeam2 + 6;
        lastTouchdownForTeam2 = true;
        displayTeam2Score(scoreTeam2);
    }

    //Should simply display the global score
    public void displayTeam1Score(int scoreTeam1) {
        TextView team1Points = (TextView) findViewById(R.id.teamOnePoints);
        team1Points.setText(String.valueOf(scoreTeam1));
    }

    public void displayTeam2Score(int scoreTeam2) {
        TextView team2Points = (TextView) findViewById(R.id.teamTwoPoints);
        team2Points.setText(String.valueOf(scoreTeam2));
    }

    //If touchdown is true, then allow the 2-point conversion
    public void team1TwoPointConversion(View view) {
        if (lastTouchdownForTeam1 == false) {
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, "Try a touchdown first...", duration);
            toast.show();
        }

        if (lastTouchdownForTeam1 == true) {
            scoreTeam1 = scoreTeam1 + 2;
            displayTeam1Score(scoreTeam1);
            lastTouchdownForTeam1 = false;
        }
    }

    public void team2TwoPointConversion(View view) {
        if (lastTouchdownForTeam2 == false) {
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, "Try a touchdown first...", duration);
            toast.show();
        }

        if (lastTouchdownForTeam2 == true) {
            scoreTeam2 = scoreTeam2 + 2;
            displayTeam2Score(scoreTeam2);
            lastTouchdownForTeam2 = false;
        }
    }

    public void team1ExtraPoint(View view) {

        if (lastTouchdownForTeam1 == false) {
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, "Try a touchdown first...", duration);
            toast.show();
        }

        if (lastTouchdownForTeam1 == true) {
            scoreTeam1 = scoreTeam1 + 1;
            displayTeam1Score(scoreTeam1);
            lastTouchdownForTeam1 = false;
        }
    }

    public void team2ExtraPoint(View view) {

        if (lastTouchdownForTeam2 == false) {
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(this, "Try a touchdown first...", duration);
            toast.show();
        }

        if (lastTouchdownForTeam2) {
            scoreTeam2 = scoreTeam2 + 1;
            displayTeam2Score(scoreTeam2);
            lastTouchdownForTeam2 = false;
        }
    }

    //Should simply add 3 points to team1's score
    public void team1FieldGoal(View view) {
        scoreTeam1 = scoreTeam1 + 3;
        displayTeam1Score(scoreTeam1);
    }

    public void team2FieldGoal(View view) {
        scoreTeam2 = scoreTeam2 + 3;
        displayTeam2Score(scoreTeam2);
    }

    public void resetBoth(View view) {
        scoreTeam2 = 0;
        scoreTeam1 = 0;

        displayTeam1Score(scoreTeam1);
        displayTeam2Score(scoreTeam2);
    }
}
