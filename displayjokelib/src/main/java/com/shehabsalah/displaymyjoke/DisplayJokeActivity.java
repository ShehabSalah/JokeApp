package com.shehabsalah.displaymyjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        TextView textView = (TextView)findViewById(R.id.testView);
        Intent intent = getIntent();
        if (intent.hasExtra(getResources().getString(R.string.intent_name))){
            textView.setText(intent.getStringExtra(getResources().getString(R.string.intent_name)));
        }
    }
}
