package com.example.lab6_numgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends Activity {
    // Declaring class level variables
    private EditText guess;
    private Button guessBtn;
    private TextView messageText;
    private int randN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        guessBtn = (Button) findViewById(R.id.guessButton);
        messageText = (TextView) findViewById(R.id.textMessage);
        guess = (EditText) findViewById(R.id.guess);
        generateNumber();
    }

    private void generateNumber() {
        Random r = new Random();
        randN = r.nextInt(100);
    }

    public void guessButtonClicked(View view) {
        int guessN = Integer.parseInt(guess.getText().toString());
        if (guessN > randN) {
            messageText.setText("Guess is too big");
            messageText.setTextColor(android.graphics.Color.BLUE);
        } else if (guessN < randN) {
            messageText.setText("Guess is too small");
            messageText.setTextColor(android.graphics.Color.RED);
        } else {
            startActivity(new Intent(this, AfterWinScreen.class));
        }
    }
}
