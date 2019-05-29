package com.example.lab8_nfc;

import android.content.Intent;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.nfc.NdefRecord.createMime;

public class MainActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback{

    EditText message;
    String messageToSend;
    TextView sentMessages;
    TextView receivedMessages;
    NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // Check for available NFC Adapter
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mNfcAdapter == null) {
            Toast.makeText(this, "NFC is not available", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        // Register callback
        mNfcAdapter.setNdefPushMessageCallback(this, this);

        message =  findViewById(R.id.messageToSend);
        sentMessages = (TextView) findViewById(R.id.sentMessages);
        receivedMessages = (TextView) findViewById(R.id.recievedMessages);
    }

    @Override
    public NdefMessage createNdefMessage(NfcEvent event) {
        String text = ("Beam me up, Android!\n\n" + "Beam Time: " +
                System.currentTimeMillis() + messageToSend);
        NdefMessage msg = new NdefMessage(
                new NdefRecord[]{createMime(
                        "application/vnd.com.example.android.beam", text.getBytes())
                });
        String alreadySent = sentMessages.getText().toString();
        sentMessages.setText(alreadySent + ", " + messageToSend);
        return msg;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Check to see that the Activity started due to an Android Beam
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
            processIntent(getIntent());
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        // onResume gets called after this to handle the intent
        setIntent(intent);
    }

    /*** Parses the NDEF Message from the intent and prints to the TextView
     * */

    void processIntent(Intent intent) {
        String current = receivedMessages.getText().toString();

        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];
        // record 0 contains the MIME type, record 1 is the AAR, if present
        receivedMessages.setText(current + ", " + new String(msg.getRecords()[0].getPayload()));
    }

    public void setMessage(View view) {
        messageToSend = message.getText().toString();

        Toast.makeText(this, "New message set.",
                Toast.LENGTH_SHORT).show();
    }
}
