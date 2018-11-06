
package com.example.mayada.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    boolean endGame = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        endGame = false;
        TextView statusA = (TextView) findViewById(R.id.statusTeamA);
        TextView statusB = (TextView) findViewById(R.id.statusTeamB);
        statusA.setText("");
        statusB.setText("");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */

    public void quaffleForA(View view) {
        if (!endGame) {
            scoreTeamA += 10;
            displayForTeamA(scoreTeamA);
        }
    }

    public void snitchForA(View view) {
        if (!endGame) {
            scoreTeamA += 150;
            endGame = true;
            TextView statusA = (TextView) findViewById(R.id.statusTeamA);
            TextView statusB = (TextView) findViewById(R.id.statusTeamB);
            if(scoreTeamA>=scoreTeamB) {
                statusA.setText("Winner");
                statusA.setAllCaps(true);
            }
            else {
                statusB.setText("Winner");
                statusB.setAllCaps(true);
            }
            displayForTeamA(scoreTeamA);
        }
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    //Team B
    public void quaffleForB(View view) {
        if (!endGame) {
            scoreTeamB += 10;
            displayForTeamB(scoreTeamB);
        }
    }

    public void snitchForB(View view) {
        if (!endGame) {
            scoreTeamB += 150;
            endGame = true;
            TextView statusA = (TextView) findViewById(R.id.statusTeamA);
            TextView statusB = (TextView) findViewById(R.id.statusTeamB);
            if(scoreTeamA>scoreTeamB) {
                statusA.setText("Winner");
                statusA.setAllCaps(true);
            }
            else {
                statusB.setText("Winner");
                statusB.setAllCaps(true);
            }
            displayForTeamB(scoreTeamB);
        }
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
