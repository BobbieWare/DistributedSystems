package com.example.lab7_web1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button send;
    private EditText number;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button) findViewById(R.id.sendButton);
        number = (EditText) findViewById(R.id.numberText);
        message = (EditText) findViewById(R.id.messageText);
    }

    public void sendButtonClicked(View view)
    {
        String numberInput = number.getText().toString();
        String messageInput = message.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(numberInput, null, messageInput, null, null);
    }
}
