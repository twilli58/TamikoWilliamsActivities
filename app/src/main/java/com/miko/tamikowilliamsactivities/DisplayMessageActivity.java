package com.miko.tamikowilliamsactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.miko.tamikowilliamsactivities.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView receivedText = (TextView)findViewById(R.id.firstText);
        receivedText.setText(message);
        /**TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);*/

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(receivedText);
    }
    public void sendSecondMessage(View view) {
        Intent intent = new Intent(this, DisplaySecondMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_secondMessage);
        String message2 = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message2);

        TextView textView = (TextView)findViewById(R.id.firstText);//if textview doesn't work change the field to a edit text and fix related issues
        String message3 = textView.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message3);

        startActivity(intent);
    }

}
