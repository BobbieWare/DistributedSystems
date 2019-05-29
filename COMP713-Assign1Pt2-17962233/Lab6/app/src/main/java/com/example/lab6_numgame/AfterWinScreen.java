package com.example.lab6_numgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterWinScreen extends Activity {

    private Button againButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_win);
        againButton = (Button)findViewById(R.id.againButton);
        exitButton = (Button) findViewById(R.id.exitButton);
    }

    public void againButtonClicked(View view)
    {
        startActivity(new Intent(this, GameActivity.class));
    }

    public void exitButtonClicked(View view)
    {
        startActivity(new Intent(this, MainActivity.class));
    }
}
